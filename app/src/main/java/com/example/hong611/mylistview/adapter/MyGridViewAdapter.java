package com.example.hong611.mylistview.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hong611.mylistview.R;
import com.example.hong611.mylistview.model.ItemModel;

import java.util.List;

/**
 * Created by hong611 on 2015/8/13.
 */
public class MyGridViewAdapter extends MyBaseAdapter {

    public MyGridViewAdapter(Context context, List<ItemModel> itemModels) {
        super(context,itemModels);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.my_gridview_item, null);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ItemModel itemModel = itemModels.get(position);
        viewHolder.avatar.setImageResource(itemModel.getAvatar());
        viewHolder.title.setText(itemModel.getTitil());

        return convertView;
    }

    class ViewHolder {
        public ImageView avatar;
        public TextView title;
    }
}
