package com.driver.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "blog")
public class Blog{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String title;
    private String content;

    private Date date;

    public Blog() {
    }

    public Blog(String title, String content) {
        this.date = new Date();
        this.title = title;
        this.content = content;
    }


    @ManyToOne
    @JoinColumn
    private User user;
    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
    private Image image;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}