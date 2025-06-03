package com.example.fragmentmenyapplication;

import java.util.ArrayList;

public class Languich {
    private int id;
    private String name;
    private static ArrayList<Languich> languichArrayList;

    public Languich(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void initLanguich(){
        languichArrayList = new ArrayList<>();
        Languich english = new Languich(0,"English");
        languichArrayList.add(english);
        languichArrayList.add( new Languich(1,"French"));
        languichArrayList.add( new Languich(2,"Japanese"));
        languichArrayList.add( new Languich(3,"Russian"));
        languichArrayList.add( new Languich(4,"Belarusian"));
        languichArrayList.add( new Languich(5,"German"));
    }

    public static ArrayList<Languich> getLanguichArrayList(){
        return languichArrayList;
    }

    public static String[] languichName(){
        String[] names = new String[languichArrayList.size()];
        for (int i = 0; i < languichArrayList.size(); i++) {
            names[i] = languichArrayList.get(i).name;

        }
        return names;
    }
}
