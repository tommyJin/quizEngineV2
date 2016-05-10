package uk.ac.ncl.csc8499.controller.teacher;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
import uk.ac.ncl.csc8499.Util.FormatValidate;
import uk.ac.ncl.csc8499.Util.RestResult;
import uk.ac.ncl.csc8499.model.ConstantParas;
import uk.ac.ncl.csc8499.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tommy on 2016/5/9.
 */
@ControllerBind(controllerKey = "/teacher/user")
public class UserController extends Controller {
    public void index(){
        Integer type = Integer.valueOf(getPara("type").toString().trim());
        String keyword = getPara("keyword")==null?null:getPara("keyword").trim();
        String orderby = getPara("orderby")==null?null:getPara("orderby").trim();
        Map<String,Object> filter = new HashMap<>();
        if (type!= ConstantParas.usertype_null) {
            filter.put("type",type);
        }
        filter.put("keyword",keyword);
        filter.put("orderby",orderby);

        renderJson(RestResult.ok(User.dao.query(filter)));
    }

    public void add(){
        User user = getModel(User.class,"user");
        String errormsg= "";
        boolean flag = true;
        if (user.get("username")==null || user.get("username").toString().trim().equals("")){
            flag = false;
            errormsg += ConstantParas.hint_username_null+" ";
        }
        if (user.get("password")==null || user.get("password").toString().trim().equals("")){
            flag = false;
            errormsg += ConstantParas.hint_password_null+" ";
        }
        if ( user.get("name")==null || user.get("name").toString().trim().equals("")){
            flag = false;
            errormsg += ConstantParas.hint_name_null+" ";
        }

        if (user.get("email")!=null && !user.get("email").toString().trim().equals("")){
            String email = user.get("email");
            if (FormatValidate.emailValidate(email)){
                flag = false;
                errormsg += ConstantParas.error_wrong_email_format+" ";
            }
        }

        Map<String,Object> filter = new HashMap<>();
        filter.put("username",user.get("username")==null?null:user.get("username").toString().trim());
        if (flag) {
            if (User.dao.getBy(filter)==null) {
                if (User.dao.add(user)) {
                    renderJson(RestResult.ok(ConstantParas.success_add));
                } else {
                    renderJson(RestResult.error(ConstantParas.failure_add));
                }
            }else {
                renderJson(RestResult.error(ConstantParas.error_username_exists));
            }
        }else {
            renderJson(RestResult.error(errormsg));
        }
    }

    public void get(){
        Long id = getPara("id")==null?0:getParaToLong("id");
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        User user = User.dao.getBy(filter);
        if (user!=null){
            renderJson(RestResult.ok(user));
        }else {
            renderJson(RestResult.error(ConstantParas.error_username_not_exist));
        }
    }

    public void update(){
        User user = getModel(User.class,"user");
        Long id = user.get("id")==null?0:Long.parseLong(user.get("id").toString());
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        if (User.dao.getBy(filter)!=null){
            boolean flag = true;
            if (user.get("email")!=null && !user.get("email").toString().trim().equals("")){
                String email = user.get("email");
                if (FormatValidate.emailValidate(email)){
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

    public void delete(){
        Long id = getPara("id")==null?0:getParaToLong("id");
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        User user = User.dao.getBy(filter);
        if (user!=null){
            if (User.dao.delete(user)){
                renderJson(RestResult.ok(ConstantParas.success_delete));
            }else {
                renderJson(RestResult.error(ConstantParas.failure_delete));
            }
        }else {
            renderJson(RestResult.error(ConstantParas.error_username_not_exist));
        }
    }
}
