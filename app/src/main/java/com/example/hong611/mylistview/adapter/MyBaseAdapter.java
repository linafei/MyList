package com.example.hong611.mylistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.hong611.mylistview.utils.MyViewHolder;

import java.util.List;

/**
 * Created by hong611 on 2015/8/13.
 */
public abstract class MyBaseAdapter<T> extends BaseAdapter {
    protected Context context;
    protected List<T> mDatas;
    protected LayoutInflater layoutInflater;
    protected int layoutId;

    public MyBaseAdapter(Context context, List<T> datas, int layoutId) {
        this.context = context;
        mDatas = datas;
        layoutInflater = LayoutInflater.from(context);
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder myViewHolder = MyViewHolder.get(context, convertView, parent, layoutId, position);
        T item = mDatas.get(position);
        convert(myViewHolder, item);

        return myViewHolder.getConvertView();
    }

    public abstract void convert(MyViewHolder myViewHolder,T item);
}
