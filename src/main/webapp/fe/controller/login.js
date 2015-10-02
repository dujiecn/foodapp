/**
 * Created by dujie on 15/10/2.
 */
require('../views/style/login.less');

function loginPage() {
    var tpl = require("../views/tpl/login.ejs");
    $(document.body).html(tpl());
}

module.exports = {
    loginPage:loginPage
};