package com.zk.test.baselibrary.bottom.iterator;

import com.zk.test.baselibrary.bottom.BottomTabItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by zhangke
 * @filename TabListIterator
 * @date on 2017\11\21 0021 17:12
 * @email 206357792@qq.com
 * @describe TODO
 */

public class TabListIterator<T extends BottomTabItem> implements TabIterator{
    private List<T> mTabItems;
    private int index;

    public TabListIterator(){
        mTabItems=new ArrayList<>();
    }

    public void addItem(T item){
        mTabItems.add(item);
    }

    @Override
    public BottomTabItem next() {
        return mTabItems.get(index++);
    }

    @Override
    public boolean hashNext() {
        return index<mTabItems.size();
    }
}
