package com.example.filemanagerprj.fragments;

import static android.content.Context.STORAGE_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Environment;

import com.example.filemanagerprj.FileAdapter;
import com.example.filemanagerprj.MainActivity;
import com.example.filemanagerprj.OnFileSelectedListener;
import com.example.filemanagerprj.R;

import java.io.File;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;


public class CardFragment extends Fragment implements OnFileSelectedListener {
//    private RecyclerView recyclerView2;
    private List<File> fileList2;
    private ImageView imgBack2;
    private TextView tvPathHolder2;
//    File storageExt;
    View view2;
    RecyclerView recyclerView;
    String pathToSD = "";
    private FileAdapter fileAdapter;
    File[] mmm;
    File pathSd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view2 = inflater.inflate(R.layout.fragment_card, container, false);
        imgBack2 = view2.findViewById(R.id.image_back2);
        tvPathHolder2 = view2.findViewById(R.id.tv_path_holder2);

        // получаем доступ к SD
//        String externalStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
//        File mmm = Environment.getExternalStorageDirectory();
//        String externalStorage = Environment.getExternalStorageDirectory().toString();
//        File[] mmm = ContextCompat.getExternalFilesDirs(this);
        mmm = ContextCompat.getExternalFilesDirs(requireContext(), null);
//        File mmm = ContextCompat.getExternalFilesDirs(requireContext(), null)[1];
        if (mmm.length>1 && mmm[1]!=null){
//            pathSd = mmm[1];

        String sss = mmm[1].getPath();
        String[] path = sss.split("/");

        if (path.length >= 3) {
            pathToSD=path[0] + "/" + path[1] + "/" + path[2];
            tvPathHolder2.setText("Path SD: " + pathToSD);
            pathSd = new File(pathToSD);
            runtimePermission();  // ечли карты нет то нет смысла отображать списки
        } else {
            tvPathHolder2.setText("Path SD: " + "SD card ejected...");
        }} else {tvPathHolder2.setText("Path(1) SD: " + "SD card ejected...");}




        return view2;
    }

    private void runtimePermission() {
        if (Build.VERSION.SDK_INT<=Build.VERSION_CODES.Q){
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
            }
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                displayFiles();
            }
        }
        //
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.R){
            if (!Environment.isExternalStorageManager()){
                try{
                    Uri uri = Uri.fromParts("package", getActivity().getPackageName(), null);
                    Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                    intent.setData(uri);
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.setData(Uri.parse(String.format("package:%s",getActivity().getPackageName())));
                    getActivity().startActivityIfNeeded(intent,101);
                } catch (Exception e) {
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                    getActivity().startActivityIfNeeded(intent,101);
                }

            }
            if (Environment.isExternalStorageManager()){
                displayFiles();
            }
        }

    }

    private void displayFiles() {
        recyclerView = view2.findViewById(R.id.recycler_internal2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        fileList2 = new ArrayList<>();
        fileList2.addAll(findFiles(pathSd));

        fileAdapter = new FileAdapter(getContext(), fileList2, this);
        recyclerView.setAdapter(fileAdapter);
    }

    private ArrayList<File> findFiles(File file) {
        ArrayList<File> arrayList = new ArrayList<>();
        File[] files = file.listFiles();
        for (File singleFile : files) {
            if (singleFile.isDirectory() && !singleFile.isHidden()){
                arrayList.add(singleFile);
            }
        }
        for (File singleFile : files) {
            if (singleFile.getName().toLowerCase().endsWith(".jpeg") ||
                    singleFile.getName().toLowerCase().endsWith(".jpg") ||
                    singleFile.getName().toLowerCase().endsWith(".png") ||
                    singleFile.getName().toLowerCase().endsWith(".mp3") ||
                    singleFile.getName().toLowerCase().endsWith(".wav") ||
                    singleFile.getName().toLowerCase().endsWith(".mp4") ||
                    singleFile.getName().toLowerCase().endsWith(".pdf") ||
                    singleFile.getName().toLowerCase().endsWith(".doc") ||
                    singleFile.getName().toLowerCase().endsWith(".apk") ){
                arrayList.add(singleFile);
            }
        }
        return arrayList;
    }

    @Override
    public void onFileClicked(File file) {
        if (file.isDirectory()){
            Bundle bundle = new Bundle();
            bundle.putString("path",file.getAbsolutePath());
            InternalFragment internalFragment = new InternalFragment();
            internalFragment.setArguments(bundle);

            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, internalFragment).addToBackStack(null).commit();
        }

    }

    @Override
    public void onFileLongClocked(File file) {

    }
}