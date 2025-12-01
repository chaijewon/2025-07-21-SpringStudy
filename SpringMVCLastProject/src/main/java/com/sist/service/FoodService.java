package com.sist.service;
import java.util.*;

/*
 *    클라이언트  ===== Service ===== DAO ===== 오라클 
 *                                  |
 *                                 수정
 */
import com.sist.vo.FoodVO;
public interface FoodService {
	   public List<FoodVO> foodListData(int start,int end);
	   public int foodTotalPage(); 
	   public FoodVO foodDetailData(int fno);
}
