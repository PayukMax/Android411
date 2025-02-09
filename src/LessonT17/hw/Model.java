package LessonT17.hw;

import java.io.*;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Model {
    private Map<String, Film> filmList;
    private final String fileName="films.txt";

    public Model() {
        this.filmList = new LinkedHashMap<>();
    }

    public void addFilm(Map film) {
        Film tmpFilm = new Film(film);
        filmList.put(tmpFilm.getFilmName(), tmpFilm);
        System.out.println("Добавлено " + tmpFilm);
    }

    public Collection getAllFilms() {
        return filmList.values();
    }

    public boolean saveFilms() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(filmList);
            return true;
        } catch (Exception e) {
            System.out.println("Проблемка с записью - " + e.getMessage());
            return false;
        }
    }

    public boolean loadFilms() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) { // считывание одиночного объекта
            filmList = (Map<String, Film>) ois.readObject();
            return true;
        } catch (Exception e) {
            System.out.println("Проблемка с чтением -"+e.getMessage());
            return false;
        }
    }

    public boolean deleteFilm(String nameDel) {
        if (filmList.containsKey(nameDel)) {
            filmList.remove(nameDel);
            return true;
        } else return false;

    }

    public Film getDataFilm(String nameFilm) {
         return filmList.get(nameFilm);
    }
}

class Film implements Serializable {
    private String filmName;
    private String filmTheme;
    private String author;
    private String filmYear;
    private String duration;
    private String production;
    private String acters;

    public Film(Map film) {
        this.filmName = (String) film.get("название");
        this.filmTheme = (String) film.get("жанр");
        this.author = (String) film.get("режиссер");
        this.filmYear = (String) film.get("год выпуска");
        this.duration = (String) film.get("длительность");
        this.production = (String) film.get("студия");
        this.acters = (String) film.get("актеры");
    }

    public String getFilmName() {
        return filmName;
    }

    public String getFilmTheme() {
        return filmTheme;
    }

    public String getAuthor() {
        return author;
    }

    public String getFilmYear() {
        return filmYear;
    }

    public String getDuration() {
        return duration;
    }

    public String getProduction() {
        return production;
    }

    public String getActers() {
        return acters;
    }

    @Override
    public String toString() {
        return filmName + " (" + author + ")";
    }
}
