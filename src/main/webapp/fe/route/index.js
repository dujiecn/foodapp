/*
   初始化路由
 */
var Router = require("director").Router;

var routes = {
    '/index':index
};

function index() {
    alert("index func");
}

console.log(Router);

Router(routes).init();