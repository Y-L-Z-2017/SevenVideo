package mycode.xin.com.seven_wying.fragmetns;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import mycode.xin.com.seven_wying.R;
import mycode.xin.com.seven_wying.mvp.mine.MineAdapter;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       List<String> mMlist = new ArrayList<>();
        mMlist.add("历史");
        mMlist.add("缓存");
        mMlist.add("收藏");
        mMlist.add("主题");
        mList.setAdapter(new MineAdapter(mMlist,getActivity()));
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
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

        mUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
