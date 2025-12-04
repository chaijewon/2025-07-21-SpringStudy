package com.sist.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.*;
import com.sist.vo.*;
/*
 *   1. SI / SM 
 *   2. 솔루션 
 *   3. Framework : 위탁 => 자체개발 
 *   4. 아키텍처 
 *      나눔기술 
 */
@Service
public class BoardServiceImpl implements BoardService{
    @Autowired
    private BoardDAO bDao;

	@Override
	public List<BoardVO> boardListData(int start, int end) {
		// TODO Auto-generated method stub
		return bDao.boardListData(start, end);
	}
	
	@Override
	public int boardRowCount() {
		// TODO Auto-generated method stub
		return bDao.boardRowCount();
	}

	@Override
	public void boardInsert(BoardVO vo) {
		// TODO Auto-generated method stub
		bDao.boardInsert(vo);
	}
    
	@Override
	public BoardVO boardDetailData(int no) {
		// TODO Auto-generated method stub
		return bDao.boardDetailData(no);
	}
}
