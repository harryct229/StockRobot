package com.stockrobot.model;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class StockTable {
	// Database table
	public static final String TABLE_NAME = "stock";
	public static final String TABLE_COMPANY = "company";
	public static final String COLUMN_ID = "stock_id";
	public static final String COLUMN_DATE = "date";
	public static final String COLUMN_OPEN = "open";
	public static final String COLUMN_CLOSE = "close";
	public static final String COLUMN_LOW = "low";
	public static final String COLUMN_HIGH = "high";
	public static final String COLUMN_VOLUME = "volume";

	// Database creation SQL statement
	private static final String DATABASE_CREATE = "create table " + TABLE_NAME
			+ "(" + COLUMN_ID + " text primary key, " + COLUMN_DATE
			+ " text not null, " + COLUMN_OPEN + " numeric," + COLUMN_CLOSE
			+ " numeric, " + COLUMN_LOW + " numeric, " + COLUMN_HIGH
			+ " numeric, " + COLUMN_VOLUME + " numeric, " + " FOREIGN KEY ("
			+ COLUMN_ID + ") REFERENCES " + TABLE_COMPANY + " (" + COLUMN_ID
			+ "));";

	public static void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
	}

	public static void onUpgrade(SQLiteDatabase database, int oldVersion,
			int newVersion) {
		Log.w(StockTable.class.getName(), "Upgrading database from version "
				+ oldVersion + " to " + newVersion
				+ ", which will destroy all old data");
		database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(database);
	}
}
