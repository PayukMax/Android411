package LessonT17.articles;

import java.util.Collection;
import java.util.Map;

public class Controller {
    private Model articleModel;
    private View userInterface;

    public Controller() {
        this.articleModel = new Model();
        this.userInterface = new View();
    }

    public void run(){
        String answer = "";
        while (!answer.equals("q")){
                answer = userInterface.waitUserAnswer();
                checkUserAnswer(answer);
        }
    }

    public void checkUserAnswer(String answer){
        if (answer.equals("1")){
            Map article = userInterface.addUserArticle();
            articleModel.addArtilce(article);
        } else if (answer.equals("2")){
            Collection articles = articleModel.getAllArticles();
            userInterface.showAllArticles(articles);
        } else if (answer.equals("3")) {
            String articleTitle = userInterface.getUserArticle();
            try {
                Map article = articleModel.getSingleArticles(articleTitle);
                userInterface.showArticlesInfo(article);
            } catch (NullPointerException npe){
                userInterface.showIncorrectTiTleErroe(articleTitle);
            }
        } else if (answer.equals("4")){
            String articleTitle = userInterface.getUserArticle();
            try {
               Article title = articleModel.removeArticles(articleTitle);
               userInterface.removeSingleArticl(articleTitle);
            } catch (NullPointerException npe){
                userInterface.showIncorrectTiTleErroe(articleTitle);
            }
        } else if (answer.equals("q")) {
            articleModel.saveData();
        } else  {
            userInterface.showIncorrectAnswerError(answer);
        }
    }
}
