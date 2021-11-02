<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
   href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
   integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
   crossorigin="anonymous">
</head>
<body>
<div class="container">
      <div class="row">
         <div class="col-8"></div>
         <div class="col-4">
            <form action = "/member/joinProcess.jsp" method="post">
               <div class="form-group">
                  <label for="userid">아이디</label> 
                  <input type="userid" class="form-control" id="userid" placeholder="아이디를 입력하세요." name= "userid">  
               </div>
               <div class="form-group">
                  <label for="password">비밀번호</label> 
                  <input type="password" class="form-control" id="password" placeholder="비밀번호를 입력하세요." name="password">
               </div>
               <div class="form-group"> 
                  <label for="passwordcheck">비밀번호 확인</label>
                  <input type="passwordcheck" class="form-control" id="passwordcheck" placeholder="비밀번호를 다시 입력하세요." name="passwordcheck">
               </div>
               <div class="form-group">
                  <label for="username">이름</label> 
                  <input type="username" class="form-control" id="username" placeholder="이름를 입력하세요."name="username">
               </div>
               <div class="form-group">
                  <label for="gender">성별 </label>
                  <input class="gender" type="radio" name="gender" id="gender" value="Male" checked="checked">남성 
                  <input class="gender" type="radio" name="gender" id="gender" value="Female" checked="checked">여성
               </div>  
               <div class="form-group">
                  <label for="email">이메일</label> 
                  <input type="email" class="" id="email" placeholder="example@gmail.com" name="email">
               </div>
               <button type="radio" class="btn btn-primary">입력</button>
               <button type="radio" class="btn btn-primary">취소</button>
            </form>
         </div>
      </div>
   </div>
</body>
</html>