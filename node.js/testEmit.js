// 자바스크립트 객체 생성

var obj = {};
obj.name = 'LIM';
obj.hello = function(){
    console.log(this.name);
};

//obj.hello();

var person = function(){
}
// 공용 메소드 정의
person.prototype.sayHello = function(){
    console.log('hihi');
}

class Member{}

var person = new person();
var member = new Member();

//상속 처리를 위한 util 모듈 로드
var util = require('util');

//이벤트 등록을 위한 EventEmitter 생성
var EventEmitter = require('events').EventEmitter;

//상속 person 에 EventEmitter 상속
util.inherits(person, EventEmitter);

//person 객체 생성
var person = new person();

//이벤트 등록
person.on('hi', function(){
    console.log('아녕하세요 반갑습니다');
});

//이벤트 발생
person.emit('hi');