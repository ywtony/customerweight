package com.yw.ywlibrary.widget.tab;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.yw.ywlibrary.util.PxUtils;

/**
 * description: 带底部线的Tablayout
 *
 * @author 杨伟-tony
 * create by 2020/5/29 13:59
 */
public class TabItemBottomLine extends LinearLayout {
    //设置linear背景
    private int backgroundColor;
    //设置字体颜色
    private int colorSelector;
    //设置Button背景
    private int backgroundResource;
    private String value;//tab要显示的值

    public TabItemBottomLine(Context context, int backgroundColor, int colorSelector, int backgroundResource, String value) {
        super(context);
        this.backgroundColor = backgroundColor;
        this.colorSelector = colorSelector;
        this.backgroundResource = backgroundResource;
        this.value = value;
        initView();
    }

    private void initView() {
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.weight = 1;
        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.gravity = Gravity.CENTER;
//        setBackgroundColor(backgroundColor);


    }

    public TabItemBottomLine buildBottomLine() {
        //定义线的长度和文本的长度一样大
        RadioButton button = new RadioButton(getContext());
        button.setTextColor(colorSelector);
        button.setBackgroundResource(backgroundResource);
        button.setButtonDrawable(null);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        button.setLayoutParams(params);
        button.setText(value);
        addView(button);
        return this;
    }

    public static class Builder {
        //设置linear背景
        private int backgroundColor;
        //设置字体颜色
        private int colorSelector;
        //设置Button背景
        private int backgroundResource;
        private String value;

        public Builder setBackgroundColor(int backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Builder setColorSelector(int colorSelector) {
            this.colorSelector = colorSelector;
            return this;
        }

        public Builder setBackgroundResource(int backgroundResource) {
            this.backgroundResource = backgroundResource;
            return this;
        }

        public Builder setValue(String value) {
            this.value = value;
            return this;
        }

        public TabItemBottomLine build(Context context) {
            return new TabItemBottomLine(context, backgroundColor, colorSelector, backgroundResource, value);
        }
    }


}
