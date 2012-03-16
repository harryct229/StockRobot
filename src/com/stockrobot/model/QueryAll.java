package com.stockrobot.model;

public class QueryAll extends Query {
	public QueryAll(String mTable) {
		this.query = "SELECT * FROM " + mTable;
	}
}
