package Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBAdapter_Alliance {
	public static final String KEY_ROWID = "_id";
	public static final String KEY_ITEM = "alliance";

	private static final String TAG = "DBAdapter_Alliance";

	private static final String DATABASE_NAME = "AllianceDB";
	private static final String DATABASE_TABLE = "characterAlliance";
	private static final int DATABASE_VERSION = 8;

	private static final String DATABASE_CREATE = "create table if not exists characterAlliance (_id integer primary key autoincrement, "
			+ "alliance VARCHAR not null);";

	private final Context context;

	private DatabaseHelper DBHelper_Alliance;
	private static SQLiteDatabase dbAlliance;

	public DBAdapter_Alliance(Context ctx) {
		this.context = ctx;
		DBHelper_Alliance = new DatabaseHelper(context);
	}

	private static class DatabaseHelper extends SQLiteOpenHelper {
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase dbAlliance) {
			try {
				dbAlliance.execSQL(DATABASE_CREATE);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase dbAlliance, int oldVersion, int newVersion) {
			Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
					+ newVersion + ", which will destroy all old data");
			dbAlliance.execSQL("DROP TABLE IF EXISTS characterAlliance");
			onCreate(dbAlliance);
		}
	}

	// ---opens the database---
	public DBAdapter_Alliance open() throws SQLException {
		dbAlliance = DBHelper_Alliance.getWritableDatabase();
		return this;
	}

	// ---closes the database---
	public void close() {
		DBHelper_Alliance.close();
	}

	// ---insert a record into the database---
	public long insertRecord(String alliance) {
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_ITEM, alliance);
		return dbAlliance.insert(DATABASE_TABLE, null, initialValues);
	}

	// ---deletes a particular record---
	public boolean deleteContact(long rowId) {
		return dbAlliance.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
	}

	// ---retrieves all the records---
	public static Cursor getAllRecords() {
		return dbAlliance.query(DATABASE_TABLE, new String[] { KEY_ROWID, KEY_ITEM},
				null, null, null, null, null, null);
	}

	// ---retrieves a particular record---
	public Cursor getRecord(long rowId) throws SQLException {
		Cursor mCursor = dbAlliance.query(true, DATABASE_TABLE, new String[] {
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
	public boolean updateRecord(long rowId, String alliance) {
		ContentValues args = new ContentValues();
		args.put(KEY_ITEM, alliance);

		return dbAlliance.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
	}
}
