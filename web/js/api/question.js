/**
 * Created by tommy on 2016/5/24.
 */

function getQuestion(id) {
    $.ajax({
        url: 'teacher/question/get',
        type: 'GET',
        dataType: 'JSON',
        data: {'id': id},
        success: function (rs) {
            var question = rs.data;
            $("#name").val(question.name);
            $("#answer").val(question.answer);
            $("#mark").val(question.mark);
            ke_content.html(question.content);
            ke_feedback.html(question.feedback);
            $("#tag").val(question.question_tag);
            $("#category option[value='" + question.question_category_id + "']").attr("selected", true);
            $("#level option[value='" + question.question_level_id + "']").attr("selected", true);
            $("#type option[value='" + question.question_type_id + "']").attr("selected", true);
            getQuestionChoice(question.id);
        },
        error: function () {
            alert("Ajax error!");
        }
    });
}

function addQuestion() {
    var name = $.trim($("#name").val());
    var mark = $.trim($("#mark").val());
    var content = $("#content").val();
    var feedback = $("#feedback").val();
    var level = $("#level").val();
    var type = $("#type").val();
    var category = $("#category").val();
    var tag = $.trim($("#tag").val());
    if(!collect()){
        return;
    }//collect content of option
    var qc_content = $("#qc_content").val();
    var answer = $("#answer").val();
    var flag = true;
    if(flag){
        $.ajax({
            url: 'teacher/question/add',
            type: 'POST',
            dataType: 'JSON',
            data: {
                'q.name': name,
                'q.mark': mark,
                'q.content': content,
                'q.feedback': feedback,
                'q.question_level_id': level,
                'q.question_type_id': type,
                'q.question_category_id': category,
                'q.question_tag':tag,
                'qc.content': qc_content,
                'q.answer': answer
            },
            success: function (rs) {
                var code = rs.status;
                var data = rs.data;
                if (code == 200) {
                    alert(data.errmsg);
                    $("#id").val(data.q.id);
                } else {
                    alert(data);
                }
            },
            error: function () {
                alert("Ajax error!");
            }
        });
    }
}

function updateQuestion() {
    var id = $.trim($("#id").val());
    var name = $.trim($("#name").val());
    var mark = $.trim($("#mark").val());
    var content = $("#content").val();
    var feedback = $("#feedback").val();
    var level = $("#level").val();
    var type = $("#type").val();
    var category = $("#category").val();
    var tag = $.trim($("#tag").val());
    if(!collect()){
        return;
    }//collect content of option
    var qc_content = $("#qc_content").val();
    var answer = $("#answer").val();
    $.ajax({
        url: 'teacher/question/update',
        type: 'POST',
        dataType: 'JSON',
        data: {
            'q.id':id,
            'q.name': name,
            'q.mark': mark,
            'q.content': content,
            'q.feedback': feedback,
            'q.question_level_id': level,
            'q.question_type_id': type,
            'q.question_category_id': category,
            'q.question_tag':tag,
            'qc.content': qc_content,
            'q.answer': answer
        },
        success: function (rs) {
            var code = rs.status;
            var data = rs.data;
            alert(data);
        },
        error: function () {
            alert("Ajax error!");
        }
    });
}

function queryQuestion(page) {
    var keyword = $.trim($("#keyword").val());
    var type = $("#type").val();
    var category = $("#category").val();
    var level = $("#level").val();
    $.ajax({
        url: 'teacher/question',
        dataType: 'json',
        data: {
            'keyword': keyword,
            'question_type_id': type,
            'question_category_id': category,
            'question_level_id': level,
            'page': page
        },
        type: 'GET',
        success: function (rs) {
            var data = rs.data;
            var list = data.list;
            pageNumber = data.pageNumber;
            var pageSize = data.pageSize;
            var totalPage = data.totalPage;
            var totalRow = data.totalRow;
            var firstPage = data.firstPage;
            var lastPage = data.lastPage;


            $("#list").empty();
            var list_list = "";

            list.map(function (o) {
                list_list += "<tr id='tr_" + o.id + "'><td><input type='checkbox' /></td>" +
                    "<td><a href='teacher/route/question_detail?id=" + o.id + "' >" + o.name + "</a></td>" +
                    "<td class='am-hide-sm-only'>" + o.category_name + "</td>" +
                    "<td class='am-hide-sm-only'>" + o.level_name + "</td>" +
                    "<td class='am-hide-sm-only'>" + o.question_tag + "</td>" +
                    "<td class='am-hide-sm-only'>" + o.type_name + "</td>" +
                    "<td><div class='am-btn-toolbar'>" +
                    "<div class='am-btn-group am-btn-group-xs'>" +
                    "<a href='teacher/route/question_detail?id=" + o.id + "' target='_blank' class='am-btn am-btn-default am-btn-xs am-text-secondary'><span class='am-icon-pencil-square-o'></span> Modify</a>" +
                    "<button type='button' onclick='deleteQuestion(" + o.id + ")' class='am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only'><span class='am-icon-trash-o'></span> Delete</button>" +
                    "</div></div></td></tr>";
            });
            $("#list").append(list_list);

            $("#pager").empty();
            var page_list = "";
            for (var i = 1; i <= totalPage; i++) {
                page_list += "<li class='" + (pageNumber == i ? "am-active" : "") + "'><a href='' onclick='queryQuestion(" + i + ");return false'>" + i + "</a></li>";
            }

            var pager = totalRow + " records<div class='am-fr'><ul class='am-pagination'>" +

                "<li class='" + (firstPage ? "am-disabled" : "") + "'><a href='' onclick='queryQuestion(" + (pageNumber - 1) + ");return false'>pre</a></li>" +
                page_list +

                "<li class='" + (lastPage ? "am-disabled" : "") + "'><a href='' onclick='queryQuestion(" + (pageNumber + 1) + ");return false'>next</a></li>" +

                '</ul></div>';
            $("#pager").append(pager);
        },
        error: function () {
            alert("Ajax error!")
        }
    });
}

function deleteQuestion(id) {
    if (confirm("Delete for sure?")) {
        $.ajax({
            url: 'teacher/question/delete',
            type: 'GET',
            dataType: 'JSON',
            data: {'id': id},
            success: function (rs) {
                alert(rs.data);
                $("#tr_" + id).remove();
            },
            error: function () {
                alert("error!");
            }
        });
    }
}