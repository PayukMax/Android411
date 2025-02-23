package LessonT17.articles;

import java.io.*;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Model {
    private Map<String,Article> articles;
    private String dbname;

    public Model() {
        this.dbname = "db.txt";
        this.articles = loadData();//new LinkedHashMap<>();
    }


    public void addArtilce (Map dictArticle){
        Article articl = new Article(dictArticle);
        articles.put((String) dictArticle.get("название"),articl);
        System.out.println(articles);
    }
    public Collection getAllArticles(){
        return articles.values();
    }

    public Map getSingleArticles(String userTitle) {
        Article ar = articles.get(userTitle);
        Map<String,String> distArticle = new LinkedHashMap<>();
        distArticle.put("название",ar.getTitle());
        distArticle.put("автор",ar.getAuthor());
        distArticle.put("количество страниц",ar.getPage());
        distArticle.put("описание",ar.getDescription());
        return distArticle;
    }

    public Article removeArticles(String articleTitle) {
        return articles.remove(articleTitle);
    }

    public void saveData() {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dbname))){
            oos.writeObject(articles);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private LinkedHashMap loadData() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dbname))){
            return (LinkedHashMap) ois.readObject();
        } catch (Exception ex){ return new LinkedHashMap<>();}

    }

}

class Article implements Serializable {
    private String title;
    private String author;
    private String page;
    private String description;

    public Article(Map dictArticl) {
        this.title = (String) dictArticl.get("название");
        this.author = (String) dictArticl.get("автор");;
        this.page = (String) dictArticl.get("количество страниц");
        this.description = (String) dictArticl.get("описание");
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPage() {
        return page;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return title + "(" + author + ")";
    }
}