package uk.ac.ncl.csc8499.controller.student;

import com.google.gson.Gson;
import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
import uk.ac.ncl.csc8499.Util.RestResult;
import uk.ac.ncl.csc8499.controller.BaseController;
import uk.ac.ncl.csc8499.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tommy on 2016/5/16.
 */
@ControllerBind(controllerKey = "/student/quiz")
public class QuizController extends BaseController {
    Gson gson = new Gson();

    public void index() {
        Long id = getPara("id") == null ? 0 : getParaToLong("id");
        Map<String, Object> filter = new HashMap<>();
        int page = getPara("page") == null ? ConstantParas.page : getParaToInt("page");
        int size = getPara("size") == null ? ConstantParas.size : getParaToInt("size");
        filter.put("page", page);
        filter.put("size", size);
        Integer level_id = getPara("level_id") == null ? null : Integer.valueOf(getPara("level_id").toString().trim());
        Integer category_id = getPara("category_id") == null ? null : Integer.valueOf(getPara("category_id").toString().trim());
        User currentUser = getTokenUser(id);
        String keyword = getPara("keyword") == null ? null : getPara("keyword").trim();
        String orderby = getPara("orderby") == null ? null : getPara("orderby").trim();

        if (level_id != null) {
            filter.put("question_level_id", level_id);
        }
        if (category_id != null) {
            filter.put("question_category_id", category_id);
        }
        filter.put("creator_id", id);
        filter.put("keyword", keyword);
        filter.put("orderby", orderby);

        renderJson(RestResult.ok(Quiz.dao.query(filter)));
    }

    public void get() {
        Long id = getPara("id") == null ? 0 : getParaToLong("id");
        Long quiz_id = getPara("quiz_id") == null ? 0 : getParaToLong("quiz_id");
        Map<String, Object> filter = new HashMap<>();
        filter.put("id", quiz_id);
        filter.put("creator_id", id);
        Quiz q = Quiz.dao.getBy(filter);
        if (q != null) {
            renderJson(RestResult.ok(q));
        } else {
            renderJson(RestResult.error(ConstantParas.error_quiz_not_exist));
        }
    }

    public void add() {
        Quiz q = getModel(Quiz.class, "paras");//paras.*
//        Integer answered = getPara("answered")==null?2:getParaToInt("answered");//1->remove  2->dont remove
        Long id = getPara("id") == null ? 0 : getParaToLong("id");
        String topic_id = getPara("topic_id");
        Map<String, Object> filter = new HashMap<>();
        User currentUser = getTokenUser(id);
        if (q != null) {
            q.set("creator_id", currentUser.get("id"));
            if (q.get("name") == null) {
                String name = "";
                filter.put("id", q.get("question_category_id"));
                name += QuestionCategory.dao.getBy(filter).get("name") + " ";
                filter.clear();
                filter.put("id", q.get("question_level_id"));
                name += QuestionLevel.dao.getBy(filter).get("name") + " ";
                name += currentUser.get("name");
                q.set("name", name);
            }
            if (q.get("content") == null) {
                q.set("content", "Generated by " + currentUser.get("name"));
            }
            q.set("question_topic_id", topic_id);
            if (Quiz.dao.add(q)) {

                //auto generate questions
                int total_mark = QuizQuestion.dao.autoGenerate(q);//quiz_question id list
                q.set("total_mark", total_mark);
                Quiz.dao.update(q);
                renderJson(RestResult.ok(q));
            } else {
                renderJson(RestResult.error(ConstantParas.failure_add));
            }
        } else {
            renderJson(RestResult.error(ConstantParas.hint_object_null));
        }
    }

    public void delete() {
        Long id = getPara("id") == null ? 0 : getParaToLong("id");
        Long quiz_id = getPara("quiz_id") == null ? 0 : getParaToLong("quiz_id");
        Map<String, Object> filter = new HashMap<>();
        filter.put("creator_id", id);
        filter.put("id", quiz_id);
        Quiz q = Quiz.dao.getBy(filter);
        if (q != null) {
            if (Quiz.dao.delete(q)) {
                renderJson(RestResult.error(ConstantParas.success_delete));
            } else {
                renderJson(RestResult.error(ConstantParas.failure_delete));
            }
        } else {
            renderJson(RestResult.error(ConstantParas.error_quiz_not_exist));
        }
    }

