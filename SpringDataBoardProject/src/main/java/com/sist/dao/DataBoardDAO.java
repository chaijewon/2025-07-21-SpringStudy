package com.sist.dao;
// Mapper구현
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class DataBoardDAO {
   @Autowired
   private DataBoardMapper mapper;
   
   // 구현 
   /*
    *   @Select("SELECT no,name,subject,"
  		+ "TO_CHAR(regdate,'yyyy-mm-dd') as dbday,hit "
		+ "FROM springDataBoard ORDER BY no DESC "
  		+ "OFFSET #{start} ROWS FETCH NEXT 10 ROWS ONLY")
   //       => mySql : limit #{start},10
   //       => TO_CHAR(regdate,'yyyy-mm-dd') : DATE_FORMAT('%y-%M-%d')
       public List<DataBoardVO> databoardListData(int start);
    */
   public List<DataBoardVO> databoardListData(int start)
   {
	   return mapper.databoardListData(start);
   }
   /*
    *   @Insert("INSERT INTO springDataBoard VALUES("
		 +"sdb_no_seq.nextval,#{name},#{subject},"
		 +"#{content},#{pwd},SYSDATE,0,#{filename},"
		 +"#{filesize},#{filecount})")
        public void databoardInsert(DataBoardVO vo); // => 업로드
    */
   public void databoardInsert(DataBoardVO vo)
   {
	   mapper.databoardInsert(vo);
   }
   /*
    *   @Select("SELECT COUNT(*) FROM springDataBoard")
        public int databoardRowCount();
    */
   public int databoardRowCount()
   {
	   return mapper.databoardRowCount();
   }
}
