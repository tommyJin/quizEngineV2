package uk.ac.ncl.csc8499.controller.teacher;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ncl.csc8499.Util.RestResult;
import uk.ac.ncl.csc8499.model.ConstantParas;
import uk.ac.ncl.csc8499.model.QuestionCategory;
import uk.ac.ncl.csc8499.model.QuestionCategory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tommy on 2016/5/15.
 */
@ControllerBind(controllerKey = "/teacher/questioncategory")
public class QuestionCategoryController extends Controller {
    static final Logger logger = LoggerFactory.getLogger(QuestionCategoryController.class);
    static final String tag = "questionlevel";

    public void index(){
        String keyword = getPara("keyword")==null?null:getPara("keyword").trim();
        String orderby = getPara("orderby")==null?null:getPara("orderby").trim();
        Map<String,Object> filter = new HashMap<>();
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
                renderJson(RestResult.ok(ConstantParas.success_add));
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
}
