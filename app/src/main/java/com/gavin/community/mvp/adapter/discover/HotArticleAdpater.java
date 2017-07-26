package com.gavin.community.mvp.adapter.discover;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gavin.community.R;
import com.gavin.community.mvp.adapter.MyPagerAdapter;
import com.gavin.community.mvp.model.bean.ArticleItemBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/21.
 * 热门文章适配器
 */

public class HotArticleAdpater  extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    private LayoutInflater inflater;
    private List<ArticleItemBean> mList;
    private HotArticleAdpater.OnItemClickListener onItemClickListener;

   public void HotArticleAdpater(Context mContext, List<ArticleItemBean> list){
       inflater = LayoutInflater.from(mContext);
       this.mList = list;
   }

    @Override
    public HotArticleAdpater.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HotArticleAdpater.MyViewHolder(inflater.inflate(R.layout.item_hot_article, parent, false));
    }

    //渲染子元素的信息
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        ((MyViewHolder)holder).tvAuthor.setText(mList.get(position).getAuthor());
        ((MyViewHolder)holder).tvTitle.setText(mList.get(position).getTitle());
        ((MyViewHolder)holder).tvTime.setText("发表于"+mList.get(position).getCreatedAt());
        ((MyViewHolder)holder).tvFavorite.setText(mList.get(position).getFavoriteCount()+"人喜欢");
        //子元素的点击事件
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

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_article_img)
        ImageView ivImg;
        @BindView(R.id.tv_article_title)
        TextView tvTitle;
        @BindView(R.id.tv_article_author)
        TextView tvAuthor;
        @BindView(R.id.tv_article_favorite)
        TextView tvFavorite;
        @BindView(R.id.tv_article_time)
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

    public void setOnItemClickListener(HotArticleAdpater.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position,View view);
    }
}
