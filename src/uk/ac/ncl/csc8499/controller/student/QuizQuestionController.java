package uk.ac.ncl.csc8499.controller.student;

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
@ControllerBind(controllerKey = "/student/quizquestion")
public class QuizQuestionController extends BaseController {
    static final Logger logger = LoggerFactory.getLogger(QuizQuestionController.class);
    static final String tag = "quizquestion";

    public void index(){
        Map<String,Object> filter = new HashMap<>();
        Integer quiz_id = getPara("quiz_id")==null?null:getParaToInt("quiz_id");
        String orderby = getPara("orderby")==null?null:getPara("orderby").trim();

        User currentUser = getCurrentUser();
        filter.put("creator_id",currentUser.get("id"));
        filter.put("id",quiz_id);
        Quiz q = Quiz.dao.getBy(filter);

        if (q!=null) {
            filter.put("orderby", orderby);
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

    public void autoGenerate(){
        Long id = getPara("id")==null?0:getParaToLong("id");
        Integer number = getPara("number")==null?0:getParaToInt("number");
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        User currentUser = getCurrentUser();
        filter.put("creator_id",currentUser.get("id"));
        Quiz quiz = Quiz.dao.getBy(filter);
        if (quiz!=null){
            List list = QuizQuestion.dao.autoGenerate(quiz,number);
            if(list.size()>0){
                renderJson(RestResult.ok(list));
            }else {
                renderJson(RestResult.error(ConstantParas.failure_add));
            }
        }else {
            renderJson(RestResult.error(ConstantParas.error_quiz_not_exist));
        }
    }

    public void answer(){

    }
}
