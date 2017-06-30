package Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class DBAdapter_HP {
    public static final String KEY_ROWID = "_id";
    public static final String KEY_ITEM = "hp";

    private static final String TAG = "DBAdapter_HP";

    private static final String DATABASE_NAME = "HPDB";
    private static final String DATABASE_TABLE = "characterHP";
    private static final int DATABASE_VERSION = 5;

    private static final String DATABASE_CREATE = "create table if not exists characterHP (_id integer primary key autoincrement, "
            + "hp VARCHAR not null);";

    private final Context context;

    private DatabaseHelper DBHelper_hp;
    private static SQLiteDatabase dbHp;

    public DBAdapter_HP(Context ctx) {
        this.context = ctx;
        DBHelper_hp = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase dbHp) {
            try {
                dbHp.execSQL(DATABASE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase dbHp, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            dbHp.execSQL("DROP TABLE IF EXISTS characterHP");
            onCreate(dbHp);
        }
    }

    // ---opens the database---
    public DBAdapter_HP open() throws SQLException {
        dbHp = DBHelper_hp.getWritableDatabase();
        return this;
    }

    // ---closes the database---
    public void close() {
        DBHelper_hp.close();
    }

    // ---insert a record into the database---
    public long insertRecord(String hp) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_ITEM, hp);
        return dbHp.insert(DATABASE_TABLE, null, initialValues);
    }

    // ---deletes a particular record---
    public boolean deleteContact(long rowId) {
        return dbHp.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }

    // ---retrieves all the records---
    public static Cursor getAllRecords() {
        return dbHp.query(DATABASE_TABLE, new String[] { KEY_ROWID, KEY_ITEM},
                null, null, null, null, null, null);
    }

    // ---retrieves a particular record---
    public Cursor getRecord(long rowId) throws SQLException {
        Cursor mCursor = dbHp.query(true, DATABASE_TABLE, new String[] {
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
    public boolean updateRecord(long rowId, String hp) {
        ContentValues args = new ContentValues();
        args.put(KEY_ITEM, hp);

        return dbHp.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    }
}
