package uk.ac.ncl.csc8499.model;

/**
 * Created by tommy on 2016/5/9.
 */
public class ConstantParas {
    //page information
    public static final int page = 1;
    public static final int size = 20;

    //upload info
    public static final int upload_success = 0;
    public static final int upload_failed = 1;
    public static final String upload_failed_wrong_format = "Upload failed! Picture format is invalid!";
    public static final String upload_failed_unknown = "Upload failed! Please try again!";

    //token information
    public static final int token_valid = 200;
    public static final int token_generate_success = 201;
    public static final int token_invalid = 400;
    public static final int token_generate_failed = 500;
    public static final String token_invalid_message = "Your login information expired! Please login again!";
    public static final String token_generate_failed_message = "Failed to login! Please try again!";

    //quiz number
    public static final int quiz_max_number = 20;
    public static final int quiz_min_number = 3;
    public static final int quiz_remove_answered = 1;
    public static final int quiz_keep_answered = 2;

    //user type
    public static final int usertype_null = 0;
    public static final int usertype_admin = 1;
    public static final int usertype_teacher = 2;
    public static final int usertype_student = 3;

    //question type
    public static final int questiontype_null = 0;

    //delete status
    public static final int isDeleted_false = 0;
    public static final int isDeleted_true = 1;

    //success message
    public static final String success_add = "Save success!";
    public static final String success_update = "Update success!";
    public static final String success_delete = "Delete success!";
    public static final String success_login = "Login success!";
    public static final String success_logout = "Logout success!";
    public static final String success_send_email = "Send email success!";

    //failure message
    public static final String failure_add = "Save failed!";
    public static final String failure_update = "Update failed!";
    public static final String failure_delete = "Delete failed!";

    //error message
    public static final String error_username_exists = "Username already exists!";
    public static final String error_username_not_exist = "Username does not exist!";
    public static final String error_question_not_exist = "Question does not exist!";
    public static final String error_question_tag_not_exist = "QuestionTag does not exist!";
    public static final String error_question_category_not_exist = "QuestionCategory does not exist!";
    public static final String error_question_type_not_exist = "QuestionType does not exist!";
    public static final String error_question_level_not_exist = "QuestionLevel does not exist!";
    public static final String error_question_choice_not_exist = "QuestionChoice does not exist!";
    public static final String error_quiz_not_exist = "Quiz does not exist!";
    public static final String error_quiz_question_not_exist = "This question does not exist!";
    public static final String error_quiz_record_not_exist =  "This question has not been answered!";
    public static final String error_quiz_record_exist = "This question has been answered!";
    public static final String error_wrong_password = "Wrong password!";
    public static final String error_wrong_email_format = "Wrong email format!";
    public static final String error_confirm_password_does_not_match = "Confirm password does not match password!";

    //hint can not be null
    public static final String hint_username_null = "Username can not be null!";
    public static final String hint_password_null = "Password can not be null!";
    public static final String hint_name_null = "Name can not be null!";
    public static final String hint_user_not_login = "Please login!";
    public static final String hint_repassword_null= "Confirm password can not be null!";
    public static final String hint_email_null= "Email can not be null!";
    public static final String hint_object_null = "Object is null!";
    public static final String hint_unknown = "Unknown reason, please retry!";
}
