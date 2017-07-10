package com.gavin.community.mvp.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.gavin.community.R;
import com.gavin.community.app.App;
import com.gavin.community.common.BarManager;
import com.gavin.community.common.base.BaseAppCompatActivity;
import com.gavin.community.common.base.SimpleActivity;
import com.gavin.community.discover.fragment.DiscoverFragment;
import com.gavin.community.home.post.fragment.PostSwipeActivity;
import com.gavin.community.message.fragment.MessageFragment;
import com.gavin.community.mvp.ui.fragement.HomeFragment;
import com.gavin.community.myself.fragment.MySelfFragment;

import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;

public class MainActivity extends SimpleActivity {

    //底部选项栏
    private static final String TAB_HOME_FRAGMENT = "home";
    private static final String TAB_MESSAGE_FRAGMENT = "message";
    private static final String TAB_DISCOVERY_FRAGMENT = "discovery";
    private static final String TAB_PROFILE_FRAGMENT = "profile";

    private RelativeLayout mHomeTabRl, mMessageTabRl, mDiscoverTabRl, mMySelfTabRl;
    private HomeFragment mHomeFragment;
    private DiscoverFragment mDiscoverFragment;
    private MessageFragment mMessageFragment;
    private MySelfFragment mMySelfFragment;
    private FragmentManager mFragmentManager;

    private FragmentTransaction mTransaction;
    private BarManager mBarManager;
    private ImageView mPostTabIv;
    private LinearLayout mButtonBarLl;


    private String mCurrentIndex;
    private boolean mComeFromAccoutActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initEventAndData();

