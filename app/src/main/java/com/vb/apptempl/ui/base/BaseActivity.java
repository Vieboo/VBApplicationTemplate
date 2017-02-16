package com.vb.apptempl.ui.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.blankj.utilcode.utils.KeyboardUtils;
import com.vb.apptempl.R;
import com.vb.titlebar.TitleBar;

import butterknife.ButterKnife;
import slide.SlideDirection;
import slide.SlideFinishOnGestureListener;


/**
 * Created by Vieboo on 2017/2/9 0009.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected Activity mActivity;
    protected boolean slideFinishFlag = true;  //是否支持右滑返回
    protected GestureDetector detector; // 触摸监听实例
    protected SlideFinishOnGestureListener gestureListener;
    protected SlideDirection slideDirection;

    /**
     * 初始化数据
     */
    protected abstract void initData(Bundle savedInstanceState);

    /**
     * 初始化布局文件
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 初始化标题栏
     */
    protected abstract void initTitleBar();

    /**
     * 初始化UI和事件
     */
    protected abstract void initViewEvent(Bundle savedInstanceState);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        initData(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initTitleBar();
        initViewEvent(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onStop();
    }

    /**
     * 启动Activity从右边进入动画
     *
     * @param intent
     */
    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.slide_in_from_right,
                R.anim.slide_out_to_left);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        overridePendingTransition(R.anim.slide_in_from_right,
                R.anim.slide_out_to_left);
    }

    /**
     * 启动Activity无动画
     * @param intent
     */
    public void startActivityNoAnim(Intent intent) {
        super.startActivity(intent);
    }

    public void startActivityForResultNoAnim(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
    }


    /**
     * 启动Activity从下面启动动画
     *
     * @param intent
     */
    public void startActivity4UpAndDown(Intent intent) {
        super.startActivity(intent);
        mActivity.overridePendingTransition(R.anim.slide_in_from_bottom, R.anim.slide_out);
        KeyboardUtils.dismissKeyboard(this);
    }


    public void startActivity4UpAndDownForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        mActivity.overridePendingTransition(R.anim.slide_in_from_bottom, R.anim.slide_out);
    }

    /**
     * 销毁Activity从右边出去动画
     */
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_from_left,
                R.anim.slide_out_to_right);
        KeyboardUtils.dismissKeyboard(this);
    }

    /**
     * 销毁Activity无动画
     */
    public void finishNoAnim() {
        super.finish();
        KeyboardUtils.dismissKeyboard(this);
    }
    /**
     * 销毁Activity从上面到下面的动画
     */
    public void finish4UpAndDown() {
        super.finish();
        overridePendingTransition(R.anim.slide_out, R.anim.slide_out_to_bottom);
        KeyboardUtils.dismissKeyboard(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev == null) {
            return true;
        }
        if(!slideFinishFlag) return super.dispatchTouchEvent(ev);
        // 过滤右划关闭监听时间
        boolean isGesture = false;
        // if (GlobalVars.IS_ENABLE_GESTURE) {
        if (slideDirection == null) {
            slideDirection = SlideDirection.RIGHT;
        }
        if (detector == null) {
            gestureListener = new SlideFinishOnGestureListener(this,
                    slideDirection);
            detector = new GestureDetector(this, gestureListener);
        }
        isGesture = detector.onTouchEvent(ev);
        // }
        if (isGesture) {
            return isGesture;
        } else {
            try {
                return super.dispatchTouchEvent(ev);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    /**
     * 关闭右滑退出
     */
    protected void closeSlideFinish() {
        slideFinishFlag = false;
    }

}
