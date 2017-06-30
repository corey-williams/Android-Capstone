package Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class DBAdapter_Gold {
    public static final String KEY_ROWID = "_id";
    public static final String KEY_ITEM = "gold";

    private static final String TAG = "DBAdapter_Gold";

    private static final String DATABASE_NAME = "GoldDB";
    private static final String DATABASE_TABLE = "characterGold";
    private static final int DATABASE_VERSION = 5;

    private static final String DATABASE_CREATE = "create table if not exists characterGold (_id integer primary key autoincrement, "
            + "gold VARCHAR not null);";

    private final Context context;

    private DatabaseHelper DBHelper_gold;
    private static SQLiteDatabase dbGold;

    public DBAdapter_Gold(Context ctx) {
        this.context = ctx;
        DBHelper_gold = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase dbGold) {
            try {
                dbGold.execSQL(DATABASE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase dbGold, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            dbGold.execSQL("DROP TABLE IF EXISTS characterGold");
            onCreate(dbGold);
        }
    }

    // ---opens the database---
    public DBAdapter_Gold open() throws SQLException {
        dbGold = DBHelper_gold.getWritableDatabase();
        return this;
    }

    // ---closes the database---
    public void close() {
        DBHelper_gold.close();
    }

    // ---insert a record into the database---
    public long insertRecord(String gold) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_ITEM, gold);
        return dbGold.insert(DATABASE_TABLE, null, initialValues);
    }

    // ---deletes a particular record---
    public boolean deleteContact(long rowId) {
        return dbGold.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }

    // ---retrieves all the records---
    public static Cursor getAllRecords() {
        return dbGold.query(DATABASE_TABLE, new String[] { KEY_ROWID, KEY_ITEM},
                null, null, null, null, null, null);
    }

    // ---retrieves a particular record---
    public Cursor getRecord(long rowId) throws SQLException {
        Cursor mCursor = dbGold.query(true, DATABASE_TABLE, new String[] {
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
    public boolean updateRecord(long rowId, String gold) {
        ContentValues args = new ContentValues();
        args.put(KEY_ITEM, gold);

        return dbGold.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    }
}
