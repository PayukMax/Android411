package com.example.second;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    private MediaPlayer sound1, sound2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ImageButton img1 = findViewById(R.id.buttonImg1);
        ImageButton img2 = findViewById(R.id.buttonImg2);
        sound1 = MediaPlayer.create(this, R.raw.sound_1);
        sound2 = MediaPlayer.create(this, R.raw.sound_2);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlayButton(sound1, sound2);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlayButton(sound2, sound1);
            }
        });



    }

    public void soundPlayButton(MediaPlayer sound_1, MediaPlayer sound_2) {
        if (sound_1.isPlaying()) {
            sound_1.pause();
            sound_1.setLooping(false);
        }

        if (sound_2.isPlaying()) {
            sound_2.pause();
            sound_2.setLooping(false);
        }
        sound_1.start();
        sound_1.setLooping(true);
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void stopSound(View view) {
        if (sound1.isPlaying()) sound1.stop();
        if (sound2.isPlaying()) sound2.stop();
    }

}