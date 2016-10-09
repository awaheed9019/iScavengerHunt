package com.example.computer.hackny;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Computer on 10/8/2016.
 */
public class TeamHomeActivity extends Activity {

    private static final String TAG = "TeamHomeActivity";

    private TextView tv_time_remaining;
    private Button b_submit_ans;
    private Button b_view_list;
    private Button b_chatroom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_home);

        Utils_debug_awaheed.log_awaheed(TAG, "onCreate");

        tv_time_remaining = (TextView) findViewById(R.id.time_remaining_tv);
        b_submit_ans = (Button) findViewById(R.id.submit_ans_b);
        b_view_list = (Button) findViewById(R.id.view_list_b);
        b_chatroom = (Button) findViewById(R.id.chatroom_b);

        b_submit_ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toSubmitAnswerActivity();
            }
        });
        b_view_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toViewListActivity();
            }
        });
        b_chatroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toChatActivity();
            }
        });
    }

    void toChatActivity(){
        Intent i = new Intent(this, ChatActivity.class);
        startActivity(i);
    }

    void toViewListActivity(){
        Intent i = new Intent(this, ViewListActivity.class);
        startActivity(i);
    }

    void toSubmitAnswerActivity(){
        Intent i = new Intent(this, SubmitAnswerActivity.class);
        startActivity(i);
    }

}