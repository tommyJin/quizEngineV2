/**
 * Created by tommy on 2016/5/24.
 */


function getLevel(id) {
    $.ajax({
        url: 'teacher/questionlevel/get',
        type: 'GET',
        dataType: 'JSON',
        data: {'id': id},
        success: function (rs) {
            var level = rs.data;
            $("#name").val(level.name);
            $("#content").val(level.content);
        },
        error: function () {
            alert("Ajax error!");
        }
    });
}

function addLevel(){
    var name = $.trim($("#name").val());
    var content = $("#content").val();
    $.ajax({
        url:'teacher/questionlevel/add',
        type:'POST',
        dataType:'JSON',
        data:{'paras.name':name,'paras.content':content},
        success: function(rs){
            var code = rs.status;
            var data = rs.data;
            if(code==200){
                alert(data.errmsg);
                $("#id").val(data.q.id);
            }else{
                alert(data);
            }
        },
        error: function(){
            alert("Ajax error!");
        }
    });
}

function updateLevel(){
    var id = $.trim($("#id").val());
    var name = $.trim($("#name").val());
    var content = $("#content").val();
    $.ajax({
        url:'teacher/questionlevel/update',
        type:'POST',
        dataType:'JSON',
        data:{'paras.id':id,'paras.name':name,'paras.content':content},
        success: function(rs){
            var code = rs.status;
            var data = rs.data;
            alert(data);
        },
        error: function(){
            alert("Ajax error!");
        }
    });
}


function getLevels(showAll) {
    $.ajax({
        url: 'teacher/questionlevel',
        type: 'GET',
        dataType: 'JSON',
        data: {},
        success: function (rs) {
            $("#level").empty();
            var code = rs.status;
            var data = rs.data;
            if(code==200){
                var list = data.list;
                var select = showAll?"<option  value='0'>All</option>":"";
                list.map(function(o){
                    select += "<option value='"+ o.id+"'>"+ o.name+"</option>";
                });
                $("#level").append(select);
            }
        },
        error: function () {
            alert("Ajax error!");
        }
    });
}

function queryLevel(page) {
    var keyword = $.trim($("#keyword").val());
    $.ajax({
        url: 'teacher/questionlevel',
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
                list_list += "<tr id='tr_"+ o.id+"'><td><input type='checkbox' /></td>" +
                    "<td>" + o.id + "</td>" +
                    "<td><a href='teacher/route/level_detail?id="+ o.id+"' >" + o.name + "</a></td>" +
                    "<td><div class='am-btn-toolbar'>" +
                    "<div class='am-btn-group am-btn-group-xs'>" +
                    "<a href='teacher/route/level_detail?id=" + o.id + "' target='_blank' class='am-btn am-btn-default am-btn-xs am-text-secondary'><span class='am-icon-pencil-square-o'></span> Modify</a>" +
                    "<button type='button' onclick='deleteLevel(" + o.id + ")' class='am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only'><span class='am-icon-trash-o'></span> Delete</button>" +
                    "</div></div></td></tr>";
            });
            $("#list").append(list_list);

            $("#pager").empty();
            var page_list = "";
            for (var i = 1; i <= totalPage; i++) {
                page_list += "<li class='" + (pageNumber == i ? "am-active" : "") + "'><a href='' onclick='queryLevel(" + i + ");return false'>" + i + "</a></li>";
            }

            var pager = totalRow + " records<div class='am-fr'><ul class='am-pagination'>" +

                "<li class='" + (firstPage ? "am-disabled" : "") + "'><a href='' onclick='queryLevel(" + (pageNumber - 1) + ");return false'>pre</a></li>" +
                page_list +

                "<li class='" + (lastPage ? "am-disabled" : "") + "'><a href='' onclick='queryLevel(" + (pageNumber + 1) + ");return false'>next</a></li>" +

                '</ul></div>';
            $("#pager").append(pager);
        },
        error: function () {
            alert("Ajax error!")
        }
    });
}

function deleteLevel(id) {
    $.ajax({
        url: 'teacher/questionlevel/delete',
        type: 'GET',
        dataType: 'JSON',
        data: {'id': id},
        success: function (rs) {
            alert(rs.data);
            $("#tr_"+id).remove();
        },
        error: function () {
            alert("error!");
        }
    });
}