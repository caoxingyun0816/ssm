//当页面加载完成后，自动加载该函数，由于没有值，所以会alert空
$(function() {
    common.showMessage($("#message").val());
    alert($("#message").val());
});

function add() {
    if(check()) {
        $("#mainForm").submit();
    }
}

function check() {
    // TODO 需要添加表单验证
    return true;
}

function goback() {
    location.href = $('#basePath').val() + '/ad';
}