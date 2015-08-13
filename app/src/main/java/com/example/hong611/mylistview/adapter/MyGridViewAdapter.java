package com.example.hong611.mylistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hong611.mylistview.R;
import com.example.hong611.mylistview.model.ItemModel;

import java.util.List;

/**
 * Created by hong611 on 2015/8/13.
 */
public class MyGridViewAdapter extends BaseAdapter {
    List<ItemModel> itemModels;
    Context context;
    LayoutInflater layoutInflater;

    public MyGridViewAdapter(Context context,List<ItemModel> itemModels){
        this.context=context;
        this.itemModels=itemModels;
        layoutInflater=LayoutInflater.from(context);
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
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView=layoutInflater.inflate(R.layout.my_gridview_item,null);
            viewHolder.avatar= (ImageView) convertView.findViewById(R.id.avatar_gv);
            viewHolder.title= (TextView) convertView.findViewById(R.id.title_gv);
            convertView.setTag(viewHolder);
        }else {

        }
        return null;
    }

    class ViewHolder{
        public ImageView avatar;
        public TextView title;
    }
}