    public void record() {
        Long id = getPara("id") == null ? null : getParaToLong("id");
        Map<String, Object> filter = new HashMap<>();
        Integer quiz_id = getPara("quiz_id") == null ? null : getParaToInt("quiz_id");
        filter.put("creator_id", id);
        filter.put("id", quiz_id);
        Quiz q = Quiz.dao.getBy(filter);
        if (q != null) {
            filter.clear();
            filter.put("user_id", id);
            filter.put("quiz_id", quiz_id);
            renderJson(RestResult.ok(QuizRecord.dao.getRecords(filter)));
        } else {
            renderJson(RestResult.error(ConstantParas.error_quiz_not_exist));
        }

    }

    public void retake() {
        Long id = getPara("id") == null ? 0 : getParaToLong("id");
        Long quiz_id = getPara("quiz_id") == null ? 0 : getParaToLong("quiz_id");
        Map<String, Object> filter = new HashMap<>();
        User currentUser = getTokenUser(id);

        filter.put("id", quiz_id);
        filter.put("creator_id", id);
        Quiz q = Quiz.dao.getBy(filter);
        if (q != null) {
            filter.clear();
            filter.put("quiz_id", quiz_id);
            List<QuizQuestion> qq = QuizQuestion.dao.queryOnlyQuizQuestion(filter);
            if (qq.size() == Integer.parseInt(q.get("number").toString())) {
//                Quiz new_q = new Quiz();
//                new_q.set("name",q.get("name"));
//                new_q.set("number",q.get("number"));
//                new_q.set("answered",q.get("answered"));
//                new_q.set("content",q.get("content"));
//                new_q.set("creator_id",id);
//                new_q.set("question_category_id",q.get("question_category_id"));
//                new_q.set("question_topic_id",q.get("question_topic_id"));
//                new_q.set("question_level_id",q.get("question_level_id"));
//                new_q.set("total_mark",q.get("total_mark"));
//                new_q.set("mark",0);
                q.remove("id");
                q.remove("mark");
                if (Quiz.dao.add(q)) {
                    int number = 0;
                    for (int i = 0; i < qq.size(); i++) {
                        qq.get(i).remove("id");
                        qq.get(i).set("quiz_id", q.get("id"));
                        System.out.println("qq:" + gson.toJson(qq.get(i)));
                        if (QuizQuestion.dao.add(qq.get(i))) {
                            number++;
                        } else {
                            System.out.println("Quiz Question id=" + qq.get(i).get("id") + " create failed!");
                        }
                    }
                    if (number == qq.size()) {
                        renderJson(RestResult.ok(q));
                    } else {
                        Quiz.dao.delete(q);
                        renderJson(RestResult.error(ConstantParas.error_quiz_retake_fail));
                    }
                } else {
                    renderJson(RestResult.error(ConstantParas.error_quiz_retake_fail));
                }
            } else {
                renderJson(RestResult.error(ConstantParas.error_quiz_question_not_match));
            }
        } else {
            renderJson(RestResult.error(ConstantParas.error_quiz_not_exist));
        }

    }

