package com.example.hong611.mylistview.ui;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.hong611.mylistview.R;
import com.example.hong611.mylistview.adapter.MyListViewAdapter;
import com.example.hong611.mylistview.model.ItemModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class ListViewFragment extends Fragment {
    List<ItemModel> itemModels = new ArrayList<ItemModel>();
    MyListViewAdapter myAdapter;
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.listview_fragment, container, false);
        listView = (ListView) view.findViewById(R.id.listview);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initDatas();
        setAdapter();
    }

    private void initDatas() {
        for (int i = 0; i < 20; i++) {
            ItemModel itemModel = new ItemModel("This is title " + i, "This is content " + i, R.mipmap.ic_launcher);

            itemModels.add(itemModel);
        }
    }

    private void setAdapter() {
        myAdapter = new MyListViewAdapter(getActivity(), itemModels);
        listView.setAdapter(myAdapter);
    }

}
