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

import static org.junit.Assert.*;

/**
 * Created by tommy on 2016/5/15.
 */
public class QuestionTypeTest  extends Base{
    static final Logger logger = LoggerFactory.getLogger(QuestionType.class);
    static final String tag = "questionTypeTest";
    Gson gson = new Gson();

    @Ignore
    @Test
    public void testQuery() throws Exception {
        Map<String,Object> filter = new HashMap<>();
//        filter.put("id",1);
        Page<QuestionType> qt = QuestionType.dao.query(filter);
        if (qt!=null){
            logger.info("qt:{}",qt);
        }else {
            logger.info("qt:{}",ConstantParas.error_question_type_not_exist);
        }
    }

    @Ignore
    @Test
    public void testGetBy() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("name","type1");
        QuestionType qt = QuestionType.dao.getBy(filter);
        if (qt!=null){
            logger.info("qt:{}",qt);
        }else {
            logger.info("qt:{}",ConstantParas.error_question_type_not_exist);
        }
    }

    @Ignore
    @Test
    public void testAdd() throws Exception {
        QuestionType qt = new QuestionType();
        qt.set("name","type1");
        qt.set("content","type1 content");
        if (QuestionType.dao.add(qt)){
            logger.info("qt:{}",qt);
        }else {
            logger.info("qt:{}",ConstantParas.failure_add);
        }
    }

    @Ignore
    @Test
    public void testUpdate() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",4);
        QuestionType qt = QuestionType.dao.getBy(filter);
        if (qt!=null){
            qt.set("name","type111");
            qt.set("content","type1 content1");
            if (QuestionType.dao.update(qt)) {
                logger.info("qt:{}", ConstantParas.success_update);
            }else {
                logger.info("qt:{}",ConstantParas.failure_update);
            }
        }else {
            logger.info("qt:{}", ConstantParas.error_question_type_not_exist);
        }
    }

//    @Ignore
    @Test
    public void testDelete() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",4);
        QuestionType qt = QuestionType.dao.getBy(filter);
        if (qt!=null){
            if (QuestionType.dao.delete(qt)) {
                logger.info("qt :{}", ConstantParas.success_delete);
            }else {
                logger.info("qt:{}",ConstantParas.failure_delete);
            }
        }else {
            logger.info("qt:{}", ConstantParas.error_question_type_not_exist);
        }
    }
}