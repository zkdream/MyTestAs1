package com.zk.test.baselibrary.bottom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * @author Created by zhangke
 * @filename BottomTabItem
 * @date on 2017\11\21 0021 16:39
 * @email 206357792@qq.com
 * @describe BottomTabItem的基类
 */

public abstract class BottomTabItem {

    private View mTabItemView;
    private int mLayoutId;
    private Context mContext;

    public BottomTabItem(int layoutId,Context context){
        this.mLayoutId=layoutId;
        this.mContext=context;
    }

    /**
     * 获取底部条目的显示
     * @return
     */
    public View getTabView(){
        if (mTabItemView==null){
            mTabItemView= LayoutInflater.from(mContext).inflate(mLayoutId,null);
            initLayout();
        }
        return mTabItemView;
    }

    /**
     * 初始化显示
     */
    protected abstract void initLayout();

    protected <T> T findViewById(int id){
       return (T)mTabItemView.findViewById(id);
    }

    /**
     * 是否选择当前的条目
     * @param selected
     */
    protected abstract void setSelected(boolean selected);
}
