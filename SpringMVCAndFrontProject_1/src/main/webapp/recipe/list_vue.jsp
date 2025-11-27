<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script type="text/javascript" src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
  margin-top: 50px;
}
.row {
  margin: 0px auto;
  width:960px;
}
p {
 overflow: hidden;
 white-space: nowrap;
 text-overflow: ellipsis;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
       <div class="col-md-3">
		    <div class="thumbnail">
		      <a href="#">
		        <img src="${vo.poster }" style="width:230px;height: 120px"
		          title="${vo.title }"
		        >
		        <div class="caption">
		          <p>${vo.chef}</p>
		        </div>
		      </a>
		    </div>
		  </div>
    </div>
    <div class="row text-center" style="margin-top: 20px">
     <ul class="pagination">
       
         <li><a href="list.do?page=${startPage-1 }">&lt;</a></li>
 
         <li ${i==curpage?"class=active":"" }>
           <a href="list.do?page=${i }">${i }</a>
         </li>
  
         <li><a href="list.do?page=${endPage+1 }">&gt;</a></li>
       
     </ul>
    </div>
  </div>

</body>
</html>