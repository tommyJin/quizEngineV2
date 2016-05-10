package uk.ac.ncl.csc8499.config;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import uk.ac.ncl.csc8499.model.User;

import java.util.Map;

/**
 * Created by tommy on 2016/5/8.
 */
public class LoginInterceptor implements Interceptor {

    @Override
    public void intercept(Invocation ai) {
        String ck = ai.getControllerKey();
        Controller controller = ai.getController();

        String author = controller.getSessionAttr("author");
        System.out.println(ai.getControllerKey()+","+author);
        if (author==null||author.equals("")){
            controller.setSessionAttr("author","notlogin");
        }
        User u = controller.getSessionAttr("login_user");
        if (u!=null){
            System.out.println("oooo");
            ai.getController().setAttr("username",u.get("username").toString());
            ai.getController().setAttr("author",u.get("author").toString());
        }
        else {
            System.out.println("xxxx");
        }
        //�жϷ��ʵ��Ƿ�Ϊuser��ͷ����admin��ͷ�ķ���
        if (!ck.startsWith("/login") && !ck.startsWith("/register")){
            if ( u != null ) {
                //�жϵ�½�û����ʵ����Լ�Ȩ�޴�ͷ�ķ���
                if ((ck.startsWith("/admin") && u.getStr("author").equals("admin"))) {
                    ai.invoke();//continue
                } else if ( !ck.startsWith("/admin")){
                    ai.invoke();
                } else {
                    System.out.println("��Ҫ���µ�¼");
                    ai.getController().redirect("/login");//error redirect
                }
            }else {
                System.out.println("��Ҫ���µ�¼");
                ai.getController().redirect("/login");//error redirect
            }
        }
        else {
            ai.invoke();
        }

    }
}
