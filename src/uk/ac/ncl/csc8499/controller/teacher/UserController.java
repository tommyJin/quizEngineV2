package uk.ac.ncl.csc8499.controller.teacher;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
import uk.ac.ncl.csc8499.Util.FormatValidate;
import uk.ac.ncl.csc8499.Util.RestResult;
import uk.ac.ncl.csc8499.controller.BaseController;
import uk.ac.ncl.csc8499.model.Category_user;
import uk.ac.ncl.csc8499.model.ConstantParas;
import uk.ac.ncl.csc8499.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tommy on 2016/5/9.
 */
@ControllerBind(controllerKey = "/teacher/user")
public class UserController extends BaseController {
    public void index(){
        User user = getCurrentUser();
        Map<String, Object> filter = new HashMap<>();
        filter.put("user_id", user.get("id"));
        List<Category_user> cus = Category_user.dao.query(filter);
        if (cus.size() > 0) {
            int page = getPara("page") == null ? ConstantParas.page : getParaToInt("page");
            int size = getPara("size") == null ? ConstantParas.size : getParaToInt("size");
            filter.put("page", page);
            filter.put("size", size);
            String keyword = getPara("keyword") == null ? null : getPara("keyword").trim();
            String orderby = getPara("orderby") == null ? null : getPara("orderby").trim();
            filter.put("keyword", keyword);
            filter.put("orderby", orderby);

            renderJson(RestResult.ok(User.dao.queryForTeacher(filter)));
        }else {
            renderJson(RestResult.error(null));
        }
    }

    public void get(){
        Long id = getPara("id")==null?0:getParaToLong("id");
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        User user = User.dao.getBy(filter);
        if (user!=null){
            Map<String,Object> map = new HashMap<>();
            map.put("user_id",user.get("id"));
            List<Category_user> cus = Category_user.dao.query(map);
            map.clear();
            map.put("user",user);
            map.put("categories",cus);
            renderJson(RestResult.ok(map));
        }else {
            renderJson(RestResult.error(ConstantParas.error_username_not_exist));
        }
    }

    public void add(){
        User user = getModel(User.class,"paras");
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
            if (!FormatValidate.emailValidate(email)){
                flag = false;
                errormsg += ConstantParas.error_wrong_email_format+" ";
            }
        }

        String categories = (getPara("categories")==null || getPara("categories").toString().length()==0)?"":getPara("categories");

        Map<String,Object> filter = new HashMap<>();
        filter.put("username",user.get("username")==null?null:user.get("username").toString().trim());
        if (flag) {
            if (User.dao.getBy(filter)==null) {
                if (User.dao.add(user)) {

                    String[] category_ids = categories.split(",");
                    for (int i = 0; i < category_ids.length; i++) {
                        Category_user cu = new Category_user();
                        cu.set("user_id",user.get("id"));
                        cu.set("category_id",category_ids[i]);
                        Category_user.dao.add(cu);
                    }

                    filter.clear();
                    filter.put("user",user);
                    filter.put("errmsg",ConstantParas.success_add);
                    renderJson(RestResult.ok(filter));
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

    public void update(){
        String categories = (getPara("categories")==null || getPara("categories").toString().length()==0)?"":getPara("categories");
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

                    List category_idList = new ArrayList<>();
                    String[] category_ids = categories.split(",");
                    for (int i = 0; i < category_ids.length; i++) {
                        category_idList.add(category_ids[i]);
                    }

                    filter.clear();
                    filter.put("user_id",user.get("id"));
                    List<Category_user> cus = Category_user.dao.query(filter);
                    for (int i = 0; i < cus.size(); i++) {
                        Category_user pre = cus.get(i);
                        if (!category_idList.contains(pre.get("category_id").toString())){
                            Category_user.dao.delete(pre);
                        }else {
                            category_idList.remove(pre.get("category_id").toString());
                        }
                    }

                    for (int i = 0; i < category_idList.size(); i++) {
                        Category_user cu = new Category_user();
                        cu.set("user_id",user.get("id"));
                        cu.set("category_id",category_idList.get(i));
                        Category_user.dao.add(cu);
                    }

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
