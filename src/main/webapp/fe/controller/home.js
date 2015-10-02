/**
 * Created by dujie on 15/10/2.
 */
require('../views/style/home.less');

function homePage() {
    var tpl = require("../views/tpl/home.ejs");
    $(document.body).html(tpl({name: "dj"}));
}

module.exports = {
    homePage: homePage
};


