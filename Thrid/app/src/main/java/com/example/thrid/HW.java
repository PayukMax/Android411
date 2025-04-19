package com.example.thrid;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HW extends AppCompatActivity {
    Switch sw;
    EditText sum;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw);

        sum = findViewById(R.id.editSumm);
        sw = findViewById(R.id.switch2);
        Button btn = findViewById(R.id.button2);
        res = findViewById(R.id.result);

        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.setText(getMessage());
            }
        });

        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.setText(getMessage());
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });

//        sum.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if (event.getAction()==KeyEvent.ACTION_DOWN && (keyCode != KeyEvent.KEYCODE_ENTER))
//                        { //
//
//                            String str = sum.getText().toString();
//                            str += Character.toString(keyCode);
//                    res.setText(str);
//                }
//                return false;
//            }
//        });


    }

    private String getMessage() {
        String msg = sum.getText().toString();
        if (sw.isChecked()) {
            double tmp = Double.valueOf(sum.getText().toString());
            if (tmp > 1000) {
                double skdk = tmp * 0.05;
                tmp = tmp - skdk;
                msg = Double.toString(tmp) + "\n(скидка 5% составила " + Double.toString(skdk) + " руб)";
            } else if (tmp > 500) {
                double skdk = tmp * 0.03;
                tmp = tmp - skdk;
                msg = Double.toString(tmp) + "\n(скидка 3% составила " + Double.toString(skdk) + " руб)";
            } else {
                msg = Double.toString(tmp) + "\n(скидка на сумму менее 500 руб не предоставляется)";
            }

        }
        return msg;
    }


}
