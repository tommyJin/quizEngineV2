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
 * Created by tommy on 2016/5/15.
 */
public class QuestionTest extends Base {
    static final Logger logger = LoggerFactory.getLogger(Question.class);
    static final String tag = "questionTest";
    Gson gson = new Gson();

    @Ignore
    @Test
    public void testQuery() throws Exception {
        Map<String, Object> filter = new HashMap<>();
//        filter.put("id", 1);
        filter.put("name", "5");
        Page<Question> q = Question.dao.query(filter);
        if (q != null) {
            logger.info("q:{}", q);
        } else {
            logger.info("q:{}", ConstantParas.error_question_not_exist);
        }
    }

    @Ignore
    @Test
    public void testGetBy() throws Exception {
        Map<String, Object> filter = new HashMap<>();
        filter.put("name", "q4");
        Question q = Question.dao.getBy(filter);
        if (q != null) {
            logger.info("q:{}", q);
        } else {
            logger.info("q:{}", ConstantParas.error_question_not_exist);
        }
    }

//    @Ignore
    @Test
    public void testAdd() throws Exception {
        String[] tags = {"Fill in Multiple Blanks", "Fill in the Blank", "Spark", "Kafka", "Big data", "SPIN"};
        Random r = new Random();
        for (int i = 50; i < 80; i++) {
            Question q = new Question();
            q.set("name", "q" + (i + 1));
            q.set("question_level_id", r.nextInt(4)+1);
            q.set("question_category_id", r.nextInt(4)+1);
            q.set("question_type_id", r.nextInt(6)+1);
            q.set("content", "q" + (i + 1) + " content");
            q.set("mark", r.nextInt(20));
            q.set("feedback", "i am q" + (i + 1) + " feedback");
            q.set("question_tag", tags[r.nextInt(tags.length)] + ";" + tags[r.nextInt(tags.length)]);
            if (Question.dao.add(q)){
                logger.info("q:{}",q);
            }else {
                logger.info(ConstantParas.failure_add);
            }
        }
    }

    @Ignore
    @Test
    public void testUpdate() throws Exception {
        Map<String, Object> filter = new HashMap<>();
        filter.put("id", 4);
        Question q = Question.dao.getBy(filter);
        if (q != null) {
            q.set("name", "q4");
            q.set("content", "q4 content 1");
            if (Question.dao.update(q)) {
                logger.info("q:{}", ConstantParas.success_update);
            } else {
                logger.info("q:{}", ConstantParas.failure_update);
            }
        } else {
            logger.info("q:{}", ConstantParas.error_question_not_exist);
        }
    }

    @Ignore
    @Test
    public void testDelete() throws Exception {
        Map<String, Object> filter = new HashMap<>();
        filter.put("id", 4);
        Question q = Question.dao.getBy(filter);
        if (q != null) {
            if (Question.dao.delete(q)) {
                logger.info("q :{}", ConstantParas.success_delete);
            } else {
                logger.info("q:{}", ConstantParas.failure_delete);
            }
        } else {
            logger.info("q:{}", ConstantParas.error_question_not_exist);
        }
    }
}