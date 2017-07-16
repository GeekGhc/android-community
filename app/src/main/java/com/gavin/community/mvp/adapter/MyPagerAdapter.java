package com.gavin.community.mvp.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gavin.community.R;
import com.gavin.community.mvp.model.bean.GankItemBean;
import com.gavin.community.mvp.model.bean.PostItemBean;
import com.gavin.community.mvp.ui.fragement.HomeFragment;
import com.gavin.community.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MyPagerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
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
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomePageAdapter.ViewHolder(inflater.inflate(R.layout.item_tech, parent, false));
    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if(tech.equals(HomeFragment.type[0])) {
            ((HomePageAdapter.ViewHolder)holder).ivIcon.setImageResource(R.mipmap.ic_android);
        } else if(tech.equals(HomeFragment.type[1])) {
            ((HomePageAdapter.ViewHolder)holder).ivIcon.setImageResource(R.mipmap.ic_ios);
        } else if(tech.equals(HomeFragment.type[2])) {
            ((HomePageAdapter.ViewHolder)holder).ivIcon.setImageResource(R.mipmap.ic_web);
        }else if(tech.equals(HomeFragment.type[3])){
            ((HomePageAdapter.ViewHolder)holder).ivIcon.setImageResource(R.mipmap.ic_php);
        }
        ((ViewHolder)holder).tvAuthor.setText(mList.get(position).getAuthor());
        ((ViewHolder)holder).tvTitle.setText(mList.get(position).getTitle());
        ((ViewHolder)holder).tvComment.setText(mList.get(position).getCommentCount());
        ((ViewHolder)holder).tvTime.setText(mList.get(position).getCreatedAt());
//        ((MyPagerAdapter.ViewHolder)holder).tvTime.setText(DateUtils.formatDateTime(DateUtils.subStandardTime(mList.get(position).getCreatedAt()), true));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickListener != null) {
                    CardView cv = (CardView) view.findViewById(R.id.cv_post_content);
                    onItemClickListener.onItemClick(holder.getAdapterPosition(),cv);
                }
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

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
        public ViewHolder(View itemView) {
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
