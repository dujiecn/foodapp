/**
 * Created by dujie on 15/10/2.
 */
require('../views/style/home.less');

function homePage() {
    var user = JSON.parse(localStorage.getItem('USER'));
    var tpl = require("../views/tpl/home.ejs");
    $(document.body).html(tpl(user));
}

module.exports = {
    homePage: homePage
};


