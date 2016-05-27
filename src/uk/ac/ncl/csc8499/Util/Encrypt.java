package uk.ac.ncl.csc8499.Util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by tommy on 2016/5/26.
 */
public class Encrypt {
    public static String MD5(String unEncrypt){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(unEncrypt.getBytes());
        return new BigInteger(1, md.digest()).toString(16);
    }
}
