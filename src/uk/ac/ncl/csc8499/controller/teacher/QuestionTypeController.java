package uk.ac.ncl.csc8499.controller.teacher;

import com.jfinal.ext.route.ControllerBind;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ncl.csc8499.Util.RestResult;
import uk.ac.ncl.csc8499.controller.BaseController;
import uk.ac.ncl.csc8499.model.ConstantParas;
import uk.ac.ncl.csc8499.model.QuestionType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tommy on 2016/5/24.
 */
@ControllerBind(controllerKey = "/teacher/questiontype")
public class QuestionTypeController extends BaseController{
    static final Logger logger = LoggerFactory.getLogger(QuestionTypeController.class);
    static final String tag = "questiontype";

    public void index(){
        Map<String,Object> filter = new HashMap<>();
        int page = getPara("page")==null? ConstantParas.page:getParaToInt("page");
        int size = getPara("size")==null?ConstantParas.size:getParaToInt("size");
        filter.put("page",page);
        filter.put("size",size);
        String keyword = getPara("keyword")==null?null:getPara("keyword").trim();
        String orderby = getPara("orderby")==null?null:getPara("orderby").trim();
        filter.put("keyword",keyword);
        filter.put("orderby",orderby);
        renderJson(RestResult.ok(QuestionType.dao.query(filter)));
    }
}
