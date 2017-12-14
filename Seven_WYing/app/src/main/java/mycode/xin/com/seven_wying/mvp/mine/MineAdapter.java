package mycode.xin.com.seven_wying.mvp.mine;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mycode.xin.com.seven_wying.R;

/**
 * date:2017/12/14  15:58
 * author:Mr.XIn💕
 */


public class MineAdapter extends BaseAdapter {
//    private String[] data;
    private Context mContext;
    private List<String> mMlist;

    public MineAdapter(List<String> mMlist, Context context) {
        this.mMlist = mMlist;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mMlist.size();
    }

    @Override
    public Object getItem(int i) {
        return mMlist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        HolderView holderView;
        if (convertView == null) {
            holderView = new HolderView();
            convertView = View.inflate(mContext, R.layout.iteam_list, null);
            holderView.tv=convertView.findViewById(R.id.tv1);
            convertView.setTag(holderView);
        }else {
            holderView= (HolderView) convertView.getTag();
        }
        holderView.tv.setText(mMlist.get(i));

        return convertView;
    }

    static class HolderView {
        private TextView tv;

    }


}

