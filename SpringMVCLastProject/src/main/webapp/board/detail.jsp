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
  width:800px;
}
h3 {
   text-align: center;
}
</style>
</head>
<body>
  <div class="container" id="detail_app">
    <h3>내용보기</h3>
    <div class="row">
     <table class="table">
       <tbody>
         <tr>
           <th width=20% class="text-center danger">번호</th>
           <td width=30% class="text-center">{{vo.no}}</td>
           <th width=20% class="text-center danger">작성일</th>
           <td width=30% class="text-center">{{vo.dbday}}</td>
         </tr>
         <tr>
           <th width=20% class="text-center danger">이름</th>
           <td width=30% class="text-center">{{vo.name}}</td>
           <th width=20% class="text-center danger">조회수</th>
           <td width=30% class="text-center">{{vo.hit}}</td>
         </tr>
         <tr>
           <th width=20% class="text-center danger">제목</th>
           <td colspan="3" class="text-center">{{vo.subject}}</td>
         </tr>
         <tr>
          <td colspan="4" class="text-left" valign="top" height="250">
            <pre style="border:none;background-color: white;white-space: pre-wrap;">{{vo.content}}</pre>
          </td>
         </tr>
         <tr>
           <td colspan="4" class="text-right">
            <a href="#" class="btn btn-xs btn-success">수정</a>
            <a href="#" class="btn btn-xs btn-info">삭제</a>
            <a href="../board/list.do" class="btn btn-xs btn-warning">목록</a>
           </td>
         </tr>
       </tbody>
     </table>
    </div>
  </div>
  <script type="text/javascript">
    let detailApp=Vue.createApp({
    	// react : state
    	data(){
    		return {
    			vo:{},
    			no:${no}
    		}
    	},
    	mounted(){
    		axios.get("http://localhost:8080/web/board/detail_vue.do",{
    			params:{
    				no:this.no
    			}
    		}).then(response=>{
    			console.log(response.data)
    			this.vo=response.data
    		})
    	}
    }).mount("#detail_app")
  </script>
</body>
</html>