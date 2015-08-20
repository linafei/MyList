package com.example.hong611.mylistview.utils;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hong611 on 2015/8/18.
 */
public class MyViewHolder {
    private SparseArray<View> mViews;
    private int position;
    private View mConvertView;

    public MyViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.position = position;
        this.mViews = new SparseArray<>();
        this.mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);

        this.mConvertView.setTag(this);
    }

    public static MyViewHolder get(Context context,View convertView, ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            return new MyViewHolder(context, parent, layoutId, position);
        } else {
            MyViewHolder myViewHolder = (MyViewHolder) convertView.getTag();
            myViewHolder.position = position;
            return myViewHolder;
        }
    }

    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }

        return (T) view;
    }

    public View getConvertView() {
        return mConvertView;
    }
}
