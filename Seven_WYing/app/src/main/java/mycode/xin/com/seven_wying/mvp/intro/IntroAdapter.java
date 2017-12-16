package mycode.xin.com.seven_wying.mvp.intro;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import mycode.xin.com.seven_wying.R;
import mycode.xin.com.seven_wying.bean.IntroBean;

/**
 * date:2017/12/15  19:19
 * author:Mr.XIn💕
 */


public class IntroAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private IntroBean mIntroBean;
    private final LayoutInflater mInflater;

    public IntroAdapter(Context context, IntroBean introBean) {
        mContext = context;
        mIntroBean = introBean;
        mInflater = LayoutInflater.from(context);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.intro_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        Glide.with(mContext)
                .load(mIntroBean.getRet().getList().get(0).getChildList().get(position).getPic())
                .into(holder1.mIntroImg);
        holder1.mIntroName.setText(mIntroBean.getRet().getList().get(0).getChildList().get(position).getTitle());


    }

    @Override
    public int getItemCount() {
        return mIntroBean.getRet().getList().get(0).getChildList().size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.intro_img)
        ImageView mIntroImg;
        @BindView(R.id.intro_name)
        TextView mIntroName;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
