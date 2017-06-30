package Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class DBAdapter_XP {
    public static final String KEY_ROWID = "_id";
    public static final String KEY_ITEM = "xp";

    private static final String TAG = "DBAdapter_XP";

    private static final String DATABASE_NAME = "XPDB";
    private static final String DATABASE_TABLE = "characterXP";
    private static final int DATABASE_VERSION = 5;

    private static final String DATABASE_CREATE = "create table if not exists characterXP (_id integer primary key autoincrement, "
            + "xp VARCHAR not null);";

    private final Context context;

    private DatabaseHelper DBHelper_xp;
    private static SQLiteDatabase dbXp;

    public DBAdapter_XP(Context ctx) {
        this.context = ctx;
        DBHelper_xp = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase dbXp) {
            try {
                dbXp.execSQL(DATABASE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase dbXp, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            dbXp.execSQL("DROP TABLE IF EXISTS characterXP");
            onCreate(dbXp);
        }
    }

    // ---opens the database---
    public DBAdapter_XP open() throws SQLException {
        dbXp = DBHelper_xp.getWritableDatabase();
        return this;
    }

    // ---closes the database---
    public void close() {
        DBHelper_xp.close();
    }

    // ---insert a record into the database---
    public long insertRecord(String xp) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_ITEM, xp);
        return dbXp.insert(DATABASE_TABLE, null, initialValues);
    }

    // ---deletes a particular record---
    public boolean deleteContact(long rowId) {
        return dbXp.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }

    // ---retrieves all the records---
    public static Cursor getAllRecords() {
        return dbXp.query(DATABASE_TABLE, new String[] { KEY_ROWID, KEY_ITEM},
                null, null, null, null, null, null);
    }

    // ---retrieves a particular record---
    public Cursor getRecord(long rowId) throws SQLException {
        Cursor mCursor = dbXp.query(true, DATABASE_TABLE, new String[] {
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
    public boolean updateRecord(long rowId, String xp) {
        ContentValues args = new ContentValues();
        args.put(KEY_ITEM, xp);

        return dbXp.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    }
}
