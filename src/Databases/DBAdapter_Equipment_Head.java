package Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter_Equipment_Head {
	public static final String KEY_ROWID = "_id";
	public static final String KEY_ITEM = "head";

	private static final String TAG = "DBAdapter_Equipment_Head";

	private static final String DATABASE_NAME = "HeadDB";
	private static final String DATABASE_TABLE = "characterEquipmentHead";
	private static final int DATABASE_VERSION = 5;

	private static final String DATABASE_CREATE = "create table if not exists characterEquipmentHead (_id integer primary key autoincrement, "
			+ "head VARCHAR not null);";

	private final Context context;

	private DatabaseHelper DBHelper_head;
	private static SQLiteDatabase dbHead;

	public DBAdapter_Equipment_Head(Context ctx) {
		this.context = ctx;
		DBHelper_head = new DatabaseHelper(context);
	}

	private static class DatabaseHelper extends SQLiteOpenHelper {
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase dbHead) {
			try {
				dbHead.execSQL(DATABASE_CREATE);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase dbHead, int oldVersion, int newVersion) {
			Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
					+ newVersion + ", which will destroy all old data");
			dbHead.execSQL("DROP TABLE IF EXISTS characterEquipmentHead");
			onCreate(dbHead);
		}
	}

	// ---opens the database---
	public DBAdapter_Equipment_Head open() throws SQLException { 
		dbHead = DBHelper_head.getWritableDatabase();
		return this;
	}

	// ---closes the database---
	public void close() {
		DBHelper_head.close();
	}

	// ---insert a record into the database---
	public long insertRecord(String head) {
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_ITEM, head);
		return dbHead.insert(DATABASE_TABLE, null, initialValues);
	}

	// ---deletes a particular record---
	public boolean deleteContact(long rowId) {
		return dbHead.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
	}

	// ---retrieves all the records---
	public static Cursor getAllRecords() {
		return dbHead.query(DATABASE_TABLE, new String[] { KEY_ROWID, KEY_ITEM},
				null, null, null, null, null, null);
	}

	// ---retrieves a particular record---
	public Cursor getRecord(long rowId) throws SQLException {
		Cursor mCursor = dbHead.query(true, DATABASE_TABLE, new String[] {
				KEY_ROWID, KEY_ITEM }, KEY_ROWID + "=" + rowId, null, null,
				null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}
	
	public int deleteAll(){
		return dbHead.delete(DATABASE_TABLE, null, null);
		 }

	// ---updates a record---
	public boolean updateRecord(long rowId, String head) {
		ContentValues args = new ContentValues();
		args.put(KEY_ITEM, head);

		return dbHead.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
	}
}
