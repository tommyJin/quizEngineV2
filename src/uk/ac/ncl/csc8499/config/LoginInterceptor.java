package uk.ac.ncl.csc8499.config;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import uk.ac.ncl.csc8499.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tommy on 2016/5/8.
 */
public class LoginInterceptor implements Interceptor {

    @Override
    public void intercept(Invocation ai) {
        String ck = ai.getControllerKey();
        Controller controller = ai.getController();

        Map<String,Object> map = controller.getSessionAttr("login_user");
        User u = null;
        if (map!=null){
            Map<String,Object> filter = new HashMap<>();
            filter.put("username",map.get("username"));
            filter.put("id",map.get("user_id"));
            u = User.dao.getBy(filter);
        }

        String author = controller.getSessionAttr("user_type");
        System.out.println(ai.getControllerKey()+","+author);
        if (author==null||author.equals("")){
            controller.setSessionAttr("author","notlogin");
        }
        if (u!=null){
            System.out.println("oooo");
            ai.getController().setAttr("username",u.get("username").toString());
            ai.getController().setAttr("type",u.get("type").toString());
        }
        else {
            System.out.println("xxxx");
        }


        if(ck.startsWith("/teacher")||ck.startsWith("/admin")) {
            if (u != null ) {
                String type = u.get("type").toString();
                if (type.equals("1")){
                    type = "admin";
                }else if (type.equals("2")){
                    type = "teacher";
                }else if (type.equals("3")){
                    type = "student";
                }
                System.out.println("");
                if ((ck.startsWith("/admin") && type.equals("admin"))) {
                    ai.invoke();//continue
                }else if ((ck.startsWith("/teacher") && type.equals("teacher"))) {
                    ai.invoke();//continue
                }
//                else if ((ck.startsWith("/student") && type.equals("student"))) {
//                    ai.invoke();//continue
//                }
                else if ( !ck.startsWith("/admin") && !ck.startsWith("/teacher")){
                    ai.invoke();
                } else {
                    System.out.println("You need to login!");
                    ai.getController().redirect("/route/login");//error redirect
                }
            }else if (u==null && ( ck.startsWith("/admin") || ck.startsWith("/teacher")  ) ){
                ai.getController().redirect("/route/login");
            }else {
                ai.getController().redirect("/route/login");
            }
        }
        else ai.invoke();

    }
}