    public void quizLevelAnalysis() {
        Long id = getPara("id") == null ? 0 : getParaToLong("id");
        Long quiz_id = getPara("quiz_id") == null ? 0 : getParaToLong("quiz_id");
        Map<String, Object> filter = new HashMap<>();

        filter.put("id", quiz_id);
        filter.put("creator_id", id);
        Quiz q = Quiz.dao.getBy(filter);
        filter.clear();
        if (q != null) {
            List<QuizQuestion> qq = QuizQuestion.dao.quizLevelAnalysis(quiz_id, id);
            Double total_mark = 0.00;
            Double student_mark = 0.00;
            List<String> topic_idList = new ArrayList<>();
            List<String> level_idList = new ArrayList<>();
            List<QuizQuestion> rightList = new ArrayList<>();
            List<QuizQuestion> wrongList = new ArrayList<>();
            Map<String, String> levelNameMap = new HashMap<>();
            String general_feedback = "";
            for (int i = 0; i < qq.size(); i++) {
                Double mark = Double.parseDouble(qq.get(i).get("mark").toString());
                Double student_m = Double.parseDouble(qq.get(i).get("student_mark").toString());
                total_mark += mark;
                student_mark += student_m;
                if (student_m > 0) {
                    rightList.add(qq.get(i));
                } else {
                    wrongList.add(qq.get(i));
                }
                if (!level_idList.contains(qq.get(i).get("level_id"))) {
                    level_idList.add(qq.get(i).get("level_id").toString());
                    levelNameMap.put(qq.get(i).get("level_id").toString(), qq.get(i).get("level_name"));
                }
                String topic_id = qq.get(i).get("topic_id");
                if (topic_id != null && topic_id.length() > 0) {
                    if (topic_id.contains(",")) {
                        String[] topic_ids = topic_id.split(",");
                        for (int j = 0; j < topic_ids.length; j++) {
                            if (!topic_idList.contains(topic_ids[j])) {
                                topic_idList.add(topic_ids[j]);
                            }
                        }
                    } else {
                        if (!topic_idList.contains(topic_id)) {
                            topic_idList.add(topic_id);
                        }
                    }
                }
            }
            System.out.println("total_mark=" + total_mark);
            System.out.println("student_mark=" + student_mark);
            System.out.println("topic_idList=" + gson.toJson(topic_idList));
            System.out.println("level_idList=" + gson.toJson(level_idList));
            System.out.println("levelNameMap=" + gson.toJson(levelNameMap));
            System.out.println("rightList=" + gson.toJson(rightList));
            System.out.println("wrongList=" + gson.toJson(wrongList));

            Map<String, Integer> levelWrongMap = new HashMap<>();
            for (int i = 0; i < level_idList.size(); i++) {
                levelWrongMap.put(level_idList.get(i), 0);
            }
            System.out.println("levelWrongMap=" + gson.toJson(levelWrongMap));
//            System.out.println(levelWrongMap.get("5"));

            general_feedback = "For this quiz, you got " + student_mark + " out of " + total_mark +
                    ". You made " + wrongList.size() + " mistake" + (wrongList.size() > 1 ? "s" : "") + " out of " + (wrongList.size() + rightList.size()) + " questions, " + judge(student_mark, total_mark) + ".";

            String topic_feedback = "";
            for (int i = 0; i < topic_idList.size(); i++) {
                filter.clear();
                filter.put("id", Integer.parseInt(topic_idList.get(i)));
                QuestionTopic qt = QuestionTopic.dao.getBy(filter);

//                System.out.println("before levelWrongMap="+gson.toJson(levelWrongMap));
                for (int j = 0; j < wrongList.size(); j++) {
                    String topic_id = "," + wrongList.get(j).get("topic_id") + ",";
//                    System.out.println("j="+j+" wrong list topic_id="+topic_id+"  "+ !topic_id.equals(",,")+"   topic_idList.get("+i+")="+topic_idList.get(i));
                    if (!topic_id.equals(",,")) {
                        if (topic_id.contains("," + topic_idList.get(i) + ",")) {
                            String level_id = wrongList.get(j).get("level_id").toString();
//                            System.out.println("level_id="+level_id);
                            levelWrongMap.put(level_id, levelWrongMap.get("" + level_id + "") + 1);//add one to this level wrong
                        }
                    } else {
                        System.out.println("this question topic_id is null");
                    }
                }
//                System.out.println("1 after levelWrongMap="+gson.toJson(levelWrongMap));

                String each_topic_feedback = " For topic " + qt.get("name") + ": ";
                for (Map.Entry<String, Integer> entry : levelWrongMap.entrySet()) {
//                    System.out.println(entry.getKey()+" = "+entry.getValue()+" >0? "+(entry.getValue()>0));
                    if (entry.getValue() > 0) {
                        each_topic_feedback += entry.getValue() + " mistake" + (entry.getValue() > 1 ? "s" : "") + " were made at level " + levelNameMap.get(entry.getKey()) + ", ";
                        double score = (double)entry.getValue() / wrongList.size() * 100;
                        System.out.println("score="+score);
                        if (score >= 80.0) {
                            each_topic_feedback += "you should choose easier levels to practise and choose this level when you are ready.";
                        } else if (score >= 60 && score < 80) {
                            each_topic_feedback += "you should practise more to fit in this level,";
                        } else if (score >= 40 && score < 60) {
                            each_topic_feedback += "you can improve your skill by practising this level more.";
                        } else if (score < 40) {
                            each_topic_feedback += "you do well at this level and you can choose harder level.";
                        }

//                        System.out.println(topic_feedback);
                    }
                    levelWrongMap.put(entry.getKey(), 0);
                }
                if (!each_topic_feedback.equals(" For topic " + qt.get("name") + ": ")) {
                    topic_feedback += each_topic_feedback;
                }
//                System.out.println("2 after levelWrongMap="+gson.toJson(levelWrongMap));
            }
//            System.out.println("topic_feedback="+topic_feedback);

            renderJson(RestResult.ok(general_feedback + topic_feedback));
        } else {
            renderJson(RestResult.error(ConstantParas.error_quiz_not_exist));
        }
    }

