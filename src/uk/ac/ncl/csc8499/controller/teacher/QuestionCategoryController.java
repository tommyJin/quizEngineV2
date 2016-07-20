package uk.ac.ncl.csc8499.controller.teacher;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
import com.jfinal.plugin.activerecord.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ncl.csc8499.Util.RestResult;
import uk.ac.ncl.csc8499.controller.BaseController;
import uk.ac.ncl.csc8499.model.*;
import uk.ac.ncl.csc8499.model.QuestionCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tommy on 2016/5/15.
 */
@ControllerBind(controllerKey = "/teacher/questioncategory")
public class QuestionCategoryController extends BaseController {
    static final Logger logger = LoggerFactory.getLogger(QuestionCategoryController.class);
    static final String tag = "questionlevel";

    public void index(){
        User user = getCurrentUser();
        Map<String,Object> filter = new HashMap<>();
        filter.put("user_id",user.get("id"));
        List<Category_user> cus = Category_user.dao.query(filter);
        if (cus.size()>0){
        int page = getPara("page")==null?ConstantParas.page:getParaToInt("page");
        int size = getPara("size")==null?ConstantParas.size:getParaToInt("size");
        filter.put("page",page);
        filter.put("size",size);
        String keyword = getPara("keyword")==null?null:getPara("keyword").trim();
        String orderby = getPara("orderby")==null?null:getPara("orderby").trim();
        filter.put("keyword",keyword);
        filter.put("orderby",orderby);
//        filter.put()
        renderJson(RestResult.ok(QuestionCategory.dao.query(filter)));
        }else {
            renderJson(RestResult.error(null));
        }
    }

    public void get(){
        Long id = getPara("id")==null?0:getParaToLong("id");
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        QuestionCategory q = QuestionCategory.dao.getBy(filter);
        if (q!=null){
            renderJson(RestResult.ok(q));
        }else {
            renderJson(RestResult.error(ConstantParas.error_question_category_not_exist));
        }
    }

    public void modules(){
        Integer user_id = (getPara("user_id")==null||getPara("user_id").toString().equals(""))?null:getParaToInt("user_id");
        Integer category_id = (getPara("category_id")==null||getPara("category_id").toString().equals(""))?null:getParaToInt("category_id");
        Map<String,Object> filter = new HashMap<>();
        filter.put("user_id",user_id);
        filter.put("category_id",category_id);
        filter.put("page",1);
        filter.put("size",100000);
        Page<QuestionCategory> page = QuestionCategory.dao.query(filter);
        List<QuestionCategory> cates = page.getList();
        renderJson(RestResult.ok(cates));
    }
}
