package uk.ac.ncl.csc8499.controller.teacher;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ncl.csc8499.Util.RestResult;
import uk.ac.ncl.csc8499.controller.BaseController;
import uk.ac.ncl.csc8499.model.*;
import uk.ac.ncl.csc8499.model.Quiz;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tommy on 2016/5/16.
 */
@ControllerBind(controllerKey = "/teacher/quiz")
public class QuizController extends BaseController {
    static final Logger logger = LoggerFactory.getLogger(QuizController.class);
    static final String tag = "quiz";

    public void index(){
        Integer level_id = getPara("level_id")==null?null:Integer.valueOf(getPara("level_id").toString().trim());
        Integer category_id = getPara("category_id")==null?null:Integer.valueOf(getPara("category_id").toString().trim());

        User currentUser = getCurrentUser();
        String keyword = getPara("keyword")==null?null:getPara("keyword").trim();
        String orderby = getPara("orderby")==null?null:getPara("orderby").trim();
        Map<String,Object> filter = new HashMap<>();
        if (level_id!= null) {
            filter.put("question_level_id",level_id);
        }
        if (category_id!=null){
            filter.put("question_category_id",category_id);
        }
//        filter.put("creator_id", currentUser.get("id"));
        filter.put("keyword",keyword);
        filter.put("orderby",orderby);

        renderJson(RestResult.ok(Quiz.dao.query(filter)));
    }

    public void get(){
        Long id = getPara("id")==null?0:getParaToLong("id");
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        Quiz q = Quiz.dao.getBy(filter);
        if (q!=null){
            renderJson(RestResult.ok(q));
        }else {
            renderJson(RestResult.error(ConstantParas.error_quiz_not_exist));
        }
    }

    public void add(){
        Quiz q = getModel(Quiz.class,"paras");//paras.*
        User currentUser = getCurrentUser();

        if (q!=null){
            Map<String,Object> filter = new HashMap<>();
            q.set("creator_id",currentUser.get("id"));
            if (q.get("name")==null){
                String name = "";
                filter.put("id",q.get("question_category_id"));
                name += QuestionCategory.dao.getBy(filter).get("name")+" ";
                filter.clear();
                filter.put("id",q.get("question_level_id"));
                name += QuestionLevel.dao.getBy(filter).get("name")+" ";
                name += currentUser.get("name");
                q.set("name", name);
            }
            if (q.get("content")==null){
                q.set("content","Generated by "+currentUser.get("name"));
            }
            if (Quiz.dao.add(q)){
                renderJson(RestResult.ok(q));
            }else {
                renderJson(RestResult.error(ConstantParas.failure_add));
            }
        }else {
            renderJson(RestResult.error(ConstantParas.hint_object_null));
        }
    }

    public void update(){
        Quiz q = getModel(Quiz.class,"paras");
        Long id = q.get("id")==null?0:Long.parseLong(q.get("id").toString());
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        if (Quiz.dao.getBy(filter)!=null){
            if (Quiz.dao.update(q)) {
                renderJson(RestResult.ok(ConstantParas.success_update));
            } else {
                renderJson(RestResult.error(ConstantParas.failure_update));
            }
        }else {
            renderJson(RestResult.error(ConstantParas.error_quiz_not_exist));
        }
    }

    public void delete(){
        Long id = getPara("id")==null?0:getParaToLong("id");
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        Quiz q = Quiz.dao.getBy(filter);
        if (q!=null){
            if (Quiz.dao.delete(q)){
                renderJson(RestResult.ok(ConstantParas.success_delete));
            }else {
                renderJson(RestResult.error(ConstantParas.failure_delete));
            }
        }else {
            renderJson(RestResult.error(ConstantParas.error_quiz_not_exist));
        }
    }


}
