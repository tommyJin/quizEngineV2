package uk.ac.ncl.csc8499.controller.teacher;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
import com.jfinal.kit.JsonKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ncl.csc8499.Util.FormatValidate;
import uk.ac.ncl.csc8499.Util.RestResult;
import uk.ac.ncl.csc8499.controller.BaseController;
import uk.ac.ncl.csc8499.model.*;
import uk.ac.ncl.csc8499.model.question_type.True_false;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tommy on 2016/5/13.
 */
@ControllerBind(controllerKey = "/teacher/question")
public class QuestionController extends BaseController {
    static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
    static final String tag = "question";

    public void index() {
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
            if (getPara("question_type_id") != null && !getPara("question_type_id").toString().equals("0")) {
                filter.put("question_type_id", getParaToLong("question_type_id"));
            }
            if (getPara("question_category_id") != null && !getPara("question_category_id").toString().equals("0")) {
                filter.put("question_category_id", getParaToLong("question_category_id"));
            }
            if (getPara("question_level_id") != null && !getPara("question_level_id").toString().equals("0")) {
                filter.put("question_level_id", getParaToLong("question_level_id"));
            }
            filter.put("keyword", keyword);
            filter.put("orderby", orderby);

            renderJson(RestResult.ok(Question.dao.query(filter)));
        }else {
            renderJson(RestResult.error(null));
        }
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
        Question q = getModel(Question.class,"q");//paras.*
        QuestionChoice qc = getModel(QuestionChoice.class,"qc");//paras.*
        Map<String,Object> filter = new HashMap<>();
        if (q!=null){
            if (Question.dao.add(q)){
                qc.set("question_id",q.get("id"));
                if (QuestionChoice.dao.add(qc)){
                    filter.put("q",q);
                    filter.put("qc",qc);
                    filter.put("errmsg",ConstantParas.success_add);
                    renderJson(RestResult.ok(filter));
                }else {
                    renderJson(RestResult.error(ConstantParas.failure_add));
                }
            }else {
                renderJson(RestResult.error(ConstantParas.failure_add));
            }
        }else {
            renderJson(RestResult.error(ConstantParas.hint_object_null));
        }
    }

    public void update(){
        Question q = getModel(Question.class,"q");
        QuestionChoice qc = getModel(QuestionChoice.class,"qc");//paras.*
        Long id = q.get("id")==null?0:Long.parseLong(q.get("id").toString());
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        if (Question.dao.getBy(filter)!=null){
                if (Question.dao.update(q)) {
                    qc.set("id",id);
                    if (QuestionChoice.dao.update(qc)){
                        renderJson(RestResult.ok(ConstantParas.success_update));
                    }else {
                        renderJson(RestResult.error(ConstantParas.failure_update));
                    }
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
