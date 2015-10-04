webpackJsonp([0,2],[
/* 0 */
/***/ function(module, exports, __webpack_require__) {

	/*
	 改写默认的alert confirm
	 */
	'use strict';

	__webpack_require__(!(function webpackMissingModule() { var e = new Error("Cannot find module \"./style/popbox.less\""); e.code = 'MODULE_NOT_FOUND'; throw e; }()));
	var tpl = __webpack_require__(!(function webpackMissingModule() { var e = new Error("Cannot find module \"./tpl/popbox.ejs\""); e.code = 'MODULE_NOT_FOUND'; throw e; }()));
	var Hammer = __webpack_require__(!(function webpackMissingModule() { var e = new Error("Cannot find module \"hammer\""); e.code = 'MODULE_NOT_FOUND'; throw e; }()));

	window.alert = function (msg) {
	    var alertbox = $('.spa-popbox.alert');
	    if (alertbox.length == 0) {
	        // 页面不存在弹出框的时候，往页面添加
	        $(document.body).append(ejs.render(tpl, { poptype: 'alert', msg: msg }));
	        alertbox = $('.spa-popbox.alert');

	        var hammer = new Hammer(alertbox.find('.submit')[0]);
	        hammer.on('tap', function (e) {
	            setTimeout(function () {
	                alertbox.hide();
	            }, 200);
	        });
	    } else {
	        alertbox.find('.msg').text(msg);
	        alertbox.show();
	    }
	};

	window.confirm = function (msg, callback) {
	    var confirmbox = $('.spa-popbox.confirm');

	    if (confirmbox.length == 0) {
	        $(document.body).append(ejs.render(tpl, { poptype: 'confirm', msg: msg }));
	        confirmbox = $('.spa-popbox.confirm');

	        var hammer = new Hammer(confirmbox.find('.submit')[0]);
	        hammer.on('tap', function (e) {
	            setTimeout(function () {
	                confirmbox.hide();
	            }, 200);
	            callback(true);
	        });

	        hammer = new Hammer(confirmbox.find('.cancel')[0]);
	        hammer.on('tap', function (e) {
	            setTimeout(function () {
	                confirmbox.hide();
	            }, 200);
	            callback(false);
	        });
	    } else {
	        confirmbox.find('.msg').text(msg);
	        confirmbox.show();
	    }
	};

/***/ }
]);