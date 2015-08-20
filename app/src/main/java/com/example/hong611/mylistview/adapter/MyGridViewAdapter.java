package com.example.hong611.mylistview.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hong611.mylistview.R;
import com.example.hong611.mylistview.model.ItemModel;
import com.example.hong611.mylistview.utils.MyViewHolder;

import java.util.List;

/**
 * Created by hong611 on 2015/8/13.
 */
public class MyGridViewAdapter extends MyBaseAdapter<ItemModel> {

    public MyGridViewAdapter(Context context, List<ItemModel> itemModels) {
        super(context, itemModels, R.layout.my_gridview_item);
    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder viewHolder;
//        if (convertView == null) {
//            viewHolder = new ViewHolder();
//            convertView = layoutInflater.inflate(R.layout.my_gridview_item, null);
//            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
//            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
//            convertView.setTag(viewHolder);
//        } else {
//            viewHolder = (ViewHolder) convertView.getTag();
//        }
//        ItemModel itemModel = mDatas.get(position);
//        viewHolder.avatar.setImageResource(itemModel.getAvatar());
//        viewHolder.title.setText(itemModel.getTitil());

//        MyViewHolder myViewHolder = MyViewHolder.get(context, convertView, parent, R.layout.my_gridview_item, position);
//
//        ItemModel itemModel = mDatas.get(position);
//        ((ImageView) myViewHolder.getView(R.id.avatar)).setImageResource(itemModel.getAvatar());
//        ((TextView) myViewHolder.getView(R.id.title)).setText(itemModel.getTitil());
//
//        return myViewHolder.getConvertView();
//    }

    @Override
    public void convert(MyViewHolder myViewHolder, ItemModel itemModel) {
        ((ImageView) myViewHolder.getView(R.id.avatar)).setImageResource(itemModel.getAvatar());
        ((TextView) myViewHolder.getView(R.id.title)).setText(itemModel.getTitil());
    }

//    class ViewHolder {
//        public ImageView avatar;
//        public TextView title;
//    }
}
