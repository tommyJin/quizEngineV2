package uk.ac.ncl.csc8499.controller.teacher;

import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ncl.csc8499.Util.RestResult;
import uk.ac.ncl.csc8499.controller.BaseController;
import uk.ac.ncl.csc8499.model.ConstantParas;
import uk.ac.ncl.csc8499.model.QuizRecord;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tommy on 2016/5/16.
 */
@ControllerBind(controllerKey = "/teacher/quizrecord")
public class QuizRecordController extends BaseController {

    static final Logger logger = LoggerFactory.getLogger(QuizRecordController.class);
    static final String tag = "quizrecord";

    public void index(){
        Integer quiz_id = getPara("quiz_id")==null?null:Integer.valueOf(getPara("quiz_id").toString().trim());
        String orderby = getPara("orderby")==null?null:getPara("orderby").trim();
        Map<String,Object> filter = new HashMap<>();
        if (quiz_id!= null) {
            filter.put("quiz_id",quiz_id);
        }
        filter.put("quiz_id",quiz_id);
        filter.put("orderby",orderby);

        renderJson(RestResult.ok(QuizRecord.dao.query(filter)));
    }

    public void get(){
        Long id = getPara("id")==null?0:getParaToLong("id");
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        QuizRecord q = QuizRecord.dao.getBy(filter);
        if (q!=null){
            renderJson(RestResult.ok(q));
        }else {
            renderJson(RestResult.error(ConstantParas.error_quiz_not_exist));
        }
    }

    public void add(){
        QuizRecord q = getModel(QuizRecord.class,"paras");//paras.*
        if (q!=null){
            if (QuizRecord.dao.add(q)){
                renderJson(RestResult.ok(ConstantParas.success_add));
            }else {
                renderJson(RestResult.error(ConstantParas.failure_add));
            }
        }else {
            renderJson(RestResult.error(ConstantParas.hint_object_null));
        }
    }

    public void update(){
        QuizRecord q = getModel(QuizRecord.class,"paras");
        Long id = q.get("id")==null?0:Long.parseLong(q.get("id").toString());
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        if (QuizRecord.dao.getBy(filter)!=null){
            if (QuizRecord.dao.update(q)) {
                renderJson(RestResult.ok(ConstantParas.success_update));
            } else {
                renderJson(RestResult.error(ConstantParas.failure_update));
            }
        }else {
            renderJson(RestResult.error(ConstantParas.error_quiz_not_exist));
        }
    }

    public void delete(){
        Long id = getPara("id")==null?0:getParaToLong("id");
        Map<String,Object> filter = new HashMap<>();
        filter.put("id",id);
        QuizRecord q = QuizRecord.dao.getBy(filter);
        if (q!=null){
            if (QuizRecord.dao.delete(q)){
                renderJson(RestResult.ok(ConstantParas.success_delete));
            }else {
                renderJson(RestResult.error(ConstantParas.failure_delete));
            }
        }else {
            renderJson(RestResult.error(ConstantParas.error_quiz_not_exist));
        }
    }
}
