package com.example.msp.sdcard;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Formatter;
import android.widget.EditText;

import java.io.File;
import java.text.Format;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File file = Environment.getExternalStorageDirectory();
        long totalSpace = file.getTotalSpace();//总大小
        Long usableSpace = file.getUsableSpace();//可用空间

        //转换数据格式为M/G
        String formatTotalSpace = Formatter.formatFileSize(this,totalSpace);

        String formatusableSpace = Formatter.formatFileSize(this,usableSpace);

        EditText et_total = (EditText) findViewById(R.id.et_total);
        EditText et_usable = (EditText) findViewById(R.id.et_usable);

        et_total.setText(formatTotalSpace);
        et_usable.setText(formatusableSpace);
    }
}
