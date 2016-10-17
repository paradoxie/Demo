package com.paradoxie.demo.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.paradoxie.demo.entity.Advert;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ADVERT".
*/
public class AdvertDao extends AbstractDao<Advert, Long> {

    public static final String TABLENAME = "ADVERT";

    /**
     * Properties of entity Advert.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Classify = new Property(1, String.class, "classify", false, "CLASSIFY");
        public final static Property Times = new Property(2, String.class, "times", false, "TIMES");
        public final static Property Time = new Property(3, String.class, "time", false, "TIME");
    };


    public AdvertDao(DaoConfig config) {
        super(config);
    }
    
    public AdvertDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ADVERT\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"CLASSIFY\" TEXT," + // 1: classify
                "\"TIMES\" TEXT," + // 2: times
                "\"TIME\" TEXT);"); // 3: time
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ADVERT\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Advert entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String classify = entity.getClassify();
        if (classify != null) {
            stmt.bindString(2, classify);
        }
 
        String times = entity.getTimes();
        if (times != null) {
            stmt.bindString(3, times);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(4, time);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Advert entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String classify = entity.getClassify();
        if (classify != null) {
            stmt.bindString(2, classify);
        }
 
        String times = entity.getTimes();
        if (times != null) {
            stmt.bindString(3, times);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(4, time);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Advert readEntity(Cursor cursor, int offset) {
        Advert entity = new Advert( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // classify
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // times
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // time
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Advert entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setClassify(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTimes(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setTime(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Advert entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Advert entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
