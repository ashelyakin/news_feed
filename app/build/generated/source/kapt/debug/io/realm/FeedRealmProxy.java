package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.ProxyUtils;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class FeedRealmProxy extends com.example.news_feed.Feed
    implements RealmObjectProxy, FeedRealmProxyInterface {

    static final class FeedColumnInfo extends ColumnInfo {
        long itemsIndex;

        FeedColumnInfo(OsSchemaInfo schemaInfo) {
            super(1);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Feed");
            this.itemsIndex = addColumnDetails("items", objectSchemaInfo);
        }

        FeedColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new FeedColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final FeedColumnInfo src = (FeedColumnInfo) rawSrc;
            final FeedColumnInfo dst = (FeedColumnInfo) rawDst;
            dst.itemsIndex = src.itemsIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(1);
        fieldNames.add("items");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private FeedColumnInfo columnInfo;
    private ProxyState<com.example.news_feed.Feed> proxyState;
    private RealmList<com.example.news_feed.FeedItem> itemsRealmList;

    FeedRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (FeedColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.news_feed.Feed>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    public RealmList<com.example.news_feed.FeedItem> realmGet$items() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (itemsRealmList != null) {
            return itemsRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.itemsIndex);
            itemsRealmList = new RealmList<com.example.news_feed.FeedItem>(com.example.news_feed.FeedItem.class, osList, proxyState.getRealm$realm());
            return itemsRealmList;
        }
    }

    @Override
    public void realmSet$items(RealmList<com.example.news_feed.FeedItem> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("items")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.example.news_feed.FeedItem> original = value;
                value = new RealmList<com.example.news_feed.FeedItem>();
                for (com.example.news_feed.FeedItem item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.itemsIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.example.news_feed.FeedItem linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.setRow(i, ((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        } else {
            osList.removeAll();
            if (value == null) {
                return;
            }
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.example.news_feed.FeedItem linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Feed", 1, 0);
        builder.addPersistedLinkProperty("items", RealmFieldType.LIST, "FeedItem");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static FeedColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new FeedColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Feed";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.example.news_feed.Feed createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        if (json.has("items")) {
            excludeFields.add("items");
        }
        com.example.news_feed.Feed obj = realm.createObjectInternal(com.example.news_feed.Feed.class, true, excludeFields);

        final FeedRealmProxyInterface objProxy = (FeedRealmProxyInterface) obj;
        if (json.has("items")) {
            if (json.isNull("items")) {
                objProxy.realmSet$items(null);
            } else {
                objProxy.realmGet$items().clear();
                JSONArray array = json.getJSONArray("items");
                for (int i = 0; i < array.length(); i++) {
                    com.example.news_feed.FeedItem item = FeedItemRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$items().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.news_feed.Feed createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.example.news_feed.Feed obj = new com.example.news_feed.Feed();
        final FeedRealmProxyInterface objProxy = (FeedRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("items")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$items(null);
                } else {
                    objProxy.realmSet$items(new RealmList<com.example.news_feed.FeedItem>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.example.news_feed.FeedItem item = FeedItemRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$items().add(item);
                    }
                    reader.endArray();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.example.news_feed.Feed copyOrUpdate(Realm realm, com.example.news_feed.Feed object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.news_feed.Feed) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.example.news_feed.Feed copy(Realm realm, com.example.news_feed.Feed newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.news_feed.Feed) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.example.news_feed.Feed realmObject = realm.createObjectInternal(com.example.news_feed.Feed.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        FeedRealmProxyInterface realmObjectSource = (FeedRealmProxyInterface) newObject;
        FeedRealmProxyInterface realmObjectCopy = (FeedRealmProxyInterface) realmObject;


        RealmList<com.example.news_feed.FeedItem> itemsList = realmObjectSource.realmGet$items();
        if (itemsList != null) {
            RealmList<com.example.news_feed.FeedItem> itemsRealmList = realmObjectCopy.realmGet$items();
            itemsRealmList.clear();
            for (int i = 0; i < itemsList.size(); i++) {
                com.example.news_feed.FeedItem itemsItem = itemsList.get(i);
                com.example.news_feed.FeedItem cacheitems = (com.example.news_feed.FeedItem) cache.get(itemsItem);
                if (cacheitems != null) {
                    itemsRealmList.add(cacheitems);
                } else {
                    itemsRealmList.add(FeedItemRealmProxy.copyOrUpdate(realm, itemsItem, update, cache));
                }
            }
        }

        return realmObject;
    }

    public static long insert(Realm realm, com.example.news_feed.Feed object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.news_feed.Feed.class);
        long tableNativePtr = table.getNativePtr();
        FeedColumnInfo columnInfo = (FeedColumnInfo) realm.getSchema().getColumnInfo(com.example.news_feed.Feed.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);

        RealmList<com.example.news_feed.FeedItem> itemsList = ((FeedRealmProxyInterface) object).realmGet$items();
        if (itemsList != null) {
            OsList itemsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.itemsIndex);
            for (com.example.news_feed.FeedItem itemsItem : itemsList) {
                Long cacheItemIndexitems = cache.get(itemsItem);
                if (cacheItemIndexitems == null) {
                    cacheItemIndexitems = FeedItemRealmProxy.insert(realm, itemsItem, cache);
                }
                itemsOsList.addRow(cacheItemIndexitems);
            }
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.news_feed.Feed.class);
        long tableNativePtr = table.getNativePtr();
        FeedColumnInfo columnInfo = (FeedColumnInfo) realm.getSchema().getColumnInfo(com.example.news_feed.Feed.class);
        com.example.news_feed.Feed object = null;
        while (objects.hasNext()) {
            object = (com.example.news_feed.Feed) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);

            RealmList<com.example.news_feed.FeedItem> itemsList = ((FeedRealmProxyInterface) object).realmGet$items();
            if (itemsList != null) {
                OsList itemsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.itemsIndex);
                for (com.example.news_feed.FeedItem itemsItem : itemsList) {
                    Long cacheItemIndexitems = cache.get(itemsItem);
                    if (cacheItemIndexitems == null) {
                        cacheItemIndexitems = FeedItemRealmProxy.insert(realm, itemsItem, cache);
                    }
                    itemsOsList.addRow(cacheItemIndexitems);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.news_feed.Feed object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.news_feed.Feed.class);
        long tableNativePtr = table.getNativePtr();
        FeedColumnInfo columnInfo = (FeedColumnInfo) realm.getSchema().getColumnInfo(com.example.news_feed.Feed.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);

        OsList itemsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.itemsIndex);
        RealmList<com.example.news_feed.FeedItem> itemsList = ((FeedRealmProxyInterface) object).realmGet$items();
        if (itemsList != null && itemsList.size() == itemsOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = itemsList.size();
            for (int i = 0; i < objects; i++) {
                com.example.news_feed.FeedItem itemsItem = itemsList.get(i);
                Long cacheItemIndexitems = cache.get(itemsItem);
                if (cacheItemIndexitems == null) {
                    cacheItemIndexitems = FeedItemRealmProxy.insertOrUpdate(realm, itemsItem, cache);
                }
                itemsOsList.setRow(i, cacheItemIndexitems);
            }
        } else {
            itemsOsList.removeAll();
            if (itemsList != null) {
                for (com.example.news_feed.FeedItem itemsItem : itemsList) {
                    Long cacheItemIndexitems = cache.get(itemsItem);
                    if (cacheItemIndexitems == null) {
                        cacheItemIndexitems = FeedItemRealmProxy.insertOrUpdate(realm, itemsItem, cache);
                    }
                    itemsOsList.addRow(cacheItemIndexitems);
                }
            }
        }

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.news_feed.Feed.class);
        long tableNativePtr = table.getNativePtr();
        FeedColumnInfo columnInfo = (FeedColumnInfo) realm.getSchema().getColumnInfo(com.example.news_feed.Feed.class);
        com.example.news_feed.Feed object = null;
        while (objects.hasNext()) {
            object = (com.example.news_feed.Feed) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);

            OsList itemsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.itemsIndex);
            RealmList<com.example.news_feed.FeedItem> itemsList = ((FeedRealmProxyInterface) object).realmGet$items();
            if (itemsList != null && itemsList.size() == itemsOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = itemsList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.example.news_feed.FeedItem itemsItem = itemsList.get(i);
                    Long cacheItemIndexitems = cache.get(itemsItem);
                    if (cacheItemIndexitems == null) {
                        cacheItemIndexitems = FeedItemRealmProxy.insertOrUpdate(realm, itemsItem, cache);
                    }
                    itemsOsList.setRow(i, cacheItemIndexitems);
                }
            } else {
                itemsOsList.removeAll();
                if (itemsList != null) {
                    for (com.example.news_feed.FeedItem itemsItem : itemsList) {
                        Long cacheItemIndexitems = cache.get(itemsItem);
                        if (cacheItemIndexitems == null) {
                            cacheItemIndexitems = FeedItemRealmProxy.insertOrUpdate(realm, itemsItem, cache);
                        }
                        itemsOsList.addRow(cacheItemIndexitems);
                    }
                }
            }

        }
    }

    public static com.example.news_feed.Feed createDetachedCopy(com.example.news_feed.Feed realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.news_feed.Feed unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.news_feed.Feed();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.news_feed.Feed) cachedObject.object;
            }
            unmanagedObject = (com.example.news_feed.Feed) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        FeedRealmProxyInterface unmanagedCopy = (FeedRealmProxyInterface) unmanagedObject;
        FeedRealmProxyInterface realmSource = (FeedRealmProxyInterface) realmObject;

        // Deep copy of items
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$items(null);
        } else {
            RealmList<com.example.news_feed.FeedItem> manageditemsList = realmSource.realmGet$items();
            RealmList<com.example.news_feed.FeedItem> unmanageditemsList = new RealmList<com.example.news_feed.FeedItem>();
            unmanagedCopy.realmSet$items(unmanageditemsList);
            int nextDepth = currentDepth + 1;
            int size = manageditemsList.size();
            for (int i = 0; i < size; i++) {
                com.example.news_feed.FeedItem item = FeedItemRealmProxy.createDetachedCopy(manageditemsList.get(i), nextDepth, maxDepth, cache);
                unmanageditemsList.add(item);
            }
        }

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Feed = proxy[");
        stringBuilder.append("{items:");
        stringBuilder.append("RealmList<FeedItem>[").append(realmGet$items().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedRealmProxy aFeed = (FeedRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aFeed.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aFeed.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aFeed.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
