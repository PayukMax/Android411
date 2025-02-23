package LessonT17.articles;

import java.util.*;

public class View {
    Scanner input = new Scanner(System.in);

    public String waitUserAnswer() {
        System.out.println("========= Ввод пользовательских данных =========");
        System.out.println("Действие со статьями:");
        System.out.println("1 - создание статьи\n2 - просмотр статей\n3 - просмотр статьи\n4 - удаление статьи\nq - выход из программы");
        System.out.print("Выберите вариант действия: ");
        String userAnswer = input.nextLine();
        System.out.println("================================================");
        return userAnswer;
    }

    public Map addUserArticle() {
        Map<String, String> dictArticle = new LinkedHashMap<>();
        dictArticle.put("название", "");
        dictArticle.put("автор", "");
        dictArticle.put("количество страниц", "");
        dictArticle.put("описание", "");
        System.out.println("========= Создание статьи =========");
        for (Map.Entry<String, String> el : dictArticle.entrySet()) {
            System.out.print("Введите " + el.getKey() + " статьи: ");
            dictArticle.put(el.getKey(), input.nextLine());
        }
        System.out.println("====================================");
        return dictArticle;

    }

    public void showAllArticles(Collection articles) {
        System.out.println("========= Список статей =========");
        for (var element : articles) {
            System.out.println(element);
        }
        System.out.println("=================================");
    }
    public String getUserArticle() {
        System.out.println("======== Ввод названия ==========");
        System.out.print("->");
        String user_art = input.nextLine();
        System.out.println("==================================");
        return user_art;

    }

    public void showArticlesInfo(Map article){
        System.out.println("========== Просмотр статьи =========");
        for (Object el:article.entrySet()){
            System.out.println(el.toString());
        }
        System.out.println("======================================");
    }

    public void showIncorrectTiTleErroe(String articleTitle) {
        System.out.println("============== Ошибка ====================");
        System.out.println("Статьи с названием "+articleTitle+" не существует");
        System.out.println("==========================================");

    }

    public void removeSingleArticl(String articleTitle) {
        System.out.println("=========== Удаление статьи =============");
        System.out.println("Статья "+ articleTitle+" удалена..");
        System.out.println("=========== Удаление статьи =============");
    }

    public void showIncorrectAnswerError(String answer) {
        System.out.println("===========  Сообщение   =============");
        System.out.println("Варианта "+ answer+" не существует...");
        System.out.println("===========  Сообщение   =============");
    }
}
