package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Service
public class DataBoardServiceImpl implements DataBoardService{
	@Autowired
    private DataBoardDAO dao;

	@Override
	public List<DataBoardVO> databoardListData(int start) {
		// TODO Auto-generated method stub
		return dao.databoardListData(start);
	}

	@Override
	public void databoardInsert(DataBoardVO vo) {
		// TODO Auto-generated method stub
		dao.databoardInsert(vo);
	}

	@Override
	public int databoardRowCount() {
		// TODO Auto-generated method stub
		return dao.databoardRowCount();
	}
}
