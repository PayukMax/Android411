package com.example.second;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_animation);

        ImageView image = findViewById(R.id.boy_image);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((AnimationDrawable) image.getDrawable()).start();
//                    Animation out = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.anim_alpha); //Аналог ниже...
//                    Animation out = AnimationUtils.loadAnimation(getBaseContext(), R.anim.anim_alpha);
//
//                    image.startAnimation(out);
                Animation translate = AnimationUtils.loadAnimation(getBaseContext(), R.anim.anim_translate);
                image.startAnimation(translate);
            }
        });

        ImageView myImageV = findViewById(R.id.boy_image0);

        ObjectAnimator rot = ObjectAnimator.ofFloat(myImageV,"rotation", 90);
        ObjectAnimator transY = ObjectAnimator.ofFloat(myImageV,"translationY",300);
        AnimatorSet set = new AnimatorSet();
        set.play(rot).with(transY);
        set.setDuration(1000);
        set.setStartDelay(1000);
        set.start();

        Button butRotCentre = findViewById(R.id.rotateCenter);
        Button butRotCorner = findViewById(R.id.rotateCorner);
        Animation animRotCentre = AnimationUtils.loadAnimation(this,R.anim.rotate_center);
        Animation animRotCorner = AnimationUtils.loadAnimation(this,R.anim.rotate_corner);

        butRotCentre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myImageV.startAnimation(animRotCentre);

            }
        });

        butRotCorner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myImageV.startAnimation(animRotCorner);
            }
        });

        Animation scale = AnimationUtils.loadAnimation(this,R.anim.shrink);
        image.startAnimation(scale);


    }
}