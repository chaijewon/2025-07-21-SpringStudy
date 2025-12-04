<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row {
  margin: 0px auto;
  width:500px;
}
h3 {
   text-align: center;
}
.a-link{
  cursor: pointer;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
      <h3>회원가입</h3>
      <table class="table">
        <tbody>
          <tr>
           <th width=20% class="text-center">ID</th>
           <td width=80%>
             <input type=text ref="userid" size=20 class="input-sm">
           </td>
          </tr>
          <tr>
           <th width=20% class="text-center">Password</th>
           <td width=80%>
             <input type=password ref="userpwd" size=20 class="input-sm">
           </td>
          </tr>
          <tr>
           <th width=20% class="text-center">이름</th>
           <td width=80%>
             <input type=text ref="username" size=20 class="input-sm">
           </td>
          </tr>
          <tr>
           <th width=20% class="text-center">성별</th>
           <td width=80%>
             <input type="radio" value="남자" checked>남자
             <input type="radio" value="여자">여자
           </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</body>
</html>