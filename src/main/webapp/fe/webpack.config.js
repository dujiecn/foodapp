var webpack = require('webpack');
var commonsPlugin = new webpack.optimize.CommonsChunkPlugin('common.js');

module.exports = {
    entry: {
        index: './route/index.js'
    },
    output: {
        path: './dist',
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
            test: /\.js$/,
            loader: 'babel',
            exclude: /node_modules/
        }]
    },
    plugins: [commonsPlugin]
}
