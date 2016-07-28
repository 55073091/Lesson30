package com.hsj.example.screenadapterdemo03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

public class MainActivity_bak01 extends AppCompatActivity {

    private DisplayMetrics displayMetrics=new DisplayMetrics();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //将当前手机的屏幕的信息存储到DisplayMetrics对象中
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        //得到当前手机屏幕的屏幕密度
        float density= displayMetrics.density;
        System.out.println("density="+density);

        int dpi=displayMetrics.densityDpi;
        System.out.println("dpi="+dpi);

        //获取手机屏幕的宽度
        int width=displayMetrics.widthPixels;
        //获取手机屏幕的高度
        int heigth=displayMetrics.heightPixels;

        System.out.println("width="+width+",height="+heigth);


        setContentView(R.layout.activity_main);
    }
}
