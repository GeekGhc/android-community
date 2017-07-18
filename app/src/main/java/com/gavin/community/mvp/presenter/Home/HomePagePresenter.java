package com.gavin.community.mvp.presenter.Home;


import com.gavin.community.app.api.PostAPI;
import com.gavin.community.app.http.response.PostHttpResponse;
import com.gavin.community.common.base.RxPresenter;
import com.gavin.community.common.base.contract.post.PostContract;
import com.gavin.community.di.module.HttpModule;
import com.gavin.community.mvp.model.bean.PostItemBean;
import com.gavin.community.mvp.ui.fragement.HomeFragment;
import com.gavin.community.mvp.ui.fragement.HomePageFragment;
import com.gavin.community.utils.ToastUtil;
import com.google.common.eventbus.Subscribe;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;


public class HomePagePresenter implements PostContract.Presenter {

    private int currentPage = 1;
    private int limitCount = 8;
    private String currentTech = HomeFragment.type[0];
    protected Retrofit mRetrofit;
    protected Retrofit.Builder mRetrofitBuilder;
    protected OkHttpClient mClient;
    PostAPI postService;
    List<PostItemBean> mList;
    protected HomePageFragment mView;

    @Inject
    public HomePagePresenter() {
        mRetrofit = new HttpModule().providePostRetrofit(mRetrofitBuilder, mClient);
        postService = mRetrofit.create(PostAPI.class);
    }

    public void onTakeView(HomePageFragment view) {
        this.mView = view;
    }

    @Override
    public void attachView(PostContract.View view) {
//        this.mView = view;
    }

    @Override
    public void detachView(){
        this.mView = null;
    }

    @Override
    public void getPostData(String tech, int type) {
        postService.getPostList(currentTech,limitCount,currentPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PostHttpResponse<List<PostItemBean>>>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(PostHttpResponse<List<PostItemBean>> postHttpResponse) {
                        mList = postHttpResponse.getData();
                        mView.showContent(mList);
                    }
                });
    }

    @Override
    public void getMorePostData(String tech) {

    }

    @Override
    public void getTypeImage(String tech) {

    }

}
