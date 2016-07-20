package uk.ac.ncl.csc8499.controller.admin;

import com.jfinal.ext.route.ControllerBind;
import com.jfinal.plugin.activerecord.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ncl.csc8499.Util.RestResult;
import uk.ac.ncl.csc8499.controller.BaseController;
import uk.ac.ncl.csc8499.controller.teacher.QuestionCategoryController;
import uk.ac.ncl.csc8499.model.ConstantParas;
import uk.ac.ncl.csc8499.model.Question;
import uk.ac.ncl.csc8499.model.QuestionCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tommy on 2016/7/20.
 */
@ControllerBind(controllerKey = "/admin/questioncategory")
public class CategoryController extends BaseController {
    static final Logger logger = LoggerFactory.getLogger(QuestionCategoryController.class);
    static final String tag = "category";

    public void index(){
        Map<String,Object> filter = new HashMap<>();
        int page = getPara("page")==null? ConstantParas.page:getParaToInt("page");
        int size = getPara("size")==null?ConstantParas.size:getParaToInt("size");
        filter.put("page",page);
        filter.put("size",size);
        String keyword = getPara("keyword")==null?null:getPara("keyword").trim();
        String orderby = getPara("orderby")==null?null:getPara("orderby").trim();
        filter.put("keyword",keyword);
        filter.put("orderby",orderby);
        logger.info("keyword:{}",keyword);
        renderJson(RestResult.ok(QuestionCategory.dao.query(filter)));
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

    public void add(){
        QuestionCategory q = getModel(QuestionCategory.class,"paras");//paras.*
        if (q!=null){
            if (QuestionCategory.dao.add(q)){
                Map<String,Object> filter = new HashMap<>();
                filter.clear();
                filter.put("q",q);
                filter.put("errmsg",ConstantParas.success_add);
                renderJson(RestResult.ok(filter));
            }else {
                renderJson(RestResult.error(ConstantParas.failure_add));
            }
        }else {
            renderJson(RestResult.error(ConstantParas.hint_object_null));
        }
    }

    public void update(){
        QuestionCategory q = getModel(QuestionCategory.class,"paras");
        Long id = q.get("id")==null?0:Long.parseLong(q.get("id").toString());
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        if (QuestionCategory.dao.getBy(filter)!=null){
            if (QuestionCategory.dao.update(q)) {
                renderJson(RestResult.ok(ConstantParas.success_update));
            } else {
                renderJson(RestResult.error(ConstantParas.failure_update));
            }
        }else {
            renderJson(RestResult.error(ConstantParas.error_question_category_not_exist));
        }
    }

    public void delete(){
        Long id = getPara("id")==null?0:getParaToLong("id");
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        QuestionCategory q = QuestionCategory.dao.getBy(filter);
        if (q!=null){
            if (QuestionCategory.dao.delete(q)){
                renderJson(RestResult.ok(ConstantParas.success_delete));
            }else {
                renderJson(RestResult.error(ConstantParas.failure_delete));
            }
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
