package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;
import com.sist.vo.*;
// 실제 데이터 전송 
@RestController 
public class FoodRestController {
   // 스프링에 등록된 클래스중에 필요한 클래스 가지고 오기 @Autowired
   @Autowired
   private FoodService fService;
   
   @GetMapping(value="food/list_vue.do",
		      produces = "text/plain;charset=UTF-8")
   public String food_list_vue(int page)
   {
	   String result="";
	   Map map=new HashMap();
	   final int ROWSIZE=12;
	   int start=(ROWSIZE*page)-(ROWSIZE-1);
	   int end=(ROWSIZE*page);
	   List<FoodVO> list=fService.foodListData(start,end);
	   int totalpage=fService.foodTotalPage();
	   
	   // 블록별 
	   final int BLOCK=10;
	   int startPage=((page-1)/BLOCK*BLOCK)+1;
	   int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   // JavaScript로 전송 
	   map.put("list", list);
	   map.put("curpage", page);
	   map.put("totalpage", totalpage);
	   map.put("startPage", startPage);
	   map.put("endPage", endPage);
	   
	   try
	   {
		   ObjectMapper mapper=
				     new ObjectMapper();
		   result=mapper.writeValueAsString(map);
	   }catch(Exception ex){}
	   return result;
   }
   
}




