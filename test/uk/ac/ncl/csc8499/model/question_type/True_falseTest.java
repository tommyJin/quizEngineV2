package uk.ac.ncl.csc8499.model.question_type;

import com.google.gson.Gson;
import com.jfinal.kit.JsonKit;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ncl.csc8499.controller.HelloController;
import uk.ac.ncl.csc8499.model.Base;
import uk.ac.ncl.csc8499.model.Question;
import uk.ac.ncl.csc8499.model.QuestionChoice;
import uk.ac.ncl.csc8499.model.TableName;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by tommy on 2016/5/13.
 */
public class True_falseTest extends Base {
    static final Logger logger = LoggerFactory.getLogger(Question.class);
    static final String tag = TableName.question;

    @Ignore
    @Test
    public void add(){
        True_false tf = new True_false();
        tf.setAnswer(false);
        tf.setFalse_content("i am false");
        tf.setTrue_content("i am true");
        logger.info("tf:{}",JsonKit.toJson(tf));

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

    @Test
    public void get(){
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",1);
        Question q = Question.dao.getBy(filter);
        if (q!=null){
            filter.put("id", q.get("id"));
            QuestionChoice qc = QuestionChoice.dao.getBy(filter);
            if (qc!=null){
                True_false tf = gson.fromJson(qc.get("content").toString(),True_false.class);
                logger.info("tf:{}",gson.toJson(tf));
            }else {
                logger.info("rs of qc:false");
            }
        }else {
            logger.info("rs of q:false");
        }
    }
}