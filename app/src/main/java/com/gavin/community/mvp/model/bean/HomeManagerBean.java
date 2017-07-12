package com.gavin.community.mvp.model.bean;


import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmList;
import io.realm.RealmObject;

public class HomeManagerBean extends RealmObject implements Parcelable  {
    public HomeManagerBean() {

    }

    private RealmList<HomeManagerItemBean> managerList;

    public RealmList<HomeManagerItemBean> getManagerList()
    {
        return managerList;
    }

    public void setManagerList(RealmList<HomeManagerItemBean> managerList) {
        this.managerList = managerList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.managerList);
    }

    protected HomeManagerBean(Parcel in) {
        this.managerList = new RealmList<>();
        in.readList(this.managerList, HomeManagerItemBean.class.getClassLoader());
    }

    public HomeManagerBean(RealmList<HomeManagerItemBean> mList) {
        this.managerList = mList;
    }

    public static final Parcelable.Creator<HomeManagerBean> CREATOR = new Parcelable.Creator<HomeManagerBean>() {
        @Override
        public HomeManagerBean createFromParcel(Parcel source) {
            return new HomeManagerBean(source);
        }

        @Override
        public HomeManagerBean[] newArray(int size) {
            return new HomeManagerBean[size];
        }
    };


}
