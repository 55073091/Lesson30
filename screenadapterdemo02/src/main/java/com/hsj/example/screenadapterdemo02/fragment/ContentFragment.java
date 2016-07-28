package com.hsj.example.screenadapterdemo02.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hsj.example.screenadapterdemo02.MyApp;
import com.hsj.example.screenadapterdemo02.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends Fragment {



    private TextView textView_info;

    /**
     * 给手机横屏时调用的方法
     * @param name
     */
    public void setName(String name){
        this.textView_info.setText(name+",你好,咱们吃饭去!");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_content, container, false);
        this.textView_info= (TextView) view.findViewById(R.id.textView_info);


        MyApp myApp= (MyApp) getActivity().getApplication();
        String name=myApp.getName();
        if(name==null){
            this.textView_info.setText("等待传值.....");
        }else{
            this.textView_info.setText(name+",你好,咱们吃饭去!");
        }


        return view;
    }


}
