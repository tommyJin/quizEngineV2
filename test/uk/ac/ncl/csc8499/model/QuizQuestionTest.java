package uk.ac.ncl.csc8499.model;

import com.google.gson.Gson;
import com.jfinal.plugin.activerecord.Page;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by tommy on 2016/5/16.
 */
public class QuizQuestionTest extends Base{

    static final Logger logger = LoggerFactory.getLogger(QuizQuestion.class);
    static final String tag = "quizQuestionTest";
    Gson gson = new Gson();

    @Ignore
    @Test
    public void testQuery() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("quiz_id",1);
        Page<QuizQuestion> q = QuizQuestion.dao.query(filter);
        if (q!=null){
            logger.info("q:{}",q.getList());
        }else {
            logger.info("q:{}",ConstantParas.error_quiz_question_not_exist);
        }
    }

    @Ignore
    @Test
    public void testGetBy() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",1);
        QuizQuestion q = QuizQuestion.dao.getBy(filter);
        if (q!=null){
            logger.info("q:{}",q);
        }else {
            logger.info("q:{}",ConstantParas.error_quiz_question_not_exist);
        }
    }

        @Ignore
    @Test
    public void testAdd() throws Exception {
        Random r = new Random();
        for (int i=0;i<5;i++) {
            QuizQuestion q = new QuizQuestion();
            q.set("quiz_id",1);
            q.set("question_id",i+1);
            if (QuizQuestion.dao.add(q)) {
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
        QuizQuestion q = QuizQuestion.dao.getBy(filter);
        if (q!=null){
            q.set("quiz_id",2);
            if (QuizQuestion.dao.update(q)) {
                logger.info("q:{}", ConstantParas.success_update);
            }else {
                logger.info("q:{}",ConstantParas.failure_update);
            }
        }else {
            logger.info("q:{}", ConstantParas.error_quiz_question_not_exist);
        }
    }

    @Ignore
    @Test
    public void testDelete() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",4);
        QuizQuestion q = QuizQuestion.dao.getBy(filter);
        if (q!=null){
            if (QuizQuestion.dao.delete(q)) {
                logger.info("q :{}", ConstantParas.success_delete);
            }else {
                logger.info("q:{}",ConstantParas.failure_delete);
            }
        }else {
            logger.info("q:{}", ConstantParas.error_quiz_question_not_exist);
        }
    }

    @Test
    public void testAutoGenerate() throws Exception{
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",1);
        Quiz quiz = Quiz.dao.getBy(filter);
        List list = QuizQuestion.dao.autoGenerate(quiz,0);
        if(list.size()>0){
            logger.info("generated qc list:{}",list);
        }else {
            logger.info("generated qc list:{}",ConstantParas.failure_add);
        }
    }
}