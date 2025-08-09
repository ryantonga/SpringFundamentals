//Some optionals
package com.example.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.dao.PurchaseDao;
import com.example.domain.Purchase;

@ExtendWith(MockitoExtension.class)
public class PurchaseServiceImplTests {

	@Mock PurchaseDao purchaseDao;


	 @InjectMocks PurchaseServiceImpl purchaseService;    
	 
    @Test
    public void testFindAllPurchases() {
        List<Purchase> expectedPurchases = expectedPurchases();

		when(purchaseDao.getAllPurchases()).thenReturn(expectedPurchases);
        

		List<Purchase> result = purchaseService.findAllPurchases();

		assertThat(result).containsExactlyElementsOf(expectedPurchases);

		verify(purchaseDao).getAllPurchases();

    }

    private List<Purchase> expectedPurchases() {
        return  List.of(
            new Purchase(1, "Praveen", new Date(), "lava lamp"),
            new Purchase(2, "Srinivas", new Date(), "badmitton set"),
            new Purchase(3, "Ramachandran", new Date(), "parachute retainer clip"),
            new Purchase(4, "Sunil", new Date(), "scuba regulator")
        );
    }

}
