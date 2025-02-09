package LessonT17.articles;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Model {
    private Map<String,Article> articles;

    public Model() {
        this.articles = new LinkedHashMap<>();
    }

    public void addArtilce (Map dictArticle){
        Article articl = new Article(dictArticle);
        articles.put((String) dictArticle.get("название"),articl);
        System.out.println(articles);
    }
    public Collection getAllArticles(){
        return articles.values();
    }
}

class Article{
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