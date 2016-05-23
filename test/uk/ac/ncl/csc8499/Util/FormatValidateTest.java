package uk.ac.ncl.csc8499.Util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tommy on 2016/5/23.
 */
public class FormatValidateTest {

    @Test
    public void testEmailValidate() throws Exception {
        String[] emails ={ "tea1@gmail.com" };

        for (int i = 0; i < emails.length; i++) {
            System.out.println(FormatValidate.emailValidate(emails[i]));
        }
    }
}