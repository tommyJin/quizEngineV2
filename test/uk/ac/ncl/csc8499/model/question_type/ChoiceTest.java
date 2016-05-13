package uk.ac.ncl.csc8499.model.question_type;

import com.google.gson.Gson;
import com.jfinal.kit.JsonKit;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ChoiceTest extends Base{
    static final Logger logger = LoggerFactory.getLogger(Question.class);
    static final String tag = TableName.question;

//    @Ignore
    @Test
    public void add(){
        Choice c = new Choice();
        c.setAnswer("A");
        c.setChoice_A("choice A");
        c.setChoice_B("choice B");
        c.setChoice_C("choice C");
        c.setChoice_D("choice D");
        c.setIsMulti(false);
        logger.info("c:{}", JsonKit.toJson(c));

        Question q = new Question();
        q.set("name","q3");
        q.set("question_level_id",1);
        q.set("question_category_id",1);
        q.set("question_type_id",1);
        q.set("content","q3 content");
        q.set("mark",5);
        q.set("feedback","i am q3 feedback");
        q.set("question_tag","1,2");
        if (Question.dao.add(q)){
            QuestionChoice qc = new QuestionChoice();
            qc.set("question_id",q.get("id"));
            qc.set("content", JsonKit.toJson(c));
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
        filter.put("id",3);
        Question q = Question.dao.getBy(filter);
        if (q!=null){
            filter.put("id", q.get("id"));
            QuestionChoice qc = QuestionChoice.dao.getBy(filter);
            if (qc!=null){
                Choice c = gson.fromJson(qc.get("content").toString(),Choice.class);
                logger.info("c:{}",gson.toJson(c));
            }else {
                logger.info("rs of qc:false");
            }
        }else {
            logger.info("rs of q:false");
        }
    }
}