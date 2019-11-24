package com.qtatelier.amqp.bean;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author JazzXia
 * @create 2019-10-22-13:21
 * @email jazzxiaw@qq.com
 * @since 2019
 *
 * 这里的一定要有无参构造器，要不然会反序列化失败
 */
public class Book implements Serializable {
    private String bookName;
    private String author;

    public Book() {
    }

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getBookName().equals(book.getBookName()) &&
                getAuthor().equals(book.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookName(), getAuthor());
    }
}
