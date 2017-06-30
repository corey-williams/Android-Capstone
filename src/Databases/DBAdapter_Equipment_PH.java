package Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter_Equipment_PH {
	public static final String KEY_ROWID = "_id";
	public static final String KEY_ITEM = "ph";

	private static final String TAG = "DBAdapter_Equipment_PH";

	private static final String DATABASE_NAME = "PHDB";
	private static final String DATABASE_TABLE = "characterEquipmentPH";
	private static final int DATABASE_VERSION = 5;

	private static final String DATABASE_CREATE = "create table if not exists characterEquipmentPH (_id integer primary key autoincrement, "
			+ "ph VARCHAR not null);";

	private final Context context;

	private DatabaseHelper DBHelper_ph;
	private static SQLiteDatabase dbPH;

	public DBAdapter_Equipment_PH(Context ctx) {
		this.context = ctx;
		DBHelper_ph = new DatabaseHelper(context);
	}

	private static class DatabaseHelper extends SQLiteOpenHelper {
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase dbPH) {
			try {
				dbPH.execSQL(DATABASE_CREATE);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase dbPH, int oldVersion, int newVersion) {
			Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
					+ newVersion + ", which will destroy all old data");
			dbPH.execSQL("DROP TABLE IF EXISTS characterEquipmentPH");
			onCreate(dbPH);
		}
	}

	// ---opens the database---
	public DBAdapter_Equipment_PH open() throws SQLException { 
		dbPH = DBHelper_ph.getWritableDatabase();
		return this;
	}

	// ---closes the database---
	public void close() {
		DBHelper_ph.close();
	}

	// ---insert a record into the database---
	public long insertRecord(String ph) {
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_ITEM, ph);
		return dbPH.insert(DATABASE_TABLE, null, initialValues);
	}

	// ---deletes a particular record---
	public boolean deleteContact(long rowId) {
		return dbPH.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
	}

	// ---retrieves all the records---
	public static Cursor getAllRecords() {
		return dbPH.query(DATABASE_TABLE, new String[] { KEY_ROWID, KEY_ITEM},
				null, null, null, null, null, null);
	}

	// ---retrieves a particular record---
	public Cursor getRecord(long rowId) throws SQLException {
		Cursor mCursor = dbPH.query(true, DATABASE_TABLE, new String[] {
				KEY_ROWID, KEY_ITEM }, KEY_ROWID + "=" + rowId, null, null,
				null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}
	
	public int deleteAll(){
		return dbPH.delete(DATABASE_TABLE, null, null);
		 }

	// ---updates a record---
	public boolean updateRecord(long rowId, String ph) {
		ContentValues args = new ContentValues();
		args.put(KEY_ITEM, ph);

		return dbPH.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
	}
}
