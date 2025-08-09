package com.example.dao;

import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.example.Config;
import com.example.domain.Purchase;



@SpringJUnitConfig(Config.class)
public class PurchaseDaoImplTests {

	@Autowired PurchaseDao dao;
    @Test
    public void	getAllPurchases() {
        dao.getAllPurchases();
    }

    @Test
    public void	getPurchase() {
        dao.getPurchase(2);
    }

    @Test
    public void	savePurchase() {
        Purchase p = new Purchase();
        p.setCustomerName("Sample");
        p.setProduct("Sample Product");
        p.setPurchaseDate( new Date());

        dao.savePurchase(p);
    }

}
