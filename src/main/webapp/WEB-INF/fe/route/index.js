/**
 * 路由
 */
var director = require("director");
var Router = director.Router;
var loginController = require("../controller/login.js");
var homeController = require("../controller/home.js");

var routes = {
    '/(login)?': loginController.loginPage,
    '/home': homeController.homePage
};

var router = new Router(routes);
router.configure({
    after: function () {
    },
    before: function () {
        // 解决路由跳转的时候滚动条不在顶部的bug
        $(document).scrollTop(0);
    },
    notfound: function () {
        console.error("route not found.");
    }
}).init();

window.router = router;
