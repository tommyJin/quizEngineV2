/**
 * Created by tommy on 2016/5/24.
 */


function getType(id) {
    $.ajax({
        url: 'teacher/questiontype/get',
        type: 'GET',
        dataType: 'JSON',
        data: {'id': id},
        success: function (rs) {
            var questiontype = rs.data;
            $("#username").val(user.username);
            $("#username").attr('disabled', 'disabled');
            $("#password").val(user.password);
            $("#name").val(user.name);
            $("#email").val(user.email);
            $("#type option[value='"+user.type+"']").attr("selected",true);
        },
        error: function () {
            alert("Ajax error!");
        }
    });
}

function getTypes(showAll) {
    $.ajax({
        url: 'teacher/questiontype',
        type: 'GET',
        dataType: 'JSON',
        data: {},
        success: function (rs) {
            $("#type").empty();
            var code = rs.status;
            var data = rs.data;
            if(code==200){
                var list = data.list;
                var select = showAll?"<option  value='0'>All</option>":"";
                list.map(function(o){
                    select += "<option value='"+ o.id+"'>"+ o.name+"</option>";
                });
                $("#type").append(select);
            }
        },
        error: function () {
            alert("Ajax error!");
        }
    });
}

function getTypesForQuestion(showAll,id) {
    $.ajax({
        url: 'teacher/questiontype',
        type: 'GET',
        dataType: 'JSON',
        data: {},
        success: function (rs) {
            $("#type").empty();
            var code = rs.status;
            var data = rs.data;
            if(code==200){
                var list = data.list;
                var select = showAll?"<option>Please Choose One</option>":"";
                list.map(function(o){
                    select += "<option value='"+ o.id+"'>"+ o.name+"</option>";
                });
                $("#type").append(select);
                if(!showAll){
                    getQuestion(id);
                }
            }
        },
        error: function () {
            alert("Ajax error!");
        }
    });
}

function addType(){
    var username = $.trim($("#username").val());
    var password = $.trim($("#password").val());
    var name = $.trim($("#name").val());
    var email = $.trim($("#email").val());
    var type = $("#type").val();
    $.ajax({
        url:'teacher/questiontype/add',
        type:'POST',
        dataType:'JSON',
        data:{'paras.username':username,'paras.password':password,'paras.name':name,'paras.email':email,'paras.type':type},
        success: function(rs){
            var code = rs.status;
            var data = rs.data;
            if(code==200){
                alert(data.errmsg);
                $("#id").val(data.user.id);
            }else{
                alert(data);
            }

            //$("#id").val(data.user.id);
        },
        error: function(){
            alert("Ajax error!");
        }
    });
}

function updateType(){
    var id = $.trim($("#id").val());
    var password = $.trim($("#password").val());
    var name = $.trim($("#name").val());
    var email = $.trim($("#email").val());
    var type = $("#type").val();
    $.ajax({
        url:'teacher/questiontype/update',
        type:'POST',
        dataType:'JSON',
        data:{'paras.id':id,'paras.password':password,'paras.name':name,'paras.email':email,'paras.type':type},
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

function queryType(page) {
    var keyword = $.trim($("#keyword").val());
    var user_type = $("#user_type").val();
    $.ajax({
        url: 'teacher/questiontype',
        dataType: 'json',
        data: {'keyword': keyword, 'type': user_type, 'page': page},
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
                    "<td><a href='teacher/route/questiontype_detail?id="+ o.id+"' >" + o.username + "</a></td>" +
                    "<td>" + o.name + "</td>" +
                    "<td class='am-hide-sm-only'>" + userType(o.type) + "</td>" +
                    "<td class='am-hide-sm-only'>" + o.email + "</td>" +
                    "<td><div class='am-btn-toolbar'>" +
                    "<div class='am-btn-group am-btn-group-xs'>" +
                    "<a href='teacher/route/questiontype_detail?id=" + o.id + "' target='_blank' class='am-btn am-btn-default am-btn-xs am-text-secondary'><span class='am-icon-pencil-square-o'></span> Modify</a>" +
                    "<button type='button' onclick='deleteType(" + o.id + ")' class='am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only'><span class='am-icon-trash-o'></span> Delete</button>" +
                    "</div></div></td></tr>";
            });
            $("#list").append(list_list);

            $("#pager").empty();
            var page_list = "";
            for (var i = 1; i <= totalPage; i++) {
                page_list += "<li class='" + (pageNumber == i ? "am-active" : "") + "'><a href='' onclick='queryType(" + i + ");return false'>" + i + "</a></li>";
            }

            var pager = totalRow + " records<div class='am-fr'><ul class='am-pagination'>" +

                "<li class='" + (firstPage ? "am-disabled" : "") + "'><a href='' onclick='queryType(" + (pageNumber - 1) + ");return false'>pre</a></li>" +
                page_list +

                "<li class='" + (lastPage ? "am-disabled" : "") + "'><a href='' onclick='queryType(" + (pageNumber + 1) + ");return false'>next</a></li>" +

                '</ul></div>';
            $("#pager").append(pager);
        },
        error: function () {
            alert("Ajax error!")
        }
    });
}

function deleteType(id) {
    $.ajax({
        url: 'teacher/questiontype/delete',
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
