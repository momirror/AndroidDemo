package com.example.msp.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_name = (EditText) findViewById(R.id.et_name);
        EditText et_pwd = (EditText) findViewById(R.id.et_password);

        Map<String,String> userInfo = UserInfoUtils.readInfo();
        et_name.setText(userInfo.get("name").toString());
        et_pwd.setText(userInfo.get("pwd").toString());
    }

    public  void  login(View v) {
        EditText et_name = (EditText) findViewById(R.id.et_name);
        EditText et_pwd = (EditText) findViewById(R.id.et_password);

        String name = et_name.getText().toString().trim();
        String pwd = et_pwd.getText().toString().trim();

        if(TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)) {
            Toast.makeText(MainActivity.this,"用户名和密码不能为空",Toast.LENGTH_SHORT).show();
        } else {
            UserInfoUtils.saveInfo(et_name.getText().toString().trim(),et_pwd.getText().toString().trim());
        }
    }
}
