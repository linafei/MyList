package com.example.hong611.mylistview.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.hong611.mylistview.R;
import com.example.hong611.mylistview.model.ItemModel;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    LinearLayout fgContainer;
    ListViewFragment listViewFragment;
    GridViewFragment gridViewFragment;
    RecyclerViewFragment recyclerViewFragment;

    public static List<ItemModel> itemModels = new ArrayList<ItemModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initFragment();

        initDatas();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fgContainer = (LinearLayout) findViewById(R.id.fg_container);

        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);

        toolbar.setOnMenuItemClickListener(menuItemClickListener);
    }

    private void initFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        listViewFragment = new ListViewFragment();
        gridViewFragment = new GridViewFragment();
        recyclerViewFragment = new RecyclerViewFragment();


        fragmentTransaction.replace(R.id.fg_container, listViewFragment);
        fragmentTransaction.commit();
    }

    private void initDatas() {
        for (int i = 0; i < 20; i++) {
            ItemModel itemModel = new ItemModel("This is title " + i, "This is content " + i, R.mipmap.ic_launcher);

            itemModels.add(itemModel);
        }
    }

    private Toolbar.OnMenuItemClickListener menuItemClickListener = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            switch (item.getItemId()) {
                case R.id.show_listview:
                    fragmentTransaction.replace(R.id.fg_container, listViewFragment);
                    break;
                case R.id.show_gridview:
                    fragmentTransaction.replace(R.id.fg_container, gridViewFragment);
                    break;
                case R.id.show_recyclerview:
                    fragmentTransaction.replace(R.id.fg_container, recyclerViewFragment);
                    break;
            }
            fragmentTransaction.commit();
            return true;
        }
    };
}
