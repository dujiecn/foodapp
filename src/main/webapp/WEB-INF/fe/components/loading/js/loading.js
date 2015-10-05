/**
 * Created by dujie on 15/10/5.
 */
require('../style/loading.less');
require('../../bower_components/velocity/velocity.js');


var elem = $('.loading-modal');

function show() {
    elem.show(0,function () {
        elem.addClass('in');
    });
}

function hide() {
    elem.removeClass('in');
    setTimeout(function() {elem.hide()},150);

}

setTimeout(show, 1000);
//setTimeout(hide, 5000);

module.exports.show = show;
module.exports.hide = hide;