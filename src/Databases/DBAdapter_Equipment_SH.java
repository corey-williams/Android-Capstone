package Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter_Equipment_SH {
	public static final String KEY_ROWID = "_id";
	public static final String KEY_ITEM = "sh";

	private static final String TAG = "DBAdapter_Equipment_SH";

	private static final String DATABASE_NAME = "SHDB";
	private static final String DATABASE_TABLE = "characterEquipmentSH";
	private static final int DATABASE_VERSION = 5;

	private static final String DATABASE_CREATE = "create table if not exists characterEquipmentSH (_id integer primary key autoincrement, "
			+ "sh VARCHAR not null);";

	private final Context context;

	private DatabaseHelper DBHelper_sh;
	private static SQLiteDatabase dbSH;

	public DBAdapter_Equipment_SH(Context ctx) {
		this.context = ctx;
		DBHelper_sh = new DatabaseHelper(context);
	}

	private static class DatabaseHelper extends SQLiteOpenHelper {
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase dbSH) {
			try {
				dbSH.execSQL(DATABASE_CREATE);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase dbSH, int oldVersion, int newVersion) {
			Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
					+ newVersion + ", which will destroy all old data");
			dbSH.execSQL("DROP TABLE IF EXISTS characterEquipmentSH");
			onCreate(dbSH);
		}
	}

	// ---opens the database---
	public DBAdapter_Equipment_SH open() throws SQLException { 
		dbSH = DBHelper_sh.getWritableDatabase();
		return this;
	}

	// ---closes the database---
	public void close() {
		DBHelper_sh.close();
	}

	// ---insert a record into the database---
	public long insertRecord(String sh) {
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_ITEM, sh);
		return dbSH.insert(DATABASE_TABLE, null, initialValues);
	}

	// ---deletes a particular record---
	public boolean deleteContact(long rowId) {
		return dbSH.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
	}

	// ---retrieves all the records---
	public static Cursor getAllRecords() {
		return dbSH.query(DATABASE_TABLE, new String[] { KEY_ROWID, KEY_ITEM},
				null, null, null, null, null, null);
	}

	// ---retrieves a particular record---
	public Cursor getRecord(long rowId) throws SQLException {
		Cursor mCursor = dbSH.query(true, DATABASE_TABLE, new String[] {
				KEY_ROWID, KEY_ITEM }, KEY_ROWID + "=" + rowId, null, null,
				null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}
	
	public int deleteAll(){
		return dbSH.delete(DATABASE_TABLE, null, null);
		 }

	// ---updates a record---
	public boolean updateRecord(long rowId, String sh) {
		ContentValues args = new ContentValues();
		args.put(KEY_ITEM, sh);

		return dbSH.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
	}
}
