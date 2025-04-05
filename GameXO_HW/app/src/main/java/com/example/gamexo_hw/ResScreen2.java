package com.example.gamexo_hw;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResScreen2 extends Dialog {
    private final String message;
    private final PlayField2 playingField2;

    public ResScreen2(@NonNull Context context, String message, PlayField2 playingField2) {
        super(context);
        this.message = message;
        this.playingField2 = playingField2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_screen2);

        TextView messageText = findViewById(R.id.messageText2);
        Button startAgainBtn = findViewById(R.id.startAgainButton2);

        messageText.setText(message);
        startAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playingField2.restartMatch();
                dismiss();
            }
        });


    }
}