/**
 * Created by tommy on 2016/5/24.
 */

function addQuizQuestion(quiz_id,number){

    $.ajax({
        url:'teacher/quizquestion/autoGenerate',
        type:'POST',
        dataType:'JSON',
        data:{'id':quiz_id,'number':number},
        success: function(rs){
            var code = rs.status;
            var data = rs.data;
            if(code==200){
                $("#number").attr('disabled','disabled');
            }else{
                alert(data);
            }
        },
        error: function(){
            alert("Ajax error!");
        }
    });
}