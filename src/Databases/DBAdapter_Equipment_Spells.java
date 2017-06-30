package Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter_Equipment_Spells {
	public static final String KEY_ROWID = "_id";
	public static final String KEY_ITEM = "spells";

	private static final String TAG = "DBAdapter_Equipment_Spells";

	private static final String DATABASE_NAME = "SpellsDB";
	private static final String DATABASE_TABLE = "characterEquipmentSpells";
	private static final int DATABASE_VERSION = 5;

	private static final String DATABASE_CREATE = "create table if not exists characterEquipmentSpells (_id integer primary key autoincrement, "
			+ "spells VARCHAR not null);";

	private final Context context;

	private DatabaseHelper DBHelper_spells;
	private static SQLiteDatabase dbSpells;

	public DBAdapter_Equipment_Spells(Context ctx) {
		this.context = ctx;
		DBHelper_spells = new DatabaseHelper(context);
	}

	private static class DatabaseHelper extends SQLiteOpenHelper {
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase dbSpells) {
			try {
				dbSpells.execSQL(DATABASE_CREATE);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase dbSpells, int oldVersion, int newVersion) {
			Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
					+ newVersion + ", which will destroy all old data");
			dbSpells.execSQL("DROP TABLE IF EXISTS characterEquipmentSpells");
			onCreate(dbSpells);
		}
	}

	// ---opens the database---
	public DBAdapter_Equipment_Spells open() throws SQLException { 
		dbSpells = DBHelper_spells.getWritableDatabase();
		return this;
	}

	// ---closes the database---
	public void close() {
		DBHelper_spells.close();
	}

	// ---insert a record into the database---
	public long insertRecord(String spells) {
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_ITEM, spells);
		return dbSpells.insert(DATABASE_TABLE, null, initialValues);
	}

	// ---deletes a particular record---
	public boolean deleteContact(long rowId) {
		return dbSpells.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
	}

	// ---retrieves all the records---
	public static Cursor getAllRecords() {
		return dbSpells.query(DATABASE_TABLE, new String[] { KEY_ROWID, KEY_ITEM},
				null, null, null, null, null, null);
	}

	// ---retrieves a particular record---
	public Cursor getRecord(long rowId) throws SQLException {
		Cursor mCursor = dbSpells.query(true, DATABASE_TABLE, new String[] {
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
	public boolean updateRecord(long rowId, String spells) {
		ContentValues args = new ContentValues();
		args.put(KEY_ITEM, spells);

		return dbSpells.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
	}
}
