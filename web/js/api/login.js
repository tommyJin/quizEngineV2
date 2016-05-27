/**
 * Created by tommy on 2016/5/27.
 */

function logout() {
    $.ajax({
        url: '/session/logout',
        type: 'GET',
        dataType: 'JSON',
        data: {},
        success: function (rs) {
            if(rs.status==200){
                alert(rs.data);
                location.href="/route/login";
            }else{
                alert(rs.data);
            }
        },
        error: function () {
            alert("Ajax error!");
        }
    });
}