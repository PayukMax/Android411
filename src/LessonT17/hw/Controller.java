package LessonT17.hw;

import java.util.Collection;
import java.util.Map;

public class Controller {
    private Model filmsModel;
    private View userInterface;

    public Controller() {
        this.filmsModel = new Model();
        this.userInterface = new View();
    }

    public void run() {
        // загрузить список -
        if (!filmsModel.loadFilms()) userInterface.errorMessage("Загрузить список фильмов не удалось...");
        String choice = "";
        while (!choice.equals("q")) {
            choice = userInterface.waitUserAnswer();
            checkUserChoice(choice);
        }
        // сохранить список
        if (!filmsModel.saveFilms()) userInterface.errorMessage("Сохранить список фильмов не удалось...");
    }

    public void checkUserChoice(String c) {
        if (c.equals("1")) {
            Map film = userInterface.getFilmData();
            filmsModel.addFilm(film);
        } else {
            if (c.equals("2")) {
                Collection filmList = filmsModel.getAllFilms();
                userInterface.showListFilms(filmList);
            } else {
                if (c.equals("3")) {
                    Collection filmList = filmsModel.getAllFilms();
                    String nameFilm = userInterface.getFilmName("название фильма который интересует? ->",filmList);
                    Film film = filmsModel.getDataFilm(nameFilm);
                    if (film!=null) userInterface.showOneFilm(film); else userInterface.errorMessage("Ошибка - "+nameFilm+" - такого фильма в коллекции нет...");

                } else {
                    if (c.equals("4")) {
                        String nameDel = userInterface.getFilmName("название фильма который нужно удалить? ->",filmsModel.getAllFilms());
                        if (filmsModel.deleteFilm(nameDel)) System.out.println("Удалено - " + nameDel);
                        else userInterface.errorMessage("Ошибка при удалении " + nameDel+" - такой фильм не найден...");
                    }
                }
            }
        }
    }
}
