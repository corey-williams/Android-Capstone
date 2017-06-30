package Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter_Equipment_Hands {
	public static final String KEY_ROWID = "_id";
	public static final String KEY_ITEM = "hands";

	private static final String TAG = "DBAdapter_Equipment_Hands";

	private static final String DATABASE_NAME = "HandsDB";
	private static final String DATABASE_TABLE = "characterEquipmentHands";
	private static final int DATABASE_VERSION = 5;

	private static final String DATABASE_CREATE = "create table if not exists characterEquipmentHands (_id integer primary key autoincrement, "
			+ "hands VARCHAR not null);";

	private final Context context;

	private DatabaseHelper DBHelper_hands;
	private static SQLiteDatabase dbHands;

	public DBAdapter_Equipment_Hands(Context ctx) {
		this.context = ctx;
		DBHelper_hands = new DatabaseHelper(context);
	}

	private static class DatabaseHelper extends SQLiteOpenHelper {
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase dbHands) {
			try {
				dbHands.execSQL(DATABASE_CREATE);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase dbHands, int oldVersion, int newVersion) {
			Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
					+ newVersion + ", which will destroy all old data");
			dbHands.execSQL("DROP TABLE IF EXISTS characterEquipmentHands");
			onCreate(dbHands);
		}
	}

	// ---opens the database---
	public DBAdapter_Equipment_Hands open() throws SQLException { 
		dbHands = DBHelper_hands.getWritableDatabase();
		return this;
	}

	// ---closes the database---
	public void close() {
		DBHelper_hands.close();
	}

	// ---insert a record into the database---
	public long insertRecord(String hands) {
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_ITEM, hands);
		return dbHands.insert(DATABASE_TABLE, null, initialValues);
	}

	// ---deletes a particular record---
	public boolean deleteContact(long rowId) {
		return dbHands.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
	}

	// ---retrieves all the records---
	public static Cursor getAllRecords() {
		return dbHands.query(DATABASE_TABLE, new String[] { KEY_ROWID, KEY_ITEM},
				null, null, null, null, null, null);
	}

	// ---retrieves a particular record---
	public Cursor getRecord(long rowId) throws SQLException {
		Cursor mCursor = dbHands.query(true, DATABASE_TABLE, new String[] {
				KEY_ROWID, KEY_ITEM }, KEY_ROWID + "=" + rowId, null, null,
				null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}
	
	public int deleteAll(){
		return dbHands.delete(DATABASE_TABLE, null, null);
		 }

	// ---updates a record---
	public boolean updateRecord(long rowId, String hands) {
		ContentValues args = new ContentValues();
		args.put(KEY_ITEM, hands);

		return dbHands.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
	}
}
