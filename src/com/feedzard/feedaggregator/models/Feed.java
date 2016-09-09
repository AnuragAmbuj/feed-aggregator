package com.feedzard.feedaggregator.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aambuj on 05-09-2016.
 */
public class Feed {
    private String title;
    private String link;
    private String description;
    private String language;
    private String copyright;
    private String pubDate;
    private List<FeedMessage> entries = new ArrayList<FeedMessage>();


    public Feed(String title, String link, String description, String language, String copyright, String pubDate, List<FeedMessage> entries) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.language = language;
        this.copyright = copyright;
        this.pubDate = pubDate;
        this.entries = entries;
    }

    public Feed(String title, String link, String description, String language, String copyright, String pubDate) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.language = language;
        this.copyright = copyright;
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public List<FeedMessage> getEntries() {
        return entries;
    }

    public void setEntries(List<FeedMessage> entries) {
        this.entries = entries;
    }

    public List<FeedMessage> getMessages() {
        return entries;
    }
}
