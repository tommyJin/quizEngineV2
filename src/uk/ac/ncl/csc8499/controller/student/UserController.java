package uk.ac.ncl.csc8499.controller.student;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
import uk.ac.ncl.csc8499.Util.FormatValidate;
import uk.ac.ncl.csc8499.Util.RestResult;
import uk.ac.ncl.csc8499.controller.BaseController;
import uk.ac.ncl.csc8499.model.ConstantParas;
import uk.ac.ncl.csc8499.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tommy on 2016/5/10.
 */
@ControllerBind(controllerKey = "/student/user")
public class UserController extends BaseController {
    public void get(){
        Long id = getPara("id")==null?0:getParaToLong("id");
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        filter.put("type",ConstantParas.usertype_student);
        User user = User.dao.getBy(filter);
        if (user!=null){
            renderJson(RestResult.ok(user));
        }else {
            renderJson(RestResult.error(ConstantParas.error_username_not_exist));
        }
    }

    public void update(){
        User user = getModel(User.class,"paras");
        Long id = user.get("id")==null?0:Long.parseLong(user.get("id").toString());
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        if (User.dao.getBy(filter)!=null){
            boolean flag = true;
            if (user.get("email")!=null && !user.get("email").toString().trim().equals("")){
                String email = user.get("email");
                if (!FormatValidate.emailValidate(email)){
                    flag = false;
                    renderJson(RestResult.error(ConstantParas.error_wrong_email_format));
                }
            }
            if (flag) {
                if (User.dao.update(user)) {
                    renderJson(RestResult.ok(ConstantParas.success_update));
                } else {
                    renderJson(RestResult.error(ConstantParas.failure_update));
                }
            }
        }else {
            renderJson(RestResult.error(ConstantParas.error_username_not_exist));
        }
    }
}
