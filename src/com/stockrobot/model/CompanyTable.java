package com.stockrobot.model;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class CompanyTable {
	// Database table
	public static final String TABLE_NAME = "company";
	public static final String COLUMN_ID = "stock_id";
	public static final String COLUMN_NAME = "company_name";
	public static final String COLUMN_INDUSTRY = "summary";
	public static final String COLUMN_YEAR = "year";
	public static final String COLUMN_EXCHANGE = "stock_exchange";
	public static final String COLUMN_FUND = "fund";
	public static final String COLUMN_INFO = "info";

	// Database creation SQL statement
	private static final String DATABASE_CREATE = "create table " + TABLE_NAME
			+ "(" + COLUMN_ID + " text primary key, " + COLUMN_NAME + " text, "
			+ COLUMN_INDUSTRY + " text," + COLUMN_YEAR + " text, "
			+ COLUMN_EXCHANGE + " text, " + COLUMN_FUND + " text, "
			+ COLUMN_INFO + " text " + ");";

	public static void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
	}

	public static void onUpgrade(SQLiteDatabase database, int oldVersion,
			int newVersion) {
		Log.w(CompanyTable.class.getName(), "Upgrading database from version "
				+ oldVersion + " to " + newVersion
				+ ", which will destroy all old data");
		database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(database);
	}
}
