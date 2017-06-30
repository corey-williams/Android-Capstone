package Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class DBAdapter_Race {
	public static final String KEY_ROWID = "_id";
	public static final String KEY_ITEM = "race";

	private static final String TAG = "DBAdapter_Race";

	private static final String DATABASE_NAME = "RaceDB";
	private static final String DATABASE_TABLE = "characterRace";
	private static final int DATABASE_VERSION = 5;

	private static final String DATABASE_CREATE = "create table if not exists characterRace (_id integer primary key autoincrement, "
			+ "race VARCHAR not null);";

	private final Context context;

	private DatabaseHelper DBHelper_Race;
	private static SQLiteDatabase dbRace;

	public DBAdapter_Race(Context ctx) {
		this.context = ctx;
		DBHelper_Race = new DatabaseHelper(context);
	}

	private static class DatabaseHelper extends SQLiteOpenHelper {
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase dbRace) {
			try {
				dbRace.execSQL(DATABASE_CREATE);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase dbRace, int oldVersion, int newVersion) {
			Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
					+ newVersion + ", which will destroy all old data");
			dbRace.execSQL("DROP TABLE IF EXISTS characterRace");
			onCreate(dbRace);
		}
	}

	// ---opens the database---
	public DBAdapter_Race open() throws SQLException {
		dbRace = DBHelper_Race.getWritableDatabase();
		return this;
	}

	// ---closes the database---
	public void close() {
		DBHelper_Race.close();
	}

	// ---insert a record into the database---
	public long insertRecord(String race) {
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_ITEM, race);
		return dbRace.insert(DATABASE_TABLE, null, initialValues);
	}

	// ---deletes a particular record---
	public boolean deleteContact(long rowId) {
		return dbRace.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
	}

	// ---retrieves all the records---
	public static Cursor getAllRecords() {
		return dbRace.query(DATABASE_TABLE, new String[] { KEY_ROWID, KEY_ITEM},
				null, null, null, null, null, null);
	}

	// ---retrieves a particular record---
	public Cursor getRecord(long rowId) throws SQLException {
		Cursor mCursor = dbRace.query(true, DATABASE_TABLE, new String[] {
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
	public boolean updateRecord(long rowId, String race) {
		ContentValues args = new ContentValues();
		args.put(KEY_ITEM, race);

		return dbRace.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
	}
}
