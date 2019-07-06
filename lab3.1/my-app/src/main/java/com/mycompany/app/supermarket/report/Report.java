package com.mycompany.app.supermarket.report;

import com.mycompany.app.supermarket.cashdesk.bill.Bill;

import java.util.List;

public class Report implements IReport{
	public void create(List<Bill> bills) {
		System.out.println("REPORT: ");
		for (int i = 0; i < bills.size(); ++i) {
			bills.get(i).showInfo();
		}
	}
}
