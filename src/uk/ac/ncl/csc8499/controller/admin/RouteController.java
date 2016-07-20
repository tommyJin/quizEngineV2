package uk.ac.ncl.csc8499.controller.admin;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
import uk.ac.ncl.csc8499.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tommy on 2016/5/19.
 */
@ControllerBind(controllerKey = "/admin/route")
public class RouteController extends Controller {
    public void index(){
        render("index.html");
    }

    public void user(){
        render("user.html");
    }

    public void user_add(){
        render("user_detail.html");
    }

    public void user_detail(){
        Long id = getPara("id")==null?null:getParaToLong("id");
        setAttr("id",id);
        render("user_detail.html");
    }

    public void category(){
        render("category.html");
    }

    public void category_detail(){
        Long id = getPara("id")==null?null:getParaToLong("id");
        setAttr("id",id);
        render("category_detail.html");
    }
}
