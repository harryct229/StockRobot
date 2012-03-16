package com.stockrobot.model;

public class QueryID extends Query {
	String mTable;

	public QueryID(String mTable, String id) {
		this.mTable = mTable;
		this.query = "SELECT * FROM " + mTable + " WHERE stock_id LIKE " + "\""
				+ id + "\"";
	}
}
