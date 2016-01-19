$(function () {
    $('#register-btn').click(function () {
        location.href = 'register.html';
    });

    $('#login-form').parsley().on('form:submit', function () {
        return login();
    });
});

/**
 * 登录
 */
function login() {
    $.ajax({
        url: 'login.ajax',
        type: 'POST',
        cache: false,
        dataType: "json",
        data: $('#login-form').serialize(),
        beforeSend: function () {
            toastr.clear();
            if (!$('#login-form').parsley().isValid())
                return false;
            return true;
        },
        success: function (data) {
            if (data && data.code == 0) {
                location.href = '../dashboard.html';
                return false;
            }
            toastr.warning(data.msg, '系统提示');
        },
        error: function () {
            toastr.error('服务器繁忙,请稍后重试!', '系统提示');
        }
    });
    return false;
}