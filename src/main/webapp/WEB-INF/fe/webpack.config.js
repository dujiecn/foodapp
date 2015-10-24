var webpack = require('webpack');
var CommonsPlugin = webpack.optimize.CommonsChunkPlugin;

var config = {
    watch:true,
    entry: {
        'route/index': './route/index.js'
    },
    output: {
        path: __dirname + '/dist',
        filename: '[name].js'
    },
    module: {
        devtool: 'source-map',
        loaders: [{
            test: /\.ejs$/,
            loader: 'ejs'
        }, {
            test: /\.less$/,
            loader: "style-loader!css-loader!less-loader"
        }, {
            test: /\.jsx?$/,
            loader: 'babel',
            exclude: /node_modules/
        }]
    },
    plugins: [new CommonsPlugin('common.js')]
};

module.exports = config;
