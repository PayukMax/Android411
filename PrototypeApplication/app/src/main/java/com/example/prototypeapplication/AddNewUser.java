package com.example.prototypeapplication;


import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.prototypeapplication.Utils.DbHelper;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class AddNewUser extends BottomSheetDialogFragment {

    public static final String TAG="AddNewUser";

    private EditText mUser, mPasw;
    private Button mSaveButton;
    private DbHelper myDB;

    public static AddNewUser newInstance() {return new AddNewUser();}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_new_user, container,false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUser = view.findViewById(R.id.n_name);
        mPasw = view.findViewById(R.id.n_passw);
        mSaveButton = view.findViewById(R.id.btn_Save);

        myDB = new DbHelper(getActivity());
        boolean isUpdate = false;
        Bundle bundle = getArguments();
        if (bundle!= null) {
            isUpdate=true;
            String t1 = bundle.getString("user");
            String t2 = bundle.getString("passw")
            mUser.setText(t1);
            mPasw.setText(t2);
            if (t1.length()>0){
                mSaveButton.setEnabled(false);
            }
        }
        mUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().equals("")){
                    mSaveButton.setEnabled(false);
                    mSaveButton.setBackgroundColor(Color.GRAY);
                } else {
                    mSaveButton.setEnabled(true);
//                        mSaveButton.setBackgroundColor();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        boolean finalIsUpdate = isUpdate;
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = mEditText.getText().toString();
                if (finalIsUpdate){
                    myDB.updateTask(bundle.getInt("Id"),text);
                } else {
                    ToDoModel item = new ToDoModel();
                    item.setTask(text);
                    item.setStatus(0);
                    myDB.insertTask(item);
                }
                dismiss();
            }
        });
    }


}
