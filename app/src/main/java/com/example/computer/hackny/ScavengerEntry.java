package com.example.computer.hackny;

import android.media.Image;

/**
 * Created by Computer on 10/8/2016.
 */
public class ScavengerEntry {
    String prompt;
    String uploaded_by_user_img_filename;
    //String answer_img_filename;
    //float percent_correct;

    public float get_percent_probability(String answer_img_filename){
        //1. use clarifai to gen probability
        //2. return prob
        return 1;
    }

    public void submit_to_entry(){
        //1. get_percent_probability
        //2. upload to db
    }
}
