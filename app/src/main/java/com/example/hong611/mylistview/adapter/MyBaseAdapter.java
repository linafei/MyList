package com.example.hong611.mylistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.hong611.mylistview.model.ItemModel;

import java.util.List;

/**
 * Created by hong611 on 2015/8/13.
 */
public class MyBaseAdapter extends BaseAdapter {
    Context context;
    List<ItemModel> itemModels;
    LayoutInflater layoutInflater;

    public MyBaseAdapter(Context context, List<ItemModel> datas) {
        this.context = context;
        itemModels = datas;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itemModels.size();
    }

    @Override
    public Object getItem(int position) {
        return itemModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
