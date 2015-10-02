/**
 * Created by dujie on 15/10/2.
 */
$.ajaxSetup({
    type: "GET",
    timeout: 60000,
    dataType: "json",
    error: function (jqXHR, textStatus, errorThrown) {
        console.error(textStatus);
    }
});

module.exports = function (obj) {
    //obj.url = 'http://localhost:8080/' + obj.url;
    return $.ajax(obj);
}