package com.example.news_feed;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/example/news_feed/Feed;", "Lio/realm/RealmObject;", "items", "Lio/realm/RealmList;", "Lcom/example/news_feed/FeedItem;", "(Lio/realm/RealmList;)V", "getItems", "()Lio/realm/RealmList;", "setItems", "app_debug"})
public class Feed extends io.realm.RealmObject {
    @org.jetbrains.annotations.NotNull()
    private io.realm.RealmList<com.example.news_feed.FeedItem> items;
    
    @org.jetbrains.annotations.NotNull()
    public final io.realm.RealmList<com.example.news_feed.FeedItem> getItems() {
        return null;
    }
    
    public final void setItems(@org.jetbrains.annotations.NotNull()
    io.realm.RealmList<com.example.news_feed.FeedItem> p0) {
    }
    
    public Feed(@org.jetbrains.annotations.NotNull()
    io.realm.RealmList<com.example.news_feed.FeedItem> items) {
        super();
    }
    
    public Feed() {
        super();
    }
}