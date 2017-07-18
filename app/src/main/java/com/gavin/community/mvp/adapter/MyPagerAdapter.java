package com.gavin.community.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gavin.community.R;
import com.gavin.community.mvp.model.bean.PostItemBean;
import com.gavin.community.mvp.ui.fragement.HomeFragment;
import com.gavin.community.mvp.ui.fragement.HomePageFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MyPagerAdapter extends RecyclerView.Adapter<MyPagerAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    private List<PostItemBean> mList;
    private MyPagerAdapter.OnItemClickListener onItemClickListener;

    private String tech;

    public MyPagerAdapter(Context mContext, List<PostItemBean> mList,String tech) {
        inflater = LayoutInflater.from(mContext);
        this.mList = mList;
        this.tech = tech;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyPagerAdapter.MyViewHolder(inflater.inflate(R.layout.item_post, parent, false));
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if(tech.equals(HomeFragment.type[0])) {
            holder.ivImg.setImageResource(R.mipmap.ic_android);
        } else if(tech.equals(HomeFragment.type[1])) {
           holder.ivImg.setImageResource(R.mipmap.ic_ios);
        } else if(tech.equals(HomeFragment.type[2])) {
            holder.ivImg.setImageResource(R.mipmap.ic_web);
        }else if(tech.equals(HomeFragment.type[3])){
            holder.ivImg.setImageResource(R.mipmap.ic_php);
        }
        holder.tvAuthor.setText(mList.get(position).getAuthor());
        holder.tvTitle.setText(mList.get(position).getTitle());
        holder.tvComment.setText(mList.get(position).getComment_count());
        holder.tvTime.setText(mList.get(position).getCreated_at());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickListener != null) {
                    /*CardView cv = (CardView) view.findViewById(R.id.cv_post_content);
                    onItemClickListener.onItemClick(holder.getAdapterPosition(),cv);*/
                }
            }
        });
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_post_img)
        ImageView ivImg;
        @BindView(R.id.tv_post_title)
        TextView tvTitle;
        @BindView(R.id.tv_post_author)
        TextView tvAuthor;
        @BindView(R.id.tv_post_comment)
        TextView tvComment;
        @BindView(R.id.tv_post_time)
        TextView tvTime;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setOnItemClickListener(MyPagerAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position,View view);
    }
}
