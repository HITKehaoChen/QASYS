package com.example.milky.qasys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity { //将qaactivity中的结果传入这里并显示.
    private ListView listview;
    private List<String> dataList = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        dataList = new ArrayList<String>();
        dataList.add("Q:软件开发云中各个区域的数据是否共通？\nA:软件开发云中各个区域的数据不共通，各自独立，如：东北区创建的项目、代码仓库、任务等，在华北区看不到，反之一样。此外，各个区域中各服务的使用量、计费情况也是分开计算的。说明：软件开发云目前只支持东北区和华北区。\n");
        ListAdapter adapter = new ArrayAdapter<String>(History.this,android.R.layout.simple_list_item_1,dataList);
        listview = (ListView) findViewById(R.id.msg_list_view);
        listview.setAdapter(adapter);
    }


}
