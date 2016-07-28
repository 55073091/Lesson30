package com.hsj.example.screenadapterdemo03;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

public class MainActivity extends AppCompatActivity {

    private DisplayMetrics displayMetrics = new DisplayMetrics();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //将当前手机的屏幕的信息存储到DisplayMetrics对象中
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        //得到当前手机屏幕的屏幕密度
        float density = displayMetrics.density;
        System.out.println("density=" + density);

        int dpi = displayMetrics.densityDpi;
        System.out.println("dpi=" + dpi);

        //获取手机屏幕的宽度
        int width = displayMetrics.widthPixels;
        //获取手机屏幕的高度
        int heigth = displayMetrics.heightPixels;

        System.out.println("width=" + width + ",height=" + heigth);


        setContentView(R.layout.activity_main);


        int px = dip2px(this, 10);
        System.out.println("px=" + px);

        int dp = px2dip(this, px);

        System.out.println("dp=" + dp);

       int statusBarHeight= getStatusBarHeight(this);
        System.out.println("statusBarHeight="+statusBarHeight);
    }

    /**
     * 将dp转换成px
     *
     * @param context
     * @param dipValue
     * @return
     */
    public static int dip2px(Context context, float dipValue) {
        //获得密度比例
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 将px转换成dp
     *
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dip(Context context, float pxValue) {
        //获得密度比例
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    /**
     * 获取系统状态栏的高度
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        Class<?> c = null;
        Object obj = null;
        java.lang.reflect.Field field = null;
        int x = 0;
        int statusBarHeight = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = context.getResources().getDimensionPixelSize(x);
            return statusBarHeight;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
