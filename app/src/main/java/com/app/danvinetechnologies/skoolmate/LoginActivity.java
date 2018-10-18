package com.app.danvinetechnologies.skoolmate;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

import com.app.danvinetechnologies.skoolmate.Adapter.ViewPagerAdapter;
import com.app.danvinetechnologies.skoolmate.Fragment.Student_Login_Fragment;
import com.app.danvinetechnologies.skoolmate.Fragment.Teacher_Login_Fragment;

public class LoginActivity extends AppCompatActivity {

    AppBarLayout appBarLayout;
    TabLayout tabLayout;
    android.support.v7.widget.Toolbar toolbar;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        toolbar = findViewById(R.id.toolbarid);
        setSupportActionBar(toolbar);



        appBarLayout = findViewById(R.id.appbarlayoutid);
        tabLayout = findViewById(R.id.tablayoutid);
        viewPager = findViewById(R.id.viewpagerid);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());


        viewPagerAdapter.Addfragment(new Student_Login_Fragment(),"Student");
        viewPagerAdapter.Addfragment(new Teacher_Login_Fragment(),"Teacher");
     //   tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);




        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


        tabLayout.getTabAt(0).setIcon(R.drawable.ic_person_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_person_black_24dp);


    }
}
