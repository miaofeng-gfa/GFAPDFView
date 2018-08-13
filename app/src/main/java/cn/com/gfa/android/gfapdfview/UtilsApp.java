package cn.com.gfa.android.gfapdfview;

import java.io.IOException;

import cn.com.gfa.android.commonutil.utils.ApplicationUtil;
import cn.com.gfa.android.commonutil.utils.CrashUtil;
import cn.com.gfa.android.commonutil.utils.FileIOUtils;
import cn.com.gfa.android.commonutil.utils.FileUtil;
import cn.com.gfa.android.commonutil.utils.LogUtil;
import cn.com.gfa.android.commonutil.utils.ThreadPoolUtil;

public class UtilsApp extends BaseApplication {

    private static UtilsApp sInstance;

    public static UtilsApp getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        ApplicationUtil.init(this);
        initLeakCanary();
        initLog();
        initCrash();
        initAssets();
    }

    private void initLeakCanary() {
        // 内存泄露检查工具
       /* if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);*/
    }

    // init it in ur application
    public void initLog() {
        LogUtil.Config config = LogUtil.getConfig()
                .setLogSwitch(BuildConfig.DEBUG)// 设置 log 总开关，包括输出到控制台和文件，默认开
                .setConsoleSwitch(BuildConfig.DEBUG)// 设置是否输出到控制台开关，默认开
                .setGlobalTag(null)// 设置 log 全局标签，默认为空
                // 当全局标签不为空时，我们输出的 log 全部为该 tag，
                // 为空时，如果传入的 tag 为空那就显示类名，否则显示 tag
                .setLogHeadSwitch(true)// 设置 log 头信息开关，默认为开
                .setLog2FileSwitch(false)// 打印 log 时是否存到文件的开关，默认关
                .setDir("")// 当自定义路径为空时，写入应用的/cache/log/目录中
                .setFilePrefix("")// 当文件前缀为空时，默认为"util"，即写入文件为"util-MM-dd.txt"
                .setBorderSwitch(true)// 输出日志是否带边框开关，默认开
                .setConsoleFilter(LogUtil.V)// log 的控制台过滤器，和 logcat 过滤器同理，默认 Verbose
                .setFileFilter(LogUtil.V)// log 文件过滤器，和 logcat 过滤器同理，默认 Verbose
                .setStackDeep(1);// log 栈深度，默认为 1
        LogUtil.d(config.toString());
    }

    private void initCrash() {
        CrashUtil.init();
    }

    private void initAssets() {
        if (!FileUtil.isFileExists(Config.TEST_APK_PATH)) {
            ThreadPoolUtil poolUtils = new ThreadPoolUtil(ThreadPoolUtil.SingleThread, 1);
            poolUtils.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        FileIOUtils.writeFileFromIS(Config.TEST_APK_PATH, getAssets().open("test_install"), false);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        } else {
            LogUtil.d("test apk existed.");
        }
    }
}
