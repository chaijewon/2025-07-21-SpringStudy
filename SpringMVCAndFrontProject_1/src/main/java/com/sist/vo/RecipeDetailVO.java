package com.sist.vo;

import lombok.Data;
// VO => Mapper (SQL) => DAO => Service => Controller = JSP
//                                         RestController = Vue
//                        | 오라클 | 기타 기능 추가 | 브라우저 전송  
/*
 *    NO                                                 NUMBER
	 POSTER                                             VARCHAR2(500)
	 TITLE                                              VARCHAR2(1000)
	 CHEF                                               VARCHAR2(300)
	 CHEF_POSTER                                        VARCHAR2(500)
	 CHEF_PROFILE                                       VARCHAR2(500)
	 INFO1                                              VARCHAR2(100)
	 INFO2                                              VARCHAR2(100)
	 INFO3                                              VARCHAR2(100)
	 CONTENT                                            CLOB
	 FOODMAKE                                           CLOB
	 
	 @Controller : 화면 제어 
	    | forward / redirect (JSP)
	 @RestController : 자바스크립트에 출력 값 전송 
	    | Ajax / Vue / Rest (JSP / HTML)
	              | router
	              | return "forward:/index.html"
	              | 일반 CDN / Module
	                -------   ------
	 ----------------------------------------------- Model
	   Model : ~VO / ~DAO / ~Service / ~Manager
	     |
	   View(JSP/HTML) : 화면 출력 역할 
	 -------------------------------------+ 연결 (DispaterServlet)
	    => 설정 => 동작에 대한 메뉴얼 작성 (XML,Properties)
	                                  |      | boot => .yml
	                                 Framework        ------
	                                                  | CI/CD
	                                                  | => 들여쓰기
	    server:
	    	port=80
	          
	           
	 
 */
@Data
public class RecipeDetailVO {
  private int no;
  private String poster,title,chef,chef_poster,
          chef_profile,info1,info2,info3,content,foodmake;
}
