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

window.route = Router(routes);
route.configure({
    after: function () {
    },
    before: function before() {
        //没有登录则跳转到登录页面
        if (!localStorage.getItem("USER") && location.hash.search(/\/(login)?$/) == -1) {
            location.hash = "/";
        }
    },
    notfound: function () {
        console.error("route not found");
    }
}).init();

