package uk.ac.ncl.csc8499.controller.teacher;

import com.jfinal.ext.route.ControllerBind;
import uk.ac.ncl.csc8499.controller.BaseController;

/**
 * Created by tommy on 2016/5/19.
 */
@ControllerBind(controllerKey = "/teacher/route")
public class RouteController extends BaseController {
    public void index(){
        render("index.html");
    }

    public void question(){
        render("question.html");
    }

    public void quiz(){
        render("quiz.html");
    }

    public void user(){
        render("user.html");
    }
}
