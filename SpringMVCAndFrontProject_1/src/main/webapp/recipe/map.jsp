<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="food.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
  margin-top: 50px;
}
.row {
  margin: 0px auto;
  width:960px;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
     <div id="a">
       <img src="map/1111.png" id="seoul_1">
       <c:forEach var="i" begin="1" end="25">
         <img id="gu${i }" src="map/gu_${i }_off.png"
          onmouseover="this.src='map/gu_${i }_on.png'"
          onmouseout="this.src='map/gu_${i }_off.png'"
         >
       </c:forEach>
     </div>
    </div>
  </div>
</body>
</html>