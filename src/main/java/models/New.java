package models;

import java.util.Objects;

public class New {
    private String name;
    private int id;

    public New(String name,int id){
        this.name =name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof New)) return false;
        New news = (New) o;
        return id == news.id &&
                Objects.equals(name, news.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
