package com.example.gamexo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class PlayingField extends AppCompatActivity {
    private final List<int[]> combinationList = new ArrayList<>();
    private int activePlayer = 1;
    private int[] boxPositions = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int totalSelectBoxes = 1;
    private ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9;
    private TextView playerOneName;
    private TextView playerTwoName;

    private int currentScoreOne = 0;
    private int currentScoreTwo = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_field);

        playerOneName = findViewById(R.id.playerOneName);
        playerTwoName = findViewById(R.id.playerTwoName);

        combinationList.add(new int[]{0,1,2});
        combinationList.add(new int[]{3,4,5});
        combinationList.add(new int[]{6,7,8});
        combinationList.add(new int[]{0,3,6});
        combinationList.add(new int[]{1,4,7});
        combinationList.add(new int[]{2,5,8});
        combinationList.add(new int[]{0,4,8});
        combinationList.add(new int[]{2,4,6});

        String getPlayerOneName = getIntent().getStringExtra("playerOne");
        String getPlayerTwoName = getIntent().getStringExtra("playerTwo");

        playerOneName.setText(getPlayerOneName);
        playerTwoName.setText(getPlayerTwoName);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);
        changePlayerTurn(activePlayer);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(0)) {
                    performAction((ImageView) v, 0);
                }
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(1)) {
                    performAction((ImageView) v, 1);
                }
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(2)) {
                    performAction((ImageView) v, 2);
                }
            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(3)) {
                    performAction((ImageView) v, 3);
                }
            }
        });
        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(4)) {
                    performAction((ImageView) v, 4);
                }
            }
        });
        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(5)) {
                    performAction((ImageView) v, 5);
                }
            }
        });
        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(6)) {
                    performAction((ImageView) v, 6);
                }
            }
        });
        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(7)) {
                    performAction((ImageView) v, 7);
                }
            }
        });
        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(8)) {
                    performAction((ImageView) v, 8);
                }
            }
        });

    }

    private void performAction(ImageView image, int selBoxPosition) {
        boxPositions[selBoxPosition] = activePlayer;
        image.setBackgroundResource(R.drawable.white_box);
        image.setScaleType(ImageView.ScaleType.CENTER);

        playerOneName = findViewById(R.id.playerOneName);
        playerTwoName = findViewById(R.id.playerTwoName);

        TextView scorePlayerOne = findViewById(R.id.scoreOne);
        TextView scorePlayerTwo = findViewById(R.id.scoreTwo);



        if (activePlayer == 1) {
            image.setImageResource(R.drawable.ximage);
            if(checkResults()) {
                ResultDialog resultDialog = new ResultDialog( PlayingField.this, playerOneName.getText().toString()+" is a WINNER!!!", PlayingField.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
                currentScoreOne++;
                scorePlayerOne.setText(String.valueOf(currentScoreOne));
            } else if(totalSelectBoxes == 9) {
                ResultDialog resultDialog = new ResultDialog(PlayingField.this, "Match Draw", PlayingField.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }  else {
                totalSelectBoxes++;
                changePlayerTurn(2);
            }
        } else {
            image.setImageResource(R.drawable.oimage);
            if(checkResults()) {
                ResultDialog resultDialog = new ResultDialog( PlayingField.this, playerTwoName.getText().toString()+" is a WINNER!!!", PlayingField.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
                currentScoreTwo++;
                scorePlayerTwo.setText(String.valueOf(currentScoreTwo));
            } else if(totalSelectBoxes == 9) {
                ResultDialog resultDialog = new ResultDialog(PlayingField.this, "Match Draw", PlayingField.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else {
                totalSelectBoxes++;
                changePlayerTurn(1);

            }
        }

    }

    private boolean checkResults(){
        boolean responce = false;
        for (int i = 0; i < combinationList.size(); i++) {
            final  int[] combination = combinationList.get(i);
            if (boxPositions[combination[0]] == activePlayer && boxPositions[combination[1]]==activePlayer && boxPositions[combination[2]]==activePlayer) {
                responce = true;
            }
        }
        return responce;
    }

    private void changePlayerTurn(int currentPlayerTurn) {
        activePlayer = currentPlayerTurn;
        LinearLayout l1 = findViewById(R.id.playerOneLayoutOuter);
        LinearLayout l2 = findViewById(R.id.playerTwoLayoutOuter);
        if (activePlayer == 1) {
            l1.setBackgroundResource(R.drawable.black_border);
            l2.setBackgroundResource(R.drawable.white_box);
        } else {
            l2.setBackgroundResource(R.drawable.black_border);
            l1.setBackgroundResource(R.drawable.white_box);
        }
    }

    private boolean isBoxSelectable(int boxPos) {
        if (boxPositions[boxPos] == 0) return true;
        else return false;
    }

    public void restartMatch() {
        boxPositions = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        activePlayer = 1;
        totalSelectBoxes = 1;
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);
        image1.setImageResource(R.drawable.white_box);
        image2.setImageResource(R.drawable.white_box);
        image3.setImageResource(R.drawable.white_box);
        image4.setImageResource(R.drawable.white_box);
        image5.setImageResource(R.drawable.white_box);
        image6.setImageResource(R.drawable.white_box);
        image7.setImageResource(R.drawable.white_box);
        image8.setImageResource(R.drawable.white_box);
        image9.setImageResource(R.drawable.white_box);
    }
}