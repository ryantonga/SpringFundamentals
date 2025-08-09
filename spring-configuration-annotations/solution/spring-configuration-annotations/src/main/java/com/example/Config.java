package com.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration   
@PropertySource("classpath:app.properties")
@ComponentScan(basePackages = "com.example.service")
public class Config {

    //  DONE-02: Comment out the @Bean definitions in this class (below).
    //  Re-run the previous test.  It should fail.  Do you understand why?

//    @Bean
//    public SalesTaxCalculator taxCalculator(@Value("${tax.rate}") double taxRate) {
//        return new SalesTaxCalculator(taxRate);
//    }
//
//    @Bean
//    public Register register(TaxCalculator taxCalculator) {
//        return new Register(taxCalculator);
//    }

    //  DONE-03:  Add a @ComponentScan annotation to this class.
    //  Set the basePackages attribute to reference the service package.
    //  Organize your imports, save your work.

}
