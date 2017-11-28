package com.zk.test.baselibrary.toolbar;

import android.content.Context;

/**
 * @author Created by zhangke
 * @filename NavigationBar
 * @date on 2017\11\21 0021 15:46
 * @email 206357792@qq.com
 * @describe 处理不一样的导航栏
 */

public class NavigationBar extends AbsNavigationBar{

    public NavigationBar(Builder builder) {
        super(builder);
    }

    public static class Builder extends AbsNavigationBar.Builder{
        public Builder(Context context, int layoutId) {
            super(context, layoutId);
        }

        @Override
        public AbsNavigationBar create() {
            return new AbsNavigationBar(this);
        }
    }
}
