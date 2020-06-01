package com.yw.ywlibrary.widget.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;

/**
 * description: TabLayout中的每一项
 *
 * @author 杨伟-tony
 * create by 2020/5/27 9:09
 */
@SuppressLint("AppCompatCustomView")
public class TabItem extends RadioButton {
    private int colorSelector;//选中和未选中的颜色
    private int backgroundResourceSelector;//选中和未选中的背景颜色
    private int index;//当前View在父容器中的位置
    private int itemHeight;//当前View的高度
    private String value;//当前Item的值
    private float textSize = -1;//字体颜色
    private int leftMargin;//从第二个item开始左填充

    public TabItem(Context context, int colorSelector, int backgroundResourceSelector, int index, int itemHeight, String value, float textSize, int leftMargin) {
        super(context);
        this.colorSelector = colorSelector;
        this.backgroundResourceSelector = backgroundResourceSelector;
        this.index = index;
        this.itemHeight = itemHeight;
        this.value = value;
        this.textSize = textSize;
        this.leftMargin = leftMargin;
    }

    public TabItem(Context context) {
        super(context);
    }

    public TabItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 创建一个TabItem
     *
     * @return
     */
    public TabItem createTabItem() {
        //设置字体颜色
        this.setTextColor(getResources().getColorStateList(colorSelector, getResources().newTheme()));
        //设置背景颜色
        this.setBackgroundResource(backgroundResourceSelector);
        this.setButtonDrawable(null);
        this.setGravity(Gravity.CENTER);
        this.setTag(index);
        if (textSize >= 9) {
            this.setTextSize(textSize);
        }
        this.setText(value);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.weight = 1;
        params.height = itemHeight;
        params.setMargins(leftMargin, 0, 0, 0);
        this.setLayoutParams(params);
        return this;
    }

    public static class Builder {
        private int colorSelector;//选中和未选中的颜色
        private int backgroundResourceSelector;//选中和未选中的背景颜色
        private int index;//当前View在父容器中的位置
        private int itemHeight;//当前View的高度
        private String value;//当前Item的值
        private float textSize = -1;//字体颜色
        private int leftMargin;//从第二个item开始左填充

        public Builder setColorSelector(int colorSelector) {
            this.colorSelector = colorSelector;
            return this;
        }

        public Builder setBackgroundResourceSelector(int backgroundResourceSelector) {
            this.backgroundResourceSelector = backgroundResourceSelector;
            return this;
        }

        public Builder setIndex(int index) {
            this.index = index;
            return this;
        }

        public Builder setItemHeight(int itemHeight) {
            this.itemHeight = itemHeight;
            return this;
        }

        public Builder setValue(String value) {
            this.value = value;
            return this;
        }

        public Builder setTextSize(float textSize) {
            this.textSize = textSize;
            return this;
        }

        public Builder setLeftMargin(int margin) {
            this.leftMargin = margin;
            return this;
        }


        /**
         * 构建一个TabItem
         *
         * @return
         */
        public TabItem build(Context context) {
            return new TabItem(context, colorSelector, backgroundResourceSelector, index, itemHeight, value, textSize, leftMargin);
        }
    }


}
