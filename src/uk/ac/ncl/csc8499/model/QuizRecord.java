package uk.ac.ncl.csc8499.model;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tommy on 2016/5/15.
 */
@TableBind(tableName = TableName.quiz_record)
public class QuizRecord extends Model<QuizRecord> {
    public static final QuizRecord dao = new QuizRecord();
    public Page<QuizRecord> query(Map<String, Object> filter){
        int page = filter.get("page")==null?ConstantParas.page:Integer.parseInt(filter.get("page").toString());
        int size = filter.get("size")==null?ConstantParas.size:Integer.parseInt(filter.get("size").toString());

        String select = "select * ";
        String where = "from "+TableName.quiz_record+" where 1=1 and isDeleted = "+ConstantParas.isDeleted_false+" ";

        if (filter.get("quiz_question_id")!=null){
            where += " and quiz_question_id = "+ Integer.parseInt(filter.get("quiz_question_id").toString());
        }

        if (filter.get("user_id")!=null){
            where += " and user_id = "+ Integer.parseInt(filter.get("user_id").toString());
        }

        if (filter.get("quiz_id")!=null){
            where += " and quiz_id = "+Integer.parseInt(filter.get("quiz_id").toString());
        }

        if (filter.get("id")!=null){
            where += " and id = "+Integer.parseInt(filter.get("id").toString());
        }

        String order = " order by "+ (filter.get("orderby")==null?"  created desc":filter.get("orderby").toString());
        return QuizRecord.dao.paginate(page, size, select, where + order);
    }

    public List<QuizRecord> getRecords(Map<String, Object> filter){
        String select = "select q.id question_id,q.content,q.mark,q.answer right_answer,q.feedback general_feedback,q.question_type_id,ql.name level_name,qr.answer user_answer,qr.mark user_mark ";
        String from = " from quiz_question qq left join quiz_record qr on qq.id = qr.quiz_question_id left join question q on q.id = qq.question_id left join question_level ql on q.question_level_id = ql.id ";
        String where = "where qq.quiz_id = "+filter.get("quiz_id")+" and qq.user_id = "+filter.get("user_id");
        return QuizRecord.dao.find(select+from+where);
    }

    public QuizRecord getBy(Map<String,Object> filter){
        String select = "select * ";
        String where = " from "+TableName.quiz_record+" where 1=1 and isDeleted = "+ConstantParas.isDeleted_false+" ";
        if (filter.get("id")!=null){
            where += " and id = "+Integer.parseInt(filter.get("id").toString());
        }

        if (filter.get("quiz_id")!=null){
            where += " and quiz_id = "+Integer.parseInt(filter.get("quiz_id").toString());
        }

        if (filter.get("user_id")!=null){
            where += " and user_id = "+Integer.parseInt(filter.get("user_id").toString());
        }

        if (filter.get("quiz_question_id")!=null){
            where += " and quiz_question_id = "+Integer.parseInt(filter.get("quiz_question_id").toString());
        }

        if (!where.equals(" from "+TableName.quiz_record+" where 1=1 and isDeleted = "+ConstantParas.isDeleted_false+" ")){
            return QuizRecord.dao.find(select + where).size()>0? QuizRecord.dao.find(select + where).get(0):null;
        }else {
            return null;
        }
    }

    public boolean add(QuizRecord test) {
        Map<String, Object> filter = new HashMap<>();
        long timestamp = System.currentTimeMillis();
        test.set("created",timestamp);
        test.set("modified",timestamp);
        test.set("isDeleted",ConstantParas.isDeleted_false);
        return test.save();
    }

    public boolean update(QuizRecord test){
        Map<String, Object> filter = new HashMap<>();
        filter.put("id", test.get("id"));
        if (getBy(filter) != null) {
            test.set("modified",System.currentTimeMillis());
            return test.update();
        } else {
            return false;
        }
    }

    public boolean delete(QuizRecord test){
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
