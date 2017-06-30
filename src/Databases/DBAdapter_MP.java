package Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class DBAdapter_MP {
    public static final String KEY_ROWID = "_id";
    public static final String KEY_ITEM = "mp";

    private static final String TAG = "DBAdapter_MP";

    private static final String DATABASE_NAME = "MPDB";
    private static final String DATABASE_TABLE = "characterMP";
    private static final int DATABASE_VERSION = 5;

    private static final String DATABASE_CREATE = "create table if not exists characterMP (_id integer primary key autoincrement, "
            + "mp VARCHAR not null);";

    private final Context context;

    private DatabaseHelper DBHelper_mp;
    private static SQLiteDatabase dbMp;

    public DBAdapter_MP(Context ctx) {
        this.context = ctx;
        DBHelper_mp = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase dbMp) {
            try {
                dbMp.execSQL(DATABASE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase dbMp, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            dbMp.execSQL("DROP TABLE IF EXISTS characterMP");
            onCreate(dbMp);
        }
    }

    // ---opens the database---
    public DBAdapter_MP open() throws SQLException {
        dbMp = DBHelper_mp.getWritableDatabase();
        return this;
    }

    // ---closes the database---
    public void close() {
        DBHelper_mp.close();
    }

    // ---insert a record into the database---
    public long insertRecord(String mp) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_ITEM, mp);
        return dbMp.insert(DATABASE_TABLE, null, initialValues);
    }

    // ---deletes a particular record---
    public boolean deleteContact(long rowId) {
        return dbMp.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }

    // ---retrieves all the records---
    public static Cursor getAllRecords() {
        return dbMp.query(DATABASE_TABLE, new String[] { KEY_ROWID, KEY_ITEM},
                null, null, null, null, null, null);
    }

    // ---retrieves a particular record---
    public Cursor getRecord(long rowId) throws SQLException {
        Cursor mCursor = dbMp.query(true, DATABASE_TABLE, new String[] {
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
    public boolean updateRecord(long rowId, String mp) {
        ContentValues args = new ContentValues();
        args.put(KEY_ITEM, mp);

        return dbMp.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    }
}
