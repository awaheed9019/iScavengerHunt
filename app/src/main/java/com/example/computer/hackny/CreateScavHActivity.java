package com.example.computer.hackny;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Computer on 10/8/2016.
 */
public class CreateScavHActivity extends Activity {

    private static final String TAG = "CreateScavHActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_scav);

        Utils_debug_awaheed.log_awaheed(TAG, "onCreate");

    }


}
