package uk.ac.ncl.csc8499.model;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tommy on 2016/5/15.
 */
@TableBind(tableName = TableName.quiz_question)
public class QuizQuestion extends Model<QuizQuestion>{
    public static final QuizQuestion dao = new QuizQuestion();

    public Page<QuizQuestion> query(Map<String, Object> filter){
        int page = filter.get("page")==null?ConstantParas.page:Integer.parseInt(filter.get("page").toString());
        int size = filter.get("size")==null?ConstantParas.size:Integer.parseInt(filter.get("size").toString());

        String select = "select * ";
        String where = "from "+TableName.quiz_question+" where 1=1 and isDeleted = "+ConstantParas.isDeleted_false+" ";

        if (filter.get("test_id")!=null){
            where += " and test_id = "+ Integer.parseInt(filter.get("test_id").toString());
        }

        if (filter.get("id")!=null){
            where += " and id = "+Integer.parseInt(filter.get("id").toString());
        }

        String order = " order by "+ (filter.get("orderby")==null?"  created desc":filter.get("orderby").toString());
        return QuizQuestion.dao.paginate(page, size, select, where + order);
    }

    public QuizQuestion getBy(Map<String,Object> filter){
        String select = "select * ";
        String where = " from "+TableName.quiz_question+" where 1=1 and isDeleted = "+ConstantParas.isDeleted_false+" ";
        if (filter.get("id")!=null){
            where += " and id = "+Integer.parseInt(filter.get("id").toString());
        }
        if (filter.get("test_id")!=null){
            where += " and test_id = "+Integer.parseInt(filter.get("test_id").toString());
        }
        if (!where.equals(" from "+TableName.quiz_question+" where 1=1 and isDeleted = "+ConstantParas.isDeleted_false+" ")){
            return QuizQuestion.dao.find(select + where).size()>0? QuizQuestion.dao.find(select + where).get(0):null;
        }else {
            return null;
        }
    }

    public boolean add(QuizQuestion test) {
        Map<String, Object> filter = new HashMap<>();
        long timestamp = System.currentTimeMillis();
        test.set("created",timestamp);
        test.set("modified",timestamp);
        test.set("isDeleted",ConstantParas.isDeleted_false);
        return test.save();
    }

    public boolean update(QuizQuestion test){
        Map<String, Object> filter = new HashMap<>();
        filter.put("id", test.get("id"));
        if (getBy(filter) != null) {
            test.set("modified",System.currentTimeMillis());
            return test.update();
        } else {
            return false;
        }
    }

    public boolean delete(QuizQuestion test){
        Map<String, Object> filter = new HashMap<>();
        filter.put("id", test.get("id"));
        if (getBy(filter) != null) {
            test.set("isDeleted",ConstantParas.isDeleted_true);
            test.set("modified",System.currentTimeMillis());
            return test.update();
        } else {
            return false;
        }
    }
}
