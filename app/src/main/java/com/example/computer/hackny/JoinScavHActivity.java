package com.example.computer.hackny;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Computer on 10/8/2016.
 */
public class JoinScavHActivity extends Activity {

    private static final String TAG = "JoinScavHActivity";

    private EditText et_team_name;
    private EditText et_invite_code;
    private Button b_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_scav);

        Utils_debug_awaheed.log_awaheed(TAG, "onCreate");

        et_team_name = (EditText) findViewById(R.id.team_name_et);
        et_invite_code = (EditText) findViewById(R.id.invite_code_et);
        b_submit = (Button) findViewById(R.id.submit_b);

        b_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toTeamHomeActivity();
            }
        });

    }

    void toTeamHomeActivity(){
        Intent i = new Intent(this, TeamHomeActivity.class);
        startActivity(i);
    }

}
