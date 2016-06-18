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
            Integer user_id = ai.getController().getPara("id")==null?null:ai.getController().getParaToInt("id");
            String token_str = ai.getController().getPara("token");
            Map<String,Object> filter = new HashMap<>();
            filter.put("user_id",user_id);
            filter.put("token",token_str);
            filter.put("expire",System.currentTimeMillis());
            System.out.println("token filter map="+filter);
            if (user_id==null || token_str==null){
                System.out.println("Token or id is null!");
                ai.getController().redirect("/token/tokenInvalid");//error redirect
            }
            else {
                Token token = Token.dao.getBy(filter);
                if (token != null) {
                    System.out.println("Token is valid!");
                    System.out.println("Token:" + token);
                    ai.invoke();
                } else {
                    System.out.println("Token is invalid!");
                    ai.getController().redirect("/token/tokenInvalid");//error redirect
                }
            }
        }else {
            ai.invoke();
        }
    }
}
