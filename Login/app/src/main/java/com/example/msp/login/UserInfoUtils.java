package com.example.msp.login;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by moshanpi on 7/4/17.
 */

public class UserInfoUtils {

    public  static boolean saveInfo(String name,String pwd) {
        try{
              String result = name + "##" + pwd;

            File file = new File("/mnt/sdcard/info.txt");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(result.getBytes());
            fos.close();
            return true;


        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public  static Map<String,String> readInfo() {
        try {

            Map<String,String> maps = new HashMap<String, String>();
            File file = new File("/mnt/sdcard/info.txt");
            FileInputStream fis = new FileInputStream(file);
            BufferedReader bufr = new BufferedReader(new InputStreamReader(fis));
            String content = bufr.readLine();

            String[] splits = content.split("##");
            String name = splits[0];
            String pwd = splits[1];
            maps.put("name",name);
            maps.put("pwd",pwd);
            fis.close();
            return maps;

        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
