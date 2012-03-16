package com.stockrobot.model;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "stock.db";
	private static final int DATABASE_VERSION = 1;
	public static final String TABLE_STOCK = "stock";

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Method is called during creation of the database
	@Override
	public void onCreate(SQLiteDatabase database) {
		CompanyTable.onCreate(database);
		StockTable.onCreate(database);
	}

	// Method is called during an upgrade of the database,
	// e.g. if you increase the database version
	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion,
			int newVersion) {
		CompanyTable.onUpgrade(database, oldVersion, newVersion);
		StockTable.onUpgrade(database, oldVersion, newVersion);
	}

	// ====================================================================
	// METHOD ADD DATA
	// ====================================================================

	// STOCK
	public void addStock(Stock stock) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();

		values.put(StockTable.COLUMN_ID, stock.id);
		values.put(StockTable.COLUMN_DATE, stock.date);
		values.put(StockTable.COLUMN_OPEN, stock.openPrice);
		values.put(StockTable.COLUMN_CLOSE, stock.closePrice);
		values.put(StockTable.COLUMN_LOW, stock.lowPrice);
		values.put(StockTable.COLUMN_HIGH, stock.highPrice);
		values.put(StockTable.COLUMN_VOLUME, stock.volume);

		// Inserting Row
		db.insert(TABLE_STOCK, null, values);
		db.close(); // Closing database connection
	}

	// COMPANY
	public void addCompany(Company com) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();

		values.put(CompanyTable.COLUMN_ID, com.id);
		// values.put(CompanyTable.COLUMN_DATE, com.date);
		// values.put(StockTable.COLUMN_OPEN, com.openPrice);
		// values.put(StockTable.COLUMN_CLOSE, com.closePrice);
		// values.put(StockTable.COLUMN_LOW, com.lowPrice);
		// values.put(StockTable.COLUMN_HIGH, com.highPrice);
		// values.put(StockTable.COLUMN_VOLUME, com.volume);

		// Inserting Row
		db.insert(TABLE_STOCK, null, values);
		db.close(); // Closing database connection
	}

	// ====================================================================
	// METHOD GET DATA
	// ====================================================================

	public Stock getStock(String id) {
		SQLiteDatabase db = this.getReadableDatabase();
		QueryID query = new QueryID(TABLE_STOCK, id);

		Cursor cursor = db.rawQuery(query.execQuery(), null);

		Stock stock = null;
		if (cursor != null) {
			if (cursor.moveToFirst()) {
				stock = new Stock(cursor.getString(0), cursor.getString(1),
						cursor.getFloat(2), cursor.getFloat(3),
						cursor.getFloat(4), cursor.getFloat(5),
						cursor.getFloat(6));
			}
		}
		// return contact
		return stock;
	}

	public List<Stock> getAllStock() {
		List<Stock> stockList = new ArrayList<Stock>();

		SQLiteDatabase db = this.getReadableDatabase();
		QueryAll query = new QueryAll(TABLE_STOCK);
		Cursor cursor = db.rawQuery(query.execQuery(), null);

		if (cursor.moveToFirst()) {
			do {
				Stock stock = new Stock(cursor.getString(0),
						cursor.getString(1), cursor.getFloat(2),
						cursor.getFloat(3), cursor.getFloat(4),
						cursor.getFloat(5), cursor.getFloat(6));
				// Adding contact to list
				stockList.add(stock);
			} while (cursor.moveToNext());
		}

		return stockList;
	}

}
