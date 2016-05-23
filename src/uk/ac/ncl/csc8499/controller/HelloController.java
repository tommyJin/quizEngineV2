package uk.ac.ncl.csc8499.controller;

import com.google.gson.Gson;
import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ncl.csc8499.Util.RestResult;
import uk.ac.ncl.csc8499.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tommy on 2016/5/8.
 */
@ControllerBind(controllerKey = "/")
public class HelloController extends Controller {
    static final Logger logger = LoggerFactory.getLogger(HelloController.class);
    static final String tag = "hello";
    Gson gson = new Gson();

    public void abc(){
        render("abc.html");
    }

    public void hello(){
        List<User> users = User.dao.find("select * from user");
        logger.info("users:{},size={}",users,users.size());
        renderJson(RestResult.ok(users));
    }

    public void query(){
        Map<String,Object> map = new HashMap<>();

        String s = " [{\"id\": 1,\"author\": \"Pete Hunt\",\"text\": \"This is one comment\"},{\"id\": 2,\"author\": \"Jordan Walke\",\"text\": \"This is *another* comment\"}]";
        renderJson(s);
    }


}
