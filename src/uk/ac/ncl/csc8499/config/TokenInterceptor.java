package uk.ac.ncl.csc8499.config;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import uk.ac.ncl.csc8499.model.Token;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tommy on 2016/5/27.
 */
public class TokenInterceptor implements Interceptor {

    @Override
    public void intercept(Invocation ai) {
        if (ai.getControllerKey().startsWith("/student")){
            String token_str = ai.getController().getPara("token");
            Map<String,Object> filter = new HashMap<>();
            filter.put("token",token_str);
            filter.put("expire",System.currentTimeMillis());
            Token token = Token.dao.getBy(filter);
            if (token!=null && token.get("type").toString().equals("2")){
                System.out.println("Token is valid!");
                System.out.println("Token:"+token);
                ai.invoke();
            }else {
                System.out.println("Token is invalid!");
                ai.getController().redirect("/token/tokenInvalid");//error redirect
            }
        }else {
            ai.invoke();
        }
    }
}
