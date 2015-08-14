package com.example.hong611.mylistview.ui.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hong611.mylistview.R;
import com.example.hong611.mylistview.adapter.MyListViewAdapter;
import com.example.hong611.mylistview.ui.activity.ImageShowActivity;
import com.example.hong611.mylistview.ui.activity.MainActivity;
import com.example.hong611.mylistview.ui.activity.WebShowActivity;

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
        initView();
    }

    private void setAdapter() {
        myAdapter = new MyListViewAdapter(getActivity(), MainActivity.itemModels);
        listView.setAdapter(myAdapter);
    }

    private void initView() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(getActivity(), WebShowActivity.class);
                    getActivity().startActivity(intent);
                }else if(position==1){
                    Intent intent = new Intent(getActivity(), ImageShowActivity.class);
                    getActivity().startActivity(intent);
                }
            }
        });
    }

}
