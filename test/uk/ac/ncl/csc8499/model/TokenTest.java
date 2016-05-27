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
 * Created by tommy on 2016/5/26.
 */
public class TokenTest extends Base{
    static final Logger logger = LoggerFactory.getLogger(Token.class);
    static final String tag = "tokenTest";
    Gson gson = new Gson();

    @Ignore
    @Test
    public void testGenerate() throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        User user = User.dao.getBy(map);
        map.clear();
        map.put("user_id",user.get("id"));
        map.put("username",user.get("username"));
        String token = Token.dao.generate(map);
        logger.info("token_str:{}",token);
    }

    @Test
    public void testGetBy() throws Exception {
        Map<String,Object> map = new HashMap<>();
        long current = System.currentTimeMillis();
        String token = "1ab9a253815da1cfbd43fab52ab096b4";
        map.put("expire",current);
        map.put("token",token);
        Token t = Token.dao.getBy(map);
        logger.info("token:{}",t);
    }

    @Test
    public void testUpdate() throws Exception {
        Map<String,Object> map = new HashMap<>();
        String token = "1ab9a253815da1cfbd43fab52ab096b4";
        map.put("token",token);
        boolean rs = Token.dao.update(map);
        logger.info("token update:{}",rs);
    }
}