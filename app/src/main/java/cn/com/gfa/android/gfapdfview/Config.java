package cn.com.gfa.android.gfapdfview;

import android.os.Environment;

public class Config {

    public static final String FILE_SEP = System.getProperty("file.separator");
    public static final String LINE_SEP = System.getProperty("line.separator");
    public static final String PKG      = "cn.com.gfa.android.gfapdfview";
    public static final String TEST_PKG = "cn.com.gfa.android.gfapdfview";
    public static final String GITHUB   = "https://github.com/Blankj/AndroidUtilCode";
    public static final String BLOG     = "http://www.jianshu.com/u/46702d5c6978";
    public static final String CACHE_PATH;
    public static final String TEST_APK_PATH;

    static {
        CACHE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
        TEST_APK_PATH = CACHE_PATH + FILE_SEP + "test_install.apk";
    }
}
