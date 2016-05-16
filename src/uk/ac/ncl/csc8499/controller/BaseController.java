package uk.ac.ncl.csc8499.controller;

import com.jfinal.core.Controller;
import uk.ac.ncl.csc8499.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tommy on 2016/5/16.
 */
public class BaseController extends Controller {
    public User getCurrentUser() {
        Map map = getSessionAttr("login_user");
        System.out.println(map);
        if (map != null) {
            Map<String,Object> filter = new HashMap<>();
            filter.put("id",map.get("user_id"));
            User user = User.dao.getBy(filter);
            System.out.println("User in session,user_id="+user.get("id"));
            return user;
        }else {
            return null;
        }
    }
}
