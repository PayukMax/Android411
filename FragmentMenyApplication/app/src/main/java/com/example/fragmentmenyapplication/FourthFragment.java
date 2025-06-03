package com.example.fragmentmenyapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;


public class FourthFragment extends Fragment {
    TextView textView, textViewLang;
    NumberPicker numberPicker, numberPickerLang;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fourth, container, false);

        textView = view.findViewById(R.id.textViewNumberPicker);
        numberPicker = view.findViewById(R.id.numberPicker);

        numberPicker.setMaxValue(10);
        numberPicker.setMinValue(0);
        numberPicker.setValue(5);

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                textView.setText("Selected "+newVal);
            }
        });

        textViewLang = view.findViewById(R.id.textViewCountryPicker);
        numberPickerLang = view.findViewById(R.id.countryPicker);
        Languich.initLanguich();
        numberPickerLang.setMaxValue(Languich.getLanguichArrayList().size()-1);
        numberPickerLang.setMinValue(0);
//        numberPickerLang.setValue(0);
        numberPickerLang.setDisplayedValues(Languich.languichName());

        numberPickerLang.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                textViewLang.setText("Selected "+Languich.getLanguichArrayList().get(newVal).getName());
            }
        });


        return view;
    }
}