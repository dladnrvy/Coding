<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<style>
		#SeatWrap{
           margin: 0 auto;
           text-align: center;
       }
       .btn{
           margin: 5px;
           display: inline-block;
           width: 70px;
           height: 70px;
           background-color: chocolate;
           color: beige;
           text-align: center;
           border: 1px solid #DDD;
           border-radius: 5px;
            display : none;
           font-size: 30px;
       }
       .btn:hover{
           background-color: saddlebrown;
           color: beige;
       }
       #h4{
       display : none;
       }

</style>
    <script>
    
        $(document).ready(function () {
        	
        	
        	$('.time').on("click",function(){
        	
            $.ajax({
                url: 'reserve/seat',
                type: "post", 
                data: {
                  time : $(this).val()          
          
                },
                success: function (data) {
                	
                	//1번 선택
                    if(data == 1){
                    	$('#h3').css('display','none');
                    	$('#h4').css('display','block');
                    	$('.btn').css('display','inline-block');
                    	
                    	if()
                    	/* $('.btn').on("click",function(){
                    		
                    		$.ajax({
                    			url: 'FirstSeat',
                    			type : "post",
                    			data: {
                    				seat : $(this).val()
                    			},
                    			success: function (data){
                    				
                    			}
                    		});
                    	}); */
                      
       	 
                    }else if(data == 2){
                    	alert("2번");
                    }else if(data == 3){
                    	alert("3번");
                    }else if(data == 4){
                    	alert("4번");
                    }
 
                }
              });
            });
        });
    </script>




</head>
<body>

<div id="main_wrap">

		<!-- context 시작 -->
		<div id="context">
			<div id="ct">
			<h3 id="h3">예약시간을 선택해주세요</h3>
	<input type="button" id="first" class="time" value="09:00~12:00">
	<input type="button" id="second" class="time" value="12:00~15:00">
	<input type="button" id="third" class="time" value="15:00~18:00">
	</div>
	 <div id="SeatWrap">
	 <h4 id="h4">원하시는 좌석을 선택해주세요.</h4>
       <input type= "button" class="btn" value="1" id="1">
      <input type= "button" class="btn" value="2" id="2">
      <input type= "button" class="btn" value="3" id="3">
      <input type= "button" class="btn" value="4" id="4">
<!--       <input type= "button" class="btn" value="5"><br>
      <input type= "button" class="btn" value="6">
      <input type= "button" class="btn" value="7">
      <input type= "button" class="btn" value="8">
      <input type= "button" class="btn" value="9">
      <input type= "button" class="btn" value="10"><br>
      <input type= "button" class="btn" value="11">
      <input type= "button" class="btn" value="12">
      <input type= "button" class="btn" value="13">
      <input type= "button" class="btn" value="14">
      <input type= "button" class="btn" value="15"><br>
      <input type= "button" class="btn" value="16">
      <input type= "button" class="btn" value="17">
      <input type= "button" class="btn" value="18">
      <input type= "button" class="btn" value="19">
      <input type= "button" class="btn" value="20"> -->
     </div>
		</div>
		<!-- context 끝 -->

	</div>
</body>
</html>