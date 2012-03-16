package com.stockrobot;

import mypackage.SceneManager.R;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class TabLayoutActivity extends TabActivity{

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_layout);
		
		TabHost tabHost = getTabHost();
		
		//Day list
		TabSpec day_tab = tabHost.newTabSpec("Day");
		day_tab.setIndicator("Day", getResources().getDrawable(R.drawable.icon_tab));
		Intent daysIntent = new Intent(this, DayListActivity.class);
		day_tab.setContent(daysIntent);
		
		//Month list
		TabSpec month_tab = tabHost.newTabSpec("Month");
		month_tab.setIndicator("Month", getResources().getDrawable(R.drawable.icon_tab));
		Intent monthsIntent = new Intent(this, MonthListActivity.class);
		month_tab.setContent(monthsIntent);
		
		//Year list
		TabSpec year_tab = tabHost.newTabSpec("Year");
		year_tab.setIndicator("Year", getResources().getDrawable(R.drawable.icon_tab));
		Intent yearsIntent = new Intent(this, YearListActivity.class);
		year_tab.setContent(yearsIntent);
		
		tabHost.addTab(day_tab);
		tabHost.addTab(month_tab);
		tabHost.addTab(year_tab);
		
	}	
}
