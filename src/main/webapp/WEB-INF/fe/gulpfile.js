var gulp = require('gulp');
var uglify = require('gulp-uglify');
var webpack = require('gulp-webpack');
var webpackConfig = require('./webpack.config');

gulp.task('webpack', function () {
    gulp.src('./route')
        .pipe(webpack(webpackConfig))
        //.pipe(uglify())
        .pipe(gulp.dest('./dist'));
});
//gulp.watch('/route/**',['webpack']);


