package com.example.prabhatd.basicfunctionality;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.List;

public class SecondACtivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Setting View Pager for each Tab
        ViewPager viewPager = findViewById(R.id.viewpager);
        setUpViewPager(viewPager);

        TabLayout tab= findViewById(R.id.tab);
        tab.addTab(tab.newTab().setText("Mobile"));
        tab.addTab(tab.newTab().setText("Clothes"));
        tab.addTab(tab.newTab().setText("Bottles"));
        //set Tabs inside Toolbar
       /* tab.setupWithViewPager(viewPager);*/






        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    private void setUpViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new ListLayout(),"List");
        adapter.addFragment(new CardLayout(),"Card");
        adapter.addFragment(new TileLayout(),"Tile");
        viewPager.setAdapter(adapter);

    }

    static class Adapter extends FragmentPagerAdapter{
        public final List<Fragment> mfragmentList = new ArrayList<>();
        public final List<String> mFragmentTitleList = new ArrayList<>();
        public Adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return mfragmentList.get(i);
        }

        @Override
        public int getCount() {
            return mfragmentList.size();
        }

        public void addFragment(Fragment fragment,String title){
            mfragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return super.getPageTitle(position);
        }
    }



}
