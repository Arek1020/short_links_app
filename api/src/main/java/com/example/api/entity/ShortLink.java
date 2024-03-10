package com.example.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name="links", schema = "short_links_app")
public class ShortLink {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @Column(nullable = false)
    public String link;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setLink(String link) {this.link = link;}

    public String getLink() {
        return link;
    }

}
