package Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter_Equipment_Feet {
	public static final String KEY_ROWID = "_id";
	public static final String KEY_ITEM = "feet";

	private static final String TAG = "DBAdapter_Equipment_Feet";

	private static final String DATABASE_NAME = "FeetDB";
	private static final String DATABASE_TABLE = "characterEquipmentFeet";
	private static final int DATABASE_VERSION = 5;

	private static final String DATABASE_CREATE = "create table if not exists characterEquipmentFeet (_id integer primary key autoincrement, "
			+ "feet VARCHAR not null);";

	private final Context context;

	private DatabaseHelper DBHelper_feet;
	private static SQLiteDatabase dbFeet;

	public DBAdapter_Equipment_Feet(Context ctx) {
		this.context = ctx;
		DBHelper_feet = new DatabaseHelper(context);
	}

	private static class DatabaseHelper extends SQLiteOpenHelper {
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase dbFeet) {
			try {
				dbFeet.execSQL(DATABASE_CREATE);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase dbFeet, int oldVersion, int newVersion) {
			Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
					+ newVersion + ", which will destroy all old data");
			dbFeet.execSQL("DROP TABLE IF EXISTS characterEquipmentFeet");
			onCreate(dbFeet);
		}
	}

	// ---opens the database---
	public DBAdapter_Equipment_Feet open() throws SQLException { 
		dbFeet = DBHelper_feet.getWritableDatabase();
		return this;
	}

	// ---closes the database---
	public void close() {
		DBHelper_feet.close();
	}

	// ---insert a record into the database---
	public long insertRecord(String feet) {
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_ITEM, feet);
		return dbFeet.insert(DATABASE_TABLE, null, initialValues);
	}

	// ---deletes a particular record---
	public boolean deleteContact(long rowId) {
		return dbFeet.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
	}

	// ---retrieves all the records---
	public static Cursor getAllRecords() {
		return dbFeet.query(DATABASE_TABLE, new String[] { KEY_ROWID, KEY_ITEM},
				null, null, null, null, null, null);
	}

	// ---retrieves a particular record---
	public Cursor getRecord(long rowId) throws SQLException {
		Cursor mCursor = dbFeet.query(true, DATABASE_TABLE, new String[] {
				KEY_ROWID, KEY_ITEM }, KEY_ROWID + "=" + rowId, null, null,
				null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}
	
	public int deleteAll(){
		return dbFeet.delete(DATABASE_TABLE, null, null);
		 }

	// ---updates a record---
	public boolean updateRecord(long rowId, String feet) {
		ContentValues args = new ContentValues();
		args.put(KEY_ITEM, feet);

		return dbFeet.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
	}
}
