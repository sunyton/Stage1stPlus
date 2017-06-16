package com.code4job.suny.stage1st.activity;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.code4job.suny.stage1st.R;

public class TopicAcitvity extends AppCompatActivity {

    BottomNavigationView navbtview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        navbtview = (BottomNavigationView) findViewById(R.id.bottom_nav);


    }
}
