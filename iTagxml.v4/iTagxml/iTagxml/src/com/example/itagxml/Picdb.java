package com.example.itagxml;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Picdb extends SQLiteOpenHelper {
	private final static String name = "picdb";
	private final static int version = 1;
	//private final static String pic = "pic";
	private final String CREATE_TABLE_SQL = "create table picdb (_id integer primary key, "
			+ "uri)";

	public Picdb(Context context) {
		super(context, name,null, version);
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO �Զ����ɵķ������
		db.execSQL(CREATE_TABLE_SQL);

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO �Զ����ɵķ������

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
