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

public  class ResScreen extends Dialog  {
    private final String message;
    private final PlayField playingField;

    public ResScreen(@NonNull Context context, String message, PlayField playingField) {
        super(context);
        this.message = message;
        this.playingField = playingField;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_screen);

        TextView messageText = findViewById(R.id.messageText);
        Button startAgainBtn = findViewById(R.id.startAgainButton);

        messageText.setText(message);
        startAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playingField.restartMatch();
                dismiss();
            }
        });


    }
}