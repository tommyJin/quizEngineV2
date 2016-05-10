package uk.ac.ncl.csc8499.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tommy on 2016/5/9.
 */
public class FormatValidate {
    public static boolean emailValidate(String email){
        boolean flag = false;
        try{
            String format = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern p = Pattern.compile(format);
            Matcher m = p.matcher(email);
            flag = m.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }
}
