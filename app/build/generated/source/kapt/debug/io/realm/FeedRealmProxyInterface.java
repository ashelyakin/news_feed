package io.realm;


public interface FeedRealmProxyInterface {
    public RealmList<com.example.news_feed.FeedItem> realmGet$items();
    public void realmSet$items(RealmList<com.example.news_feed.FeedItem> value);
}
