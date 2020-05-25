package com.yw.ywlibrary.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;


import com.yw.ywlibrary.util.PxUtils;

import java.util.List;

/**
 * description: 传统TabLayout实现单选效果
 * <p>
 * 提供一个容器，根据用户设置的样式展示不同的效果
 * 高度封装，如果想要扩展，请自行更改源代码
 *
 * @author 杨伟-tony
 * create by 2020/5/18 16:28
 */
public class CommonTabLayout extends RadioGroup {

    //每一项的默认高度
    private int itemHeight = PxUtils.dp2px(getContext(), 36);
    //默认字体大小
    private float textSize = PxUtils.sp2px(getContext(), 16);
    //数据集合
    private List<String> datas;
    //选中和未选中状态字体颜色
    private int colorSelector;
    //左边按钮选中和未选中字体颜色
    private int leftDrawableSelector;
    //中间选中和未选中字体颜色
    private int middleDrawableSelector;
    //右边选中和未选中字体颜色
    private int rightDrawableSelector;
    //默认被选中的第一个item
    private int defaultIndex;
    //点击每一项时的监听器
    private OnItemClickListener onItemClickListener;
    //默认线的高度
    private int lineHeight = PxUtils.dp2px(getContext(), 3);
    //默认上限左右填充
    private int marginLeft, marginTop, marginRight, marginBottom;
    //默认线的颜色
    private int line_color;

    public CommonTabLayout(Context context) {
        super(context);
    }

