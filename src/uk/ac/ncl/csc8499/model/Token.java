package uk.ac.ncl.csc8499.model;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.jfinal.plugin.activerecord.Model;
import sun.security.provider.MD5;
import uk.ac.ncl.csc8499.Util.Encrypt;

import java.util.Map;
import java.util.Random;

/**
 * Created by tommy on 2016/5/26.
 */
@TableBind(tableName = TableName.token)
public class Token extends Model<Token> {
    public static final Token dao = new Token();

    public String generate(Map<String,Object> map){
        String token_str = "";

        String user_id = map.get("user_id").toString();
        String username = map.get("username").toString();
        String nonStr = nonStr(10);
        long current = System.currentTimeMillis();
        long expire = current+ 60*60*24*1000;//expire timestamp
        String unMD5 = user_id+";"+username+";"+nonStr+";"+current;
        token_str = Encrypt.MD5(unMD5);

        Token token = new Token();
        token.set("user_id",user_id);
        token.set("token",token_str);
        token.set("created",current);
        token.set("modified",current);
        token.set("expire",expire);
        token.set("isDeleted",ConstantParas.isDeleted_false);

        Token.dao.add(token);

        return token_str;
    }

    public Token getBy(Map<String,Object> filter){
        String select = "select t.*,u.username,u.type,u.name ";
        String where = " from "+TableName.token+" t,"+TableName.user+" u  where 1=1 and t.isDeleted = "+ConstantParas.isDeleted_false+" and t.user_id=u.id ";
        if (filter.get("user_id")!=null){
            where += " and t.user_id = "+Integer.parseInt(filter.get("user_id").toString());
        }
        if (filter.get("token")!=null && !filter.get("token").toString().equals("")){
            where += " and t.token = '"+filter.get("token").toString()+"' ";
        }
        if (filter.get("expire")!=null && !filter.get("expire").toString().equals("")){
            where += " and t.expire > "+Long.parseLong(filter.get("expire").toString())+" ";
        }
        String orderby = "order by t.expire desc limit 1";
        if (!where.equals(" from "+TableName.token+" t,"+TableName.user+" u  where 1=1 and t.isDeleted = "+ConstantParas.isDeleted_false+" and t.user_id=u.id ")){

            return Token.dao.find(select + where + orderby).size()>0?Token.dao.find(select + where + orderby).get(0):null;
        }else {
            return null;
        }
    }

    public boolean add(Token token){
        return token.save();
    }

    public boolean update(Map<String,Object> filter){
        String token = filter.get("token").toString();
        long current = System.currentTimeMillis();
        filter.clear();
        filter.put("token",token);
        filter.put("expire",current);
        Token pre = getBy(filter);
        if (pre!=null){
            pre.set("modified",current);
            pre.set("expire",current+60*60*24*1000);
            return pre.update();
        }else {
            return false;
        }
    }


    public String nonStr(int length){
        String nonStr = "";
        String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int num = random.nextInt(s.length());
            nonStr += s.charAt(num);
        }
        return nonStr;
    }

}
