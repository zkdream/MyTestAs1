package com.zk.test.baselibrary.toolbar;

import android.view.View;
import android.view.ViewGroup;

/**
 * @author Created by zhangke
 * @filename INavigation
 * @date on 2017\11\20 0020 20:33
 * @email 206357792@qq.com
 * @describe 定义导航栏的规范
 */

public interface INavigation {
    /**
     * 创建导航栏
     */
    void createNavigationBar();
    /**
     * 绑定参数
     */
    void attachNavigationParams();
    /**
     * 将NavigationView添加到父布局
     */
    void attachParent(View navigationBar, ViewGroup parent);
}
