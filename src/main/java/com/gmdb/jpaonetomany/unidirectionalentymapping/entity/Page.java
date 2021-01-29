package com.gmdb.jpaonetomany.unidirectionalentymapping.entity;

import javax.persistence.*;

@Entity
public class Page {

    @Id
    @GeneratedValue
    private Long id;

    private String content;
    private Integer pageNo;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;

    public Page() {
    }

    public Page(String content, Integer pageNo) {
        this.content = content;
        this.pageNo = pageNo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
