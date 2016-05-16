package uk.ac.ncl.csc8499.model;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import uk.ac.ncl.csc8499.Util.CommonTool;

import java.util.*;

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

        if (filter.get("quiz_id")!=null){
            where += " and quiz_id = "+ Integer.parseInt(filter.get("quiz_id").toString());
        }

        if (filter.get("question_id")!=null){
            where += " and question_id = "+ Integer.parseInt(filter.get("question_id").toString());
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
        if (filter.get("quiz_id")!=null){
            where += " and quiz_id = "+Integer.parseInt(filter.get("quiz_id").toString());
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

    /**
    * Generate greater than min questions
    * */
    public List autoGenerate(Quiz quiz, int number){
        boolean flag = true;
        Random r = new Random();
        int mark = 0;

        Integer quiz_id = quiz.get("id");
        Integer category_id = quiz.get("question_category_id");
        Integer level_id = quiz.get("question_level_id");

        Map<String,Object> filter = new HashMap<>();
        filter.put("question_level_id",level_id);
        filter.put("question_category_id",category_id);
        List<Question> questions = Question.dao.query(filter).getList();
        int size = questions.size();
        if (number < ConstantParas.quiz_min_number) {
            number = r.nextInt(ConstantParas.quiz_max_number - ConstantParas.quiz_min_number) + ConstantParas.quiz_min_number;
        }
        if (size > ConstantParas.quiz_min_number) {
            while (number > size){
                number = r.nextInt(ConstantParas.quiz_max_number-ConstantParas.quiz_min_number)+ConstantParas.quiz_min_number;
            }
        }else {
            flag = false;
        }
        List selected = new ArrayList<>();
        if (flag){
            List<Integer> index = CommonTool.getIndex(number,size);
            for (int i = 0; i < index.size(); i++) {
                selected.add(questions.get(index.get(i)).get("id"));
            }

            for (int i = 0; i < selected.size(); i++) {
                QuizQuestion qq = new QuizQuestion();
                qq.set("quiz_id",quiz_id);
                qq.set("question_id",selected.get(i));
                filter.clear();
                filter.put("id",selected.get(i));
                Question question = Question.dao.getBy(filter);
                qq.set("mark",question.get("mark"));
                QuizQuestion.dao.add(qq);
            }
        }

        return selected;
    }
}