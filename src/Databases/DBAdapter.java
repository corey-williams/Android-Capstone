package Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {
	public static final String KEY_ROWID = "_id";
	public static final String KEY_ITEM = "item";

	private static final String TAG = "DBAdapter";

	private static final String DATABASE_NAME = "InventoryDB";
	private static final String DATABASE_TABLE = "inventory";
	private static final int DATABASE_VERSION = 4;

	private static final String DATABASE_CREATE = "create table if not exists inventory (_id integer primary key autoincrement, "
			+ "item VARCHAR not null);";

	private final Context context;

	private DatabaseHelper DBHelper;
	private static SQLiteDatabase db;

	public DBAdapter(Context ctx) {
		this.context = ctx;
		DBHelper = new DatabaseHelper(context);
	}

	private static class DatabaseHelper extends SQLiteOpenHelper {
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			try {
				db.execSQL(DATABASE_CREATE);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.w(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
			db.execSQL("DROP TABLE IF EXISTS inventory");
			onCreate(db);
		}
	}

	// ---opens the database---
	public DBAdapter open() throws SQLException {
		db = DBHelper.getWritableDatabase();
		return this;
	}

	// ---closes the database---
	public void close() {
		DBHelper.close();
	}

	// ---insert a record into the database---
	public long insertRecord(String item) {
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_ITEM, item);
		return db.insert(DATABASE_TABLE, null, initialValues);
	}

	// ---deletes a particular record---
	public boolean deleteContact(long id) {
		// return db.delete(DATABASE_TABLE, KEY_ITEM + "='" + item + "'", null)
		// > 0;
		return db.delete(DATABASE_TABLE, "_id=?", new String[] { String.valueOf(id) }) > 0;
	}

	// ---retrieves all the records---
	public static Cursor getAllRecords() {
		return db.query(DATABASE_TABLE, new String[] { KEY_ROWID, KEY_ITEM }, null, null, null, null, KEY_ITEM + " ASC");
	}

	// ---retrieves a particular record---
	public Cursor getRecord(long rowId) throws SQLException {
		Cursor mCursor = db.query(true, DATABASE_TABLE, new String[] { KEY_ROWID, KEY_ITEM }, KEY_ROWID + "=" + rowId, null, null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}

	public int deleteAll() {
		return db.delete(DATABASE_TABLE, null, null);
	}

	// ---updates a record---
	public boolean updateRecord(long rowId, String item) {
		ContentValues args = new ContentValues();
		args.put(KEY_ITEM, item);

		return db.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
	}
}
