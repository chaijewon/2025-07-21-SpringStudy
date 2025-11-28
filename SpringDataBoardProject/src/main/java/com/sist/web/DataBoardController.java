package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.service.*;
import com.sist.vo.*;
@Controller
public class DataBoardController {
    @Autowired
	private DataBoardService dService;
   
    @GetMapping("databoard/list.do")
    public String databoard_list(String page,Model model)
    {
    	// Model model : JSP / HTML => 데이터 전송 객체 = request대체
    	if(page==null)
    		page="1";
    	int curpage=Integer.parseInt(page);
    	int rowSize=10;
    	int start=(curpage-1)*rowSize; // OFFSET => 0
    	//                             // rownum => 1
    	List<DataBoardVO> list=dService.databoardListData(start);
    	int count=dService.databoardRowCount();
    	int totalpage=(int)(Math.ceil(count/10.0));
    	count=count-((rowSize*curpage)-rowSize);
    	/*
    	 *   count => 13
    	 *   count-((10*1)-10) ==> 13
    	 *   count-((10*2)-10) ==> 3
    	 */
    	// JSP전송
    	model.addAttribute("list", list);
    	model.addAttribute("count", count);
    	model.addAttribute("totalpage", totalpage);
    	model.addAttribute("curpage", curpage);
    	return "databoard/list";
    }
    @GetMapping("databoard/insert.do")
    public String databoard_insert()
    {
    	return "databoard/insert";
    }
}
