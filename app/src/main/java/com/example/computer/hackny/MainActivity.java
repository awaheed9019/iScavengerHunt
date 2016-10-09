package com.example.computer.hackny;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity  {

    private static final String TAG = "MainActivity";

    private Button b_create_scav;
    private Button b_join_scav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utils_debug_awaheed.log_awaheed(TAG, "Running...");
        Utils_debug_awaheed.log_awaheed(TAG, "onCreate");

        b_create_scav = (Button) findViewById(R.id.create_scav_b);
        b_join_scav = (Button) findViewById(R.id.join_scav_b);

        b_create_scav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toCreateScavHActivity();
            }
        });
        b_join_scav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toJoinScavHActivity();
            }
        });

    }

    void toCreateScavHActivity(){
        Intent i = new Intent(this, CreateScavHActivity.class);
        startActivity(i);
    }

    void toJoinScavHActivity(){
        Intent i = new Intent(this, JoinScavHActivity.class);
        startActivity(i);
    }



}
