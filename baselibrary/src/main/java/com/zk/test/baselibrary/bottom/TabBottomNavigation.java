package com.zk.test.baselibrary.bottom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.zk.test.baselibrary.bottom.iterator.TabIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by zhangke
 * @filename TabBottomNavigation
 * @date on 2017\11\21 0021 17:04
 * @email 206357792@qq.com
 * @describe 底部导航栏
 */

public class TabBottomNavigation extends LinearLayout{

    private List<BottomTabItem> mTabItems;
    private int mCurrentIndex=-1;

    public TabBottomNavigation(Context context) {
        this(context,null);
    }

    public TabBottomNavigation(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TabBottomNavigation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(HORIZONTAL);
        mTabItems=new ArrayList<>();
    }

    public void setTabIterator(TabIterator tabIterator){
        mTabItems.clear();

        int index=0;
        while (tabIterator.hashNext()){
            BottomTabItem tabItem=tabIterator.next();
            View tabView=tabItem.getTabView();
            addView(tabView);

            LayoutParams params= (LayoutParams) tabView.getLayoutParams();
            params.weight=1;
            params.gravity= Gravity.CENTER;
            tabView.setLayoutParams(params);

//            给条目设置点击事件  等
            setItemClickListener(tabView,index++);
            mTabItems.add(tabItem);
        }

        mTabItems.get(0).setSelected(true);
        mCurrentIndex=0;
    }

    private void setItemClickListener(View tabView, final int position) {
        tabView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCurrentIndex!=position){
//                    原来的标为非选中
                    mTabItems.get(mCurrentIndex).setSelected(false);
//                    把当前设置为选中
                    mCurrentIndex=position;
                    mTabItems.get(mCurrentIndex).setSelected(true);
//                    把点击的事件用接口暴露除去
                    if (mBottomClickListener!=null){
                        mBottomClickListener.click(position);
                    }
                }
            }
        });
    }

    private TabBottomClickListener mBottomClickListener;

    public void setOnTabBottomClickListener(TabBottomClickListener bottomClickListener){
        this.mBottomClickListener=bottomClickListener;
    }

    private interface TabBottomClickListener{
        void click(int position);
    }
}
