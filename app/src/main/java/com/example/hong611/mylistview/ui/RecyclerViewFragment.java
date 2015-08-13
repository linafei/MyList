package com.example.hong611.mylistview.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hong611.mylistview.R;

/**
 * Created by hong611 on 2015/8/13.
 */
public class RecyclerViewFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.recyclerview_fragment,null);
        return view;
    }
}
