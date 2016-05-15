package uk.ac.ncl.csc8499.model;

import com.google.gson.Gson;
import com.jfinal.plugin.activerecord.Page;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by tommy on 2016/5/16.
 */
public class QuizRecordTest extends Base {
    static final Logger logger = LoggerFactory.getLogger(QuizRecord.class);
    static final String tag = "quizRecordTest";
    Gson gson = new Gson();

        @Ignore
    @Test
    public void testQuery() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("quiz_id",1);
        Page<QuizRecord> q = QuizRecord.dao.query(filter);
        if (q!=null){
            logger.info("q:{}",q.getList());
        }else {
            logger.info("q:{}",ConstantParas.error_quiz_record_not_exist);
        }
    }

    @Ignore
    @Test
    public void testGetBy() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",1);
        QuizRecord q = QuizRecord.dao.getBy(filter);
        if (q!=null){
            logger.info("q:{}",q);
        }else {
            logger.info("q:{}",ConstantParas.error_quiz_record_not_exist);
        }
    }

    @Ignore
    @Test
    public void testAdd() throws Exception {
        Random r = new Random();
        String[] answers = {String.valueOf(true),"A","Text","A;C;E"};
        for (int i=0;i<5;i++) {
            QuizRecord q = new QuizRecord();
            q.set("quiz_id",1);
            q.set("user_id",1);
            q.set("quiz_question_id",i+1);
            q.set("answer",answers[r.nextInt(answers.length)]);
            q.set("mark",5);
            if (QuizRecord.dao.add(q)) {
                logger.info("q:{}", q);
            } else {
                logger.info("q:{}", ConstantParas.failure_add);
            }
        }
    }

    @Ignore
    @Test
    public void testUpdate() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",4);
        QuizRecord q = QuizRecord.dao.getBy(filter);
        if (q!=null){
            q.set("quiz_id",2);
            if (QuizRecord.dao.update(q)) {
                logger.info("q:{}", ConstantParas.success_update);
            }else {
                logger.info("q:{}",ConstantParas.failure_update);
            }
        }else {
            logger.info("q:{}", ConstantParas.error_quiz_record_not_exist);
        }
    }

    @Ignore
    @Test
    public void testDelete() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",4);
        QuizRecord q = QuizRecord.dao.getBy(filter);
        if (q!=null){
            if (QuizRecord.dao.delete(q)) {
                logger.info("q :{}", ConstantParas.success_delete);
            }else {
                logger.info("q:{}",ConstantParas.failure_delete);
            }
        }else {
            logger.info("q:{}", ConstantParas.error_quiz_record_not_exist);
        }
    }
}