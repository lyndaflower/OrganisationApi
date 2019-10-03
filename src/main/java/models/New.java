package models;

import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class New {
    private String author;
    private String news;
    private int id;

    public New(String author, String news) {
        this.author = author;
        this.id = id;
        this.news = news;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String name) {
        this.author = author;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public int getId() {
        return id;
    }

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO news (author, news) VALUES (:author, :news)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("author", this.author)
                    .addParameter("news", this.news)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<New> all(){
        String sql = "SELECT * FROM news";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(New.class);
        }
    }

    public static New find(int id) {
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM news where id = :id";
            New neww = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(New.class);
            return neww;
        }
    }
}


