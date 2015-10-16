var gulp = require('gulp');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');
var webpack = require('gulp-webpack');
var webpackConfig = require('./webpack.config');


gulp.task('webpack', function () {
    gulp.src('./route')
        .pipe(webpack(webpackConfig))
        .pipe(gulp.dest('./dist'));

});

gulp.task('uglify', function () {
    gulp.src('./dist')
        .pipe(uglify());
});

gulp.watch('route/**', ['webpack']);