    public void overallFeedback() {
        Long id = getPara("id") == null ? 0 : getParaToLong("id");
        Long quiz_id = getPara("quiz_id") == null ? 0 : getParaToLong("quiz_id");
        Map<String, Object> filter = new HashMap<>();

        filter.put("id", quiz_id);
        filter.put("creator_id", id);
        Quiz q = Quiz.dao.getBy(filter);
        filter.clear();
        String overallFeedback = "";
        if (q != null) {
            filter.put("id", q.get("question_category_id"));
            QuestionCategory qc = QuestionCategory.dao.getBy(filter);
            System.out.println("qc=" + gson.toJson(qc));
            filter.clear();
            filter.put("question_category_id", q.get("question_category_id"));
            filter.put("creator_id", id);
            filter.put("page", 1);
            filter.put("size", 10000000);
            List<Quiz> quizzes = Quiz.dao.query(filter).getList();//find all quizzes
//            System.out.println("quizzes="+gson.toJson(quizzes));
            filter.clear();
            List quiz_ids = new ArrayList();
            for (int i = 0; i < quizzes.size(); i++) {
                quiz_ids.add(quizzes.get(i).get("id"));
            }
            List<QuizQuestion> qq = QuizQuestion.dao.overallLevelAnalysis(quiz_ids, id);//all quiz questions
//            System.out.println("qq="+gson.toJson(qq));

            Double total_mark = 0.00;
            Double student_mark = 0.00;
            List<String> topic_idList = new ArrayList<>();
            List<QuizQuestion> rightList = new ArrayList<>();
            List<QuizQuestion> wrongList = new ArrayList<>();
            Map<String, String> topicNameMap = new HashMap<>();
            for (int i = 0; i < qq.size(); i++) {
                Double mark = Double.parseDouble(qq.get(i).get("mark").toString());
                Double student_m = Double.parseDouble(qq.get(i).get("student_mark").toString());
                total_mark += mark;
                student_mark += student_m;
                if (student_m > 0) {
                    rightList.add(qq.get(i));
                } else {
                    wrongList.add(qq.get(i));
                }

                String topic_id = qq.get(i).get("topic_id");
                if (topic_id != null && topic_id.length() > 0) {
                    if (topic_id.contains(",")) {
                        String[] topic_ids = topic_id.split(",");
                        for (int j = 0; j < topic_ids.length; j++) {
                            if (!topic_idList.contains(topic_ids[j])) {
                                topic_idList.add(topic_ids[j]);
                            }
                        }
                    } else {
                        if (!topic_idList.contains(topic_id)) {
                            topic_idList.add(topic_id);
                        }
                    }
                }
            }
            System.out.println("total_mark=" + total_mark);
            System.out.println("student_mark=" + student_mark);
            System.out.println("topic_idList=" + gson.toJson(topic_idList));
            System.out.println("rightList=" + gson.toJson(rightList));
            System.out.println("wrongList=" + gson.toJson(wrongList));

            Map<String, Integer> topicWrongMap = new HashMap<>();
            Map<String, Integer> topicRightMap = new HashMap<>();
            for (int i = 0; i < topic_idList.size(); i++) {
                topicWrongMap.put(topic_idList.get(i), 0);
                topicRightMap.put(topic_idList.get(i), 0);
            }
            System.out.println("topicWrongMap=" + gson.toJson(topicWrongMap));
//            System.out.println(levelWrongMap.get("5"));

            overallFeedback = "Generally speaking, you are " + judge(student_mark, total_mark) + " in this module.";

            for (int i = 0; i < topic_idList.size(); i++) {
                filter.clear();
                filter.put("id", Integer.parseInt(topic_idList.get(i)));
                QuestionTopic qt = QuestionTopic.dao.getBy(filter);

//                System.out.println("before levelWrongMap="+gson.toJson(levelWrongMap));
                for (int j = 0; j < wrongList.size(); j++) {
                    String topic_id = "," + wrongList.get(j).get("topic_id") + ",";
                    if (!topic_id.equals(",,")) {
                        if (topic_id.contains("," + topic_idList.get(i) + ",")) {
                            topicWrongMap.put(topic_idList.get(i), topicWrongMap.get("" + topic_idList.get(i) + "") + 1);//add one to this level wrong
                        }
                    } else {
                        System.out.println("this question topic_id is null");
                    }
                }
                System.out.println("1 after topicWrongMap=" + gson.toJson(topicWrongMap));

                for (int j = 0; j < rightList.size(); j++) {
                    String topic_id = "," + rightList.get(j).get("topic_id") + ",";
                    if (!topic_id.equals(",,")) {
                        if (topic_id.contains("," + topic_idList.get(i) + ",")) {
                            topicRightMap.put(topic_idList.get(i), topicRightMap.get("" + topic_idList.get(i) + "") + 1);//add one to this level wrong
                        }
                    } else {
                        System.out.println("this question topic_id is null");
                    }
                }
                System.out.println("1 after topicRightMap=" + gson.toJson(topicRightMap));
                String each_topic_feedback = "";

                String topic_name = qt.get("name");
                System.out.println("id="+topic_idList.get(i)+" "+topic_name+"  wrong value="+topicWrongMap.get(topic_idList.get(i))+"  right value="+topicRightMap.get(topic_idList.get(i)));
                double score = (double)topicWrongMap.get(topic_idList.get(i)) / (topicWrongMap.get(topic_idList.get(i)) + topicRightMap.get(topic_idList.get(i))) * 100;

                System.out.println(topic_name + " = " + score);
                if (score >= 80.0) {
                    each_topic_feedback += "You do quite bad and are supposed to practise more about topic " + topic_name + ".";
                } else if (score >= 60 && score < 80) {
                    each_topic_feedback += "You are not good at this topic and you can improve more in topic" + topic_name + ".";
                } else if (score >= 40 && score < 60) {
                    each_topic_feedback += "Your score showed that you do not know " + topic_name + " quite well, and it is necessary to do more quizzes.";
                } else if (score >= 20 && score < 40) {
                    each_topic_feedback += "You have done a good job in answering " + topic_name + " questions, but you can be better.";
                } else if (score < 20) {
                    each_topic_feedback += "You are good at topic " + topic_name + ".";
                }
                topicWrongMap.put(topic_idList.get(i), 0);
                topicRightMap.put(topic_idList.get(i), 0);
                if (!each_topic_feedback.equals("")) {
                    overallFeedback += each_topic_feedback;
                }
            }
            renderJson(RestResult.ok(overallFeedback));
        } else {
            renderJson(RestResult.error(ConstantParas.error_quiz_not_exist));
        }
    }


    private String judge(double nmerator, double denominator) {
        String rs = "";
        double result = nmerator / denominator * 100;
        if (result >= 90) {
            rs = "excellent";
        } else if (result >= 70 && result < 90) {
            rs = "good";
        } else if (result >= 50 && result < 70) {
            rs = "not bad";
        } else if (result >= 30 && result < 50) {
            rs = "bad";
        } else if (result < 30) {
            rs = "very bad";
        }
        return rs;
    }
}
