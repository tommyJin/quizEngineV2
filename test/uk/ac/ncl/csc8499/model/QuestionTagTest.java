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
public class QuestionTagTest extends Base{
    static final Logger logger = LoggerFactory.getLogger(QuestionTag.class);
    static final String tag = "questionTagTest";
    Gson gson = new Gson();

    @Ignore
    @Test
    public void testQuery() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",1);
        Page<QuestionTag> qt = QuestionTag.dao.query(filter);
        if (qt!=null){
            logger.info("qt:{}",qt);
        }else {
            logger.info("qt:{}",ConstantParas.error_question_tag_not_exist);
        }
    }

    @Ignore
    @Test
    public void testGetBy() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("name","java");
        QuestionTag qt = QuestionTag.dao.getBy(filter);
        if (qt!=null){
            logger.info("qt:{}",qt);
        }else {
            logger.info("qt:{}",ConstantParas.error_question_tag_not_exist);
        }
    }

//    @Ignore
    @Test
    public void testAdd() throws Exception {
        String[] names = {"Fill in Multiple Blanks","Fill in the Blank","Spark","Kafka","Big data","SPIN"};
        for (int i=0;i<names.length;i++) {
            QuestionTag ql = new QuestionTag();
            ql.set("name", names[i]);
            ql.set("content", names[i] + " content");
            if (QuestionTag.dao.add(ql)) {
                logger.info("ql:{}", ql);
            } else {
                logger.info("ql:{}", ConstantParas.failure_add);
            }
        }
    }

    @Ignore
    @Test
    public void testUpdate() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",4);
        QuestionTag qt = QuestionTag.dao.getBy(filter);
        if (qt!=null){
            qt.set("name","tag111");
            qt.set("content","tag1 content1");
            if (QuestionTag.dao.update(qt)) {
                logger.info("qt:{}", ConstantParas.success_update);
            }else {
                logger.info("qt:{}",ConstantParas.failure_update);
            }
        }else {
            logger.info("qt:{}", ConstantParas.error_question_tag_not_exist);
        }
    }

    @Ignore
    @Test
    public void testDelete() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",4);
        QuestionTag qt = QuestionTag.dao.getBy(filter);
        if (qt!=null){
            if (QuestionTag.dao.delete(qt)) {
                logger.info("qt :{}", ConstantParas.success_delete);
            }else {
                logger.info("qt:{}",ConstantParas.failure_delete);
            }
        }else {
            logger.info("qt:{}", ConstantParas.error_question_tag_not_exist);
        }
    }
}