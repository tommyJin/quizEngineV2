package uk.ac.ncl.csc8499.model;

import com.jfinal.plugin.activerecord.Page;
import org.junit.Test;
import org.junit.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by tommy on 2016/5/9.
 */
public class UserTest extends Base {
    static final Logger logger = LoggerFactory.getLogger(User.class);
    static final String tag = "userTest";

    User dao = User.dao;

    @Ignore
    @Test
    public void testQuery() throws Exception {
        Map<String,Object> filter = new HashMap<>();
        int type = ConstantParas.usertype_teacher;
        filter.put("type",type);
        String username = "admin";
        filter.put("keyword",username);
        Page<User> users = dao.query(filter);
        logger.info("users:{}",users.getList());

        filter.clear();
        String name = "or";
        filter.put("keyword",name);
        users = dao.query(filter);
        logger.info("users:{}",users.getList());

    }

    @Ignore
    @Test
    public void testLogin() throws Exception {
        String username = "admin";
        String password = "admin";
        logger.info("user:{}", dao.login(username, password));
    }

    @Ignore
    @Test
    public void testGet() throws Exception {
        int id = 1;
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",null);
        logger.info("getUserById:{}",dao.getBy(filter));
        filter.clear();
        String username = "admin";
        filter.put("username",username);
        logger.info("getUserByUsername:{}",dao.getBy(filter));
    }

//    @Ignore
    @Test
    public void testAdd() throws Exception {
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.set("username","user"+i);
            user.set("password","user"+i);
            user.set("name","testuser"+i);
            user.set("type",ConstantParas.usertype_student);
            logger.info("addUser:{}", dao.add(user));
        }

    }

    @Ignore
    @Test
    public void testUpdate() throws Exception {
        int id = 1;
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        User user = dao.getBy(filter);
        if (user!=null){
            logger.info("before updateUserById:{}", user);
            user.set("name","updateuser");
            logger.info("updateUserById:{}", dao.update(user));
            logger.info("after updateUserById:{}", dao.getBy(filter));
        }else {
            logger.info("getUserById: user does not exist" );
        }
    }

    @Ignore
    @Test
    public void testDelete() throws Exception {
        int id = 1;
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        User user = dao.getBy(filter);
        if (user!=null){
            logger.info("before deleteUserById:{}", user);
            user.set("isDeleted",ConstantParas.isDeleted_true);
            logger.info("deleteUserById:{}", dao.update(user));
            logger.info("after deleteUserById:{}", dao.getBy(filter));
        }else {
            logger.info("getUserById: user does not exist" );
        }
    }
}