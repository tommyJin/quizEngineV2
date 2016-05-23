package uk.ac.ncl.csc8499.controller.admin;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;

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
}
