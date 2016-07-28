package com.hsj.example.screenadapterdemo03;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

public class MainActivity_bak02 extends AppCompatActivity {

    private DisplayMetrics displayMetrics=new DisplayMetrics();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取当前程序运行时对应的android版本号
        int currentVersion=Build.VERSION.SDK_INT;

        System.out.println("currentVersion="+currentVersion);


        if(currentVersion>=Build.VERSION_CODES.HONEYCOMB){
            System.out.println("当前android版本大于等于3.0,可以使用fragment");
        }else if(currentVersion>=Build.VERSION_CODES.JELLY_BEAN){

        } else{
            System.out.println("当前android版本小于3.0,不能使用fragment");
        }
    }
}
