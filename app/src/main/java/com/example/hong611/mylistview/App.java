package com.example.hong611.mylistview;

import android.content.Context;

/**
 * Created by hong611 on 2015/8/19.
 */
public class App extends android.app.Application {
    public static Context ctx;

    @Override
    public void onCreate() {
        super.onCreate();
        ctx = this;

        initLeanCloud();
        initDatabase();
    }

    private void initLeanCloud(){
//        AVOSCloud.initialize(this, "bbpuektabrjrpkv3ari7mfqn5hd7d0t3714wlqquz7keq7vw", "qn8dj6kbpjm1geq6ohht11x0qcrs0jkocd5wqb989sbi8kcq");
    }

    private void initDatabase() {

    }
}
