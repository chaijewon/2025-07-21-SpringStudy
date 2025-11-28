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
    @GetMapping("databoard/detail.do")
    public String databoard_detail(int no,Model model)
    {
    	// 오라클에서 데이터 읽기 
    	DataBoardVO vo=dService.databoardDetailData(no);
    	if(vo.getFilecount()>0)
    	{
    	  List<String> fList=new ArrayList<String>();
    	  List<String> sList=new ArrayList<String>();
    	  String[] f=vo.getFilename().split(",");
    	  String[] s=vo.getFilesize().split(",");
    	  fList=Arrays.asList(f);
    	  sList=Arrays.asList(s);
    	  
    	  model.addAttribute("fList", fList);
    	  model.addAttribute("sList", sList);
    	}
    	model.addAttribute("vo", vo);
    	return "databoard/detail";
    }
    /*
     *   Spring => Model 제작 
     *   --------------------
     *   리턴형 : void / String
     *                 | 파일 변경(화면 변경) 
     *           |다운로드 (화면이동 / 화면 이동이 없는 경우)
     *           
     *   메소드 찾기 => URL주소을 이용한다 
     *     |
     *   매개변수 
     *     => 사용자가 보내준 데이터 : 일반 데이터 / VO
     *     => 데이터 전송이 있는 경우 : Model model
     *     => Cookie / Session 
     *                 | HttpSession session 
     *         | request/response
     *     => 필요한 데이터나 객체 => 매개변수를 통해서 가지고 온다 
     */
    // download.do?fn=${f}
    @GetMapping("databoard/download.do")
    public void databoard_download(String fn)
    {
    	
    }
    
}
