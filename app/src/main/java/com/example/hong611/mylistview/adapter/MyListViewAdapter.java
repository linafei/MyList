package com.example.hong611.mylistview.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hong611.mylistview.R;
import com.example.hong611.mylistview.model.ItemModel;
import com.example.hong611.mylistview.utils.MyViewHolder;

import java.util.List;

/**
 * Created by hong611 on 2015/6/26.
 */
public class MyListViewAdapter extends MyBaseAdapter<ItemModel> {

    public MyListViewAdapter(Context context, List<ItemModel> datas) {
        super(context, datas,R.layout.my_listview_item);
    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
        //普通方法
//        if (convertView == null) {
//            convertView = layoutInflater.inflate(R.layout.my_listview_item, null);
//        }
//        ImageView avatar = (ImageView) convertView.findViewById(R.id.avatar);
//        TextView title = (TextView) convertView.findViewById(R.id.title);
//        TextView content = (TextView) convertView.findViewById(R.id.content);
//        ItemModel itemModel=itemModels.get(position);
//        avatar.setImageResource(itemModel.getAvatar());
//        title.setText(itemModel.getTitil());
//        content.setText(itemModel.getContent());

        //文艺方法
//        ViewHolder viewHolder;
//        if (convertView == null) {
//            viewHolder=new ViewHolder();
//            convertView = layoutInflater.inflate(R.layout.my_listview_item, null);
//            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.avatar);
//            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
//            viewHolder.content = (TextView) convertView.findViewById(R.id.content);
//            convertView.setTag(viewHolder);
//        }else {
//            viewHolder= (ViewHolder) convertView.getTag();
//        }
//        ItemModel itemModel=mDatas.get(position);
//        viewHolder.imageView.setImageResource(itemModel.getAvatar());
//        viewHolder.title.setText(itemModel.getTitil());
//        viewHolder.content.setText(itemModel.getContent());

//    }

    @Override
    public void convert(MyViewHolder myViewHolder, ItemModel itemModel) {
        ((ImageView) myViewHolder.getView(R.id.avatar)).setImageResource(itemModel.getAvatar());
        ((TextView) myViewHolder.getView(R.id.title)).setText(itemModel.getTitil());
        ((TextView) myViewHolder.getView(R.id.content)).setText(itemModel.getContent());
    }

//    class ViewHolder {
//        public ImageView imageView;
//        public TextView title;
//        public TextView content;
//    }
}
