package com.vb.apptempl.presenter;

import com.vb.apptempl.App;
import com.vb.apptempl.base.BaseBean;
import com.vb.apptempl.base.RxPresenter;
import com.vb.apptempl.bean.NoticeBean;
import com.vb.apptempl.presenter.contract.TestContract;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by Administrator on 2017/2/24 0024.
 */

public class TestPresenter extends RxPresenter<TestContract.View> implements TestContract.Presenter {


    @Override
    public void getNotices() {

    }
}
