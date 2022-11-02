package com.example.ticketnow;

import com.example.ticketnow.Util.Util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UtilUnitTest {
    //check email is not null and valid
    @Test
    public void emailValidationSuccessTest() {
        boolean actual = Util.EmailValidation("test@gmail.com");
        boolean expected = true;
        assertEquals("Valid Email", expected, actual);
    }

    @Test
    public void emailValidationFailTest() {
        boolean actual = Util.EmailValidation("test.com");
        boolean expected = false;
        assertEquals("InValid Email", expected, actual);
    }

    //check nic is not null and valid
    @Test
    public void nicNewValidationSuccessTest() {
        boolean actual = Util.EmailValidation("200102402806");
        boolean expected = true;
        assertEquals("Valid NIC", expected, actual);
    }

    @Test
    public void nicOldValidationFailTest() {
        boolean actual = Util.EmailValidation("444444444V");
        boolean expected = true;
        assertEquals("InValid NIC", expected, actual);
    }

    @Test
    public void nicValidationFailTest() {
        boolean actual = Util.EmailValidation("vjglig");
        boolean expected = false;
        assertEquals("InValid NIC", expected, actual);
    }

    //check mobile Number is not null and valid
    @Test
    public void mobileNumberValidationSuccessTest() {
        boolean actual = Util.mobileNumberValidation("768523525");
        boolean expected = true;
        assertEquals("Valid Mobile Number", expected, actual);
    }

    @Test
    public void mobileNumberValidationFailTest() {
        boolean actual = Util.mobileNumberValidation("rgfaig");
        boolean expected = false;
        assertEquals("InValid Mobile Number", expected, actual);
    }

}
