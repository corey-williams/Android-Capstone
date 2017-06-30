package Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class DBAdapter_XPLimit {
    public static final String KEY_ROWID = "_id";
    public static final String KEY_ITEM = "xplimit";

    private static final String TAG = "DBAdapter_XPLimit";

    private static final String DATABASE_NAME = "XPLimitDB";
    private static final String DATABASE_TABLE = "characterXPLimit";
    private static final int DATABASE_VERSION = 5;

    private static final String DATABASE_CREATE = "create table if not exists characterXPLimit (_id integer primary key autoincrement, "
            + "xplimit VARCHAR not null);";

    private final Context context;

    private DatabaseHelper DBHelper_xplimit;
    private static SQLiteDatabase dbXpLimit;

    public DBAdapter_XPLimit(Context ctx) {
        this.context = ctx;
        DBHelper_xplimit = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase dbXpLimit) {
            try {
                dbXpLimit.execSQL(DATABASE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase dbXpLimit, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            dbXpLimit.execSQL("DROP TABLE IF EXISTS characterXPLimit");
            onCreate(dbXpLimit);
        }
    }

    // ---opens the database---
    public DBAdapter_XPLimit open() throws SQLException {
        dbXpLimit = DBHelper_xplimit.getWritableDatabase();
        return this;
    }

    // ---closes the database---
    public void close() {
        DBHelper_xplimit.close();
    }

    // ---insert a record into the database---
    public long insertRecord(String xplimit) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_ITEM, xplimit);
        return dbXpLimit.insert(DATABASE_TABLE, null, initialValues);
    }

    // ---deletes a particular record---
    public boolean deleteContact(long rowId) {
        return dbXpLimit.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }

    // ---retrieves all the records---
    public static Cursor getAllRecords() {
        return dbXpLimit.query(DATABASE_TABLE, new String[] { KEY_ROWID, KEY_ITEM},
                null, null, null, null, null, null);
    }

    // ---retrieves a particular record---
    public Cursor getRecord(long rowId) throws SQLException {
        Cursor mCursor = dbXpLimit.query(true, DATABASE_TABLE, new String[] {
                KEY_ROWID, KEY_ITEM }, KEY_ROWID + "=" + rowId, null, null,
                null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public int deleteAll(){
        return 0;

    }

    // ---updates a record---
    public boolean updateRecord(long rowId, String xplimit) {
        ContentValues args = new ContentValues();
        args.put(KEY_ITEM, xplimit);

        return dbXpLimit.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    }
}
