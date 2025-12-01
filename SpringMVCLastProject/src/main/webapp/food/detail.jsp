<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
       1. vue 
          1) 라이브러리 로드 
             <script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
             <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
          2) 태그안에 속성이나 데이터를 제어 : 디렉티브 (v-)
             반복문 : v-for="vo in list"
                                 ===== [{},{},{}...] 
                    v-for="(vo,index) in list"
             조건문 :  v-if="조건문"
                     v-if ~ v-else 
             양방향 : v-model="변수명"
             변수연결 : v-bind => :
             show/hide => v-show="조건"
          3) 객체 생성 
             Vue.createApp({
                // Model => 데이터 관리 
                data(){ ===============> setup()
                  return {
                     관리할 변수 설정 
                  }
                },
                // ViewModel
                mounted(){
                   window.onload=function(){} 
                   $(function(){}))
                },
                computed:{ => filter
                   숫자 변환 / 날짜 변환 
                },
                watch:{
                  component의 값이 변경되는 경우 감지 
                },
                methods:{
                   // 사용자 정의 apthem
                },
                components:{
                  
                }
             }).mounted("제어하는 HTML 영역")
                        ================== View 
             1) ViewModel에서 데이터 변경 
                => 이벤트 / 서버에서 값 읽기 
             2) Model에 저장 
             3) Model에 저장된 값을 View(HTML)로 전송 
             ------------- MVVM (***)
             
         생명주기 
         created = mounted = updated = unmounted
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row{
  margin: 0px auto;
  width: 900px;
}
</style>
</head>
<body>
  <div class="container" id="food_detail">
   <div class="row">
    <table class="table">
     <tr>
       <td width=30% class="text-center" rowspan="8">
         <img :src="vo.poster" style="width:100%">
       </td>
       <td colspan="2">
         <h3>{{vo.name}}&nbsp;<span style="color:orange">{{vo.score}}</span></h3>
       </td>
     </tr>
     <tr>
       <td width=15% style="color:gray">주소</td>
       <td width=55%>{{vo.address}}</td>
     </tr>
     <tr>
       <td width=15% style="color:gray">전화</td>
       <td width=55%>{{vo.phone}}</td>
     </tr>
     <tr>
       <td width=15% style="color:gray">음식종류</td>
       <td width=55%>{{vo.type}}</td>
     </tr>
     <tr>
       <td width=15% style="color:gray">가격대</td>
       <td width=55%>{{vo.price}}</td>
     </tr>
     <tr>
       <td width=15% style="color:gray">주차</td>
       <td width=55%>{{vo.parking}}</td>
     </tr>
     <tr>
       <td width=15% style="color:gray">영업시간</td>
       <td width=55%>{{vo.time}}</td>
     </tr>
     <tr>
       <td width=15% style="color:gray">테마</td>
       <td width=55%>{{vo.theme}}</td>
     </tr>
    </table>
    <table class="table">
      <tr>
        <td>{{vo.content}}</td>
      </tr>
      <tr>
        <td class="text-right">
          <a href="../main/main.do" class="btn btn-sm btn-danger">목록</a>
        </td>
      </tr>
    </table>
   </div>
  </div>
  <script>
    let detailApp=Vue.createApp({
    	data(){
    		return {
    			vo:{},
    			images:[],
    			fno:${fno}
    		}
    	},
    	mounted(){
    		// detail.do?fno=10
    		axios.get('../food/detail_vue.do',{
    			params:{
    				fno:this.fno
    			}
    		}).then(response=>{
    			console.log(response.data)
    			this.vo=response.data
    			this.images=response.data.images.split(",")
    		})
    	}
    }).mount("#food_detail")
  </script>
</body>
</html>