/**
 * Created by tommy on 2016/5/23.
 */
function userType(type){
    var user_type = "";
    if(type==1){
        user_type = "admin";
    }else if(type==2){
        user_type = "teacher";
    }else if(type==3){
        user_type = "student";
    }
    return user_type;
}

function uploadPath(){
    return "/teacher/upload/upload_img";
}