    public CommonTabLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        rg = (RadioGroup) LayoutInflater.from(context).inflate(R.layout.tab_layout, null);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setLayoutParams(params);
        this.setGravity(Gravity.CENTER);
        this.setOrientation(HORIZONTAL);
        this.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, final int checkedId) {
                final RadioButton rbb = CommonTabLayout.this.findViewById(group.getCheckedRadioButtonId());
                //设置RadioButton的选中事件
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick((int) rbb.getTag());
                }
            }
        });
    }

    /**
     * 设置字体颜色
     *
     * @param colorSelector
     * @return
     */
    public CommonTabLayout setTextColor(int colorSelector) {
        this.colorSelector = colorSelector;
        return this;
    }

    /**
     * 设置左边的DrawableSelector
     *
     * @param leftDrawableSelector
     * @return
     */
    public CommonTabLayout setLeftDrawableSelector(int leftDrawableSelector) {
        this.leftDrawableSelector = leftDrawableSelector;
        return this;
    }

    /**
     * 设置中间的DrawableSelector
     *
     * @param middleDrawableSelector
     * @return
     */
    public CommonTabLayout setMiddleDrawableSelector(int middleDrawableSelector) {
        this.middleDrawableSelector = middleDrawableSelector;
        return this;
    }

    /**
     * 设置右边的drawableSelector
     *
     * @param rightDrawableSelector
     * @return
     */
    public CommonTabLayout setRightDrawableSelector(int rightDrawableSelector) {
        this.rightDrawableSelector = rightDrawableSelector;
        return this;
    }

    /**
     * 设置列表数据，有多少数据就会显示多少项
     *
     * @param datas
     * @return
     */
    public CommonTabLayout setData(List<String> datas) {
        this.datas = datas;
        return this;
    }

    /**
     * 设置字体大小
     *
     * @param textSize
     * @return
     */
    public CommonTabLayout setTextSize(int textSize) {
        this.textSize = textSize;
        return this;
    }

    /**
     * 设置每一项的高度
     *
     * @param itemHeight
     * @return
     */
    public CommonTabLayout setItemHeight(int itemHeight) {
        this.itemHeight = itemHeight;
        return this;
    }

    /**
     * 设置默认选中按钮
     *
     * @param defaultIndex
     * @return
     */
    public CommonTabLayout setDefaultSelectIndex(int defaultIndex) {
        this.defaultIndex = defaultIndex;
        return this;
    }

    /**
     * 设置每一项的点击事件
     *
     * @param onItemClickListener
     * @return
     */
    public CommonTabLayout setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        return this;
    }

    /**
     * 设置线的高度
     *
     * @param lineHeight
     * @return
     */
    public CommonTabLayout setLineHeight(int lineHeight) {
        this.lineHeight = lineHeight;
        return this;
    }

    /**
     * 设置线的颜色
     *
     * @param line_color
     * @return
     */
    public CommonTabLayout setLineColor(int line_color) {
        this.line_color = line_color;
        return this;
    }

    /**
     * 设置线的四边填充
     *
     * @param left
     * @param top
     * @param right
     * @param bottom
     * @return
     */
    public CommonTabLayout setMargin(int left, int top, int right, int bottom) {
        this.marginLeft = left;
        this.marginTop = top;
        this.marginRight = right;
        this.marginBottom = bottom;
        return this;
    }

    /**
     * 建造一个可以设置左、中、右背景的View
     */
    public CommonTabLayout buildViewByLeftMiddleRight() {
        if (datas == null || datas.size() < 3) {
            throw new RuntimeException("集合个数必须大于等于3");
        }
        this.removeAllViews();
        int count = datas.size();
        for (int i = 0; i < count; i++) {
            final RadioButton rb = new RadioButton(getContext());
            rb.setTag(i);
            //设置字体颜色
            rb.setTextColor(getResources().getColorStateList(colorSelector, getResources().newTheme()));
            //设置背景颜色
            if (i == 0) {
                rb.setBackgroundResource(leftDrawableSelector);
            } else if (i == count - 1) {
                rb.setBackgroundResource(rightDrawableSelector);
            } else {
                rb.setBackgroundResource(middleDrawableSelector);
            }
            rb.setButtonDrawable(null);
            rb.setGravity(Gravity.CENTER);
            rb.setTag(i);
//            rb.setTextSize(textSize);
            //
            rb.setText(datas.get(i));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.weight = 1;
            params.height = itemHeight;
            rb.setLayoutParams(params);
            this.addView(rb);
        }
        ((RadioButton) this.getChildAt(defaultIndex)).setChecked(true);
        return this;
    }

    /**
     * 可以设置左背景和右背景的View
     */
    public CommonTabLayout buildViewByLeftRight() {
        if (datas.size() != 2) {
            throw new RuntimeException("元素个数必须是两个！");
        }
        this.removeAllViews();
        int count = datas.size();
        for (int i = 0; i < count; i++) {
            final RadioButton rb = new RadioButton(getContext());
            rb.setTag(i);
            //设置字体颜色
            rb.setTextColor(getResources().getColorStateList(colorSelector, getResources().newTheme()));
            //设置背景颜色
            rb.setBackgroundResource(leftDrawableSelector);
            //
            rb.setText(datas.get(i));
            rb.setTag(i);
            rb.setButtonDrawable(null);
            rb.setGravity(Gravity.CENTER);
            final int finalI = i;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params.weight = 1;
            params.height = itemHeight;
            params.gravity = Gravity.CENTER;
            rb.setLayoutParams(params);
            this.addView(rb);
        }
        this.getChildAt(0).setBackgroundResource(leftDrawableSelector);
        this.getChildAt(1).setBackgroundResource(rightDrawableSelector);
        //默认选中左边Button
        ((RadioButton) this.getChildAt(defaultIndex)).setChecked(true);
//        this.addView(rg);
        return this;
    }

    private StateListDrawable addStateDrawable(int unselected, int selected) {
        StateListDrawable sd = new StateListDrawable();
        Drawable normal = unselected == -1 ? null : getResources().getDrawable(unselected, getResources().newTheme());
        Drawable pressed = selected == -1 ? null : getResources().getDrawable(selected, getResources().newTheme());
        //注意该处的顺序，只要有一个状态与之相配，背景就会被换掉
        //所以不要把大范围放在前面了，如果sd.addState(new[]{},normal)放在第一个的话，就没有什么效果了
        sd.addState(new int[]{android.R.attr.state_checked}, pressed);
        sd.addState(new int[]{android.R.attr.state_checked}, normal);
        sd.addState(new int[]{}, normal);
        return sd;
    }


    /**
     * 制作一个底部带有线的TabLayout
     * 主要解决Android库中原生的TabLayout中item下的那条线不是很好控制的问题
     */
    public CommonTabLayout buildViewByBottomLine() {
        int count = datas.size();
        for (int i = 0; i < count; i++) {
            LinearLayout linear = new LinearLayout(getContext());
            linear.setOrientation(VERTICAL);
            linear.setGravity(Gravity.CENTER);
            LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            layoutParams.weight = 1;
            layoutParams.height = itemHeight;
            layoutParams.gravity = Gravity.CENTER;
            linear.setBackgroundResource(middleDrawableSelector);
            linear.setLayoutParams(layoutParams);
            TextView tv_title = new TextView(getContext());
            tv_title.setText(datas.get(i));
            tv_title.setTextSize(textSize);
            tv_title.setTextColor(getContext().getColor(colorSelector));
            tv_title.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams titleparams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            titleparams.height = itemHeight - lineHeight;
            tv_title.setLayoutParams(titleparams);
            TextView tv_line = new TextView(getContext());
            tv_line.setBackgroundColor(getContext().getColor(line_color));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            params.height = lineHeight;
            params.setMargins(marginLeft, marginTop, marginRight, marginBottom);
            tv_line.setLayoutParams(params);
            tv_line.setVisibility(View.GONE);
            linear.addView(tv_title);
            linear.addView(tv_line);
            final int finalI = i;
            linear.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    resetViewSelected();
                    updateViewState(finalI);
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(finalI);
                    }
                }
            });
            this.addView(linear);
        }
        updateViewState(defaultIndex);
        return this;
    }

    /**
     * 重置所有View的选中状态
     */
    private void resetViewSelected() {
        //将所有状态置空
        int count = this.getChildCount();
        for (int i = 0; i < count; i++) {
            ((LinearLayout) this.getChildAt(i)).getChildAt(1).setVisibility(View.GONE);
        }
    }

    /**
     * 设置点击的view为选中状态
     *
     * @param pos
     */
    private void updateViewState(int pos) {
        ((LinearLayout) this.getChildAt(pos)).getChildAt(1).setVisibility(View.VISIBLE);
    }


    public interface OnItemClickListener {
        void onItemClick(int pos);
    }
}
