package uk.ac.ncl.csc8499.config;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * Created by tommy on 2016/5/8.
 */
public class AllInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation ai) {
        if(ai.getControllerKey().startsWith("/user")){
            ai.invoke();
        }else {
            if (ai.getController().getSessionAttr("id") != null) {
                ai.getController().setAttr("user_id", ai.getController().getSessionAttr("id"));
                ai.getController().setAttr("username", ai.getController().getSessionAttr("username"));
            }
            ai.invoke();
        }
    }

}
