package com.app.danvinetechnologies.skoolmate.Fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.app.danvinetechnologies.skoolmate.Adapter.ViewPagerAdapterrr;
import com.app.danvinetechnologies.skoolmate.R;
import com.app.danvinetechnologies.skoolmate.SimpleAdapter;

import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class Teacher_Home_Fragment extends Fragment {


    static Activity activity;
    RecyclerView recyclerView;

    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;


    public Teacher_Home_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_teacher__home_, container, false);


        //autoimageslider
        viewPager = view.findViewById(R.id.viewPager);
        sliderDotspanel =  view.findViewById(R.id.SliderDots);

        //aniimatedrecyclerview
        recyclerView = view.findViewById(R.id.recyclerview);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        runAnimation(recyclerView,0);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));





        //autoimageslider
        ViewPagerAdapterrr viewPagerAdapterrr = new ViewPagerAdapterrr(getContext());

        viewPager.setAdapter(viewPagerAdapterrr);

        dotscount = viewPagerAdapterrr.getCount();
        dots = new ImageView[dotscount];

        for(int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(getContext());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.nonactive_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Timer timer = new Timer();
        timer.scheduleAtFixedRate( new MyTimerTask(), 2000, 4000);

        return  view;
    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(viewPager.getCurrentItem() == 0){
                        viewPager.setCurrentItem(1);
                    } else if(viewPager.getCurrentItem() == 1){
                        viewPager.setCurrentItem(2);

                    }
                    else if(viewPager.getCurrentItem() == 2){
                        viewPager.setCurrentItem(3);

                    }else{
                        viewPager.setCurrentItem(0);
                    }
                }
            });

        }
    }

    //animated recyclerview method
    private void runAnimation(RecyclerView recyclerView, int i) {

        Context context = recyclerView.getContext();
        LayoutAnimationController controller = null;

        if(i==0)
            controller = AnimationUtils.loadLayoutAnimation(context,R.anim.layout_slide_from_left);

        SimpleAdapter simpleAdapter = new SimpleAdapter();
        recyclerView.setAdapter(simpleAdapter);



        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }

}