        //如果是从崩溃中恢复，还需要加载之前的缓存
        if (savedInstanceState != null) {
            restoreFragment(savedInstanceState);
        } else {
            setTabFragment(TAB_HOME_FRAGMENT);
        }
        setTabFragment(TAB_HOME_FRAGMENT);
    }

    @Override
    protected void initEventAndData() {
        prepareView();
        initData();
        initView();
        initListener();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    //初始化数据
    private void initData()
    {

    }

    //初始化视图
    private void initView()
    {
        mBarManager = new BarManager();
        mBarManager.showBottomBar(mButtonBarLl);
        mFragmentManager = getSupportFragmentManager();
    }

    //初始化监听器
    private void initListener()
    {
        mHomeTabRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTabFragment(TAB_HOME_FRAGMENT);
            }
        });
        mMessageTabRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTabFragment(TAB_MESSAGE_FRAGMENT);
            }
        });
        mPostTabIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PostSwipeActivity.class);
                startActivity(intent);
            }
        });
        mDiscoverTabRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTabFragment(TAB_DISCOVERY_FRAGMENT);
            }
        });
        mMySelfTabRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTabFragment(TAB_PROFILE_FRAGMENT);
            }
        });
    }

    //视图准备
    private void prepareView() {
        mHomeTabRl = (RelativeLayout) findViewById(R.id.tv_home);
        mMessageTabRl = (RelativeLayout) findViewById(R.id.tv_message);
        mDiscoverTabRl = (RelativeLayout) findViewById(R.id.tv_discovery);
        mMySelfTabRl = (RelativeLayout) findViewById(R.id.tv_profile);
        mPostTabIv = (ImageView) findViewById(R.id.fl_post);
        mButtonBarLl = (LinearLayout) findViewById(R.id.buttonBarId);
    }

    /**
     * 执行切换fragment 的操作
     * 注意：
     * 1. 切换页面的时候，还要调用showBottomBar来保证底部导航栏的显示
     *
     * @param index
     */
    private void switchToFragment(String index) {
        mButtonBarLl.clearAnimation();
        mButtonBarLl.setVisibility(View.VISIBLE);
        mTransaction = mFragmentManager.beginTransaction();
        hideAllFragments(mTransaction);
        switch (index) {
            case TAB_HOME_FRAGMENT:
                showHomeFragment();
                break;
            case TAB_MESSAGE_FRAGMENT:
                showMessageFragment();
                break;
            case TAB_DISCOVERY_FRAGMENT:
                showDiscoveryFragment();
                break;
            case TAB_PROFILE_FRAGMENT:
                showProfileFragment();
                break;
        }
        mCurrentIndex = index;
        mTransaction.commit();
    }

    /**
     * 切换到首页模块
     */
    private void showHomeFragment() {
        mHomeTabRl.setSelected(true);
        if (mHomeFragment == null) {
            mHomeFragment = new HomeFragment();
            mTransaction.add(R.id.main_content_fl, mHomeFragment, TAB_HOME_FRAGMENT);
        } else {
            mTransaction.show(mHomeFragment);
        }

    }

    /**
     * 切换到消息模块
     */
    private void showMessageFragment() {
        mMessageTabRl.setSelected(true);
        if (mMessageFragment == null) {
            mMessageFragment = new MessageFragment();
            mTransaction.add(R.id.main_content_fl, mMessageFragment, TAB_MESSAGE_FRAGMENT);
        } else {
            mTransaction.show(mMessageFragment);
        }
    }

    /**
     * 切换到发现模块
     */
    private void showDiscoveryFragment() {
        mDiscoverTabRl.setSelected(true);
        if (mDiscoverFragment == null) {
            mDiscoverFragment = new DiscoverFragment();
            mTransaction.add(R.id.main_content_fl, mDiscoverFragment, TAB_DISCOVERY_FRAGMENT);
        } else {
            mTransaction.show(mDiscoverFragment);
        }
    }

    /**
     * 切换到关于我模块
     */
    private void showProfileFragment() {
        mMySelfTabRl.setSelected(true);
        if (mMySelfFragment == null) {
            mMySelfFragment = new MySelfFragment();
            mTransaction.add(R.id.main_content_fl, mMySelfFragment, TAB_PROFILE_FRAGMENT);
        } else {
            mTransaction.show(mMySelfFragment);

        }
    }


    /**
     * 显示指定的fragment，并且把对应的导航栏的icon设置成高亮状态
     * 注意：
     * 1. 如果选项卡已经位于当前页，则执行其他操作
     *
     * @param tabName 需要切换到的具体页面
     */
    private void setTabFragment(String tabName) {
        if (mHomeFragment != null) {
            mBarManager.showBottomBar(mButtonBarLl);
        }

        if (!tabName.equals(mCurrentIndex)) {
            switchToFragment(tabName);
        } else {
            alreadyAtFragment(mCurrentIndex);
        }
    }

    /**
     * 如果选项卡已经位于当前页
     * 1. 对于首页fragment，执行：滑动到顶部，并且刷新时间线，获取最新微博
     * 2. 对于消息fragment，执行：无
     * 3. 对于发现fragment，执行：无
     * 4. 对于关于我fragment，执行：无
     *
     * @param currentIndex
     */
    private void alreadyAtFragment(String currentIndex) {
        //如果在当前页
        switch (currentIndex) {
            case TAB_HOME_FRAGMENT:
                break;
            case TAB_MESSAGE_FRAGMENT:
                break;
            case TAB_DISCOVERY_FRAGMENT:
                break;
            case TAB_PROFILE_FRAGMENT:
                break;
        }
    }


    /**
     * 隐藏所有的fragment，并且取消所有的底部导航栏的icon的高亮状态
     *
     * @param transaction
     */
    private void hideAllFragments(FragmentTransaction transaction) {
        if (mHomeFragment != null) {
            transaction.hide(mHomeFragment);
        }
        if (mMessageFragment != null) {
            transaction.hide(mMessageFragment);
        }

        if (mDiscoverFragment != null) {
            transaction.hide(mDiscoverFragment);
        }
        if (mMySelfFragment != null) {
            transaction.hide(mMySelfFragment);
        }
        mHomeTabRl.setSelected(false);
        mMessageTabRl.setSelected(false);
        mDiscoverTabRl.setSelected(false);
        mMySelfTabRl.setSelected(false);
    }

    /**
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mHomeFragment != null) {
            mHomeFragment.onActivityResult(requestCode, resultCode, data);
        }
    }

    /**
     * 监听返回按钮
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == android.view.KeyEvent.KEYCODE_BACK) {
            showExitDialog();
        }
        return false;
    }


    /**
     * 如果fragment因为内存不够或者其他原因被销毁掉，在这个方法中执行恢复操作
     */
    private void restoreFragment(Bundle savedInstanceState) {
        mCurrentIndex = savedInstanceState.getString("index");
        mHomeFragment = (HomeFragment) mFragmentManager.findFragmentByTag(TAB_HOME_FRAGMENT);
        mMessageFragment = (MessageFragment) mFragmentManager.findFragmentByTag(TAB_MESSAGE_FRAGMENT);
        mDiscoverFragment = (DiscoverFragment) mFragmentManager.findFragmentByTag(TAB_DISCOVERY_FRAGMENT);
        mMySelfFragment = (MySelfFragment) mFragmentManager.findFragmentByTag(TAB_PROFILE_FRAGMENT);
        switchToFragment(mCurrentIndex);
    }


    /**
     * Activity被销毁的时候，要记录当前处于哪个页面
     *
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("index", mCurrentIndex);
        super.onSaveInstanceState(outState);
    }

    /**
     * 显示退出窗口
     */
    public void showExitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setMessage("确定要退出？")
                .setCancelable(true)
                .setIcon(R.drawable.logo)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        App.getInstance().finishAll();
                        finish();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
