package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
    @PostMapping("databoard/insert_ok.do")
    public String databoard_insert_ok(DataBoardVO vo)
    {
    	String path="c:\\upload";
    	List<MultipartFile> list=vo.getFiles();
    	if(list==null) // 파일이 없는 상태
    	{
    	    vo.setFilename("");
    	    vo.setFilesize("");
    	    vo.setFilecount(0);
    	}
    	else // 파일 올리기 
    	{
    		try
    		{
    			String filename="";
    			String filesize="";
    			for(MultipartFile mf:list)
    			{
    				String oname=mf.getOriginalFilename();
    				File file=new File(path+"\\"+oname);
    				// 파일 중복 
    				if(file.exists())
    				{
    				   String name=oname.substring(0,oname.lastIndexOf("."));
    				   String ext=oname.substring(oname.lastIndexOf("."));
    				   int count=1;
    				   while(file.exists())
    				   {
    					   String newName=name+"("+count+")"+ext;
    					   file=new File(path+"\\"+newName);
    					   count++;
    				   }
    				}
    				mf.transferTo(file);
    				filename+=file.getName()+",";
    				filesize+=file.length()+",";
    			}
    			filename=filename.substring(0,filename.lastIndexOf(","));
    			filesize=filesize.substring(0,filesize.lastIndexOf(","));
    			vo.setFilename(filename);
    			vo.setFilesize(filesize);
    			vo.setFilecount(list.size());
    		}catch(Exception ex) {}
    		
    	}
    	dService.databoardInsert(vo);
    	return "redirect:list.do";
    }
}
