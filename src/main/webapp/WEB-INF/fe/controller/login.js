/**
 * Created by dujie on 15/10/2.
 */
require('../template/style/login.less');

var request = require('../util/request');

function loginPage() {
    var tpl = require("../template/login.ejs");
    $(document.body).html(tpl());
    $('#loginBtn').on('click', loginSubmit);
}

function loginSubmit() {
    localStorage.setItem('USER', JSON.stringify({uid:200,username:'dj'}));
    router.setRoute('/home');
    return;
    var data = $('#loginForm').serializeArray();
    request({
        url: '/user/login',
        data: data,
        success: function (data) {
            if (data.code == 1) {
                localStorage.setItem('USER', JSON.stringify(data.data));
                router.setRoute('/home');
            } else {
                console.log('login failed.');
            }
        }
    });
}


module.exports = {
    loginPage: loginPage
};