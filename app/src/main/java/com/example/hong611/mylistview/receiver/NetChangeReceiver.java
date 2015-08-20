package com.example.hong611.mylistview.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by hong611 on 2015/8/17.
 */
public class NetChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("netchange","netchange");
    }
}
