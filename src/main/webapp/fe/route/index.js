/*
 初始化路由
 */
var Router = require("director").Router;
var loginController = require("../controller/login.js");
var homeController = require("../controller/home.js");


var routes = {
    '/(login)?': loginController.loginPage,
    '/home': homeController.homePage
};

function before() {
    // 登录操作
    //throw new error();
}

function notfound() {
    console.error("route not found");
}

function after() {
    //console.log("after...");
}

Router(routes).configure({
    after:after,
    before: before,
    notfound:notfound
}).init();