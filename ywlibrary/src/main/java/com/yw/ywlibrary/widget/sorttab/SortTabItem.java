package com.yw.ywlibrary.widget.sorttab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.yw.ywlibrary.util.PxUtils;

/**
 * description: 排序Tab的每一项
 *
 * @author 杨伟-tony
 * create by 2020/6/2 9:20
 */
class SortTabItem extends LinearLayout {
    private int marginLeft = 5;//小图标左填充
    private String textValue;//文本描述
    private int iconResourceId;//图标的资源id
    private int textSize = 16;//字体大小
    private int textColorResource;//字体颜色

    public SortTabItem(Context context, int marginLeft, String textValue, int iconResourceId, int textSize, int textColorResource) {
        super(context);
        this.marginLeft = marginLeft;
        this.textValue = textValue;
        this.iconResourceId = iconResourceId;
        this.textSize = textSize;
        this.textColorResource = textColorResource;
        initView();
    }


    private void initView() {
        //横排
        this.setOrientation(HORIZONTAL);
        this.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight = 1;
        params.gravity = Gravity.CENTER;
        this.setLayoutParams(params);

    }

    public SortTabItem createItem() {
        //添加TextView和ImageView
        TextView tv_title = new TextView(getContext());
        tv_title.setTextSize(PxUtils.sp2px(getContext(), textSize));
        tv_title.setTextColor(textColorResource);
        tv_title.setText(textValue);
        ImageView iv_icon = new ImageView(getContext());
        iv_icon.setImageResource(iconResourceId);
        LinearLayout.LayoutParams iv_param = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        iv_param.setMargins(PxUtils.dp2px(getContext(),marginLeft), 0, 0, 0);
        iv_icon.setLayoutParams(iv_param);
        this.addView(tv_title);
        this.addView(iv_icon);
        return this;
    }

    public static class Builder {
        private int marginLeft;//小图标左填充
        private String textValue;//文本值
        private int iconResourceId;//图标的资源id
        private int textSize = 16;//字体大小
        private int textColorResource;//字体颜色

        public Builder setMarginLeft(int marginLeft) {
            this.marginLeft = marginLeft;
            return this;
        }

        public Builder setTextValue(String textValue) {
            this.textValue = textValue;
            return this;
        }

        public Builder setIconResourceId(int iconResourceId) {
            this.iconResourceId = iconResourceId;
            return this;
        }

        public Builder setTextSize(int textSize) {
            this.textSize = textSize;
            return this;
        }

        public Builder setTextColorResource(int textColorResource) {
            this.textColorResource = textColorResource;
            return this;
        }

        /**
         * 构建一个SortTabItem
         *
         * @param context
         * @return
         */
        public SortTabItem build(Context context) {
            return new SortTabItem(context, marginLeft, textValue, iconResourceId, textSize, textColorResource);
        }
    }
}
