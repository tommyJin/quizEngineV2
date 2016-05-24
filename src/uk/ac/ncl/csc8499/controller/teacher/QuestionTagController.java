package uk.ac.ncl.csc8499.controller.teacher;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ncl.csc8499.Util.RestResult;
import uk.ac.ncl.csc8499.controller.BaseController;
import uk.ac.ncl.csc8499.model.ConstantParas;
import uk.ac.ncl.csc8499.model.QuestionTag;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tommy on 2016/5/15.
 */
@ControllerBind(controllerKey = "/teacher/questiontag")
public class QuestionTagController extends BaseController {
    static final Logger logger = LoggerFactory.getLogger(QuestionTagController.class);
    static final String tag = "questiontag";

    public void index(){
        Map<String,Object> filter = new HashMap<>();
        int page = getPara("page")==null?ConstantParas.page:getParaToInt("page");
        int size = getPara("size")==null?ConstantParas.size:getParaToInt("size");
        filter.put("page",page);
        filter.put("size",size);
        String keyword = getPara("keyword")==null?null:getPara("keyword").trim();
        String orderby = getPara("orderby")==null?null:getPara("orderby").trim();
        filter.put("keyword",keyword);
        filter.put("orderby",orderby);
        renderJson(RestResult.ok(QuestionTag.dao.query(filter)));
    }

    public void get(){
        Long id = getPara("id")==null?0:getParaToLong("id");
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        QuestionTag q = QuestionTag.dao.getBy(filter);
        if (q!=null){
            renderJson(RestResult.ok(q));
        }else {
            renderJson(RestResult.error(ConstantParas.error_question_tag_not_exist));
        }
    }

    public void add(){
        QuestionTag q = getModel(QuestionTag.class,"paras");//paras.*
        if (q!=null){
            if (QuestionTag.dao.add(q)){
                Map<String,Object> filter = new HashMap<>();
                filter.clear();
                filter.put("q",q);
                filter.put("errmsg",ConstantParas.success_add);
                renderJson(RestResult.ok(filter));
            }else {
                renderJson(RestResult.error(ConstantParas.failure_add));
            }
        }else {
            renderJson(RestResult.error(ConstantParas.hint_object_null));
        }
    }

    public void update(){
        QuestionTag q = getModel(QuestionTag.class,"paras");
        Long id = q.get("id")==null?0:Long.parseLong(q.get("id").toString());
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        if (QuestionTag.dao.getBy(filter)!=null){
            if (QuestionTag.dao.update(q)) {
                renderJson(RestResult.ok(ConstantParas.success_update));
            } else {
                renderJson(RestResult.error(ConstantParas.failure_update));
            }
        }else {
            renderJson(RestResult.error(ConstantParas.error_question_tag_not_exist));
        }
    }

    public void delete(){
        Long id = getPara("id")==null?0:getParaToLong("id");
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        QuestionTag q = QuestionTag.dao.getBy(filter);
        if (q!=null){
            if (QuestionTag.dao.delete(q)){
                renderJson(RestResult.ok(ConstantParas.success_delete));
            }else {
                renderJson(RestResult.error(ConstantParas.failure_delete));
            }
        }else {
            renderJson(RestResult.error(ConstantParas.error_question_tag_not_exist));
        }
    }
}
