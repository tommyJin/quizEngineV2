package uk.ac.ncl.csc8499.model;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tommy on 2016/5/13.
 */
@TableBind(tableName = TableName.question_choice)
public class QuestionChoice extends Model<QuestionChoice> {
    public static final QuestionChoice dao = new QuestionChoice();

/*
    public Page<QuestionChoice> query(Map<String, Object> filter){
        int page = filter.get("page")==null?ConstantParas.page:Integer.parseInt(filter.get("page").toString());
        int size = filter.get("size")==null?ConstantParas.size:Integer.parseInt(filter.get("size").toString());
        int type = filter.get("type")==null?ConstantParas.usertype_null:Integer.parseInt(filter.get("type").toString());

        String select = "select * ";
        String where = "from "+TableName.question_choice+" where 1=1 and isDeleted = "+ConstantParas.isDeleted_false+" ";

        if (filter.get("keyword")!=null && !filter.get("keyword").toString().equals("")){
            String keyword = filter.get("keyword").toString();
            where += " and ( name like '%"+keyword+"%' ";
        }

        if (filter.get("id")!=null){
            where += " and id = "+Integer.parseInt(filter.get("id").toString());
        }

        String order = " order by "+ (filter.get("orderby")==null?"  created desc":filter.get("orderby").toString());
        System.out.println(select+where+order);
        return QuestionChoice.dao.paginate(page, size, select, where + order);
    }
    */

    public QuestionChoice getBy(Map<String,Object> filter){
        String select = "select * ";
        String where = " from "+TableName.question_choice+" where 1=1 and isDeleted = "+ConstantParas.isDeleted_false+" ";
        if (filter.get("id")!=null){
            where += " and id = "+Integer.parseInt(filter.get("id").toString());
        }
        if (filter.get("question_id")!=null){
            where += " and question_id = "+Integer.parseInt(filter.get("question_id").toString());
        }
        if (!where.equals(" from "+TableName.question_choice+" where 1=1 and isDeleted = "+ConstantParas.isDeleted_false+" ")){
            System.out.println(select + where);
            return QuestionChoice.dao.find(select + where).size()>0?QuestionChoice.dao.find(select + where).get(0):null;
        }else {
            return null;
        }
    }

    public boolean add(QuestionChoice questionChoice) {
        Map<String, Object> filter = new HashMap<>();
        long timestamp = System.currentTimeMillis();
        questionChoice.set("created",timestamp);
        questionChoice.set("modified",timestamp);
        questionChoice.set("isDeleted",ConstantParas.isDeleted_false);
        try {
            return questionChoice.save();
        }catch (Exception e){
            return false;
        }
    }

    public boolean update(QuestionChoice questionChoice){
        Map<String, Object> filter = new HashMap<>();
        filter.put("id", questionChoice.get("id"));
        if (getBy(filter) != null) {
            questionChoice.set("modified",System.currentTimeMillis());
            return questionChoice.update();
        } else {
            return false;
        }
    }

    /*
    * not using at this moment
    * */
    public boolean delete(QuestionChoice questionChoice){
        Map<String, Object> filter = new HashMap<>();
        filter.put("question_id", questionChoice.get("question_id"));
        if (getBy(filter) != null) {
            questionChoice.set("isDeleted",ConstantParas.isDeleted_true);
            questionChoice.set("modified",System.currentTimeMillis());
            return questionChoice.update();
        } else {
            return false;
        }
    }
}
