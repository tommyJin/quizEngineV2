package uk.ac.ncl.csc8499.model.question_type;

/**
 * Created by tommy on 2016/5/13.
 */
public class Choice {
    boolean isMulti;//true-> multiple choice; false->one choice
//    String choice;//might contain A,B,C,D,E...
    String choice_A;//might contain A,B,C,D,E...
    String choice_B;//might contain A,B,C,D,E...
    String choice_C;//might contain A,B,C,D,E...
    String choice_D;//might contain A,B,C,D,E...
    String answer;//might be A or A,B or A,C,E

    public boolean isMulti() {
        return isMulti;
    }

    public void setIsMulti(boolean isMulti) {
        this.isMulti = isMulti;
    }

    public String getChoice_A() {
        return choice_A;
    }

    public void setChoice_A(String choice_A) {
        this.choice_A = choice_A;
    }

    public String getChoice_B() {
        return choice_B;
    }

    public void setChoice_B(String choice_B) {
        this.choice_B = choice_B;
    }

    public String getChoice_C() {
        return choice_C;
    }

    public void setChoice_C(String choice_C) {
        this.choice_C = choice_C;
    }

    public String getChoice_D() {
        return choice_D;
    }

    public void setChoice_D(String choice_D) {
        this.choice_D = choice_D;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
