package uk.ac.ncl.csc8499.controller;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
import uk.ac.ncl.csc8499.Util.RestResult;
import uk.ac.ncl.csc8499.model.QuestionType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tommy on 2016/5/15.
 */
@ControllerBind(controllerKey = "/questiontype")
public class QuestionTypeController extends Controller {
    public void index(){
        Map<String,Object> filter = new HashMap<>();
        renderJson(RestResult.ok( QuestionType.dao.query(filter).getList()));
    }
}
