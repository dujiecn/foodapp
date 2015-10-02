/**
 * Created by dujie on 15/10/2.
 */
require('../views/style/login.less');

var request = require('../util/request.js');

function loginPage() {
    var tpl = require("../views/tpl/login.ejs");
    $(document.body).html(tpl());
    $('#loginBtn').on('click', loginSubmit);
}

function loginSubmit() {
    var data = $('#loginForm').serializeArray();
    request({
        url: '/user/login',
        data: data,
        success: function (data) {
            if (data.code == 1) {
                localStorage.setItem('USER', JSON.stringify(data.data));
                location.hash = '/home';
            } else {
                console.log('login failed.');
            }
        }
    });
}


module.exports = {
    loginPage: loginPage
};