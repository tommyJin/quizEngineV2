package uk.ac.ncl.csc8499.model;

import com.google.gson.Gson;
import com.jfinal.kit.JsonKit;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ncl.csc8499.model.question_type.Choice;
import uk.ac.ncl.csc8499.model.question_type.True_false;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by tommy on 2016/5/15.
 */
public class QuestionChoiceTest extends Base{
    static final Logger logger = LoggerFactory.getLogger(QuestionChoice.class);
    static final String tag = "questionChoiceTest";
    Gson gson = new Gson();



    @Ignore
    @Test
    public void testAdd() throws Exception {
        Choice c = new Choice();
        c.setAnswer("A");
        c.setChoice_A("choice A");
        c.setChoice_B("choice B");
        c.setChoice_C("choice C");
        c.setChoice_D("choice D");
        c.setIsMulti(false);
        logger.info("c:{}", JsonKit.toJson(c));

//        Question q = new Question();
//        q.set("name","q5");
//        q.set("question_level_id",2);
//        q.set("question_category_id",2);
//        q.set("question_type_id",2);
//        q.set("content","q3 content");
//        q.set("mark",15);
//        q.set("feedback","i am q5 feedback");
//        q.set("question_tag","1,2");
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",2);
        Question q = Question.dao.getBy(filter);
        if (q!=null){
            QuestionChoice qc = new QuestionChoice();
            qc.set("question_id",q.get("id"));
            qc.set("content", gson.toJson(c));
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
    public void testGetBy() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",1);
        QuestionChoice qc = QuestionChoice.dao.getBy(filter);
        if (qc!=null){
            logger.info("qc:{}",qc);
        }else {
            logger.info("qc:null");
        }
    }

//    @Ignore
    @Test
    public void testUpdate() throws Exception {
        True_false tf = new True_false();
        tf.setAnswer(true);
        tf.setFalse_content("false content");
        tf.setTrue_content("true content");
        logger.info("tf:{}", gson.toJson(tf));

        Map<String,Object> filter = new HashMap<>();
        filter.put("id",1);
        Question q = Question.dao.getBy(filter);
        if (q!=null){
            filter.clear();
            filter.put("question_id",2);
            QuestionChoice qc = QuestionChoice.dao.getBy(filter);
            if (qc!=null) {
                qc.set("content", gson.toJson(tf));
                if (QuestionChoice.dao.update(qc)) {
                    logger.info("rs of qc:true");
                } else {
                    logger.info("rs of qc:false");
                }
            }else {
                logger.info("rs of qc:null");
            }
        } else {
            logger.info("rs of q:null");
        }
    }

    @Ignore
    @Test
    public void testDelete() throws Exception {
        //not using
    }
}