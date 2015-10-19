/**
 * 路由
 */
var Router = require("director").Router;
var loginController = require("../controller/login.js");
var homeController = require("../controller/home.js");

var routes = {
    '/(login)?': loginController.loginPage,
    '/home': homeController.homePage
};

window.router = Router(routes);
router.configure({
    after: function () {
    },
    before: function () {
        //没有登录则跳转到登录页面
        if (!localStorage.getItem("USER") && location.hash.search(/\/(login)?$/) == -1) {
            router.setRoute('/');
        }
    },
    notfound: function () {
        console.error("route not found.");
    }
}).init();

