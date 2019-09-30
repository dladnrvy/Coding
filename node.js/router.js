var express = require('express');
var router = express.Router();

// /hello, /howareyou/:who

router.get('/hello', sayHello);
router.get('/howareyou/:who', sayhowareyou);

function sayHello(req, res){
    res.send('Hello~ router');
}

function sayhowareyou(req, res){
    var who = req.params.who;
    res.send('Fine Thanks ' + who + ' And you ?')
}

module.exports = router;