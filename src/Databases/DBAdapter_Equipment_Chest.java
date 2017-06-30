package Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter_Equipment_Chest {
	public static final String KEY_ROWID = "_id";
	public static final String KEY_ITEM = "chest";

	private static final String TAG = "DBAdapter_Equipment_Chest";

	private static final String DATABASE_NAME = "ChestDB";
	private static final String DATABASE_TABLE = "characterEquipmentChest";
	private static final int DATABASE_VERSION = 5;

	private static final String DATABASE_CREATE = "create table if not exists characterEquipmentChest (_id integer primary key autoincrement, "
			+ "chest VARCHAR not null);";

	private final Context context;

	private DatabaseHelper DBHelper_chest;
	private static SQLiteDatabase dbChest;

	public DBAdapter_Equipment_Chest(Context ctx) {
		this.context = ctx;
		DBHelper_chest = new DatabaseHelper(context);
	}

	private static class DatabaseHelper extends SQLiteOpenHelper {
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase dbChest) {
			try {
				dbChest.execSQL(DATABASE_CREATE);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase dbChest, int oldVersion, int newVersion) {
			Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
					+ newVersion + ", which will destroy all old data");
			dbChest.execSQL("DROP TABLE IF EXISTS characterEquipmentChest");
			onCreate(dbChest);
		}
	}

	// ---opens the database---
	public DBAdapter_Equipment_Chest open() throws SQLException { 
		dbChest = DBHelper_chest.getWritableDatabase();
		return this;
	}

	// ---closes the database---
	public void close() {
		DBHelper_chest.close();
	}

	// ---insert a record into the database---
	public long insertRecord(String chest) {
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_ITEM, chest);
		return dbChest.insert(DATABASE_TABLE, null, initialValues);
	}

	// ---deletes a particular record---
	public boolean deleteContact(long rowId) {
		return dbChest.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
	}

	// ---retrieves all the records---
	public static Cursor getAllRecords() {
		return dbChest.query(DATABASE_TABLE, new String[] { KEY_ROWID, KEY_ITEM},
				null, null, null, null, null, null);
	}

	// ---retrieves a particular record---
	public Cursor getRecord(long rowId) throws SQLException {
		Cursor mCursor = dbChest.query(true, DATABASE_TABLE, new String[] {
				KEY_ROWID, KEY_ITEM }, KEY_ROWID + "=" + rowId, null, null,
				null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}
	
	public int deleteAll(){
		return dbChest.delete(DATABASE_TABLE, null, null);
		 }

	// ---updates a record---
	public boolean updateRecord(long rowId, String chest) {
		ContentValues args = new ContentValues();
		args.put(KEY_ITEM, chest);

		return dbChest.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
	}
}
