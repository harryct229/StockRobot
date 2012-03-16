package com.stockrobot.model;


public class Stock {

	public String id;
	public String date;
	public float openPrice;
	public float closePrice;
	public float lowPrice;
	public float highPrice;
	public float volume;

	public Stock(String id, String date, float openPrice, float closePrice,
			float lowPrice, float highPrice, float volume) {
		this.id = id;
		this.date = date;
		this.openPrice = openPrice;
		this.closePrice = closePrice;
		this.lowPrice = lowPrice;
		this.highPrice = highPrice;
		this.volume = volume;
	}

}
