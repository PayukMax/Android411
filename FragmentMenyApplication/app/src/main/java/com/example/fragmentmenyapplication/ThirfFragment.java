package com.example.fragmentmenyapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SearchView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirfFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirfFragment extends Fragment {
    SearchView searchView;
    ListView listView;

    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_thirf, container, false);
        searchView = view.findViewById(R.id.search);
        listView = view.findViewById(R.id.listView);

        arrayList= new ArrayList<>();
        arrayList.add("Архангельск");
        arrayList.add("Арзамасс");
        arrayList.add("Воронеж");
        arrayList.add("Астрахань");
        arrayList.add("Москва");
        arrayList.add("Смоленск");
        arrayList.add("Владимир");
        arrayList.add("Волгоград");
        arrayList.add("Ставрополь");
        arrayList.add("Адлер");
        arrayList.add("Выборг");
        arrayList.add("Самара");
        arrayList.add("Усть-Каменогорск");

        adapter = new ArrayAdapter<>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });




        return view;
    }
}