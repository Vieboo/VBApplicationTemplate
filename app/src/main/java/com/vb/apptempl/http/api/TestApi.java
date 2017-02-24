package com.vb.apptempl.http.api;


import com.vb.apptempl.base.BaseBean;
import com.vb.apptempl.bean.NoticeBean;

import io.reactivex.Observable;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/2/23 0023.
 */

public interface TestApi {

    @POST("finance_interface/newsNotice/getNewsNotice")
    Observable<BaseBean<NoticeBean>> getNotice();
}
