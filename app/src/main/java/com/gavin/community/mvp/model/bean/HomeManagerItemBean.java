package com.gavin.community.mvp.model.bean;


import android.os.Parcel;
import android.os.Parcelable;

public class HomeManagerItemBean implements Parcelable {

    private int index;
    private boolean isSelect;

    public HomeManagerItemBean () {

    }

    public HomeManagerItemBean(int index, boolean isSelec){
        this.index = index;
        this.isSelect = isSelect;
    }

    protected HomeManagerItemBean(Parcel in) {
        this.index = in.readInt();
        this.isSelect = in.readByte() != 0;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean getIsSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }


    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.index);
        dest.writeByte(this.isSelect ? (byte) 1 : (byte) 0);
    }

    public static final Parcelable.Creator<HomeManagerItemBean> CREATOR = new Parcelable.Creator<HomeManagerItemBean>() {
        @Override
        public HomeManagerItemBean createFromParcel(Parcel source) {
            return new HomeManagerItemBean(source);
        }

        @Override
        public HomeManagerItemBean[] newArray(int size) {
            return new HomeManagerItemBean[size];
        }
    };
}
