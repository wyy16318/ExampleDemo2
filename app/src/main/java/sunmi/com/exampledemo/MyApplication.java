package sunmi.com.exampledemo;

import android.app.Application;
import android.util.Log;

import com.maning.librarycrashmonitor.MCrashMonitor;
import com.maning.librarycrashmonitor.listener.MCrashCallBack;

import java.io.File;

/**
 * 　　  　　　　 ┏┓       ┏┓
 * 　　　　　　　┏┛┻━━━━━━━┛┻┓
 * 　　　　　　　┃　　　　　　 ┃
 * 　　　　　　　┃　　　━　　　┃
 * 　　　　　　 █████━█████  ┃
 * 　　　　　　　┃　　　　　　 ┃
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　 ┃
 * 　　　　　　　┗━━┓　　　 ┏━┛
 * 　　　　　　　　　　┃　　　┃  神兽保佑,代码无bug
 * <p>
 * Created by Administrator on 2018/9/25.
 * Created with Android Studio
 * Created By Kinsey
 * Date: 2018/9/25
 * Time: 17:33
 * 王洋洋
 */

public class MyApplication    extends Application{


    private static final String TAG = "MyApplication";
    private static MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        initCrashMonitor();
    }

    public static MyApplication getInstance(){
        return myApplication;
    }

    private void initCrashMonitor() {
        /**
         * 初始化日志系统
         * context :    上下文
         * isDebug :    是不是Debug模式,true:崩溃后显示自定义崩溃页面 ;false:关闭应用,不跳转奔溃页面(默认)
         * CrashCallBack : 回调执行
         */
        MCrashMonitor.init(this, true, new MCrashCallBack() {
            @Override
            public void onCrash(File file) {
                //可以在这里保存标识，下次再次进入把日志发送给服务器
                Log.i(TAG, "CrashMonitor回调:" + file.getAbsolutePath());
            }
        });
    }



}
