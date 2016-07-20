package uk.ac.ncl.csc8499.model;

import com.google.gson.Gson;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by tommy on 2016/7/20.
 */
public class Category_userTest extends Base{
    static final Logger logger = LoggerFactory.getLogger(Category_user.class);
    static final String tag = "categoryUserTest";
    Gson gson = new Gson();

    @Test
    public void query() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("user_id",1);
//        filter.put("category_id",2);
        List<Category_user> cus = Category_user.dao.query(filter);

        logger.info("cus:{}",gson.toJson(cus));
    }

    @Test
    public void getBy() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("user_id",1);
        filter.put("category_id",2);
        Category_user cu = Category_user.dao.getBy(filter);

        logger.info("cu:{}",gson.toJson(cu));
    }

    @Ignore
    @Test
    public void add() throws Exception {
        for (int i = 1; i < 6; i++) {
            Category_user cu = new Category_user();
            cu.set("user_id",1);
            cu.set("category_id",i);
            logger.info("add cu:{}",Category_user.dao.add(cu));
        }
    }

    @Ignore
    @Test
    public void update() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("user_id",1);
        filter.put("category_id",2);
        Category_user cu = Category_user.dao.getBy(filter);
        cu.set("user_id",1);
        cu.set("category_id",2);
        logger.info("update cu:{}",Category_user.dao.update(cu));
    }

    @Test
    public void delete() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        filter.put("user_id",1);
        filter.put("category_id",0);
        Category_user cu = Category_user.dao.getBy(filter);
        logger.info("delete cu:{}",Category_user.dao.delete(cu));
    }

}