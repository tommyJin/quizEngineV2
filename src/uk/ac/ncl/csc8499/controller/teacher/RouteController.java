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

    public void question_detail(){
        Long id = getPara("id")==null?null:getParaToLong("id");
        setAttr("id",id);
        render("question_detail.html");
    }

    public void category(){
        render("category.html");
    }

    public void category_detail(){
        Long id = getPara("id")==null?null:getParaToLong("id");
        setAttr("id",id);
        render("category_detail.html");
    }

    public void topic(){
        render("topic.html");
    }

    public void topic_detail(){
        Long id = getPara("id")==null?null:getParaToLong("id");
        setAttr("id",id);
        render("topic_detail.html");
    }

    public void level(){
        render("level.html");
    }

    public void level_detail(){
        Long id = getPara("id")==null?null:getParaToLong("id");
        setAttr("id",id);
        render("level_detail.html");
    }
    public void quiz(){
        render("quiz.html");
    }

    public void quiz_detail(){
        Long id = getPara("id")==null?null:getParaToLong("id");
        setAttr("id",id);
        render("quiz_detail.html");
    }

    public void user(){
        render("user.html");
    }

    public void user_detail(){
        Long id = getPara("id")==null?null:getParaToLong("id");
        setAttr("id",id);
        setAttr("user_id",getCurrentUser().get("id"));
        render("user_detail.html");
    }
}
