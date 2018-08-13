package cn.com.gfa.android.gfapdfview;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

import cn.com.gfa.android.commonutil.utils.LogUtil;

public class MainActivity extends AppCompatActivity {

    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pdfView = (PDFView) findViewById(R.id.pdfView);
//        pdfView.fromAsset("sample.pdf").load();
//        displayFromAssets("sample.pdf");
        displayFromFile( new File( Environment.getExternalStorageDirectory()+File.separator+ "sample.pdf"));

//        ApplicationUtil.init(this.getApplication());
        LogUtil.eTag("666666666","99999999999");
    }

    private void displayFromAssets(String assetFileName ) {
        pdfView.fromAsset(assetFileName)   //设置pdf文件地址
                .load();
    }

    private void displayFromFile( File file ) {
        pdfView.fromFile(file)   //设置pdf文件地址
                .swipeHorizontal(true)
                .load();
    }

}
