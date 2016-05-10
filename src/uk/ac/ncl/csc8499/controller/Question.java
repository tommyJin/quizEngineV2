package uk.ac.ncl.csc8499.controller;

/**
 * Created by tommy on 2016/5/9.
 */
public interface Question {
    /*
    *  get one question by its id
    *  return question json info
    * */
    public String get(Long id);

    /*
    * send answer content json
    * return score
    * */
    public int answer(String json);

}
