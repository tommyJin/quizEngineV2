/**
 * Created by tommy on 2016/5/23.
 */


function getUser(id, type) {
    $.ajax({
        url: userType(type) + '/user/get',
        type: 'GET',
        dataType: 'JSON',
        data: {'id': id},
        success: function (rs) {
            var user = rs.data.user;
            var categories = rs.data.categories;
            $("#username").val(user.username);
            $("#username").attr('disabled', 'disabled');
            $("#password").val(user.password);
            $("#name").val(user.name);
            $("#email").val(user.email);
            $("#type option[value='" + user.type + "']").attr("selected", true);
            setCheckedCategories(categories);
        },
        error: function () {
            alert("Ajax error!");
        }
    });
}

function addUser(type) {
    var username = $.trim($("#username").val());
    var password = $.trim($("#password").val());
    var name = $.trim($("#name").val());
    var email = $.trim($("#email").val());
    var user_type = $("#type").val();
    var categories = getAllCheckedCategories();//which module does this one belong to
    $.ajax({
        url:userType(type) + '/user/add',
        type: 'POST',
        dataType: 'JSON',
        data: {
            'paras.username': username,
            'paras.password': password,
            'paras.name': name,
            'paras.email': email,
            'paras.type': user_type,
            'categories':categories
        },
        success: function (rs) {
            var code = rs.status;
            var data = rs.data;
            if (code == 200) {
                alert(data.errmsg);
                $("#id").val(data.user.id);
            } else {
                alert(data);
            }

            //$("#id").val(data.user.id);
        },
        error: function () {
            alert("Ajax error!");
        }
    });
}

function updateUser(type) {
    var id = $.trim($("#id").val());
    var password = $.trim($("#password").val());
    var name = $.trim($("#name").val());
    var email = $.trim($("#email").val());
    var user_type = $("#type").val();
    var categories = getAllCheckedCategories();//which module does this one belong to
    $.ajax({
        url: userType(type) + '/user/update',
        type: 'POST',
        dataType: 'JSON',
        data: {
            'paras.id': id,
            'paras.password': password,
            'paras.name': name,
            'paras.email': email,
            'paras.type': user_type,
            'categories':categories
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

function queryUser(page,type) {
    var keyword = $.trim($("#keyword").val());
    var user_type = type==1?$("#user_type").val():"";
    $.ajax({
        url: userType(type) + '/user',
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
                list_list += "<tr id='tr_" + o.id + "'><td><input type='checkbox' /></td>" +
                    "<td>" + o.id + "</td>" +
                    "<td><a href='"+userType(type)+"/route/user_detail?id=" + o.id + "' >" + o.username + "</a></td>" +
                    "<td>" + o.name + "</td>" +
                    "<td class='am-hide-sm-only'>" + userType(o.type) + "</td>" +
                    "<td class='am-hide-sm-only'>" + o.email + "</td>" +
                    "<td><div class='am-btn-toolbar'>" +
                    "<div class='am-btn-group am-btn-group-xs'>" +
                    "<a href='"+userType(type)+"/route/user_detail?id=" + o.id + "' target='_blank' class='am-btn am-btn-default am-btn-xs am-text-secondary'><span class='am-icon-pencil-square-o'></span> Modify</a>" +
                    "<button type='button' onclick='deleteUser(" + o.id + ","+type+")' class='am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only'><span class='am-icon-trash-o'></span> Delete</button>" +
                    "</div></div></td></tr>";
            });
            $("#list").append(list_list);

            $("#pager").empty();
            var page_list = "";
            for (var i = 1; i <= totalPage; i++) {
                page_list += "<li class='" + (pageNumber == i ? "am-active" : "") + "'><a href='' onclick='queryUser(" + i + ","+type+");return false'>" + i + "</a></li>";
            }

            var pager = totalRow + " records<div class='am-fr'><ul class='am-pagination'>" +

                "<li class='" + (firstPage ? "am-disabled" : "") + "'><a href='' onclick='queryUser(" + (pageNumber - 1) + ","+type+");return false'>pre</a></li>" +
                page_list +

                "<li class='" + (lastPage ? "am-disabled" : "") + "'><a href='' onclick='queryUser(" + (pageNumber + 1) + ","+type+");return false'>next</a></li>" +

                '</ul></div>';
            $("#pager").append(pager);
        },
        error: function () {
            alert("Ajax error!")
        }
    });
}

function deleteUser(id,type) {
    if (confirm("Delete for sure?")) {
        $.ajax({
            url: userType(type) + '/user/delete',
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
