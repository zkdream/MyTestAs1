package com.zk.test.baselibrary.adapter.listview;

/**
 * Created by Administrator on 2017/10/31.
 */

public interface ItemViewDelegate<T> {

    public abstract int getItemViewLayoutId();

    public abstract boolean isForViewType(T item, int position);

    public abstract void convert(ViewHolder holder, T t, int position);

}
