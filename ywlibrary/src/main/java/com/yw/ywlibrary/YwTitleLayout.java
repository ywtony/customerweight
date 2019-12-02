package com.yw.ywlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * 标题栏自定义控件
 * create by yangwei
 * on 2019-12-02 12:48
 */
public class YwTitleLayout extends FrameLayout {
    private TextView tv_left;
    private TextView tv_right;
    private TextView tv_title;
    private ImageView iv_left;
    private ImageView iv_right;

    public YwTitleLayout(@NonNull Context context) {
        super(context);
    }

    public YwTitleLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.YwTitleLayout);
        View view = LayoutInflater.from(context).inflate(R.layout.titlelayout, this);
        initViewsAttrs(context, typedArray, view);
    }

    public YwTitleLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public YwTitleLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * 初始化Viwe的属性配置
     *
     * @param typedArray
     * @param view
     */
    private void initViewsAttrs(Context context, TypedArray typedArray, View view) {
        //整体背景
        int layout_background = typedArray.getColor(R.styleable.YwTitleLayout_titlelayout_background_color, Color.BLACK);
        int layout_background_resource = typedArray.getResourceId(R.styleable.YwTitleLayout_titlelayout_background_resourceId, 0);
        //左侧
        int leftIcon = typedArray.getResourceId(R.styleable.YwTitleLayout_leftIcon, 0);
        String leftText = typedArray.getString(R.styleable.YwTitleLayout_leftText);
        int leftTextColor = typedArray.getColor(R.styleable.YwTitleLayout_leftTextColor, 0);
        int leftTextSize = typedArray.getInteger(R.styleable.YwTitleLayout_leftTextSize, 12);
        int leftMarginLeft = typedArray.getDimensionPixelOffset(R.styleable.YwTitleLayout_lefttMarginLeft, 10);
        //标题
        String titleText = typedArray.getString(R.styleable.YwTitleLayout_titleText);
        int titleTextColor = typedArray.getColor(R.styleable.YwTitleLayout_titleTextColor, 0);
        int titleTextSize = typedArray.getInteger(R.styleable.YwTitleLayout_titleTextSize, 12);
        //右侧
        int rightIcon = typedArray.getResourceId(R.styleable.YwTitleLayout_rightIcon, 0);
        String rightText = typedArray.getString(R.styleable.YwTitleLayout_rightText);
        int rightTextColor = typedArray.getColor(R.styleable.YwTitleLayout_rightTextColor, 0);
        int rightTextSize = typedArray.getInteger(R.styleable.YwTitleLayout_rightTextSize, 12);
        int rightMarginRight = typedArray.getDimensionPixelOffset(R.styleable.YwTitleLayout_rightMarginRight, 10);
        tv_left = view.findViewById(R.id.titlebar_tv_left);
        tv_title = view.findViewById(R.id.titlebar_tv_title);
        tv_right = view.findViewById(R.id.titlebar_tv_right);
        iv_left = view.findViewById(R.id.titlebar_iv_back);
        iv_right = view.findViewById(R.id.titlebar_iv_right);
        //给背景赋值
        if (layout_background_resource == 0) {
            view.setBackgroundColor(layout_background);
        } else {
            view.setBackgroundResource(layout_background_resource);
        }
        //设置left的值
//        setTextViewDrawableLeftSize(context, R.mipmap.icon_toleft, tv_left);
        tv_left.setText(leftText);
        tv_left.setTextColor(leftTextColor);
        tv_left.setTextSize(leftTextSize);
//        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tv_left.getLayoutParams();
//        layoutParams.setMargins(leftMarginLeft, 0, 0, 0);
//        tv_left.setLayoutParams(layoutParams);
        iv_left.setImageResource(leftIcon);
        //设置title的值
        tv_title.setText(titleText);
        tv_title.setTextColor(titleTextColor);
        tv_title.setTextSize(titleTextSize);
        //设置right的值
//        setTextViewDrawableLeftSize(context, R.mipmap.icon_toleft, tv_right);
        tv_right.setText(rightText);
        tv_right.setTextColor(rightTextColor);
        tv_right.setTextSize(rightTextSize);
//        RelativeLayout.LayoutParams layoutParamsRight = (RelativeLayout.LayoutParams) tv_right.getLayoutParams();
//        layoutParams.setMargins(0, 0, rightMarginRight, 0);
//        tv_right.setLayoutParams(layoutParamsRight);
        iv_right.setImageResource(rightIcon);
        iv_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ywTitleLayoutCallBack != null) {
                    ywTitleLayoutCallBack.leftClick(tv_left);
                }
            }
        });
        tv_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ywTitleLayoutCallBack != null) {
                    ywTitleLayoutCallBack.leftClick(tv_left);
                }
            }
        });
        iv_right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ywTitleLayoutCallBack != null) {
                    ywTitleLayoutCallBack.rightClick(tv_right);
                }
            }
        });
        tv_right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ywTitleLayoutCallBack != null) {
                    ywTitleLayoutCallBack.rightClick(tv_right);
                }
            }
        });
    }

    public void setTextViewDrawableLeftSize(Context context, int left, TextView textView) {
        Drawable drawableLeft = context.getResources().getDrawable(left);
        drawableLeft.setBounds(0, 0, 40, 40);
        textView.setCompoundDrawables(drawableLeft, null, null, null);
    }

    public interface YwTitleLayoutCallBack {
        /**
         * 点击左侧的执行事件
         *
         * @param tv_left
         */
        void leftClick(TextView tv_left);

        /**
         * 点击右侧的执行事件
         *
         * @param tv_right
         */
        void rightClick(TextView tv_right);
    }

    private YwTitleLayoutCallBack ywTitleLayoutCallBack;

    public void setYwTitleLayoutCallBack(YwTitleLayoutCallBack ywTitleLayoutCallBack) {
        this.ywTitleLayoutCallBack = ywTitleLayoutCallBack;
    }
}
