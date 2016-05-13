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
}
