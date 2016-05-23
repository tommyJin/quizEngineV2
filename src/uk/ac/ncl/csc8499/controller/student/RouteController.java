package uk.ac.ncl.csc8499.controller.student;

import com.jfinal.ext.route.ControllerBind;
import uk.ac.ncl.csc8499.controller.BaseController;

/**
 * Created by tommy on 2016/5/19.
 */
@ControllerBind(controllerKey = "/student/route")
public class RouteController extends BaseController {
    public void index(){
        render("index.html");
    }

    public void user(){
        render("user.html");
    }
}
