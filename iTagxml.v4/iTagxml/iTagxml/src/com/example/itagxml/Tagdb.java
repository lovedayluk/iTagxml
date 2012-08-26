package com.example.itagxml;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Tagdb extends SQLiteOpenHelper {
	private final static String name = "tagdb";
	private final static int version = 1;
	private final String CREATE_TABLE_SQL = "create table tagdb (_id integer primary key, "
			+ "tag, uri)";
	public final String tag = "tag";
	public final String uri = "uri";

	public Tagdb(Context context) {
		super(context, name,null, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_SQL);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

	}

	/**
	 * @param args
	 */
	public Cursor select() {
		
		SQLiteDatabase db=this.getReadableDatabase();
		Cursor cursor = db.rawQuery("SELECT DISTINCT tag FROM tagdb",null);
		return cursor;

	}
public Cursor select_uri(String uri) {
		
		SQLiteDatabase db=this.getReadableDatabase();
		Cursor cursor = db.rawQuery("SELECT DISTINCT tag FROM tagdb WHERE uri = "+uri,null);  
		return cursor;

	}

public Cursor select_tag(String tag) {
	
	SQLiteDatabase db=this.getReadableDatabase();
	Cursor cursor = db.rawQuery("SELECT DISTINCT uri FROM tagdb WHERE tag = ?", new String[]{tag});  
	return cursor;

}

}
