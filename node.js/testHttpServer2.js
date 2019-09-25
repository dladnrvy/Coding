//1. 모듈을 로드
//http 모듈
var http = require('http');
//fs 모듈
var fs = require('fs');

//server 생성
var server = http.createServer(function(req,res){
    res.end('hi','utf-8');
});

//port 설정
server.listen(3000);