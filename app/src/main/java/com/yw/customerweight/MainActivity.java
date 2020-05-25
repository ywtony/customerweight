package com.yw.customerweight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.yw.customerweight.adapter.MainAdapter;
import com.yw.ywlibrary.YwTitleLayout;
import com.yw.ywlibrary.widget.CommonTabLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private MainAdapter adapter = null;
    //存储标题名称
    private List<String> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        initData();
        adapter = new MainAdapter(this, datas);
        listView.setAdapter(adapter);
    }

    /**
     * 初始化列表数据
     */
    private void initData() {
        datas = Arrays.asList(getResources().getStringArray(R.array.classNames));
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent();
        intent.setClassName(this, datas.get(i));
        startActivity(intent);
    }
}
