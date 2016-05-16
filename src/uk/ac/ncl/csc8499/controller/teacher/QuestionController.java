package uk.ac.ncl.csc8499.controller.teacher;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
import com.jfinal.kit.JsonKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ncl.csc8499.Util.FormatValidate;
import uk.ac.ncl.csc8499.Util.RestResult;
import uk.ac.ncl.csc8499.controller.BaseController;
import uk.ac.ncl.csc8499.model.ConstantParas;
import uk.ac.ncl.csc8499.model.Question;
import uk.ac.ncl.csc8499.model.QuestionChoice;
import uk.ac.ncl.csc8499.model.User;
import uk.ac.ncl.csc8499.model.question_type.True_false;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tommy on 2016/5/13.
 */
@ControllerBind(controllerKey = "/teacher/question")
public class QuestionController extends BaseController {
    static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
    static final String tag = "question";

    public void index(){
        Integer type = Integer.valueOf(getPara("question_type_id").toString().trim());
        String keyword = getPara("keyword")==null?null:getPara("keyword").trim();
        String orderby = getPara("orderby")==null?null:getPara("orderby").trim();
        Map<String,Object> filter = new HashMap<>();
        if (type!= ConstantParas.usertype_null) {
            filter.put("question_type_id",type);
        }
        if (getPara("question_category_id")!=null){
            filter.put("question_category_id",getParaToLong("question_category_id"));
        }
        if (getPara("question_level_id")!=null){
            filter.put("question_level_id",getParaToLong("question_level_id"));
        }
        filter.put("keyword",keyword);
        filter.put("orderby",orderby);

        renderJson(RestResult.ok(Question.dao.query(filter)));
    }

    public void get(){
        Long id = getPara("id")==null?0:getParaToLong("id");
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        Question q = Question.dao.getBy(filter);
        if (q!=null){
            renderJson(RestResult.ok(q));
        }else {
            renderJson(RestResult.error(ConstantParas.error_question_not_exist));
        }
    }

    public void add(){
        Question q = getModel(Question.class,"paras");//paras.*
        if (q!=null){
            if (Question.dao.add(q)){
                renderJson(RestResult.ok(ConstantParas.success_add));
            }else {
                renderJson(RestResult.error(ConstantParas.failure_add));
            }
        }else {
            renderJson(RestResult.error(ConstantParas.hint_object_null));
        }
    }

    public void update(){
        Question q = getModel(Question.class,"paras");
        Long id = q.get("id")==null?0:Long.parseLong(q.get("id").toString());
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        if (Question.dao.getBy(filter)!=null){
                if (Question.dao.update(q)) {
                    renderJson(RestResult.ok(ConstantParas.success_update));
                } else {
                    renderJson(RestResult.error(ConstantParas.failure_update));
                }
        }else {
            renderJson(RestResult.error(ConstantParas.error_question_not_exist));
        }
    }

    public void delete(){
        Long id = getPara("id")==null?0:getParaToLong("id");
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        Question q = Question.dao.getBy(filter);
        if (q!=null){
            if (Question.dao.delete(q)){
                renderJson(RestResult.ok(ConstantParas.success_delete));
            }else {
                renderJson(RestResult.error(ConstantParas.failure_delete));
            }
        }else {
            renderJson(RestResult.error(ConstantParas.error_question_not_exist));
        }
    }
}
