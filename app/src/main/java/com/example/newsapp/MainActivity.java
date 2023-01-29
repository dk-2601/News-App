package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageButton backButton;
    TabLayout tabLayout;
    TabItem mhome,msports,mpolitics,mentertainment,mscience,mhealth,mtechnology;
    ViewPager viewPager;
    PagerAdaptor pagerAdaptor;

    String api = "f7b3023a27364ade9a4fe819fe0f68bc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbarOfMain);


        backButton = findViewById(R.id.backButtonOfMain);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        setSupportActionBar(toolbar);


        tabLayout = findViewById(R.id.include);
        mhome = findViewById(R.id.home);
        msports = findViewById(R.id.sports);
        mpolitics = findViewById(R.id.politics);
        mentertainment = findViewById(R.id.entertainment);
        mscience = findViewById(R.id.science);
        mhealth = findViewById(R.id.health);
        mtechnology = findViewById(R.id.technology);

        viewPager = findViewById(R.id.fragmentContainer);

        pagerAdaptor = new PagerAdaptor(getSupportFragmentManager(),7);
        viewPager.setAdapter(pagerAdaptor);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2 || tab.getPosition() == 3 || tab.getPosition() == 4 || tab.getPosition() == 5 || tab.getPosition() == 6)
                {
                    pagerAdaptor.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
}