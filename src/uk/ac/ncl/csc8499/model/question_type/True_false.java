package uk.ac.ncl.csc8499.model.question_type;

/**
 * Created by tommy on 2016/5/13.
 */
public class True_false {
    String true_content;
    String false_content;
    boolean answer;

    public True_false() {
    }

    public String getTrue_content() {
        return true_content;
    }

    public void setTrue_content(String true_content) {
        this.true_content = true_content;
    }

    public String getFalse_content() {
        return false_content;
    }

    public void setFalse_content(String false_content) {
        this.false_content = false_content;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
