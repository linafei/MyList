package com.example.hong611.mylistview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hong611.mylistview.R;
import com.example.hong611.mylistview.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hong611 on 2015/8/12.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {
    List<ItemModel> itemModels;
    Context context;
    LayoutInflater layoutInflater;

    List<Integer> mHeights = new ArrayList<>();
    boolean showListView;
    boolean showStaggeredView;

    public void setShowListView(boolean b) {
        showListView = b;
    }

    public void setShowStaggeredView(boolean b) {
        showStaggeredView = b;
    }

    public MyRecyclerAdapter(Context context, List<ItemModel> itemModels) {
        this.context = context;
        this.itemModels = itemModels;
        layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (showListView) {
            view = layoutInflater.inflate(R.layout.my_listview_item, parent, false);
        } else {
            view = layoutInflater.inflate(R.layout.my_gridview_item, parent, false);
        }
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        if (showStaggeredView) {
            for (int i = 0; i < itemModels.size(); i++) {
                mHeights.add((int)(300 + Math.random() * 300));
            }
            StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams();
            layoutParams.height = mHeights.get(position);
            viewHolder.itemView.setLayoutParams(layoutParams);
        }

        viewHolder.imageView.setImageResource(itemModels.get(position).getAvatar());
        viewHolder.title.setText(itemModels.get(position).getTitil());
        viewHolder.content.setText(itemModels.get(position).getContent());
        viewHolder.content.setVisibility(showListView ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return itemModels.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView title;
        public TextView content;

        public MyViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.avatar);
            title = (TextView) view.findViewById(R.id.title);
            content = (TextView) view.findViewById(R.id.content);
        }
    }
}


