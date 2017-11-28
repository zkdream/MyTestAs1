package com.zk.test.mytestas.ui;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.zk.test.baselibrary.bottom.BottomTabItem;
import com.zk.test.mytestas.R;

/**
 * @author Created by zhangke
 * @filename MainBottomTabItem
 * @date on 2017\11\21 0021 17:43
 * @email 206357792@qq.com
 * @describe 自己实现主页的Bottom
 */

public class MainBottomTabItem extends BottomTabItem{
    private Builder builder;

    public MainBottomTabItem(Context context) {
        super(R.layout.tab_main_bottom_item, context);
    }

    public MainBottomTabItem(Builder builder) {
        this(builder.context);
        this.builder = builder;
    }

    @Override
    protected void initLayout() {
//        初始化显示
        // 初始化显示
        TextView tabText = findViewById(R.id.tab_text);
        ImageView tabIcon = findViewById(R.id.tab_icon);

        if (!TextUtils.isEmpty(builder.text)) {
            tabText.setText(builder.text);
        }

        if (builder.resIconId != 0) {
            tabIcon.setImageResource(builder.resIconId);
        }

    }

    @Override
    protected void setSelected(boolean selected) {
        TextView tabText = findViewById(R.id.tab_text);
        ImageView tabIcon = findViewById(R.id.tab_icon);

        tabText.setSelected(selected);
        tabIcon.setSelected(selected);
    }

    public static class Builder{
        Context context;
        String text;
        int resIconId;

        public Builder(Context context){
            this.context=context;
        }

        public Builder setText(String text){
            this.text=text;
            return this;
        }

        public Builder resIcon(int resIconId){
            this.resIconId=resIconId;
            return this;
        }

        public MainBottomTabItem create(){
            return new MainBottomTabItem(this);
        }
    }
}
