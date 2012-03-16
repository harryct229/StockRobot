package com.stockrobot.model;

public class Company {
	public String id;
	public String name;
	public String industry;
	public String year;
	public String exchange;
	public String fund;
	public String info;

	public Company(String id, String name, String industry, String year,
			String exchange, String fund, String info) {
		this.id = id;
		this.name = name;
		this.industry = industry;
		this.year = year;
		this.exchange = exchange;
		this.fund = fund;
		this.info = info;
	}

	// =============================================================
	// Method
	// =============================================================
	public String getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getIndustry() {
		return industry;
	}

	public String getYear() {
		return year;
	}

	public String getExchange() {
		return exchange;
	}

	public String getfund() {
		return fund;
	}

	public String getInfo() {
		return info;
	}

}
