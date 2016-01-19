$(function () {
    $('#register-form').parsley().on('form:submit', function () {
        return register();
    });
});

/**
 * 登录
 */
function register() {
    $.ajax({
        url: 'register.ajax',
        type: 'POST',
        cache: false,
        dataType: "json",
        data: $('#register-form').serialize(),
        beforeSend: function () {
            toastr.clear();
            if (!$('#register-form').parsley().isValid())
                return false;
            return true;
        },
        success: function (data) {
            if (data && data.code == 0) {
                // 跳转到登录界面
                location.href = 'login.jsp';
                return false;
            }
            toastr.warning(data.msg, '系统提示');
        },
        error: function () {
            toastr.warning('服务器繁忙,请稍后重试!', '系统提示');
        }
    });
    return false;
}