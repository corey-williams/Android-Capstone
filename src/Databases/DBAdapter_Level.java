package Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class DBAdapter_Level {
    public static final String KEY_ROWID = "_id";
    public static final String KEY_ITEM = "level";

    private static final String TAG = "DBAdapter_Level";

    private static final String DATABASE_NAME = "LevelDB";
    private static final String DATABASE_TABLE = "characterLevel";
    private static final int DATABASE_VERSION = 5;

    private static final String DATABASE_CREATE = "create table if not exists characterLevel (_id integer primary key autoincrement, "
            + "level VARCHAR not null);";

    private final Context context;

    private DatabaseHelper DBHelper_level;
    private static SQLiteDatabase dbLevel;

    public DBAdapter_Level(Context ctx) {
        this.context = ctx;
        DBHelper_level = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase dbLevel) {
            try {
                dbLevel.execSQL(DATABASE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase dbLevel, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            dbLevel.execSQL("DROP TABLE IF EXISTS characterLevel");
            onCreate(dbLevel);
        }
    }

    // ---opens the database---
    public DBAdapter_Level open() throws SQLException {
        dbLevel = DBHelper_level.getWritableDatabase();
        return this;
    }

    // ---closes the database---
    public void close() {
        DBHelper_level.close();
    }

    // ---insert a record into the database---
    public long insertRecord(String level) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_ITEM, level);
        return dbLevel.insert(DATABASE_TABLE, null, initialValues);
    }

    // ---deletes a particular record---
    public boolean deleteContact(long rowId) {
        return dbLevel.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }

    // ---retrieves all the records---
    public static Cursor getAllRecords() {
        return dbLevel.query(DATABASE_TABLE, new String[] { KEY_ROWID, KEY_ITEM},
                null, null, null, null, null, null);
    }

    // ---retrieves a particular record---
    public Cursor getRecord(long rowId) throws SQLException {
        Cursor mCursor = dbLevel.query(true, DATABASE_TABLE, new String[] {
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
    public boolean updateRecord(long rowId, String level) {
        ContentValues args = new ContentValues();
        args.put(KEY_ITEM, level);

        return dbLevel.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    }
}
