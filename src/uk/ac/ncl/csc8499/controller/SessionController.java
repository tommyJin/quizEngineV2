package uk.ac.ncl.csc8499.controller;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ncl.csc8499.Util.FormatValidate;
import uk.ac.ncl.csc8499.Util.RestResult;
import uk.ac.ncl.csc8499.model.ConstantParas;
import uk.ac.ncl.csc8499.model.Token;
import uk.ac.ncl.csc8499.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tommy on 2016/5/9.
 */
@ControllerBind(controllerKey = "/session")
public class SessionController extends Controller {
    static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    static final String tag = "session";

    public void index(){
        renderJson(RestResult.error(ConstantParas.hint_user_not_login));
    }

    public void login() {
        Map<String, Object> filter = new HashMap<String, Object>();
        String username = getPara("username")==null?null:getPara("username").trim();
        String password = getPara("password")==null?null:getPara("password").trim();
        String errormsg = "";
        boolean flag = true;
        if (username == null || username.equals("")) {
            flag = false;
            errormsg += ConstantParas.hint_username_null+" ";
        }
        if (password == null || password.equals("")) {
            flag = false;
            errormsg += ConstantParas.hint_password_null+" ";
        }
        if (flag) {
            filter.put("username",username);
            if (User.dao.getBy(filter)==null){
                flag = false;
                errormsg += ConstantParas.error_username_not_exist;
            }
            User user = new User();
            if (flag) {
                user = User.dao.login(username, password);
                if (user != null) {
                    errormsg += ConstantParas.success_login;
                    Map<String,Object> usermap = new HashMap<String, Object>();

                    usermap.put("user_id",user.get("id"));
                    usermap.put("username",user.get("username"));
                    usermap.put("name",user.get("name"));
                    Integer type = user.get("type");
                    usermap.put("type",type);
                    if (type==1){
                        usermap.put("user_type","admin");
                    }else if (type==2){
                        usermap.put("user_type","teacher");
                    }else if (type==3){
                        usermap.put("user_type","student");
                    }

                    setSessionAttr("login_user", usermap);
                    setSessionAttr("user",user);
                } else {
                    flag = false;
                    errormsg += ConstantParas.error_wrong_password;
                }
            }

            filter.clear();
            filter.put("errormsg", errormsg);
            filter.put("user", user);
            if(flag) {
                renderJson(RestResult.ok(filter));
            }else {
                renderJson(RestResult.error(filter));
            }
        }
    }

    public void student_login(){
        Map<String, Object> filter = new HashMap<String, Object>();
        Map<String,Object> usermap = new HashMap<String, Object>();

        String username = getPara("username")==null?null:getPara("username").trim();
        String password = getPara("password")==null?null:getPara("password").trim();
        String errormsg = "";
        boolean flag = true;
        if (username == null || username.equals("")) {
            flag = false;
            errormsg += ConstantParas.hint_username_null+" ";
        }
        if (password == null || password.equals("")) {
            flag = false;
            errormsg += ConstantParas.hint_password_null+" ";
        }
        if (flag) {
            filter.put("username",username);
            filter.put("type",ConstantParas.usertype_student);
            if (User.dao.getBy(filter)==null){
                flag = false;
                errormsg += ConstantParas.error_username_not_exist;
            }
            User user = new User();
            if (flag) {
                user = User.dao.login(username, password);
                if (user != null) {
                    errormsg += ConstantParas.success_login;

                    filter.clear();
                    filter.put("user_id",user.get("id"));
                    filter.put("username",user.get("username"));
                    String token = Token.dao.generate(filter);


                    usermap.put("id",user.get("id"));
                    usermap.put("username",user.get("username"));
                    usermap.put("name",user.get("name"));
                    Integer type = user.get("type");
                    usermap.put("type",type);
                    if (type==1){
                        usermap.put("user_type","admin");
                    }else if (type==2){
                        usermap.put("user_type","teacher");
                    }else if (type==3){
                        usermap.put("user_type","student");
                    }
                    usermap.put("token",token);

                } else {
                    flag = false;
                    errormsg += ConstantParas.error_wrong_password;
                }
            }

            filter.clear();
            filter.put("errormsg", errormsg);
            if(flag) {
                renderJson(RestResult.ok(usermap));
            }else {
                renderJson(RestResult.error(filter));
            }
        }
    }

    public void register(){
        Map<String, Object> filter = new HashMap<String, Object>();
        String username = getPara("username")==null?null:getPara("username").trim();
        String name = getPara("name")==null?null:getPara("name").trim();
        String email = getPara("email")==null?null:getPara("email").trim();
        String password = getPara("password")==null?null:getPara("password").trim();
        String repassword = getPara("repassword")==null?null:getPara("repassword").trim();
        String errormsg = "";
        boolean flag = true;
        if (username == null || username.equals("")) {
            flag = false;
            errormsg += ConstantParas.hint_username_null+" ";
        }
        if (name == null || name.equals("")) {
            flag = false;
            errormsg += ConstantParas.hint_name_null+" ";
        }
        if (email == null || email.equals("")) {
            flag = false;
            errormsg += ConstantParas.hint_email_null+" ";
        }else if (!FormatValidate.emailValidate(email)){
            flag = false;
            errormsg += ConstantParas.error_wrong_email_format+" ";
        }
        if (password == null || password.equals("")) {
            flag = false;
            errormsg += ConstantParas.hint_password_null+" ";
        }
        if (repassword == null || repassword.equals("")) {
            flag = false;
            errormsg += ConstantParas.hint_repassword_null+" ";
        }else if (!password.equals(repassword)){
            flag = false;
            errormsg += ConstantParas.error_confirm_password_does_not_match+" ";
        }
        User user = new User();
        filter.put("username",username);
        logger.info("flag:{},user:{}",flag,User.dao.getBy(filter));
        if (flag && User.dao.getBy(filter)!=null){
            System.out.println("exist");
            flag = false;
            errormsg += ConstantParas.error_username_exists+" ";
        }
        System.out.println(flag);
        if (flag){
            user.set("username",username);
            user.set("password", password);
            user.set("name",name);
            if (User.dao.add(user)){
                errormsg = ConstantParas.success_add;
            }else {
                errormsg = ConstantParas.failure_add;
            }
        }
        if (flag){
            renderJson(RestResult.ok(errormsg));
        }else {
            renderJson(RestResult.error(errormsg));
        }
    }

    public void forget(){
        Map<String, Object> filter = new HashMap<String, Object>();
        String username = getPara("username")==null?null:getPara("username").trim();
        String errormsg = "";
        boolean flag = true;
        if (username == null || username.equals("")) {
            flag = false;
            errormsg += ConstantParas.hint_username_null+" ";
        }

        filter.put("username",username);
        User user = User.dao.getBy(filter);
        if (user!=null && flag){
            errormsg += ConstantParas.success_send_email+" Please check your email: "+username;
            renderJson(RestResult.ok(errormsg));
        }else {
            errormsg += ConstantParas.error_username_not_exist;
            renderJson(RestResult.error(errormsg));
        }
    }

    public void logout(){
        removeSessionAttr("login_user");
        renderJson(RestResult.ok(ConstantParas.success_logout));
    }

}
