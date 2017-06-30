package Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBAdapter_Class {
	public static final String KEY_ROWID = "_id";
	public static final String KEY_ITEM = "class1";

	private static final String TAG = "DBAdapter_Class";

	private static final String DATABASE_NAME = "ClassDB";
	private static final String DATABASE_TABLE = "characterClass";
	private static final int DATABASE_VERSION = 8;

	private static final String DATABASE_CREATE = "create table if not exists characterClass (_id integer primary key autoincrement, "
			+ "class1 VARCHAR not null);";

	private final Context context;

	private DatabaseHelper DBHelper_Class;
	private static SQLiteDatabase dbClass;

	public DBAdapter_Class(Context ctx) {
		this.context = ctx;
		DBHelper_Class = new DatabaseHelper(context);
	}

	private static class DatabaseHelper extends SQLiteOpenHelper {
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase dbClass) {
			try {
				dbClass.execSQL(DATABASE_CREATE);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase dbClass, int oldVersion, int newVersion) {
			Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
					+ newVersion + ", which will destroy all old data");
			dbClass.execSQL("DROP TABLE IF EXISTS characterClass");
			onCreate(dbClass);
		}
	}

	// ---opens the database---
	public DBAdapter_Class open() throws SQLException {
		dbClass = DBHelper_Class.getWritableDatabase();
		return this;
	}

	// ---closes the database---
	public void close() {
		DBHelper_Class.close();
	}

	// ---insert a record into the database---
	public long insertRecord(String class1) {
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_ITEM, class1);
		return dbClass.insert(DATABASE_TABLE, null, initialValues);
	}

	// ---deletes a particular record---
	public boolean deleteContact(long rowId) {
		return dbClass.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
	}

	// ---retrieves all the records---
	public static Cursor getAllRecords() {
		return dbClass.query(DATABASE_TABLE, new String[] { KEY_ROWID, KEY_ITEM},
				null, null, null, null, null, null);
	}

	// ---retrieves a particular record---
	public Cursor getRecord(long rowId) throws SQLException {
		Cursor mCursor = dbClass.query(true, DATABASE_TABLE, new String[] {
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
	public boolean updateRecord(long rowId, String class1) {
		ContentValues args = new ContentValues();
		args.put(KEY_ITEM, class1);

		return dbClass.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
	}
}
