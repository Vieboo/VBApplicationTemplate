package com.vb.apptempl.constant;

import com.vb.apptempl.App;

import java.io.File;

/**
 * Created by Administrator on 2017/2/14 0014.
 */

public class Constants {

    //网络缓存
    public static final String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

}
