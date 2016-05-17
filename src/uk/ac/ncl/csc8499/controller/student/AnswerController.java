package uk.ac.ncl.csc8499.controller.student;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ncl.csc8499.Util.RestResult;
import uk.ac.ncl.csc8499.controller.BaseController;
import uk.ac.ncl.csc8499.controller.teacher.QuizRecordController;
import uk.ac.ncl.csc8499.model.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tommy on 2016/5/15.
 */
@ControllerBind(controllerKey = "/student/answer")
public class AnswerController extends BaseController {
    static final Logger logger = LoggerFactory.getLogger(QuizRecordController.class);
    static final String tag = "quizRecord";

    public void index() {
        Integer quiz_id = getPara("quiz_id") == null ? ConstantParas.questiontype_null : getParaToInt("quiz_id");
        Integer quiz_question_id = getPara("quiz_question_id") == null ? ConstantParas.questiontype_null : getParaToInt("quiz_question_id");
        String input = getPara("answer") == null ? "" : getPara("answer");

        int user_id = getCurrentUser().get("id");

        Map<String, Object> filter = new HashMap<>();
        filter.put("id", quiz_question_id);
        QuizQuestion qq = QuizQuestion.dao.getBy(filter);

        filter.clear();
        filter.put("quiz_id", quiz_id);
        filter.put("user_id", user_id);
        filter.put("quiz_question_id", quiz_question_id);
        QuizRecord quizRecord = QuizRecord.dao.getBy(filter);
        logger.info("qr:{}",quizRecord);
        if (quizRecord == null) {
            filter.clear();
            if (qq != null) {
                filter.put("id", qq.get("question_id"));
                Question q = Question.dao.getBy(filter);
                String answer = q.get("answer");
                if (q != null) {
                    int type = q.get("question_type_id");
                    filter.put("id", type);
                    QuestionType qt = QuestionType.dao.getBy(filter);

                    if (qt != null) {
                        String name = qt.get("name");
                        int mark = 0;

                        if (input.equals(answer)) {
                            mark = q.get("mark");
                        }

                        if (name.equals("Fill in Multiple Blanks")) {

                        }
                        if (name.equals("Fill in the Blank")) {

                        }
                        if (name.equals("Multiple Answer")) {

                        }
                        if (name.equals("Multiple Choice")) {

                        }
                        if (name.equals("Calculate Numeric")) {

                        }

                        qq.set("mark", Integer.parseInt(qq.get("mark").toString()) + mark);
                        QuizQuestion.dao.update(qq);
                        QuizRecord qr = new QuizRecord();
                        qr.set("quiz_id", quiz_id);
                        qr.set("user_id", user_id);
                        qr.set("quiz_question_id", quiz_question_id);
                        qr.set("answer", answer);
                        qr.set("mark", mark);
                        if (QuizRecord.dao.add(qr)) {
                            renderJson(RestResult.ok(qr));
                        } else {
                            renderJson(RestResult.error(ConstantParas.failure_add));
                        }
                    } else {
                        renderJson(RestResult.error(ConstantParas.error_question_type_not_exist));
                    }

                } else {
                    renderJson(RestResult.error(ConstantParas.error_question_not_exist));
                }
            } else {
                renderJson(RestResult.error(ConstantParas.error_quiz_question_not_exist));
            }
        } else {
            renderJson(RestResult.error(ConstantParas.error_quiz_record_exist));
        }
    }


}
