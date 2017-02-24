package com.vb.apptempl.presenter.contract;

import android.view.View;

import com.vb.apptempl.base.BasePresenter;
import com.vb.apptempl.base.BaseView;
import com.vb.apptempl.bean.NoticeBean;

/**
 * Created by Administrator on 2017/2/24 0024.
 */

public interface TestContract  {

    interface View extends BaseView {
        void showNotice(NoticeBean result);
    }

    interface Presenter extends BasePresenter<View> {
        void getNotices();
    }

}
