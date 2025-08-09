package com.example.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import com.example.domain.Purchase;


@Repository
public class PurchaseDaoImpl implements PurchaseDao {

	private @Autowired JdbcClient jdbcClient;

	@Override
	public List<Purchase> getAllPurchases() {
		String sql = "SELECT * FROM PURCHASE";
		//return null;
		return jdbcClient
			.sql(sql)
			.query(Purchase.class)
			.list();
	}


	@Override
	public Purchase getPurchase(int id) {
		String sql = "SELECT * FROM PURCHASE WHERE ID = ?";
		// Add code here
		return jdbcClient
			.sql(sql)
			.param(id)
			.query(Purchase.class)
			.single();
	}

	@Override
	public void savePurchase(Purchase purchase) {
		String sql = "insert into PURCHASE (CUSTOMERNAME, PRODUCT, PURCHASEDATE) values(?,?,?)";
		jdbcClient
			.sql(sql)
			.param(purchase.getCustomerName())
			.param(purchase.getProduct())
			.param(purchase.getPurchaseDate())
			.update();	
	}


	@Override
	public Purchase getPurchase(String name, Date date) {
		String sql = "SELECT * FROM PURCHASE WHERE CUSTOMERNAME = ? and PURCHASEDATE = ?";
		return jdbcClient
			.sql(sql)
			.param(name)
			.param(date)
			.query(Purchase.class)
			.single();
	}


}
