package uk.ac.ncl.csc8499.model;

import com.google.gson.Gson;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by tommy on 2016/5/15.
 */
public class QuestionCategoryTest extends Base{
    static final Logger logger = LoggerFactory.getLogger(QuestionCategory.class);
    static final String tag = "questionCategoryTest";
    Gson gson = new Gson();

    @Ignore
    @Test
    public void testQuery() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",1);
        QuestionCategory qc = QuestionCategory.dao.getBy(filter);
        if (qc!=null){
            logger.info("qc:{}",qc);
        }else {
            logger.info("qc:{}",ConstantParas.error_question_category_not_exist);
        }
    }

    @Ignore
    @Test
    public void testGetBy() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("name","java");   
        QuestionCategory qc = QuestionCategory.dao.getBy(filter);
        if (qc!=null){
            logger.info("qc:{}",qc);
        }else {
            logger.info("qc:{}",ConstantParas.error_question_category_not_exist);
        }
    }

//    @Ignore
    @Test
    public void testAdd() throws Exception {
        QuestionCategory qc = new QuestionCategory();
        qc.set("name","tag1");
        qc.set("content","tag1 content");
        if (QuestionCategory.dao.add(qc)){
            logger.info("qc:{}",qc);
        }else {
            logger.info("qc:{}",ConstantParas.failure_add);
        }
    }

    @Ignore
    @Test
    public void testUpdate() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",4);   
        QuestionCategory qc = QuestionCategory.dao.getBy(filter);
        if (qc!=null){
            qc.set("name","tag111");
            qc.set("content","tag1 content1");
            if (QuestionCategory.dao.update(qc)) {
                logger.info("qc:{}", ConstantParas.success_update);
            }else {
                logger.info("qc:{}",ConstantParas.failure_update);
            }
        }else {
            logger.info("qc:{}", ConstantParas.error_question_category_not_exist);
        }
    }

    @Ignore
    @Test
    public void testDelete() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",4);
        QuestionCategory qc = QuestionCategory.dao.getBy(filter);
        if (qc!=null){
            if (QuestionCategory.dao.delete(qc)) {
                logger.info("qc :{}", ConstantParas.success_delete);
            }else {
                logger.info("qc:{}",ConstantParas.failure_delete);
            }
        }else {
            logger.info("qc:{}", ConstantParas.error_question_category_not_exist);
        }
    }
}