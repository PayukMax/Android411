package com.example.fragmentmenyapplication;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstPage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstPage extends Fragment {

    RatingBar ratingBar;
    Button ratingBtn, buttonFindDesription;
    Spinner spinerColors;
    TextView textViewDescription, textView ;
    SeekBar seekBar,seekBar2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first_page, container, false);
        ratingBar = view.findViewById(R.id.ratingBar);
        ratingBtn = view.findViewById(R.id.rating_btn);

        ratingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                float value = ratingBar.getRating();
                Toast.makeText(getContext(), "Rating: " + ratingBar.getRating(), Toast.LENGTH_SHORT).show();
            }
        });

        spinerColors = view.findViewById(R.id.spinner_list);
        buttonFindDesription = view.findViewById(R.id.button_find_description);
        textViewDescription = view.findViewById(R.id.text_view_description);

        buttonFindDesription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = spinerColors.getSelectedItemPosition();
                textViewDescription.setText(getDescriptionPosition(position));
                buttonFindDesription.setBackgroundColor(Color.parseColor(getColors(position)));

            }
        });

        textViewDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "!!!!!!!!!!", Toast.LENGTH_SHORT).show();
            }
        });

        seekBar=view.findViewById(R.id.seekBar);
        seekBar2=view.findViewById(R.id.seekBar2);
        textView= view.findViewById(R.id.textView2);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText(progress+"/100");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
// здесь происходят действия при взятии за бегунок
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
// здесь происходят действия при отпускании бегунка
            }
        });

        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setTextSize(30+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        return view;
    }

    private String getDescriptionPosition(int position) {
        String[] description = getResources().getStringArray(R.array.description_of_temp);
        return description[position];
    }

    private String getColors(int position) {
        String[] description = getResources().getStringArray(R.array.colors_button);
        return description[position];
    }

}