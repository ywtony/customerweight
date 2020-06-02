package com.yw.ywlibrary.widget.sorttab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * description: 筛选TabLayout
 *
 * @author 杨伟-tony
 * create by 2020/6/2 9:18
 */
public class SortTabLayout extends LinearLayout {
    private int textColor;
    private int textSize = 10;
    private int iconResource;
    private int marginLeft = 5;
    private List<String> datas = new ArrayList<>();

    public SortTabLayout(Context context, int textSize, int textColor, int iconResource, int marginLeft, List<String> datas) {
        super(context);
        this.textColor = textColor;
        this.textSize = textSize;
        this.iconResource = iconResource;
        this.marginLeft = marginLeft;
        this.datas = datas;
        initViews();
    }

    public SortTabLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    private void initViews() {
        //横排
        this.setOrientation(HORIZONTAL);
        this.setGravity(Gravity.CENTER);
    }

    /**
     * 创建SortTablayout
     */
    public SortTabLayout createSortTab() {
        for (int i = 0; i < datas.size(); i++) {
            SortTabItem sortTabItem = new SortTabItem.Builder()
                    .setMarginLeft(marginLeft)
                    .setIconResourceId(iconResource)
                    .setTextColorResource(textColor)
                    .setTextSize(textSize)
                    .setTextValue(datas.get(i))
                    .build(getContext())
                    .createItem();
            int finalI = i;
            sortTabItem.setTag(true);
            sortTabItem.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    rotation(finalI);
                    if (onSortTabItemClickListener != null) {
                        onSortTabItemClickListener.onItemClick(finalI);
                    }
                }
            });
            this.addView(sortTabItem);
        }
        return this;
    }

    private void rotation(int i) {
        LinearLayout linearLayout = ((LinearLayout) this.getChildAt(i));
        boolean flag = Boolean.valueOf(linearLayout.getTag().toString());
        if (flag) {
            linearLayout.setTag(false);
            linearLayout.getChildAt(1).setRotation(180);
        } else {
            linearLayout.setTag(true);
            linearLayout.getChildAt(1).setRotation(0);
        }

    }


    public SortTabLayout setTextColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    public SortTabLayout setTextSize(int textSize) {
        this.textSize = textSize;
        return this;
    }


    public SortTabLayout setIconResource(int iconResource) {
        this.iconResource = iconResource;
        return this;
    }


    public SortTabLayout setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
        return this;
    }

    public SortTabLayout setDatas(List<String> datas) {
        this.datas = datas;
        return this;
    }

    public static class Builder {
        private int textColor;
        private int textSize = 10;
        private int iconResource;
        private int marginLeft = 5;
        private List<String> datas;


        public Builder setTextColor(int textColor) {
            this.textColor = textColor;
            return this;
        }


        public Builder setTextSize(int textSize) {
            this.textSize = textSize;
            return this;
        }


        public Builder setIconResource(int iconResource) {
            this.iconResource = iconResource;
            return this;
        }


        public Builder setMarginLeft(int marginLeft) {
            this.marginLeft = marginLeft;
            return this;
        }

        public Builder setData(List<String> datas) {
            this.datas = datas;
            return this;
        }

        public SortTabLayout build(Context context) {
            return new SortTabLayout(context, textSize, textColor, iconResource, marginLeft, datas);
        }
    }

    private OnSortTabItemClickListener onSortTabItemClickListener;

    public SortTabLayout setOnSortTabItemClickListener(OnSortTabItemClickListener onSortTabItemClickListener) {
        this.onSortTabItemClickListener = onSortTabItemClickListener;
        return this;
    }

    public interface OnSortTabItemClickListener {
        /**
         * 当item点击的时候执行
         *
         * @param pos
         */
        void onItemClick(int pos);
    }
}
