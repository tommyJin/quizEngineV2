package uk.ac.ncl.csc8499.controller.teacher;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
import uk.ac.ncl.csc8499.Util.RestResult;
import uk.ac.ncl.csc8499.controller.BaseController;
import uk.ac.ncl.csc8499.model.ConstantParas;
import uk.ac.ncl.csc8499.model.Question;
import uk.ac.ncl.csc8499.model.QuestionChoice;
import uk.ac.ncl.csc8499.model.QuestionLevel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tommy on 2016/5/15.
 */
@ControllerBind(controllerKey = "/teacher/questionchoice")
public class QuestionChoiceController extends BaseController {
    public void get(){
        Long id = getPara("question_id")==null?0:getParaToLong("question_id");
        Map<String,Object> filter = new HashMap<>();
        filter.put("question_id",id);
        QuestionChoice q = QuestionChoice.dao.getBy(filter);
        if (q!=null){
            renderJson(RestResult.ok(q));
        }else {
            renderJson(RestResult.error(ConstantParas.error_question_choice_not_exist));
        }
    }

    public void add(){
        QuestionChoice q = getModel(QuestionChoice.class,"paras");//paras.*
        if (q!=null){
            if (QuestionChoice.dao.add(q)){
                renderJson(RestResult.ok(ConstantParas.success_add));
            }else {
                renderJson(RestResult.error(ConstantParas.failure_add));
            }
        }else {
            renderJson(RestResult.error(ConstantParas.hint_object_null));
        }
    }

    public void update(){
        QuestionChoice q = getModel(QuestionChoice.class,"paras");
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",q.get("id"));
        if (QuestionChoice.dao.getBy(filter)!=null){
            if (QuestionChoice.dao.update(q)) {
                renderJson(RestResult.ok(ConstantParas.success_update));
            } else {
                renderJson(RestResult.error(ConstantParas.failure_update));
            }
        }else {
            renderJson(RestResult.error(ConstantParas.error_question_choice_not_exist));
        }
    }
}
