package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// 자바스크립트로 데이터 전송 

import com.sist.dao.BoardDAO;
@RestController
public class RestBoardController {
  @Autowired
  private BoardDAO dao;
  
  @GetMapping(value="board/delete.do",produces = "text/plain;charset=UTF-8")
  // response.setContentType("text/plain;charset=UTF-8")
  public String board_delete(int no,String pwd)
  {
	  String res="";
	  res=dao.boardDelete(no, pwd);
	  return res;
  }
}
