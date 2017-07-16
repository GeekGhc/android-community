package com.gavin.community.mvp.presenter.Home;


import com.gavin.community.common.base.RxPresenter;
import com.gavin.community.common.base.contract.post.PostContract;

public class HomePagePresenter extends RxPresenter<PostContract.View> implements PostContract.Presenter{


    @Override
    public void getPostData(String tech, int type){

    }

    @Override
    public void getMorePostData(String tech) {

    }

    @Override
    public void getTypeImage(String tech){

    }

}
