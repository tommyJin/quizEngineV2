/**
 * Created by tommy on 2016/5/24.
 */


function getCategory(id, type) {
    $.ajax({
        url: userType(type) +'/questioncategory/get',
        type: 'GET',
        dataType: 'JSON',
        data: {'id': id},
        success: function (rs) {
            var category = rs.data;
            $("#name").val(category.name);
            $("#content").val(category.content);
        },
        error: function () {
            alert("Ajax error!");
        }
    });
}

function getCategories(showAll, type) {
    $.ajax({
        url: userType(type) +'/questioncategory',
        type: 'GET',
        dataType: 'JSON',
        data: {},
        async:false,
        success: function (rs) {
            $("#category").empty();
            var code = rs.status;
            var data = rs.data;
            if (code == 200) {
                var list = data.list;
                var select = showAll ? "<option  value='0'>All</option>" : "";
                list.map(function (o) {
                    select += "<option value='" + o.id + "'>" + o.name + "</option>";
                });
                $("#category").append(select);
            }else {
                $("#category").append("<option  value='0'>No Module Available</option>");
            }
        },
        error: function () {
            alert("Ajax error!");
        }
    });
}

function addCategory() {
    var name = $.trim($("#name").val());
    var content = $("#content").val();
    $.ajax({
        url: 'admin/questioncategory/add',
        type: 'POST',
        dataType: 'JSON',
        data: {'paras.name': name, 'paras.content': content},
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

function updateCategory() {
    var id = $.trim($("#id").val());
    var name = $.trim($("#name").val());
    var content = $("#content").val();
    $.ajax({
        url: 'admin/questioncategory/update',
        type: 'POST',
        dataType: 'JSON',
        data: {'paras.id': id, 'paras.name': name, 'paras.content': content},
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

function queryCategory(page,type) {
    var keyword = $.trim($("#keyword").val());
    $.ajax({
        url: userType(type) +'/questioncategory',
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
                list_list += "<tr id='tr_" + o.id + "'>" +
                    // "<td><input type='checkbox' /></td>" +
                    "<td>" + o.id + "</td>" +
                    "<td><a href='"+userType(type) +"/route/category_detail?id=" + o.id + "' >" + o.name + "</a></td>" +
                    "<td><div class='am-btn-toolbar'>" +
                    "<div class='am-btn-group am-btn-group-xs'>" +
                    "<a href='"+userType(type) +"/route/category_detail?id=" + o.id + "' target='_blank' class='am-btn am-btn-default am-btn-xs am-text-secondary'><span class='am-icon-pencil-square-o'></span> Modify</a>" +
                    "<button type='button' onclick='deleteCategory(" + o.id + ")' class='am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only'><span class='am-icon-trash-o'></span> Delete</button>" +
                    "</div></div></td></tr>";
            });
            $("#list").append(list_list);

            $("#pager").empty();
            var page_list = "";
            for (var i = 1; i <= totalPage; i++) {
                page_list += "<li class='" + (pageNumber == i ? "am-active" : "") + "'><a href='' onclick='queryCategory(" + i + ","+type+");return false'>" + i + "</a></li>";
            }

            var pager = totalRow + " records<div class='am-fr'><ul class='am-pagination'>" +

                "<li class='" + (firstPage ? "am-disabled" : "") + "'><a href='' onclick='queryCategory(" + (pageNumber - 1) + ","+type+");return false'>pre</a></li>" +
                page_list +

                "<li class='" + (lastPage ? "am-disabled" : "") + "'><a href='' onclick='queryCategory(" + (pageNumber + 1) + ","+type+");return false'>next</a></li>" +

                '</ul></div>';
            $("#pager").append(pager);
        },
        error: function () {
            alert("Ajax error!")
        }
    });
}

function deleteCategory(id) {
    if (confirm("Delete for sure?")) {
        $.ajax({
            url: 'admin/questioncategory/delete',
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


function getMoudles(user_id,category_id,type,isCheckbox){
    $.ajax({
        url: userType(type) +'/questioncategory/modules',
        dataType: 'json',
        data: {'user_id':user_id,'category_id':category_id},
        type: 'GET',
        sync:true,
        success: function (rs) {
            var list = rs.data;
            $("#modules").empty();
            var list_list = "";

            list.map(function (o) {
                list_list += "<label  class='am-btn am-btn-default am-btn-xs'> <input id='category_"+o.id+"' type='"+(isCheckbox==1?"checkbox":"radio")+"' value='"+o.id+"'> "+o.name+" </label>";
            });
            $("#modules").append(list_list);
        },
        error: function () {
            alert("Ajax error!")
        }
    });
}

function getAllCheckedCategories(){
    var ids = "";
    $("#modules input[type=checkbox]:checked").map(function (o) {
        ids += $(this).val()+",";
    });
    return ids.length>0?ids.substring(0,ids.length-1):ids;
}

function setCheckedCategories(list) {
    $.map(list,function (o) {
        var id = "#category_"+o.category_id;
        $(id).parent().addClass("am-active");
        $(id).prop("checked",true);
    })
}