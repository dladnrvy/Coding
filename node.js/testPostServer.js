//모듈 로드
//Http.Server
var http = require('http');
var querystring = require('querystring');
var fs = require('fs');
var formidable = require('formidable');
var pathUtil = require('path'); 

//데이터
var movieList = [
    {
        title : '스타워즈' ,
        director : '조지루카스',
        image: '/images/ukpyo.jpg'
    }
];

// images 경로
var imgDirPath = __dirname + '/images';


var Server = http.createServer(function(req,res){

    var url = req.url;
    var method = req.method.toLocaleLowerCase();

    if(url == '/' && method == 'get'){

        list(req,res);

    }else if(url.indexOf('/images/') == 0 && method == 'get'){
        var urlPath = __dirname + req.url; // images/starwars.jpg
        res.writeHead(200, {'Content-Type' : 'image/jpg'});
        fs.createReadStream(urlPath).pipe(res);

        
    }else if(url == '/' && method == 'post'){
        addNewMovie(req,res);
    }else if(url == '/v1/movies' && method == 'get'){
        responseJson(req,res);
    }

    //GET / POST 구분
  //  var method = req.method.toLocaleLowerCase();
  //  console.log('requset Method : '+ method);

  //  if(method == 'post'){
  //      console.log('POST 요청일 때 처리');
 //       addMovie(req,res);
 //   }else{
 //       console.log('GET 요청일 때 처리');
 //       list(req,res);
 //   }
   });

//포트 설정
Server.listen(3000);

function responseJson(req,res){
    res.writeHeader(200,{'Content-Type' : 'application/json'});
    res.end(JSON.stringify(movieList));
}

function addNewMovie(req,res){

    var form = formidable.IncomingForm();
    //form.uploadDir = imgDirPath;

    form.parse(req, function(err, fields, files){

        var title = fields.title;
        var director = fields.director;
        var posterImg = files.poster;

        var date = new Date();

        var newFileName = 'poster_'+ date.getHours() + date.getMinutes() + date.getSeconds();
    
        var ext = pathUtil.parse(posterImg.name).ext;

        var newPath = __dirname + pathUtil.sep + 'images' + pathUtil.sep + newFileName + ext;

        fs.renameSync(posterImg.path, newPath);

        var newPosterImgUrl = 'images/' + newFileName + ext;

        var mInfo = {
            title : title,
            director : director,
            image : newPosterImgUrl
        };

        movieList.push(mInfo);



        res.statusCode = 302;
        res.setHeader('Location','.');
        res.end('success');
    });

}

function addMovie(req, res){
    //res 의 'data' / 'end' 이벤트를 이용해서 body의 내용을 읽어 처리한다.

    var body = '';

    req.on('data',function(chunk){

        body += chunk;
        console.log('body : ' + body);
    });

    req.on('end',function(){

        var parsedData = querystring.parse(body);

        console.log('parsed : ' , parsedData);

        movieList.push({title : parsedData.title, director : parsedData.director});

        //list(req,res);

        
        res.statusCode = 302;
        res.setHeader('Location','.');
        res.end('success');
    });
}

function list(req, res){
    //movieList 데이터를 출력해서 보여주는 html

    res.writeHeader(200, {'Content-Type':'text/html; charset=UTF-8'});

    //body 설정
    res.write('<html>');
    res.write('<meta charset="UTF-8">');
    res.write('<body>');
    res.write('<h3>Favorite Movie</h3>');
    res.write('<div><ul>');

    movieList.forEach(function (item) {
        res.write('<li><img src="'+ item.image+ '" height = "50px">'+ item.title + '(' + item.director + ')</li>');
        }, this);
    res.write('</ul></div>');

    res.write(
        '<form method="post" enctype="multipart/form-data"><h4>새 영화 입력</h4>' +
        '<div><input type="text" name="title" placeholder="영화제목"></div>' +
        '<div><input type="text" name="director" placeholder="감독"></div>' +
        '<div><input type="file" name="poster" placeholder="이미지"></div>' +
        '<input type="submit" value="upload">' +
        '</form>'
        );
        res.write('</body>');
        res.write('</html>');

    //응답실행
    res.end();
}