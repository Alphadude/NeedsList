package com.ng.needslist.needslist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.ng.needslist.needslist.Activities.MainActivity;

public class Splash extends AppCompatActivity {

    private ImageView splashImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashImage = (ImageView)findViewById(R.id.splash);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.transition);
        splashImage.startAnimation(animation);

        final Intent intent = new Intent(this,MainActivity.class);

        Thread timer = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(3000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }

}
