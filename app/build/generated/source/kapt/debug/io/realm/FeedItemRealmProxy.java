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
public class FeedItemRealmProxy extends com.example.news_feed.FeedItem
    implements RealmObjectProxy, FeedItemRealmProxyInterface {

    static final class FeedItemColumnInfo extends ColumnInfo {
        long titleIndex;
        long linkIndex;
        long thumbnailIndex;
        long descriptionIndex;
        long guidIndex;

        FeedItemColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("FeedItem");
            this.titleIndex = addColumnDetails("title", objectSchemaInfo);
            this.linkIndex = addColumnDetails("link", objectSchemaInfo);
            this.thumbnailIndex = addColumnDetails("thumbnail", objectSchemaInfo);
            this.descriptionIndex = addColumnDetails("description", objectSchemaInfo);
            this.guidIndex = addColumnDetails("guid", objectSchemaInfo);
        }

        FeedItemColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new FeedItemColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final FeedItemColumnInfo src = (FeedItemColumnInfo) rawSrc;
            final FeedItemColumnInfo dst = (FeedItemColumnInfo) rawDst;
            dst.titleIndex = src.titleIndex;
            dst.linkIndex = src.linkIndex;
            dst.thumbnailIndex = src.thumbnailIndex;
            dst.descriptionIndex = src.descriptionIndex;
            dst.guidIndex = src.guidIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(5);
        fieldNames.add("title");
        fieldNames.add("link");
        fieldNames.add("thumbnail");
        fieldNames.add("description");
        fieldNames.add("guid");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private FeedItemColumnInfo columnInfo;
    private ProxyState<com.example.news_feed.FeedItem> proxyState;

    FeedItemRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (FeedItemColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.news_feed.FeedItem>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$title() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.titleIndex);
    }

    @Override
    public void realmSet$title(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'title' to null.");
            }
            row.getTable().setString(columnInfo.titleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'title' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.titleIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$link() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.linkIndex);
    }

    @Override
    public void realmSet$link(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'link' to null.");
            }
            row.getTable().setString(columnInfo.linkIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'link' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.linkIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$thumbnail() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.thumbnailIndex);
    }

    @Override
    public void realmSet$thumbnail(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'thumbnail' to null.");
            }
            row.getTable().setString(columnInfo.thumbnailIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'thumbnail' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.thumbnailIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$description() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.descriptionIndex);
    }

    @Override
    public void realmSet$description(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'description' to null.");
            }
            row.getTable().setString(columnInfo.descriptionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'description' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.descriptionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$guid() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.guidIndex);
    }

    @Override
    public void realmSet$guid(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'guid' to null.");
            }
            row.getTable().setString(columnInfo.guidIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'guid' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.guidIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("FeedItem", 5, 0);
        builder.addPersistedProperty("title", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("link", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("thumbnail", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("description", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("guid", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static FeedItemColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new FeedItemColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "FeedItem";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.example.news_feed.FeedItem createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.news_feed.FeedItem obj = realm.createObjectInternal(com.example.news_feed.FeedItem.class, true, excludeFields);

        final FeedItemRealmProxyInterface objProxy = (FeedItemRealmProxyInterface) obj;
        if (json.has("title")) {
            if (json.isNull("title")) {
                objProxy.realmSet$title(null);
            } else {
                objProxy.realmSet$title((String) json.getString("title"));
            }
        }
        if (json.has("link")) {
            if (json.isNull("link")) {
                objProxy.realmSet$link(null);
            } else {
                objProxy.realmSet$link((String) json.getString("link"));
            }
        }
        if (json.has("thumbnail")) {
            if (json.isNull("thumbnail")) {
                objProxy.realmSet$thumbnail(null);
            } else {
                objProxy.realmSet$thumbnail((String) json.getString("thumbnail"));
            }
        }
        if (json.has("description")) {
            if (json.isNull("description")) {
                objProxy.realmSet$description(null);
            } else {
                objProxy.realmSet$description((String) json.getString("description"));
            }
        }
        if (json.has("guid")) {
            if (json.isNull("guid")) {
                objProxy.realmSet$guid(null);
            } else {
                objProxy.realmSet$guid((String) json.getString("guid"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.news_feed.FeedItem createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.example.news_feed.FeedItem obj = new com.example.news_feed.FeedItem();
        final FeedItemRealmProxyInterface objProxy = (FeedItemRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("title")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$title((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$title(null);
                }
            } else if (name.equals("link")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$link((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$link(null);
                }
            } else if (name.equals("thumbnail")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$thumbnail((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$thumbnail(null);
                }
            } else if (name.equals("description")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$description((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$description(null);
                }
            } else if (name.equals("guid")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$guid((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$guid(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.example.news_feed.FeedItem copyOrUpdate(Realm realm, com.example.news_feed.FeedItem object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.example.news_feed.FeedItem) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.example.news_feed.FeedItem copy(Realm realm, com.example.news_feed.FeedItem newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.news_feed.FeedItem) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.example.news_feed.FeedItem realmObject = realm.createObjectInternal(com.example.news_feed.FeedItem.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        FeedItemRealmProxyInterface realmObjectSource = (FeedItemRealmProxyInterface) newObject;
        FeedItemRealmProxyInterface realmObjectCopy = (FeedItemRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$title(realmObjectSource.realmGet$title());
        realmObjectCopy.realmSet$link(realmObjectSource.realmGet$link());
        realmObjectCopy.realmSet$thumbnail(realmObjectSource.realmGet$thumbnail());
        realmObjectCopy.realmSet$description(realmObjectSource.realmGet$description());
        realmObjectCopy.realmSet$guid(realmObjectSource.realmGet$guid());
        return realmObject;
    }

    public static long insert(Realm realm, com.example.news_feed.FeedItem object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.news_feed.FeedItem.class);
        long tableNativePtr = table.getNativePtr();
        FeedItemColumnInfo columnInfo = (FeedItemColumnInfo) realm.getSchema().getColumnInfo(com.example.news_feed.FeedItem.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$title = ((FeedItemRealmProxyInterface) object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        }
        String realmGet$link = ((FeedItemRealmProxyInterface) object).realmGet$link();
        if (realmGet$link != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.linkIndex, rowIndex, realmGet$link, false);
        }
        String realmGet$thumbnail = ((FeedItemRealmProxyInterface) object).realmGet$thumbnail();
        if (realmGet$thumbnail != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.thumbnailIndex, rowIndex, realmGet$thumbnail, false);
        }
        String realmGet$description = ((FeedItemRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        }
        String realmGet$guid = ((FeedItemRealmProxyInterface) object).realmGet$guid();
        if (realmGet$guid != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.guidIndex, rowIndex, realmGet$guid, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.news_feed.FeedItem.class);
        long tableNativePtr = table.getNativePtr();
        FeedItemColumnInfo columnInfo = (FeedItemColumnInfo) realm.getSchema().getColumnInfo(com.example.news_feed.FeedItem.class);
        com.example.news_feed.FeedItem object = null;
        while (objects.hasNext()) {
            object = (com.example.news_feed.FeedItem) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$title = ((FeedItemRealmProxyInterface) object).realmGet$title();
            if (realmGet$title != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
            }
            String realmGet$link = ((FeedItemRealmProxyInterface) object).realmGet$link();
            if (realmGet$link != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.linkIndex, rowIndex, realmGet$link, false);
            }
            String realmGet$thumbnail = ((FeedItemRealmProxyInterface) object).realmGet$thumbnail();
            if (realmGet$thumbnail != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.thumbnailIndex, rowIndex, realmGet$thumbnail, false);
            }
            String realmGet$description = ((FeedItemRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
            }
            String realmGet$guid = ((FeedItemRealmProxyInterface) object).realmGet$guid();
            if (realmGet$guid != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.guidIndex, rowIndex, realmGet$guid, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.news_feed.FeedItem object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.news_feed.FeedItem.class);
        long tableNativePtr = table.getNativePtr();
        FeedItemColumnInfo columnInfo = (FeedItemColumnInfo) realm.getSchema().getColumnInfo(com.example.news_feed.FeedItem.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$title = ((FeedItemRealmProxyInterface) object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
        }
        String realmGet$link = ((FeedItemRealmProxyInterface) object).realmGet$link();
        if (realmGet$link != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.linkIndex, rowIndex, realmGet$link, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.linkIndex, rowIndex, false);
        }
        String realmGet$thumbnail = ((FeedItemRealmProxyInterface) object).realmGet$thumbnail();
        if (realmGet$thumbnail != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.thumbnailIndex, rowIndex, realmGet$thumbnail, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.thumbnailIndex, rowIndex, false);
        }
        String realmGet$description = ((FeedItemRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
        }
        String realmGet$guid = ((FeedItemRealmProxyInterface) object).realmGet$guid();
        if (realmGet$guid != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.guidIndex, rowIndex, realmGet$guid, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.guidIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.news_feed.FeedItem.class);
        long tableNativePtr = table.getNativePtr();
        FeedItemColumnInfo columnInfo = (FeedItemColumnInfo) realm.getSchema().getColumnInfo(com.example.news_feed.FeedItem.class);
        com.example.news_feed.FeedItem object = null;
        while (objects.hasNext()) {
            object = (com.example.news_feed.FeedItem) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$title = ((FeedItemRealmProxyInterface) object).realmGet$title();
            if (realmGet$title != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
            }
            String realmGet$link = ((FeedItemRealmProxyInterface) object).realmGet$link();
            if (realmGet$link != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.linkIndex, rowIndex, realmGet$link, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.linkIndex, rowIndex, false);
            }
            String realmGet$thumbnail = ((FeedItemRealmProxyInterface) object).realmGet$thumbnail();
            if (realmGet$thumbnail != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.thumbnailIndex, rowIndex, realmGet$thumbnail, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.thumbnailIndex, rowIndex, false);
            }
            String realmGet$description = ((FeedItemRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
            }
            String realmGet$guid = ((FeedItemRealmProxyInterface) object).realmGet$guid();
            if (realmGet$guid != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.guidIndex, rowIndex, realmGet$guid, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.guidIndex, rowIndex, false);
            }
        }
    }

    public static com.example.news_feed.FeedItem createDetachedCopy(com.example.news_feed.FeedItem realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.news_feed.FeedItem unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.news_feed.FeedItem();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.news_feed.FeedItem) cachedObject.object;
            }
            unmanagedObject = (com.example.news_feed.FeedItem) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        FeedItemRealmProxyInterface unmanagedCopy = (FeedItemRealmProxyInterface) unmanagedObject;
        FeedItemRealmProxyInterface realmSource = (FeedItemRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$title(realmSource.realmGet$title());
        unmanagedCopy.realmSet$link(realmSource.realmGet$link());
        unmanagedCopy.realmSet$thumbnail(realmSource.realmGet$thumbnail());
        unmanagedCopy.realmSet$description(realmSource.realmGet$description());
        unmanagedCopy.realmSet$guid(realmSource.realmGet$guid());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("FeedItem = proxy[");
        stringBuilder.append("{title:");
        stringBuilder.append(realmGet$title());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{link:");
        stringBuilder.append(realmGet$link());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{thumbnail:");
        stringBuilder.append(realmGet$thumbnail());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{description:");
        stringBuilder.append(realmGet$description());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{guid:");
        stringBuilder.append(realmGet$guid());
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
        FeedItemRealmProxy aFeedItem = (FeedItemRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aFeedItem.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aFeedItem.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aFeedItem.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
