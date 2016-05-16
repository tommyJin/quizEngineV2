package uk.ac.ncl.csc8499.model;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tommy on 2016/5/15.
 */
@TableBind(tableName = TableName.quiz)
public class Quiz extends Model<Quiz> {
    public static final Quiz dao = new Quiz();

    public Page<Quiz> query(Map<String, Object> filter){
        int page = filter.get("page")==null?ConstantParas.page:Integer.parseInt(filter.get("page").toString());
        int size = filter.get("size")==null?ConstantParas.size:Integer.parseInt(filter.get("size").toString());

        String select = "select * ";
        String where = "from "+TableName.quiz+" where 1=1 and isDeleted = "+ConstantParas.isDeleted_false+" ";

        if (filter.get("keyword")!=null && !filter.get("keyword").toString().equals("")){
            String keyword = filter.get("keyword").toString();
            where += " and ( name like '%"+keyword+"%' ) ";
        }

        if (filter.get("question_level_id")!=null){
            where += " and question_level_id = "+ Integer.parseInt(filter.get("question_level_id").toString());
        }

        if (filter.get("question_category_id")!=null){
            where += " and question_category_id = "+ Integer.parseInt(filter.get("question_category_id").toString());
        }

        if (filter.get("creator_id")!=null){
            where += " and creator_id = "+ Integer.parseInt(filter.get("creator_id").toString());
        }

        if (filter.get("id")!=null){
            where += " and id = "+Integer.parseInt(filter.get("id").toString());
        }

        String order = " order by "+ (filter.get("orderby")==null?"  created desc":filter.get("orderby").toString());
        System.out.println(select+where+order);
        return Quiz.dao.paginate(page, size, select, where + order);
    }

    public Quiz getBy(Map<String,Object> filter){
        String select = "select * ";
        String where = " from "+TableName.quiz+" where 1=1 and isDeleted = "+ConstantParas.isDeleted_false+" ";
        if (filter.get("id")!=null){
            where += " and id = "+Integer.parseInt(filter.get("id").toString());
        }
        if (filter.get("name")!=null && !filter.get("name").toString().equals("")){
            where += " and name = '"+filter.get("name").toString()+"' ";
        }
        if (!where.equals(" from "+TableName.quiz+" where 1=1 and isDeleted = "+ConstantParas.isDeleted_false+" ")){
            return Quiz.dao.find(select + where).size()>0? Quiz.dao.find(select + where).get(0):null;
        }else {
            return null;
        }
    }

    public boolean add(Quiz quiz) {
        Map<String, Object> filter = new HashMap<>();
        long timestamp = System.currentTimeMillis();
        quiz.set("created",timestamp);
        quiz.set("modified",timestamp);
        quiz.set("isDeleted",ConstantParas.isDeleted_false);
        return quiz.save();
    }

    public boolean update(Quiz quiz){
        Map<String, Object> filter = new HashMap<>();
        filter.put("id", quiz.get("id"));
        if (getBy(filter) != null) {
            quiz.set("modified",System.currentTimeMillis());
            return quiz.update();
        } else {
            return false;
        }
    }

    public boolean delete(Quiz quiz){
        Map<String, Object> filter = new HashMap<>();
        filter.put("id", quiz.get("id"));
        if (getBy(filter) != null) {
            quiz.set("isDeleted",ConstantParas.isDeleted_true);
            quiz.set("modified",System.currentTimeMillis());
            return quiz.update();
        } else {
            return false;
        }
    }
}
