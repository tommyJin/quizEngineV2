package uk.ac.ncl.csc8499.controller.student;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
import com.jfinal.plugin.activerecord.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ncl.csc8499.Util.RestResult;
import uk.ac.ncl.csc8499.controller.BaseController;
import uk.ac.ncl.csc8499.controller.teacher.QuizRecordController;
import uk.ac.ncl.csc8499.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tommy on 2016/5/15.
 */
@ControllerBind(controllerKey = "/student/answer")
public class AnswerController extends BaseController {
    static final Logger logger = LoggerFactory.getLogger(QuizRecordController.class);
    static final String tag = "quizRecord";

    public void index() {
        Long id = getPara("id") == null ? 0 : getParaToLong("id");
        Integer quiz_id = getPara("quiz_id") == null ? 0 : getParaToInt("quiz_id");
        Integer mark = getPara("mark") == null ? 0 : getParaToInt("mark");
        Integer quiz_question_id = getPara("quiz_question_id") == null ? 0 : getParaToInt("quiz_question_id");
        String answer = getPara("answer") == null ? "" : getPara("answer");
        Long quiz_record_id = getPara("quiz_record_id") == null ? null : getParaToLong("quiz_record_id");

        Long user_id = id;

        Map<String, Object> filter = new HashMap<>();
        filter.put("id", quiz_question_id);
        QuizQuestion qq = QuizQuestion.dao.getBy(filter);

        filter.clear();
        filter.put("quiz_id", quiz_id);
        filter.put("user_id", user_id);
        filter.put("quiz_question_id", quiz_question_id);
        filter.put("id",quiz_record_id);
        QuizRecord quizRecord = QuizRecord.dao.getBy(filter);
        logger.info("qr:{}", quizRecord);
//        if (quizRecord == null) {
            if (qq != null) {
//                qq.set("mark", Integer.parseInt(qq.get("mark").toString()) + mark);
//                QuizQuestion.dao.update(qq);
                QuizRecord qr = new QuizRecord();
                qr.set("quiz_id", quiz_id);
                qr.set("user_id", user_id);
                qr.set("quiz_question_id", quiz_question_id);
                qr.set("answer", answer);
                qr.set("mark", mark);

                if (quizRecord ==null){
                    if (QuizRecord.dao.add(qr)) {
                        renderJson(RestResult.ok(qr));
                    } else {
                        renderJson(RestResult.error(ConstantParas.failure_add));
                    }
                }else {
                    quizRecord.set("answer",answer);
                    quizRecord.set("mark",mark);
                    if (QuizRecord.dao.update(quizRecord)) {
                        renderJson(RestResult.ok(quizRecord));
                    } else {
                        renderJson(RestResult.error(ConstantParas.failure_update));
                    }
                }

            } else {
                renderJson(RestResult.error(ConstantParas.error_quiz_question_not_exist));
            }
//        } else {
//            renderJson(RestResult.error(ConstantParas.error_quiz_record_exist));
//        }
    }

    public void get(){
        Long id = getPara("id") == null ? 0 : getParaToLong("id");
        Integer quiz_question_id = getPara("quiz_question_id") == null ? 0: getParaToInt("quiz_question_id");
        Map<String, Object> filter = new HashMap<>();
        filter.put("quiz_question_id",quiz_question_id);
        filter.put("user_id",id);
        QuizRecord qr = QuizRecord.dao.getBy(filter);
        if (qr!=null){
            renderJson(RestResult.ok(qr));
        }else {
            renderJson(RestResult.error(null));
        }
    }

    public void finish(){
        Long id = getPara("id") == null ? 0 : getParaToLong("id");
        Integer quiz_id = getPara("quiz_id") == null ? ConstantParas.questiontype_null : getParaToInt("quiz_id");
        Map<String, Object> filter = new HashMap<>();
        filter.put("id",quiz_id);
        filter.put("creator_id",id);
        Quiz quiz = Quiz.dao.getBy(filter);
        Integer mark = 0;
        if (quiz!=null){
            filter.clear();
            filter.put("user_id",id);
            filter.put("quiz_id",quiz_id);
            Page<QuizRecord> qrs = QuizRecord.dao.query(filter);
            if (qrs!=null && qrs.getList().size()>0){
                List<QuizRecord> list = qrs.getList();
                for (int i = 0; i < list.size(); i++) {
                    mark+= Integer.parseInt(list.get(i).get("mark").toString());
                }
                quiz.set("mark",mark);
                if (Quiz.dao.update(quiz)){
                    renderJson(RestResult.ok(quiz));
                }else {
                    renderJson(RestResult.error(ConstantParas.failure_update));
                }
            }else {
                renderJson(RestResult.error("Please finish all questions first!"));
            }
        }else {
            renderJson(RestResult.error(ConstantParas.error_quiz_not_exist));
        }
    }


}
