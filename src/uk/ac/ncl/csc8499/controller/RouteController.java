package uk.ac.ncl.csc8499.controller;

import com.jfinal.ext.route.ControllerBind;

/**
 * Created by tommy on 2016/5/23.
 */
@ControllerBind(controllerKey = "/route")
public class RouteController extends BaseController {
    public void login(){
        render("login.html");
    }
}
