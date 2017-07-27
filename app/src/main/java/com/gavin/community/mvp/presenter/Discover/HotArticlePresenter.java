package com.gavin.community.mvp.presenter.Discover;

import com.gavin.community.app.api.ArticleAPI;
import com.gavin.community.app.api.PostAPI;
import com.gavin.community.app.http.response.ArticleHttpResponse;
import com.gavin.community.app.http.response.PostHttpResponse;
import com.gavin.community.common.base.contract.article.HotArticleContract;
import com.gavin.community.common.base.contract.post.PostContract;
import com.gavin.community.di.module.HttpModule;
import com.gavin.community.discover.fragment.DiscoverFragment;
import com.gavin.community.mvp.model.bean.ArticleItemBean;
import com.gavin.community.mvp.model.bean.PostItemBean;
import com.gavin.community.mvp.ui.fragement.HomePageFragment;
import com.gavin.community.utils.ToastUtil;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2017/7/27.
 * 热门文章的presenter
 */

public class HotArticlePresenter implements HotArticleContract.Presenter {

    private int limitCount = 8;
    protected Retrofit mRetrofit;
    protected Retrofit.Builder mRetrofitBuilder;
    protected OkHttpClient mClient;
    protected DiscoverFragment mView;
    List<ArticleItemBean> mList;
    ArticleAPI articleService;
    private String type;

    @Inject
    public HotArticlePresenter(String type) {
        mRetrofit = new HttpModule().provideArticleRetrofit(mRetrofitBuilder, mClient);
        articleService = mRetrofit.create(ArticleAPI.class);
        this.type = type;
    }

    public void onTakeView(DiscoverFragment view) {
        this.mView = view;
    }

    @Override
    public void attachView(HotArticleContract.View view) {
//        this.mView = view;
    }

    @Override
    public void detachView(){
        this.mView = null;
    }

    @Override
    public void getHotArticleData()
    {
        articleService.getHotList(type,limitCount)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ArticleHttpResponse<List<ArticleItemBean>>>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(Long.MAX_VALUE);
                    }
                    @Override
                    public void onComplete() {}
                    @Override
                    public void onError(Throwable e) {}
                    @Override
                    public void onNext(ArticleHttpResponse<List<ArticleItemBean>> articleHttpResponse) {
                        mList = articleHttpResponse.getData();
                        mView.showContent(mList);
                    }
                });

    }
}
