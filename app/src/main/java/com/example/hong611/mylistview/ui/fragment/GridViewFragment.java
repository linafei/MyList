package com.example.hong611.mylistview.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.hong611.mylistview.R;
import com.example.hong611.mylistview.adapter.MyGridViewAdapter;
import com.example.hong611.mylistview.model.ItemModel;
import com.example.hong611.mylistview.ui.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hong611 on 2015/8/13.
 */
public class GridViewFragment extends Fragment {
    List<ItemModel> itemModels = new ArrayList<>();
    MyGridViewAdapter myGridViewAdapter;
    GridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gridview_fragment, null);
        gridView = (GridView) view.findViewById(R.id.gridview);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setAdapter();
    }

    private void setAdapter() {
        myGridViewAdapter = new MyGridViewAdapter(getActivity(), MainActivity.itemModels);
        gridView.setAdapter(myGridViewAdapter);

    }
}
