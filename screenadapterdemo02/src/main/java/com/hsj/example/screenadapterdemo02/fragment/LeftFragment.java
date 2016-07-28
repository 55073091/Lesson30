package com.hsj.example.screenadapterdemo02.fragment;

import android.app.ListFragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hsj.example.screenadapterdemo02.DetailActivity;
import com.hsj.example.screenadapterdemo02.MyApp;
import com.hsj.example.screenadapterdemo02.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hsjwcf on 16/7/28.
 */
public class LeftFragment extends ListFragment {

    private ArrayAdapter<String> adapter;
    private List<String> data;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.data=this.getData();
        this.adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,data);
        this.setListAdapter(adapter);
    }

    private List<String> getData() {
        this.data=new ArrayList<>();
        for(int i=0;i<30;i++){
            this.data.add("小丽"+i);
        }
        return this.data;
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
       String name= data.get(position);

        MyApp myApp= (MyApp) getActivity().getApplication();
        myApp.setName(name);

        //this.getResources().getConfiguration().orientation:得到当前手机屏幕方向对应的整数值
        if(this.getResources().getConfiguration().orientation==Configuration.ORIENTATION_PORTRAIT){
            Intent intent=new Intent(getActivity(), DetailActivity.class);
            startActivity(intent);
        } else if(this.getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
           ContentFragment contentFragment= (ContentFragment) getFragmentManager().findFragmentById(R.id.fragment_content);
            contentFragment.setName(name);
        }

        //Toast.makeText(getActivity(), "name="+name, Toast.LENGTH_SHORT).show();
    }
}
