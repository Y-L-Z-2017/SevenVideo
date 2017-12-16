package mycode.xin.com.seven_wying.mvp.choiceness;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import mycode.xin.com.seven_wying.R;
import mycode.xin.com.seven_wying.bean.HomeBean;
import mycode.xin.com.seven_wying.utils.MyBanner;

/**
 * data:2017/12/14
 * auther:admin
 */

public class JpAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private HomeBean bean;
    private LayoutInflater inflater;
    private List<HomeBean.RetBean.ListBean.ChildListBean> childList;
    public OnClickListener listener;

    public JpAdapter(Context context, HomeBean bean, List<HomeBean.RetBean.ListBean.ChildListBean> childList) {
        this.context = context;
        this.bean = bean;
        this.childList = childList;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==0){
            View view=inflater.inflate(R.layout.jp_item1,parent,false);
            Holder1 holder1=new Holder1(view);
            return holder1;
        }else if(viewType==1) {
            View view=inflater.inflate(R.layout.jp_item2,parent,false);
            final Holder2 holder2=new Holder2(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.Onclck(holder2.getPosition());
                }
            });
            return holder2;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof Holder1){
            List<String> list=new ArrayList<>();
            final List<HomeBean.RetBean.ListBean.ChildListBean> imagelist = bean.getRet().getList().get(0).getChildList();
            for (int i=0;i<imagelist.size();i++){
                list.add(imagelist.get(i).getPic());
                Log.e("ada",imagelist.get(i).getPic());
            }
            ((Holder1) holder).banner.setImageLoader(new MyBanner());
            ((Holder1) holder).banner.setImages(list);
            ((Holder1) holder).banner.start();
           ((Holder1) holder).banner.setOnBannerListener(new OnBannerListener() {
               @Override
               public void OnBannerClick(int position) {
                   Toast.makeText(context, imagelist.get(position).getTitle(), Toast.LENGTH_SHORT).show();
               }
           });
        }else if(holder instanceof Holder2) {
            ((Holder2) holder).title.setText(childList.get(position-1).getTitle());
            Glide.with(context).load(childList.get(position-1).getPic()).into(((Holder2) holder).imageView);
        }
    }

    @Override
    public int getItemCount() {
        return childList.size()+1;
    }
    @Override
    public int getItemViewType(int position) {
        return position==0?0:1;
    }
    class  Holder1 extends RecyclerView.ViewHolder{
        private Banner banner;
        public Holder1(View itemView) {
            super(itemView);
            banner=itemView.findViewById(R.id.banner);
        }
    }
    class Holder2 extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView title;
        public Holder2(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.slt);
            title=itemView.findViewById(R.id.tv_title);
        }
    }
    public interface OnClickListener{
        void Onclck(int position);
    }

    public void setListener(OnClickListener listener) {

        this.listener = listener;
    }



}
