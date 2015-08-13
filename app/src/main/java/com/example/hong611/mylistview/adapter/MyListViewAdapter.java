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
 * Created by hong611 on 2015/6/26.
 */
public class MyListViewAdapter extends BaseAdapter {
    Context context;
    List<ItemModel> itemModels;
    LayoutInflater layoutInflater;

    public MyListViewAdapter(Context context, List<ItemModel> datas) {
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
        //普通方法
//        if (convertView == null) {
//            convertView = layoutInflater.inflate(R.layout.mylist_item, null);
//        }
//        ImageView avatar = (ImageView) convertView.findViewById(R.id.avatar);
//        TextView title = (TextView) convertView.findViewById(R.id.title);
//        TextView content = (TextView) convertView.findViewById(R.id.content);
//        ItemModel itemModel=itemModels.get(position);
//        avatar.setImageResource(itemModel.getAvatar());
//        title.setText(itemModel.getTitil());
//        content.setText(itemModel.getContent());

        //优化方法
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder=new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.mylist_item, null);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.avatar);
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.content = (TextView) convertView.findViewById(R.id.content);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        ItemModel itemModel=itemModels.get(position);
        viewHolder.imageView.setImageResource(itemModel.getAvatar());
        viewHolder.title.setText(itemModel.getTitil());
        viewHolder.content.setText(itemModel.getContent());

        return convertView;
    }

    class ViewHolder {
        public ImageView imageView;
        public TextView title;
        public TextView content;
    }
}
