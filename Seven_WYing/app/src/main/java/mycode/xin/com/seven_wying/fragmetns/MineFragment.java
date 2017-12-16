package mycode.xin.com.seven_wying.fragmetns;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import mycode.xin.com.seven_wying.R;
import mycode.xin.com.seven_wying.mvp.mine.MineAdapter;

import static android.app.Activity.RESULT_OK;

/**
 * date:2017/12/12  23:34
 * author:Mr.XIn💕
 */


public class MineFragment extends Fragment {
    @BindView(R.id.user)
    ImageView mUser;
    @BindView(R.id.list)
    ListView mList;
    Unbinder unbinder;
    private int mYourChoice;
    private TextView mCamera;
    private TextView mPicture;
    private String path = Environment.getExternalStorageDirectory().getPath() + "/head.jpg";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_mine, container, false);
        unbinder = ButterKnife.bind(this, mView);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<String> mMlist = new ArrayList<>();
        mMlist.add("历史");
        mMlist.add("缓存");
        mMlist.add("收藏");
        mMlist.add("主题");
        mList.setAdapter(new MineAdapter(mMlist, getActivity()));
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Toast.makeText(getActivity(), "历史", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getActivity(), "缓存", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getActivity(), "收藏", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getActivity(), "主题", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });


        View mDialog = View.inflate(getActivity(), R.layout.dialogview, null);
        mCamera = mDialog.findViewById(R.id.camera);
        mPicture = mDialog.findViewById(R.id.picture);
        final AlertDialog alertDialog = new AlertDialog
                .Builder(getActivity())
                .setView(mDialog)
                .create();

        mUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.show();
            }
        });
        mCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                it.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(path)));
                startActivityForResult(it, 2000);
            }
        });
        mPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 4000);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 2.拍照完以后进行裁剪
        // RESULT_OK:-->是常亮,代表返回操作成功;
        if (requestCode == 2000 && resultCode == RESULT_OK) {
            // 2.调取系统的裁剪
            Intent it = new Intent("com.android.camera.action.CROP");
            // 拿到图片 type 图片的类型
            it.setDataAndType(Uri.fromFile(new File(path)), "image/*");
            // 是否支持裁剪
            it.putExtra("crop", true);
            // 设置宽高比
            it.putExtra("aspectX", 1);
            it.putExtra("aspectY", 1);
            // 设置图片输出的大小
            it.putExtra("outputX", 250);
            it.putExtra("outputY", 250);
            // 是否支持人脸识别
            it.putExtra("onFaceDetection", false);
            it.putExtra("return-data", true);
            // 剪裁完之后,发送startActivityForResult;
            startActivityForResult(it, 3000);

        }

        // 2.设置图片

        if (requestCode == 3000 && resultCode == RESULT_OK) {
            Bitmap bitmap = data.getParcelableExtra("data");
            try {
                //Bitmap对象保存味图片文件
                File file = new File(path);//将要保存图片的路径
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
                bos.flush();
                bos.close();
                // presenter.upPic(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 3.调取完系统的相册后 进行裁剪
        if (requestCode == 4000 && resultCode == RESULT_OK) {
            // 得到相册的图片的路径,直接用这个getData;
            Uri uri = data.getData();
            // 3.调取系统的裁剪
            Intent it = new Intent("com.android.camera.action.CROP");
            // 拿到图片 type 图片的类型
            it.setDataAndType(uri, "image/*");
            // 是否支持裁剪
            it.putExtra("crop", true);
            // 设置宽高比
            it.putExtra("aspectX", 1);
            it.putExtra("aspectY", 1);
            // 设置图片输出的大小
            it.putExtra("outputX", 250);
            it.putExtra("outputY", 250);
            // 是否支持人脸识别
            it.putExtra("onFaceDetection", false);
            it.putExtra("return-data", true);
            startActivityForResult(it, 3000);
        }
    }
}
