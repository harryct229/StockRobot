package com.stockrobot.model;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class StockRobotActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.main);
		DatabaseHelper db = new DatabaseHelper(this);

		// db.addCompany(new Company("ABC", "", "", "", "", "", ""));
		// db.addStock(new Stock("ABC", "22/09", 246, 346, 799, 496, 4546));
		// db.addStock(new Stock("ABCX", "224/09", 246, 346, 799, 496, 4546));
		// db.addStock(new Stock("ABCXZ", "223/09", 246, 346, 799, 496, 4546));
		List<Stock> stocks = db.getAllStock();
		for (Stock cn : stocks) {
			String log = "Id: " + cn.id + " ,Date: " + cn.date;
			// Writing Contacts to log
			Log.d("Name: ", log);
		}
		Stock stock = db.getStock("ABC");
		String log = "Id: " + stock.id + " ,Date: " + stock.date;
		Log.d("Name: ", log);

		Stock stock2 = db.getStock("ABCd");
		if (stock2 != null) {
			String log2 = "Id: " + stock2.id + " ,Date: " + stock2.date;
			Log.d("Name: ", log);
		} else {
			Log.d("Name: ", "NOT FOUND");
		}
	}
}