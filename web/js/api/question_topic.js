/**
 * Created by tommy on 2016/5/24.
 */

function getTopic(id) {
    $.ajax({
        url: 'teacher/questiontopic/get',
        type: 'GET',
        dataType: 'JSON',
        data: {'id': id},
        success: function (rs) {
            var topic = rs.data;
            $("#name").val(topic.name);
            $("#content").val(topic.content);
            $("#category option[value='" + topic.category_id + "']").attr("selected", true);
        },
        error: function () {
            alert("Ajax error!");
        }
    });
}

function addTopic() {
    var name = $.trim($("#name").val());
    var content = $("#content").val();
    var category = $("#category").val();
    $.ajax({
        url: 'teacher/questiontopic/add',
        type: 'POST',
        dataType: 'JSON',
        data: {'paras.name': name, 'paras.content': content, 'paras.category_id':category},
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

function updateTopic() {
    var id = $.trim($("#id").val());
    var name = $.trim($("#name").val());
    var content = $("#content").val();
    var category = $("#category").val();
    $.ajax({
        url: 'teacher/questiontopic/update',
        type: 'POST',
        dataType: 'JSON',
        data: {'paras.id': id, 'paras.name': name, 'paras.content': content,'paras.category_id':category},
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

function queryTopic(page) {
    var keyword = $.trim($("#keyword").val());
    $.ajax({
        url: 'teacher/questiontopic',
        dataType: 'json',
        data: {'keyword': keyword, 'page': page},
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
                    "<td>" + o.id + "</td>" +
                    "<td><a href='teacher/route/topic_detail?id=" + o.id + "' >" + o.name + "</a></td>" +
                    "<td><div class='am-btn-toolbar'>" +
                    "<div class='am-btn-group am-btn-group-xs'>" +
                    "<a href='teacher/route/topic_detail?id=" + o.id + "' target='_blank' class='am-btn am-btn-default am-btn-xs am-text-secondary'><span class='am-icon-pencil-square-o'></span> Modify</a>" +
                    "<button type='button' onclick='deleteTopic(" + o.id + ")' class='am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only'><span class='am-icon-trash-o'></span> Delete</button>" +
                    "</div></div></td></tr>";
            });
            $("#list").append(list_list);

            $("#pager").empty();
            var page_list = "";
            for (var i = 1; i <= totalPage; i++) {
                page_list += "<li class='" + (pageNumber == i ? "am-active" : "") + "'><a href='' onclick='queryTopic(" + i + ");return false'>" + i + "</a></li>";
            }

            var pager = totalRow + " records<div class='am-fr'><ul class='am-pagination'>" +

                "<li class='" + (firstPage ? "am-disabled" : "") + "'><a href='' onclick='queryTopic(" + (pageNumber - 1) + ");return false'>pre</a></li>" +
                page_list +

                "<li class='" + (lastPage ? "am-disabled" : "") + "'><a href='' onclick='queryTopic(" + (pageNumber + 1) + ");return false'>next</a></li>" +

                '</ul></div>';
            $("#pager").append(pager);
        },
        error: function () {
            alert("Ajax error!")
        }
    });
}

function deleteTopic(id) {
    if (confirm("Delete for sure?")) {
        $.ajax({
            url: 'teacher/questiontopic/delete',
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
