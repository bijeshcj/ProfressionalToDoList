package com.profressionaltodolist;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by npcompete on 29/7/13.
 */
public class BaseActivity extends Activity{
    public static final String TAG = "Professional_To_do_list";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "$$$ BaseActivity");
    }
}
