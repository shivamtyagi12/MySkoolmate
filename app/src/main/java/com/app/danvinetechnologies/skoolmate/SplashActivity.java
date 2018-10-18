package com.app.danvinetechnologies.skoolmate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;



public class SplashActivity extends AppCompatActivity {

    ImageView imageViewhome,imageViewboy;
    Animation animation,animation1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageViewhome = findViewById(R.id.img_home_id);
       // imageViewboy = findViewById(R.id.imgboyid);
       // TranslateAnimation animation = new TranslateAnimation(0, 200,0, 0);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
       // animation.setDuration(1000);  // animation duration
       // animation.setRepeatCount(1);  // animation repeat count
       // animation.setRepeatMode(1);   // repeat animation (left to right, right to left )
        //animation.setFillAfter(true);

        //imageViewboy.startAnimation(animation);
        animation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        imageViewhome.setAnimation(animation);
       // animation1 = AnimationUtils.loadAnimation(this,R.anim.uptodown);
       // imageViewboy.setAnimation(animation);
       // imageViewboy.setAnimation(animation1);


            Thread thread = new Thread()
            {
                @Override
                public void run()
                {
                    try{
                        sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {

                        Intent intent = new Intent(SplashActivity.this, com.app.danvinetechnologies.skoolmate.LoginActivity.class);
                        startActivity(intent);
                    }
                }
            };
            thread.start();


    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
