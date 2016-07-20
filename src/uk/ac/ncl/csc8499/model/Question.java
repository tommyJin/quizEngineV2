package uk.ac.ncl.csc8499.model;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tommy on 2016/5/13.
 */
@TableBind(tableName = TableName.question)
public class Question extends Model<Question> {
    public static final Question dao = new Question();

    public Page<Question> query(Map<String, Object> filter){
        int page = filter.get("page")==null?ConstantParas.page:Integer.parseInt(filter.get("page").toString());
        int size = filter.get("size")==null?ConstantParas.size:Integer.parseInt(filter.get("size").toString());

        String select = "select q.*,ql.name level_name,qt.name type_name,qc.name category_name ";
        String where = " from "+TableName.question+" q, "+TableName.question_category+" qc, "+TableName.question_type+" qt, "+TableName.question_level+" ql where 1=1 and q.isDeleted = "+ConstantParas.isDeleted_false+" and q.question_category_id = qc.id and q.question_type_id = qt.id and q.question_level_id = ql.id ";

        if (filter.get("keyword")!=null && !filter.get("keyword").toString().equals("")){
            String keyword = filter.get("keyword").toString();
            where += " and ( q.name like '%"+keyword+"%' ) ";
        }

        if (filter.get("question_type_id")!=null){
            where += " and question_type_id = "+Integer.parseInt(filter.get("question_type_id").toString());
        }

        if (filter.get("question_level_id")!=null){
            where += " and question_level_id = "+ Integer.parseInt(filter.get("question_level_id").toString());
        }

        if (filter.get("question_category_id")!=null){
            where += " and question_category_id = "+ Integer.parseInt(filter.get("question_category_id").toString());
        }

        if (filter.get("id")!=null){
            where += " and q.id = "+Integer.parseInt(filter.get("id").toString());
        }

        if (filter.get("user_id")!=null){
            where += " and qc.id in (SELECT category_id FROM "+TableName.category_user+" where isDeleted = 0 and user_id = "+Integer.parseInt(filter.get("user_id").toString())+" ) ";
        }

        if (filter.get("answered")!=null){
            Integer answered = Integer.valueOf(filter.get("answered").toString());
            if (answered== ConstantParas.quiz_remove_answered){
                Integer creator_id = Integer.valueOf(filter.get("creator_id").toString());
                String remove = "select qq.question_id id from "+TableName.quiz_record+" qr,"+TableName.quiz_question+" qq where qr.quiz_question_id=qq.id and qr.user_id="+creator_id;
                where += " and q.id not in ("+ remove +")";
            }
        }

//        System.out.println("sql="+select+where);

        String order = " order by "+ (filter.get("orderby")==null?"  q.created desc":filter.get("orderby").toString());
        return Question.dao.paginate(page, size, select, where + order);
    }

    public Question getBy(Map<String,Object> filter){
        String select = "select q.*,ql.name level_name,qt.name type_name,qc.name category_name ";
        String where = " from "+TableName.question+" q, "+TableName.question_category+" qc, "+TableName.question_type+" qt, "+TableName.question_level+" ql where 1=1 and q.isDeleted = "+ConstantParas.isDeleted_false+" and q.question_category_id = qc.id and q.question_type_id = qt.id and q.question_level_id = ql.id ";
        if (filter.get("id")!=null){
            where += " and q.id = "+Integer.parseInt(filter.get("id").toString());
        }
        if (filter.get("name")!=null && !filter.get("name").toString().equals("")){
            where += " and q.name = '"+filter.get("name").toString()+"' ";
        }
        if (!where.equals(" from "+TableName.question+" q, "+TableName.question_category+" qc, "+TableName.question_type+" qt, "+TableName.question_level+" ql where 1=1 and q.isDeleted = "+ConstantParas.isDeleted_false+" and q.question_category_id = qc.id and q.question_type_id = qt.id and q.question_level_id = ql.id ")){
            return Question.dao.find(select + where).size()>0?Question.dao.find(select + where).get(0):null;
        }else {
            return null;
        }
    }

    public boolean add(Question question) {
        Map<String, Object> filter = new HashMap<>();
        long timestamp = System.currentTimeMillis();
        question.set("created",timestamp);
        question.set("modified",timestamp);
        question.set("isDeleted",ConstantParas.isDeleted_false);
        return question.save();
    }

    public boolean update(Question question){
        Map<String, Object> filter = new HashMap<>();
        filter.put("id", question.get("id"));
        if (getBy(filter) != null) {
            question.set("modified",System.currentTimeMillis());
            return question.update();
        } else {
            return false;
        }
    }

    public boolean delete(Question question){
        Map<String, Object> filter = new HashMap<>();
        filter.put("id", question.get("id"));
        if (getBy(filter) != null) {
            question.set("isDeleted",ConstantParas.isDeleted_true);
            question.set("modified",System.currentTimeMillis());
            return question.update();
        } else {
            return false;
        }
    }
}
