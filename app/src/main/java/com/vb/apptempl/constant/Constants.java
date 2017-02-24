package com.vb.apptempl.constant;

import com.vb.apptempl.App;

import java.io.File;

/**
 * Created by Administrator on 2017/2/14 0014.
 */

public interface Constants {

    //网络缓存
    String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    String PATH_CACHE = PATH_DATA + "/NetCache";

}
