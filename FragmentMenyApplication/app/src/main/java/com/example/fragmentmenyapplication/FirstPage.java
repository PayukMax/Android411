package com.example.fragmentmenyapplication;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

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
FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first_page, container, false);
        ratingBar = view.findViewById(R.id.ratingBar);
        ratingBtn = view.findViewById(R.id.rating_btn);

        fab = view.findViewById(R.id.fab);

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

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomDialog();
            }
        });

        return view;
    }

    private void showBottomDialog() {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom_sheet_layout);
        TextView second = dialog.findViewById(R.id.second);
        TextView thrid = dialog.findViewById(R.id.third);
        TextView fourth = dialog.findViewById(R.id.fourth);

        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                replaceFragment(new SecondPage());
            }
        });

        thrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                replaceFragment(new ThirfFragment());
            }
        });

        fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                replaceFragment(new FourthFragment());
            }
        });

        dialog.show();

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; // сам DialogAnim  объявлен в themes.xml
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
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