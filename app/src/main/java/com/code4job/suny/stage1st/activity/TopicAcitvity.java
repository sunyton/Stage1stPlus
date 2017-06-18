package com.code4job.suny.stage1st.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.code4job.suny.stage1st.R;
import com.code4job.suny.stage1st.fragment.FragmentHome;
import com.code4job.suny.stage1st.fragment.FragmentLove;

public class TopicAcitvity extends AppCompatActivity {

    BottomNavigationView navbtview;
    FragmentManager fm = getSupportFragmentManager();
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        navbtview = (BottomNavigationView) findViewById(R.id.bottom_nav);
        fm.beginTransaction().replace(R.id.fg, new FragmentLove()).commit();
        mToolbar = (Toolbar) findViewById(R.id.tl);
        setSupportActionBar(mToolbar);
        mToolbar.setTitleTextColor(getResources().getColor(R.color.white));

        navbtview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.love:
                        fm.beginTransaction().replace(R.id.fg, new FragmentLove()).commit();
                        break;
                    case R.id.home:
                        Log.i("ttt", "home");
                        fm.beginTransaction().replace(R.id.fg, new FragmentHome()).commit();
                        break;
                }
                return true;
            }


        });


    }
}
