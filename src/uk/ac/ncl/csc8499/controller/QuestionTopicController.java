package uk.ac.ncl.csc8499.controller;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
import uk.ac.ncl.csc8499.Util.RestResult;
import uk.ac.ncl.csc8499.model.QuestionTopic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tommy on 2016/5/15.
 */
@ControllerBind(controllerKey = "/questiontopic")
public class QuestionTopicController extends Controller {
    public void index(){
        Map<String,Object> filter = new HashMap<>();
        Integer category_id = getPara("category_id")==null?null:getParaToInt("category_id");
        filter.put("category_id",category_id);
        renderJson(RestResult.ok(QuestionTopic.dao.query(filter).getList()));
    }
}
