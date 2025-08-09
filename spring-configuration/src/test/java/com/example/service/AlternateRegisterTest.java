
package com.example.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.AlternateConfig;

class AlternateRegisterTest {

    private static Register register;

    @BeforeAll
    static void setup() {

        //  TODO-16: (OPTIONAL) Use System.setProperty to set 
        //  the "spring.profiles.active" property to "alternate".
        //  This Java System Property will activate the "alternate" profile.
        System.setProperty("spring.profiles.active", "alternate");

        //  TODO-17: (OPTIONAL) Instantiate the ApplicationContext using AnnotationConfigApplicationContext.
        //  (Reference the code you just completed in App.java or RegisterTest.java for guidance.)
        //  Get the Register bean from the ApplicationContext.
        //  Assign the Register bean to the static field.
        ApplicationContext spring =
                new AnnotationConfigApplicationContext(AlternateConfig.class);
        register = spring.getBean(Register.class);
    }

    //  TODO-18: (OPTIONAL) Write a @Test method to verify the computeTotal method.
    //  Use your previous test method as a guide.  However,
    //  adjust the logic to assert the total based on the configured tax.rate.
    @Test
    void testRegister() {
        Assertions.assertThat(
                register.computeTotal(100)).isEqualTo(100.00 + 6.00);
    }

    //  TODO-19: (OPTIONAL) Organize your imports, save your work.  Run the test, it should pass.

}
