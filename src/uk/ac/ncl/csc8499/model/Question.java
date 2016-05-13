package uk.ac.ncl.csc8499.model;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

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
        int type = filter.get("type")==null?ConstantParas.usertype_null:Integer.parseInt(filter.get("type").toString());

        String select = "select * ";
        String where = "from "+TableName.question+" where 1=1 and isDeleted = "+ConstantParas.isDeleted_false+" ";

        if (filter.get("keyword")!=null && !filter.get("keyword").toString().equals("")){
            String keyword = filter.get("keyword").toString();
            where += " and ( name like '%"+keyword+"%' ";
        }

        if (filter.get("id")!=null){
            where += " and id = "+Integer.parseInt(filter.get("id").toString());
        }

        String order = " order by "+ (filter.get("orderby")==null?"  created desc":filter.get("orderby").toString());
        System.out.println(select+where+order);
        return Question.dao.paginate(page, size, select, where + order);
    }

    public Question getBy(Map<String,Object> filter){
        String select = "select * ";
        String where = "from "+TableName.question+" where 1=1 and isDeleted = "+ConstantParas.isDeleted_false+" ";
        if (filter.get("id")!=null){
            where += " and id = "+Integer.parseInt(filter.get("id").toString());
        }
        if (filter.get("name")!=null && !filter.get("name").toString().equals("")){
            where += " and name = '"+filter.get("name").toString()+"' ";
        }
        if (!where.equals("from "+TableName.user+" where 1=1")){
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
