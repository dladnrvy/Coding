//expressServer2
var express = require('express');
var app = express();

app.use('/images',express.static(__dirname + '/images'));

//미들웨어를 통한 사용자 요청 매핑
// 1. 미들웨어 사용
// 2. 라우터 분기 : app.get(), app.post(), app.put(), app.delete()
// 3. 라우터 메서드 : app.router('경로').get([경로],func), post([경로],func), delete([경로],func) 
// 4. 라우터 코드 분리 : 모듈로 구성

//2번 사용
app.get('/test', function(req, res){
    res.send('use app.get()');
});

//3번 사용
app.route('/v1/book').get(function(req, res){
    res.send('use app route().get');
}).post(function(req, res){
    res.send('use app route().post');

}).put(function(req, res){
    res.send('use app route().put');

}).delete(function(req, res){
    res.send('use app route().delete');
});

app.use('/v1/hi', require('./router.js'))
// http://localhost:3000/v1/hi/hello
// http://localhost:3000/v1/hi/howareyou/cool

app.listen(3000);