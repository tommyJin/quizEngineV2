package uk.ac.ncl.csc8499.model;

import com.google.gson.Gson;
import com.jfinal.plugin.activerecord.Page;
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
public class QuestionLevelTest  extends Base{
    static final Logger logger = LoggerFactory.getLogger(QuestionLevel.class);
    static final String tag = "questionTypeTest";
    Gson gson = new Gson();

    @Ignore
    @Test
    public void testQuery() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",1);
        Page<QuestionLevel> ql = QuestionLevel.dao.query(filter);
        if (ql!=null){
            logger.info("ql:{}",ql);
        }else {
            logger.info("ql:{}",ConstantParas.error_question_level_not_exist);
        }
    }

    @Ignore
    @Test
    public void testGetBy() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("name","type1");
        QuestionLevel ql = QuestionLevel.dao.getBy(filter);
        if (ql!=null){
            logger.info("ql:{}",ql);
        }else {
            logger.info("ql:{}",ConstantParas.error_question_level_not_exist);
        }
    }

    @Ignore
    @Test
    public void testAdd() throws Exception {
        QuestionLevel ql = new QuestionLevel();
        ql.set("name","level 1");
        ql.set("content","level 1 content");
        if (QuestionLevel.dao.add(ql)){
            logger.info("ql:{}",ql);
        }else {
            logger.info("ql:{}",ConstantParas.failure_add);
        }
    }

    @Ignore
    @Test
    public void testUpdate() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",4);
        QuestionLevel ql = QuestionLevel.dao.getBy(filter);
        if (ql!=null){
            ql.set("name","level 11");
            ql.set("content","level 11 content1");
            if (QuestionLevel.dao.update(ql)) {
                logger.info("ql:{}", ConstantParas.success_update);
            }else {
                logger.info("ql:{}",ConstantParas.failure_update);
            }
        }else {
            logger.info("ql:{}", ConstantParas.error_question_level_not_exist);
        }
    }

//        @Ignore
    @Test
    public void testDelete() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",4);
        QuestionLevel ql = QuestionLevel.dao.getBy(filter);
        if (ql!=null){
            if (QuestionLevel.dao.delete(ql)) {
                logger.info("ql :{}", ConstantParas.success_delete);
            }else {
                logger.info("ql:{}",ConstantParas.failure_delete);
            }
        }else {
            logger.info("ql:{}", ConstantParas.error_question_level_not_exist);
        }
    }
}