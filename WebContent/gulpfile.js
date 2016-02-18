var gulp = require('gulp'),
	jade = require('gulp-jade'),
	concat = require('gulp-concat')
	watch = require('gulp-watch')

	gulp.task('jade', function(){
		return gulp.src('file.jade')
		.pipe(jade())
		.pipe(gulp.dest(''))
	})

	gulp.task('default',function(){
		gulp.run('jade')
		gulp.watch('file.jade', function(){
			gulp.run('jade')
		})
	})