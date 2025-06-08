package com.example.filemanagerprj.fragments;

import static android.content.Context.STORAGE_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Environment;

import com.example.filemanagerprj.MainActivity;
import com.example.filemanagerprj.R;

import java.io.File;

import java.util.List;
import java.util.Objects;


public class CardFragment extends Fragment {
    private RecyclerView recyclerView2;
    private List<File> fileList2;
    private ImageView imgBack2;
    private TextView tvPathHolder2;
    File storageExt;
    View view2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card, container, false);
        imgBack2 = view.findViewById(R.id.image_back2);
        tvPathHolder2 = view.findViewById(R.id.tv_path_holder2);

        // получаем доступ к SD
//        String externalStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
//        File mmm = Environment.getExternalStorageDirectory();
//        String externalStorage = Environment.getExternalStorageDirectory().toString();
//        File[] mmm = ContextCompat.getExternalFilesDirs(this);
        File[] mmm = ContextCompat.getExternalFilesDirs(requireContext(), null);
//        File mmm = ContextCompat.getExternalFilesDirs(requireContext(), null)[1];
        if (mmm.length>1 && mmm[1]!=null){
        String sss = mmm[1].getPath();
        String[] path = sss.split("/");
        String pathToSD = "";
        if (path.length >= 3) {
            pathToSD=path[0] + "/" + path[1] + "/" + path[2];
            tvPathHolder2.setText("Path SD: " + pathToSD);
        } else {
            tvPathHolder2.setText("Path SD: " + "SD card ejected...");
        }} else {tvPathHolder2.setText("Path(1) SD: " + "SD card ejected...");}


        return view;
    }
}