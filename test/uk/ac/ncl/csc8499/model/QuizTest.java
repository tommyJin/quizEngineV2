package uk.ac.ncl.csc8499.model;

import com.google.gson.Gson;
import org.junit.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by tommy on 2016/5/15.
 */
public class QuizTest extends Base{
    static final Logger logger = LoggerFactory.getLogger(Quiz.class);
    static final String tag = "quizTest";
    Gson gson = new Gson();

    @Ignore
    @Test
    public void testQuery() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",1);
        Quiz q = Quiz.dao.getBy(filter);
        if (q!=null){
            logger.info("q:{}",q);
        }else {
            logger.info("q:{}",ConstantParas.error_quiz_not_exist);
        }
    }

    @Ignore
    @Test
    public void testGetBy() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("name","quiz 1");
        Quiz q = Quiz.dao.getBy(filter);
        if (q!=null){
            logger.info("q:{}",q);
        }else {
            logger.info("q:{}",ConstantParas.error_quiz_not_exist);
        }
    }

        @Ignore
    @Test
    public void testAdd() throws Exception {
        Random r = new Random();
        for (int i=0;i<5;i++) {
            Quiz q = new Quiz();
            q.set("name", "quiz "+(i+1));
            q.set("content", "quiz "+(i+1)+" content");
            q.set("creator_id",1);
            q.set("question_level_id",r.nextInt(4)+1);
            q.set("mark",5);
            if (Quiz.dao.add(q)) {
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
        Quiz q = Quiz.dao.getBy(filter);
        if (q!=null){
            q.set("name","quiz 4.1");
            q.set("content","quiz 4 content1");
            if (Quiz.dao.update(q)) {
                logger.info("q:{}", ConstantParas.success_update);
            }else {
                logger.info("q:{}",ConstantParas.failure_update);
            }
        }else {
            logger.info("q:{}", ConstantParas.error_quiz_not_exist);
        }
    }

    @Ignore
    @Test
    public void testDelete() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",4);
        Quiz q = Quiz.dao.getBy(filter);
        if (q!=null){
            if (Quiz.dao.delete(q)) {
                logger.info("q :{}", ConstantParas.success_delete);
            }else {
                logger.info("q:{}",ConstantParas.failure_delete);
            }
        }else {
            logger.info("q:{}", ConstantParas.error_quiz_not_exist);
        }
    }
}