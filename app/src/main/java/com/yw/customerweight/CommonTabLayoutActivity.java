package com.yw.customerweight;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;


import com.yw.ywlibrary.util.PxUtils;
import com.yw.ywlibrary.widget.CommonTabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author 杨伟-tony
 * create by 2020/5/18 16:27
 */
public class CommonTabLayoutActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selecttablayout);
        CommonTabLayout selectTabLayout = (CommonTabLayout) findViewById(R.id.tablayout);
        List<String> datas = new ArrayList<>();
        datas.add("来电");
        datas.add("来访");
        datas.add("认购");
        datas.add("签约");
        datas.add("签约");
        /**
         * 创建一个左、中、右背景切换各不同的TabLayout（ps：也可以相同，看您怎样设置）
         */
        selectTabLayout.
                setData(datas).
                setTextColor(R.color.manager_radio_textcolor_selector).
                setLeftDrawableSelector(R.drawable.manager_radio_left_selector).
                setMiddleDrawableSelector(R.drawable.manager_radio_middle_selector).
                setRightDrawableSelector(R.drawable.manager_radio_right_selector).
                setDefaultSelectIndex(2).
                setOnItemClickListener(new CommonTabLayout.OnItemClickListener() {
                    @Override
                    public void onItemClick(int pos) {
                        Toast.makeText(CommonTabLayoutActivity.this, "您点击了其中的某一项:"+pos, Toast.LENGTH_SHORT).show();
                    }
                }).buildViewByLeftMiddleRight();


        CommonTabLayout selectTabLayout2 = findViewById(R.id.tablayout2);
        List<String> datas2 = new ArrayList<>();
        datas2.add("Left");
        datas2.add("Right");
        /**
         * 创建一个左、右背景切换各不同的TabLayout（ps：也可以相同，看您怎样设置）
         */
        selectTabLayout2.
                setData(datas2).
                setTextColor(R.color.manager_radio_textcolor_selector).
                setLeftDrawableSelector(R.drawable.manager_radio_left_selector).
                setMiddleDrawableSelector(R.drawable.manager_radio_middle_selector).
                setRightDrawableSelector(R.drawable.manager_radio_right_selector).
                setDefaultSelectIndex(1).
                setOnItemClickListener(new CommonTabLayout.OnItemClickListener() {
                    @Override
                    public void onItemClick(int pos) {
                        Toast.makeText(CommonTabLayoutActivity.this, "您点击了其中的某一项:"+pos, Toast.LENGTH_SHORT).show();
                    }
                }).buildViewByLeftRight();


        CommonTabLayout selectTabLayout3 = findViewById(R.id.tablayout3);
        List<String> datas3 = new ArrayList<>();
        datas3.add("Item1");
        datas3.add("Item2");
        datas3.add("Item3");
        datas3.add("Item4");
        datas3.add("Item5");
        datas3.add("Item6");
        /**
         * 创建一个左、右背景切换各不同的TabLayout（ps：也可以相同，看您怎样设置）
         */
        selectTabLayout3.setData(datas3)
                .setDefaultSelectIndex(0)
//                .setItemHeight()//直接用默认值，如果不满足条件再修改
                .setMiddleDrawableSelector(R.color.white)
                .setTextColor(R.color.theme)
                .setLineColor(R.color.theme)
                .setTextSize(12)
                .setLineHeight(PxUtils.dp2px(this, 3))
                .setMargin(PxUtils.dp2px(this, 30), 0, PxUtils.dp2px(this, 30), 0)
                .buildViewByBottomLine()
                .setOnItemClickListener(new CommonTabLayout.OnItemClickListener() {
                    @Override
                    public void onItemClick(int pos) {
                        Toast.makeText(CommonTabLayoutActivity.this, "您点击了其中的某一项", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
