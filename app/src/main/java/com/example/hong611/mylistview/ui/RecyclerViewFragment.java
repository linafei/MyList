package com.example.hong611.mylistview.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hong611.mylistview.R;
import com.example.hong611.mylistview.adapter.MyRecyclerAdapter;

/**
 * Created by hong611 on 2015/8/13.
 */
public class RecyclerViewFragment extends Fragment {
    public static int SHOW_LISTVIEW = 1;
    public static int SHOW_GRIDVIEW = 2;
    public static int SHOW_HORIZANTAL_GRIDVIEW = 3;
    public static int SHOW_STAGGERED_VIEW = 4;

    private int showTag;

    public void setShowTag(int tag) {
        showTag = tag;
    }

    RecyclerView recyclerView;
    MyRecyclerAdapter recyclerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerview_fragment, null);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setAdapter();
        setRecyclerView();
    }

    private void setAdapter() {
        recyclerAdapter = new MyRecyclerAdapter(getActivity(), MainActivity.itemModels);
        recyclerAdapter.setShowListView(showTag == SHOW_LISTVIEW);
        recyclerAdapter.setShowStaggeredView(showTag == SHOW_STAGGERED_VIEW);
        recyclerView.setAdapter(recyclerAdapter);
    }

    private void setRecyclerView() {
        switch (showTag) {
            case 1:
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(linearLayoutManager);
                break;
            case 2:
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
                break;
            case 3:
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL));
                break;
            case 4:
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
                break;
        }
    }
}
