package com.sist.service;

import java.util.List;

import com.sist.vo.DataBoardVO;

public interface DataBoardService {
	public List<DataBoardVO> databoardListData(int start);
	public void databoardInsert(DataBoardVO vo);
	public int databoardRowCount();
	public DataBoardVO databoardDetailData(int no);
}
