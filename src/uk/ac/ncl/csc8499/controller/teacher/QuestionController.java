package uk.ac.ncl.csc8499.controller.teacher;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
import com.jfinal.kit.JsonKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ncl.csc8499.model.Question;
import uk.ac.ncl.csc8499.model.QuestionChoice;
import uk.ac.ncl.csc8499.model.question_type.True_false;

/**
 * Created by tommy on 2016/5/13.
 */
@ControllerBind(controllerKey = "/teacher/question")
public class QuestionController extends Controller {
    static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
    static final String tag = "question";

    public void add(){
        True_false tf = new True_false();
        tf.setAnswer(false);
        tf.setFalse_content("i am false");
        tf.setTrue_content("i am true");
        logger.info("tf:{}", JsonKit.toJson(tf));

        Question q = new Question();
        q.set("name","q1");
        q.set("question_level_id",1);
        q.set("question_category_id",1);
        q.set("question_type_id",1);
        q.set("content","q1 content");
        q.set("mark",10);
        q.set("feedback","i am q1 feedback");
        q.set("question_tag","1,2,3");
        if (Question.dao.add(q)){
            QuestionChoice qc = new QuestionChoice();
            qc.set("question_id",q.get("id"));
            qc.set("content", JsonKit.toJson(tf));
            if (QuestionChoice.dao.add(qc)){
                logger.info("rs of qc:true");
            }else {
                logger.info("rs of qc:false");
            }
        }else {
            logger.info("rs of q:false");
        }
    }
}
