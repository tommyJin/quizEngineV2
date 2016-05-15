package uk.ac.ncl.csc8499.controller;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
import uk.ac.ncl.csc8499.Util.RestResult;
import uk.ac.ncl.csc8499.model.QuestionCategory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tommy on 2016/5/15.
 */
@ControllerBind(controllerKey = "/questioncategory")
public class QuestionCategoryController extends Controller {
    public void index(){
        Map<String,Object> filter = new HashMap<>();
        renderJson(RestResult.ok(QuestionCategory.dao.query(filter).getList()));
    }
}
