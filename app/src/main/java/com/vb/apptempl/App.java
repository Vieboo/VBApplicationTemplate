package com.vb.apptempl;


import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.support.v7.app.AppCompatDelegate;
import android.text.TextUtils;


import com.blankj.utilcode.utils.AppUtils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.vb.apptempl.http.HttpRetrofitHelper;
import com.vb.imageloader.ImageLoaderHelper;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Vieboo on 2017/2/13 0013.
 */
public class App extends MultiDexApplication implements Handler.Callback {
    // 默认存放图片的路径
    public final static String IMAGE_CACHE_PATH = "vbapp/cache";

    private static App instance;

    public String client_version;//版本
    public int client_version_code;// 版本号
    public String client_device_id;// //设备ID

    private static HttpRetrofitHelper httpRetrofitHelper;

    public static App getInstance() {
        return instance;
    }

    public static HttpRetrofitHelper getHttpRetrofitHelper() {
        return httpRetrofitHelper;
    }

    /**
     * 分割 Dex 支持
     *
     * @param base
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //延迟初始化三方库，防止应用启动太慢
        mHandler.sendEmptyMessageDelayed(0, 200);
    }


    Handler mHandler = new Handler(this);

    @Override
    public boolean handleMessage(Message msg) {
        initVersionAndID();
        try {
            ImageLoaderHelper.init(instance, IMAGE_CACHE_PATH);
            httpRetrofitHelper = new HttpRetrofitHelper(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    public void initVersionAndID() {
        client_version = AppUtils.getAppVersionName(instance);
        client_version_code =AppUtils.getAppVersionCode(instance);
    }


    @Override
    public void onLowMemory() {
        // TODO Auto-generated method stub
        super.onLowMemory();
        try {
            ImageLoaderHelper.clearMemoryCache();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }


    public static String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager
                .getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }

    /**
     * 生成设备唯一标识
     * @return
     */
    private String makeAndroidID() {
        String time = String.valueOf(System.currentTimeMillis());
        String englist[] = new String[]{"A", "B", "C", "D", "E", "F", "G",
                "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z"};
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append(englist[random.nextInt(englist.length)]);
        sb.append(englist[random.nextInt(englist.length)]);
        sb.append(time.substring(0, time.length() / 2));
        sb.append(englist[random.nextInt(englist.length)]);
        sb.append(englist[random.nextInt(englist.length)]);
        sb.append(time.substring(0, time.length() / 2));
        sb.append(englist[random.nextInt(englist.length)]);
        sb.append(englist[random.nextInt(englist.length)]);
        sb.append(englist[random.nextInt(englist.length)]);
        sb.append(englist[random.nextInt(englist.length)]);
        return sb.toString();
    }

}