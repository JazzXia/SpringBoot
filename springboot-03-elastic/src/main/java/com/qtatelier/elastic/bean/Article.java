package com.qtatelier.elastic.bean;

import io.searchbox.annotations.JestId;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author JazzXia
 * @create 2019-10-23-11:38
 * @email jazzxiaw@qq.com
 * @since 2019
 */
public class Article implements Serializable {

    //标识这为主键
    @JestId
    private Integer id;
    private String author;
    private String title;
    private String content;

    public Article() {
    }

    public Article(Integer id, String author, String title, String content) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return getId().equals(article.getId()) &&
                getAuthor().equals(article.getAuthor()) &&
                getTitle().equals(article.getTitle()) &&
                getContent().equals(article.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAuthor(), getTitle(), getContent());
    }
}
