package LessonT17.hw;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    Scanner input = new Scanner(System.in);

    public String waitUserAnswer() {
        System.out.println("========= Редактирование данных каталога фильмов =========");
        System.out.println("Действие с фильмами:");
        System.out.println("1 - добавление фильма\n2 - каталог фильмов\n3 - просмотр определенного фильма\n4 - удаление фильма\nq - выход из программы");
        System.out.print("Выберите вариант действия: ");
        String userAnswer = input.nextLine();
        System.out.println("================================================");
        return userAnswer;
    }

    public Map getFilmData() {
        Map<String,String> filmArticle = new LinkedHashMap<>();
        filmArticle.put("название","");
        filmArticle.put("жанр","");
        filmArticle.put("режиссер","");
        filmArticle.put("год выпуска","");
        filmArticle.put("длительность","");
        filmArticle.put("студия","");
        filmArticle.put("актеры","");
        System.out.println("========= Добавление фильма =========");
        for (Map.Entry<String, String> el : filmArticle.entrySet()) {
            System.out.print("Введите " + el.getKey() + " фильма: ");
            filmArticle.put(el.getKey(), input.nextLine());
        }
        System.out.println("=====================================");
        return filmArticle;
    }

    public void showListFilms(Collection filmList) {
        System.out.println("========= Каталог фильмов =========");
        for (var element : filmList) {
            System.out.println(element);
        }
        System.out.println("===================================");
    }

    public String getFilmName(String s, Collection filmList) {
        showListFilms(filmList);
        System.out.print(s);
        return input.nextLine();
    }

    public void showOneFilm(Film dataFilm) {
        System.out.println("========= Информация о фильме =========");
        System.out.println("Название: "+dataFilm.getFilmName());
        System.out.println("Жанр: "+dataFilm.getFilmTheme());
        System.out.println("Режиссер: "+dataFilm.getAuthor());
        System.out.println("Год выпуска: "+dataFilm.getFilmYear());
        System.out.println("Длительность: "+dataFilm.getDuration());
        System.out.println("Студия: "+dataFilm.getProduction());
        System.out.println("Актеры: "+dataFilm.getActers());
        System.out.println("=======================================");
    }

    public void errorMessage(String s) {
        System.out.println(s);
    }
}
