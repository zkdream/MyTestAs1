package com.zk.test.mytestas;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.zk.test.baselibrary.bottom.TabBottomNavigation;
import com.zk.test.baselibrary.bottom.iterator.TabListIterator;
import com.zk.test.baselibrary.toolbar.DefaultNavigationBar;
import com.zk.test.mytestas.ui.MainBottomTabItem;

import static android.view.Window.ID_ANDROID_CONTENT;

public class MainActivity extends AppCompatActivity {

    private TabBottomNavigation bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new DefaultNavigationBar.Builder(this).hideLeftIcon().setMiddleText("首页").create();
        bottomNavigation=findViewById(R.id.tab_bottom_navigation);

        TabListIterator<MainBottomTabItem> tabIterator = new TabListIterator<>();
        tabIterator.addItem(new MainBottomTabItem.Builder(this).resIcon(R.drawable.comment_add_menu).setText("资讯").create());
        tabIterator.addItem(new MainBottomTabItem.Builder(this).resIcon(R.drawable.comment_add_menu).setText("评价").create());
        tabIterator.addItem(new MainBottomTabItem.Builder(this).resIcon(R.drawable.comment_add_menu).setText("指数").create());
        tabIterator.addItem(new MainBottomTabItem.Builder(this).resIcon(R.drawable.comment_add_menu).setText("趋势").create());
        bottomNavigation.setTabIterator(tabIterator);

    }
}
