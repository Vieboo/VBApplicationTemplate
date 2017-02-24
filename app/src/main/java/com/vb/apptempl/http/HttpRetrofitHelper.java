package com.vb.apptempl.http;

import android.app.Application;

import com.vb.apptempl.constant.ApiConstants;
import com.vb.apptempl.constant.Constants;
import com.vb.apptempl.http.api.TestApi;
import com.vb.httpretrofit.BaseRetrofitHelper;

/**
 * Created by Administrator on 2017/2/24 0024.
 */

public class HttpRetrofitHelper extends BaseRetrofitHelper implements ApiConstants, Constants {

    private TestApi testApi;

    public HttpRetrofitHelper(Application app) {
        super(app);

        testApi = getApiService(TEST_URL, TestApi.class);
    }

    @Override
    public String getCachePath() {
        return PATH_CACHE;
    }

    @Override
    public int getTimeOutSeconds() {
        return NETWORK_TIMEOUT;
    }

    public TestApi getTestApi() {
        return testApi;
    }

}
