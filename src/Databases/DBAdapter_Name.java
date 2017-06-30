package Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class DBAdapter_Name {
	public static final String KEY_ROWID = "_id";
	public static final String KEY_ITEM = "name";

	private static final String TAG = "DBAdapter_Name";

	private static final String DATABASE_NAME = "NameDB";
	private static final String DATABASE_TABLE = "characterName";
	private static final int DATABASE_VERSION = 5;

	private static final String DATABASE_CREATE = "create table if not exists characterName (_id integer primary key autoincrement, "
			+ "name VARCHAR not null);";

	private final Context context;

	private DatabaseHelper DBHelper_name;
	private static SQLiteDatabase dbName;

	public DBAdapter_Name(Context ctx) {
		this.context = ctx;
		DBHelper_name = new DatabaseHelper(context);
	}

	private static class DatabaseHelper extends SQLiteOpenHelper {
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase dbName) {
			try {
				dbName.execSQL(DATABASE_CREATE);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase dbName, int oldVersion, int newVersion) {
			Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
					+ newVersion + ", which will destroy all old data");
			dbName.execSQL("DROP TABLE IF EXISTS characterName");
			onCreate(dbName);
		}
	}

	// ---opens the database---
	public DBAdapter_Name open() throws SQLException { 
		dbName = DBHelper_name.getWritableDatabase();
		return this;
	}

	// ---closes the database---
	public void close() {
		DBHelper_name.close();
	}

	// ---insert a record into the database---
	public long insertRecord(String name) {
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_ITEM, name);
		return dbName.insert(DATABASE_TABLE, null, initialValues);
	}

	// ---deletes a particular record---
	public boolean deleteContact(long rowId) {
		return dbName.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
	}

	// ---retrieves all the records---
	public static Cursor getAllRecords() {
		return dbName.query(DATABASE_TABLE, new String[] { KEY_ROWID, KEY_ITEM},
				null, null, null, null, null, null);
	}

	// ---retrieves a particular record---
	public Cursor getRecord(long rowId) throws SQLException {
		Cursor mCursor = dbName.query(true, DATABASE_TABLE, new String[] {
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
	public boolean updateRecord(long rowId, String name) {
		ContentValues args = new ContentValues();
		args.put(KEY_ITEM, name);

		return dbName.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
	}
}
