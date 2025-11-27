package com.sist.web;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// 화면 제어(X) => Front로 데이터 전송 
// => 1. 일반문자열 , 2. 정수 , 3. JSON 
// => JSON을 자동으로 구현 

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.vo.EmpVO;
@RestController
public class RestRecipeController {
   @GetMapping(value="emp/list.do",produces = "text/plain;charset=UTF-8")
   public String emp_list() throws Exception
   {
	   List<EmpVO> list=new ArrayList<EmpVO>();
	   list.add(new EmpVO(1,"홍길동1","개발부"));
	   list.add(new EmpVO(2,"홍길동2","개발부"));
	   list.add(new EmpVO(3,"홍길동3","개발부"));
	   ObjectMapper mapper=new ObjectMapper();
	   String json=mapper.writeValueAsString(list);
	   return json;
	   
   }
}
