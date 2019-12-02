package com.yw.customerweight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.yw.ywlibrary.YwTitleLayout;

public class MainActivity extends AppCompatActivity implements YwTitleLayout.YwTitleLayoutCallBack {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        YwTitleLayout ywTitleLayout = findViewById(R.id.titlebar);
        ywTitleLayout.setYwTitleLayoutCallBack(this);
    }

    @Override
    public void leftClick(TextView tv_left) {
        finish();
    }

    @Override
    public void rightClick(TextView tv_right) {

    }
}
