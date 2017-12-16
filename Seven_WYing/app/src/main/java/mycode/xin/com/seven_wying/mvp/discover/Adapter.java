package mycode.xin.com.seven_wying.mvp.discover;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.fashare.stack_layout.StackLayout;

import mycode.xin.com.seven_wying.R;
import mycode.xin.com.seven_wying.bean.DiscoverBean;


/**
 * 1.类的用途
 */

public class Adapter extends StackLayout.Adapter<Adapter.ViewHolder>{
    Context context;
    DiscoverBean bean;

    public Adapter(Context context, DiscoverBean bean) {
        this.context = context;
        this.bean = bean;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.discover_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mTextView.setText(bean.getRet().getList().get(position).getTitle());
        holder.jian.setText(bean.getRet().getList().get(position).getDescription());
        Glide.with(context).load(bean.getRet().getList().get(position).getPic()).into(holder.iv);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, position+"", Toast.LENGTH_SHORT).show();
                Toast.makeText(context, bean.getRet().getList().get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.i("sss",bean.getRet().getList().size()+"");
        return bean.getRet().getList().size();
    }

    public class ViewHolder extends StackLayout.ViewHolder{
        TextView mTextView,jian;
        ImageView iv,iv1;
        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.tv);
            jian = itemView.findViewById(R.id.jian);
            iv=itemView.findViewById(R.id.layout_content);
            iv1=itemView.findViewById(R.id.iv_delete);
        }
    }

}
