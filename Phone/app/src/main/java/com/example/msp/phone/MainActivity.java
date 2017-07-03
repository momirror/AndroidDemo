package com.example.msp.phone;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText textNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        textNumber =  (EditText)findViewById(R.id.editText);
        Button button = (Button)findViewById(R.id.button);

        //内部类实现响应方法
//        button.setOnClickListener(new MyClickListener());

        //匿名内部类方法实现响应方法
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                callPhone();
//            }
//        });

        //实现View.OnClickListener接口
//        button.setOnClickListener(this);

        //在layout 文件中指定click属性
    }

    @Override
    public void onClick(View v) {
        callPhone();
    }

    public void testClick(View v) {
        callPhone();
    }

    private  void callPhone() {
        String number = textNumber.getText().toString().trim();

        if("".equals(number)) {
            Toast.makeText(MainActivity.this,"电话号码不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        System.out.println("点我点我: "+ textNumber.getText());
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+number));
        startActivity(intent);
    }
    private  class  MyClickListener implements View.OnClickListener {

        @Override
        public void  onClick(View v) {
           callPhone();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
