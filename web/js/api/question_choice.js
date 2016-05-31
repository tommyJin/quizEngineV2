/**
 * Created by tommy on 2016/5/31.
 */

function getQuestionChoice(question_id) {
    $.ajax({
        url: 'teacher/questionchoice/get',
        type: 'GET',
        dataType: 'JSON',
        data: {'question_id': question_id},
        success: function (rs) {
            var q = rs.data;
            $("#qc_content").val(q.content);
            initType();
        },
        error: function () {
            alert("Ajax error!");
        }
    });
}