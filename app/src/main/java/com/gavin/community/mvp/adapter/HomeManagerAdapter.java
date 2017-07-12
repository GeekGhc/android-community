package com.gavin.community.mvp.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmList;

import com.gavin.community.R;
import com.gavin.community.mvp.model.bean.HomeManagerItemBean;

import static com.gavin.community.mvp.ui.fragement.HomeFragment.type;

public class HomeManagerAdapter extends RecyclerView.Adapter<HomeManagerAdapter.ViewHolder>{

    private RealmList<HomeManagerItemBean> mList;
    private LayoutInflater inflater;

    public HomeManagerAdapter(Context mContext, RealmList<HomeManagerItemBean> mList) {
        inflater = LayoutInflater.from(mContext);
        this.mList = mList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_type_manager, parent, false));
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.tvType.setText(type[mList.get(position).getIndex()]);
        holder.scSwitch.setChecked(mList.get(position).getIsSelect());
        holder.scSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mList.get(holder.getAdapterPosition()).setSelect(b);
            }
        });
    }

    @Override
    public int getItemCount() {
        return type.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_gold_manager_type)
        TextView tvType;
        @BindView(R.id.sc_gold_manager_switch)
        SwitchCompat scSwitch;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
