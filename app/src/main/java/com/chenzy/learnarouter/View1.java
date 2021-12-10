package com.chenzy.learnarouter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by zhangyu on 2021/12/3.
 */

public class View1 extends View {
    public View1(Context context) {
        super(context);
    }

    public View1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public View1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }
}
