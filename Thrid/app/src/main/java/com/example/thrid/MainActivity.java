package com.example.thrid;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {
private int currentProgress=0;
private ProgressBar progressBar;
private EditText mytext;
private ChipGroup chipGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        Button btnNext = findViewById(R.id.btn_next);

        RadioGroup radGr = findViewById(R.id.radioGroup);
        TextView textView = findViewById(R.id.changeColor);
        radGr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton1) {
                    textView.setTextColor(Color.parseColor("#009212"));
                } else if (checkedId == R.id.radioButton2) {
                    textView.setTextColor(Color.parseColor("#FF6F00"));
                }
            }
        });

        ToggleButton tgb = findViewById(R.id.toggleButton);
        tgb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tgb.isChecked()){
                    btn.setBackgroundColor(Color.parseColor("#009212"));
                } else {btn.setBackgroundColor(Color.parseColor("#FF6F00"));

                }
            }
        });

        Switch swt = findViewById(R.id.switch1);
        swt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    swt.setTextColor(Color.parseColor("#FF6F00"));
                } else {swt.setTextColor(Color.parseColor("#009212"));}
            }
        });

        ConstraintLayout cl = findViewById(R.id.main);
        SwitchMaterial swNew = findViewById(R.id.switchMaterial);

        swNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (swNew.isChecked()){
                    swNew.setThumbDrawable(getDrawable(R.drawable.baseline_ac_unit_24));
                    swNew.setText("Turn on Night mode...");
                    swNew.setThumbTintList(ColorStateList.valueOf(Color.BLUE)); // меняется цвет значка
                    swNew.setTrackTintList(ColorStateList.valueOf(Color.RED)); // меняется цвет трека под значком
                    cl.setBackgroundResource(R.color.bg);

                } else {
                    swNew.setThumbDrawable(getDrawable(R.drawable.baseline_wb_sunny_24));
                swNew.setText("Turn on Day mode...");
                    swNew.setTrackTintList(ColorStateList.valueOf(Color.GREEN)); // меняется цвет трека под значком
                cl.setBackgroundResource(R.color.white);
                }
            }
        });

        CheckBox boldBox = findViewById(R.id.boldChBox);
        CheckBox italBox = findViewById(R.id.italicChBox);
        TextView sText = findViewById(R.id.textView2);

        boldBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    if (italBox.isChecked()){ sText.setTypeface(null, Typeface.BOLD_ITALIC); } else {sText.setTypeface(null, Typeface.BOLD);}
                } else {if (italBox.isChecked()) {sText.setTypeface(null, Typeface.ITALIC);} else { sText.setTypeface(null, Typeface.NORMAL);}}
            }
        });

        italBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    if(boldBox.isChecked()) {sText.setTypeface(null, Typeface.BOLD_ITALIC);} else {sText.setTypeface(null, Typeface.ITALIC);}

                } else { if (boldBox.isChecked()) {sText.setTypeface(null, Typeface.BOLD);} else {sText.setTypeface(null, Typeface.NORMAL);} }
            }
        });


        progressBar= findViewById(R.id.progBarHoriz);

        Button btnPG = findViewById(R.id.btnForProgress);
        btnPG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ProgressBar pg1 = findViewById(R.id.progressBar);
//                pg1.setVisibility(View.VISIBLE);
                currentProgress += 10;
                progressBar.setMax(100); // Устанавливаем максимально значение прогресс бара
                progressBar.setProgress(currentProgress); // устанавливаем текущее значение исполненного от максимального значения


            }
        });

        mytext = findViewById(R.id.editTextText);
        chipGroup = findViewById(R.id.chipGroup);

        Button btnAdd = findViewById(R.id.butAdd);
        Button btnShow = findViewById(R.id.butShow);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewChip();
            }
        });


        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSelections();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HWActivity2.class);
                startActivity(intent);
            }
        });




//        Chip chip1 = findViewById(R.id.chip);
//        chip1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Action complete", Toast.LENGTH_LONG).show();
//            }
//        });



//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                RadioGroup radGr = findViewById(R.id.radioGroup);
//                int checkedButtonIndex = radGr.getCheckedRadioButtonId(); // радиокнопки в группе объеденены в кучу и таким образом получаем выбранную позицию в группе начиная с 0
//                TextView textView = findViewById(R.id.changeColor);
//                if (checkedButtonIndex==R.id.radioButton1){
//                    textView.setTextColor(Color.parseColor("#009212"));
//                } else if(checkedButtonIndex==R.id.radioButton2) {
//                    textView.setTextColor(Color.parseColor("#FF6F00"));
//                }
//
//            }
//        });


    }

    private void showSelections(){
        int count = chipGroup.getChildCount(); // получаем количество вложений в группу
        String s=null;
        for (int i = 0; i < count; i++) {
            Chip child = (Chip) chipGroup.getChildAt(i);
            if(!child.isChecked()){
                continue;
            }
            if(s==null){ s=child.getText().toString();} else {s +=", "+child.getText().toString();}
        }
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    private void addNewChip(){
        String keyword = mytext.getText().toString();
        if (keyword.isEmpty()) {
            Toast.makeText(this, "Please enter text...", Toast.LENGTH_SHORT).show();
            return;
        }
        LayoutInflater inflater = LayoutInflater.from(this);
        Chip newChip = (Chip) inflater.inflate(R.layout.layout_chip_entry, this.chipGroup, false);
        newChip.setText(keyword);
        chipGroup.addView(newChip);
        mytext.setText("");
        newChip.setOnCloseIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleChipCloseIconClicked((Chip) v);
            }
        });

    }
    private void handleChipCloseIconClicked(Chip chip){
        ChipGroup parent = (ChipGroup) chip.getParent(); // для удаления эменета необходимо обратиться к родительскому элементу - находим родителя
        parent.removeView(chip); // через родителя удаляем необходимый элемент - это тот который пришел
    }
}