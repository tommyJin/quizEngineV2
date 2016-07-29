package uk.ac.ncl.csc8499.controller.teacher;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ncl.csc8499.Util.RestResult;
import uk.ac.ncl.csc8499.controller.BaseController;
import uk.ac.ncl.csc8499.model.ConstantParas;
import uk.ac.ncl.csc8499.model.Quiz;
import uk.ac.ncl.csc8499.model.QuizQuestion;
import uk.ac.ncl.csc8499.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tommy on 2016/5/16.
 */
@ControllerBind(controllerKey = "/teacher/quizquestion")
public class QuizQuestionController extends BaseController {

    static final Logger logger = LoggerFactory.getLogger(QuizQuestionController.class);
    static final String tag = "quizquestion";

    public void index(){
        Integer quiz_id = getPara("quiz_id")==null?0:getParaToInt("quiz_id");
        String orderby = getPara("orderby")==null?null:getPara("orderby").trim();
        Map<String,Object> filter = new HashMap<>();

        User currentUser = getCurrentUser();
        filter.put("creator_id",currentUser.get("id"));
        filter.put("id",quiz_id);
        logger.info("filter:{}",filter);
        Quiz q = Quiz.dao.getBy(filter);
        logger.info("q:{}",q);

        if (q!=null) {
            filter.clear();
            filter.put("quiz_id",quiz_id);
            filter.put("user_id", currentUser.get("id"));
            filter.put("orderby", orderby);
            renderJson(RestResult.ok(QuizQuestion.dao.query(filter)));
        } else {
            renderJson(RestResult.error(ConstantParas.error_quiz_not_exist));
        }
    }

    public void get(){
        Long id = getPara("id")==null?0:getParaToLong("id");
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        QuizQuestion q = QuizQuestion.dao.getBy(filter);
        if (q!=null){
            renderJson(RestResult.ok(q));
        }else {
            renderJson(RestResult.error(ConstantParas.error_quiz_not_exist));
        }
    }

    public void add(){
        QuizQuestion q = getModel(QuizQuestion.class,"paras");//paras.*
        if (q!=null){
            User currentUser = getCurrentUser();
            q.set("user_id",currentUser.get("id"));
            if (QuizQuestion.dao.add(q)){
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

    public void addToQuiz(){
        Integer quiz_id = getPara("quiz_id")==null?null:getParaToInt("quiz_id");
        Integer question_id = getPara("question_id")==null?null:getParaToInt("question_id");

        Map<String,Object> filter = new HashMap<>();
        filter.put("id",quiz_id);
        User currentUser = getCurrentUser();
        filter.put("creator_id",currentUser.get("id"));
        Quiz quiz = Quiz.dao.getBy(filter);

        if (question_id!=null && quiz_id!=null) {
            if (quiz!=null) {
                QuizQuestion quizQuestion = new QuizQuestion();
                quizQuestion.set("quiz_id", quiz_id);
                quizQuestion.set("question_id", question_id);
                if (QuizQuestion.dao.add(quizQuestion)) {
                    renderJson(RestResult.ok(ConstantParas.success_add));
                } else {
                    renderJson(RestResult.ok(ConstantParas.failure_add));
                }
            }else {
                renderJson(RestResult.error(ConstantParas.error_quiz_not_exist));
            }
        }else {
            renderJson(RestResult.ok(ConstantParas.hint_unknown));
        }
    }

    public void autoGenerate(){
        Long id = getPara("id")==null?0:getParaToLong("id");
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        User currentUser = getCurrentUser();
        filter.put("creator_id",currentUser.get("id"));
        Quiz quiz = Quiz.dao.getBy(filter);
        if (quiz!=null){
            int mark = QuizQuestion.dao.autoGenerate(quiz);
            if(mark>0){
                renderJson(RestResult.ok(mark));
            }else {
                renderJson(RestResult.error(ConstantParas.failure_add));
            }
        }else {
            renderJson(RestResult.error(ConstantParas.error_quiz_not_exist));
        }
    }

    public void update(){
        QuizQuestion q = getModel(QuizQuestion.class,"paras");
        Long id = q.get("id")==null?0:Long.parseLong(q.get("id").toString());
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        if (QuizQuestion.dao.getBy(filter)!=null){
            if (QuizQuestion.dao.update(q)) {
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
        QuizQuestion q = QuizQuestion.dao.getBy(filter);
        if (q!=null){
            if (QuizQuestion.dao.delete(q)){
                renderJson(RestResult.ok(ConstantParas.success_delete));
            }else {
                renderJson(RestResult.error(ConstantParas.failure_delete));
            }
        }else {
            renderJson(RestResult.error(ConstantParas.error_quiz_not_exist));
        }
    }

}
