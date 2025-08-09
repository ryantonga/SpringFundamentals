package com.example.service.mockito;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.service.Register;
import com.example.service.TaxCalculator;

//  DONE-05: (OPTIONAL) If our objects are true POJOs, we should 
//  be able to test them without any using the Spring framework.
//  Annotate this class as a Mockito test class.
//  You will need to use the JUnit @ExtendWith annotation combined with the MockitoExtension class.
//  This test will use Java, JUnit, Mockito, and AssertJ.  It will not use Spring.
@ExtendWith(MockitoExtension.class)
public class MockitoRegisterTests {

    //	DONE-06: (OPTIONAL) Define a variable called taxCalculator of type TaxCalculator.
    //  Annotate this variable with @Mock.
	@Mock TaxCalculator taxCalculator;


    //  DONE-07: (OPTIONAL) Define a variable called register of type Register.
    //  Annotate this variable with @InjectMocks.  This tells Mockito to inject it with the mock purchaseDao.
	@InjectMocks Register register;

    @Test
    public void testRegister() {
        //  DONE-08: (OPTIONAL)  Use Mockito's when() method to program the mock.
        //  When the taxCalculator.calculateTax() method is called
        //  with any double argument, then return 7.0.
    	when(taxCalculator.calculateTax(anyDouble())).thenReturn(7.0);

        //  DONE-09: (OPTIONAL)  Call the method under test (computeTotal)
        //  on the register object.  Pass in a value of 100.
        //  Store the results in a double variable.
    	double result = register.computeTotal(100);

        //  DONE-10: (OPTIONAL)  Use AssertJ to verify the result.
        //  Assert that the result is equal to 100.00 + 7.0.
    	assertThat(result).isEqualTo(100.00 + 7.0);

        //  DONE-11: (OPTIONAL)  Verify that the mock had its calculateTax() method called.
        //  Use Mockito's verify() method.  Your mock object is the parameter to this method.
        //  (For some tests, verifying the mock behavior is critical; for this test it is trivial.)
    	verify(taxCalculator).calculateTax(anyDouble());
    }
}
