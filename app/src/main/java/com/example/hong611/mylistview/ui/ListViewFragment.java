package com.example.hong611.mylistview.ui;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.hong611.mylistview.R;
import com.example.hong611.mylistview.adapter.MyListViewAdapter;

public class ListViewFragment extends Fragment {
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

        setAdapter();
    }

    private void setAdapter() {
        myAdapter = new MyListViewAdapter(getActivity(), MainActivity.itemModels);
        listView.setAdapter(myAdapter);
    }

}
