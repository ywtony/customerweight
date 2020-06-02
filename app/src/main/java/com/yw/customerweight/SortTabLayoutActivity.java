package com.yw.customerweight;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.yw.ywlibrary.widget.sorttab.SortTabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * description: 排序的tabLayout
 *
 * @author 杨伟-tony
 * create by 2020/6/2 9:50
 */
public class SortTabLayoutActivity extends Activity {
    private SortTabLayout sortTabLayout1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sorttablayout);
        sortTabLayout1 = findViewById(R.id.sorttablayout1);
        List<String> datas = new ArrayList<>();
        datas.add("Item1");
        datas.add("Item2");
        datas.add("Item3");
        datas.add("Item4");
        sortTabLayout1.setDatas(datas)
                .setIconResource(R.mipmap.main_house_map_tip_blue)
                .setMarginLeft(5)
                .setTextColor(R.color.color_333333)
                .setTextSize(5)
                .createSortTab()
                .setOnSortTabItemClickListener(new SortTabLayout.OnSortTabItemClickListener() {
                    @Override
                    public void onItemClick(int pos) {
                        Toast.makeText(getApplicationContext(),"您点击了Item:+"+pos,Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
