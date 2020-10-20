package com.example.demo.entities;

import jdk.jfr.Description;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class RSSFeed {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long guid;

    private String title;
    private String link;
    private Date pubDate;
    private String description;
    private String source;

    protected RSSFeed() {}

    public RSSFeed(String title, String link, Date pubDate, String description, String source)
    {
        this.title = title;
        this.link = link;
        this.pubDate = pubDate;
        this.description = description;
        this.source = source;
    }

    public Long getguid()
    {
        return guid;
    }

    public String getTitle()
    {
        return title;
    }

    public String getLink()
    {
        return link;
    }

    public Date getPubDate()
    {
        return pubDate;
    }

    public String getDescription()
    {
        return description;
    }

    public String getSource()
    {
        return source;
    }
}
