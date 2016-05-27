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

        String select = "select q.*,u.name user_name,ql.name level_name,qc.name category_name ";
        String where = " from "+TableName.quiz+" q,"+TableName.user+" u,"+TableName.question_level+" ql,"+TableName.question_category+" qc  where 1=1 and q.isDeleted = "+ConstantParas.isDeleted_false+" and q.creator_id=u.id and q.question_level_id=ql.id and q.question_category_id=qc.id ";

        if (filter.get("keyword")!=null && !filter.get("keyword").toString().equals("")){
            String keyword = filter.get("keyword").toString();
            where += " and ( q.name like '%"+keyword+"%' or  u.name like '%"+keyword+"%' or  u.username like '%"+keyword+"%' ) ";
        }

        if (filter.get("question_level_id")!=null){
            where += " and q.question_level_id = "+ Integer.parseInt(filter.get("question_level_id").toString());
        }

        if (filter.get("question_category_id")!=null){
            where += " and q.question_category_id = "+ Integer.parseInt(filter.get("question_category_id").toString());
        }

        if (filter.get("creator_id")!=null){
            where += " and q.creator_id = "+ Integer.parseInt(filter.get("creator_id").toString());
        }

        if (filter.get("id")!=null){
            where += " and q.id = "+Integer.parseInt(filter.get("id").toString());
        }

        String order = " order by "+ (filter.get("orderby")==null?"  q.created desc":filter.get("orderby").toString());
        System.out.println(select+where+order);
        return Quiz.dao.paginate(page, size, select, where + order);
    }

    public Quiz getBy(Map<String,Object> filter){
        String select = "select q.*,u.name user_name,ql.name level_name,qc.name category_name ";
        String where = " from "+TableName.quiz+" q,"+TableName.user+" u,"+TableName.question_level+" ql,"+TableName.question_category+" qc  where 1=1 and q.isDeleted = "+ConstantParas.isDeleted_false+" and q.creator_id=u.id and q.question_level_id=ql.id and q.question_category_id=qc.id ";

        if (filter.get("creator_id")!=null){
            where += " and q.creator_id = "+ Integer.parseInt(filter.get("creator_id").toString());
        }

        if (filter.get("id")!=null){
            where += " and q.id = "+Integer.parseInt(filter.get("id").toString());
        }

        if (!where.equals(" from "+TableName.quiz+" q,"+TableName.user+" u,"+TableName.question_level+" ql,"+TableName.question_category+" qc  where 1=1 and q.isDeleted = "+ConstantParas.isDeleted_false+" and q.creator_id=u.id and q.question_level_id=ql.id and q.question_category_id=qc.id ")){
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
