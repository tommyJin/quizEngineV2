package uk.ac.ncl.csc8499.controller.student;

import com.jfinal.ext.route.ControllerBind;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ncl.csc8499.Util.RestResult;
import uk.ac.ncl.csc8499.controller.BaseController;
import uk.ac.ncl.csc8499.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tommy on 2016/5/16.
 */
@ControllerBind(controllerKey = "/student/quizquestion")
public class QuizQuestionController extends BaseController {
    static final Logger logger = LoggerFactory.getLogger(QuizQuestionController.class);
    static final String tag = "quizquestion";

    public void index(){
        Long id = getPara("id")==null?null:getParaToLong("id");
        Map<String,Object> filter = new HashMap<>();
        Integer quiz_id = getPara("quiz_id")==null?null:getParaToInt("quiz_id");
        String orderby = getPara("orderby")==null?null:getPara("orderby").trim();
        int page = getPara("page")==null?ConstantParas.page:getParaToInt("page");
        int size = getPara("size")==null?ConstantParas.size:getParaToInt("size");
        filter.put("page",page);
        filter.put("size",size);

        User currentUser = getTokenUser(id);
        filter.put("creator_id",currentUser.get("id"));
        filter.put("id",quiz_id);
        Quiz q = Quiz.dao.getBy(filter);

        if (q!=null) {
            filter.clear();
            filter.put("orderby", orderby);
            filter.put("size",size);
            filter.put("user_id", currentUser.get("id"));
            filter.put("quiz_id",quiz_id);
            renderJson(RestResult.ok(QuizQuestion.dao.query(filter)));
        }else {
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

    public void maxSize(){
        Long id = getPara("id")==null?0:getParaToLong("id");
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        filter.put("type",ConstantParas.usertype_student);
        User currentUser = User.dao.getBy(filter);
        filter.clear();
        String answered = getPara("answered")==null? String.valueOf(ConstantParas.quiz_keep_answered):getPara("answered");
        Long level_id = getPara("level_id")==null?null:getParaToLong("level_id");
        Long category_id = getPara("category_id")==null?null:getParaToLong("category_id");
        String topic_id = getPara("topic_id")==null?null:getPara("topic_id");
        filter.put("question_level_id",level_id);
        filter.put("question_category_id",category_id);
        filter.put("question_topic_id",topic_id);
        filter.put("creator_id",currentUser.get("id"));
        int answer = ConstantParas.quiz_keep_answered;
        if (answered.equals( String.valueOf(ConstantParas.quiz_remove_answered))){
            answer = ConstantParas.quiz_remove_answered;
        }
        filter.put("answered",answer);
        filter.put("size",100000);
        renderJson(RestResult.ok(Question.dao.query(filter).getList().size()));
    }

}
