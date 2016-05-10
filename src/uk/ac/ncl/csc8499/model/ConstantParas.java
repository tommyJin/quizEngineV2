package uk.ac.ncl.csc8499.model;

/**
 * Created by tommy on 2016/5/9.
 */
public class ConstantParas {
    //page information
    public static final int page = 1;
    public static final int size = 20;

    //user type
    public static final int usertype_null = 0;
    public static final int usertype_admin = 1;
    public static final int usertype_teacher = 2;
    public static final int usertype_student = 3;

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
}
