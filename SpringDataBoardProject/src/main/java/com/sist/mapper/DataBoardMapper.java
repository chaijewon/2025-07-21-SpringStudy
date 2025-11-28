package com.sist.mapper;
// SQL문장 저장 
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface DataBoardMapper {
  //1. 목록 
  @Select("SELECT no,name,subject,"
  		+ "TO_CHAR(regdate,'yyyy-mm-dd') as dbday,hit "
		+ "FROM springDataBoard ORDER BY no DESC "
  		+ "OFFSET #{start} ROWS FETCH NEXT 10 ROWS ONLY")
  //       => mySql : limit #{start},10
  //       => TO_CHAR(regdate,'yyyy-mm-dd') : DATE_FORMAT('%y-%M-%d')
  public List<DataBoardVO> databoardListData(int start);
  @Select("SELECT COUNT(*) FROM springDataBoard")
  public int databoardRowCount();
  //2. 추가 (업로드)
  @Insert("INSERT INTO springDataBoard VALUES("
		 +"sdb_no_seq.nextval,#{name},#{subject},"
		 +"#{content},#{pwd},SYSDATE,0,#{filename},"
		 +"#{filesize},#{filecount})")
  public void databoardInsert(DataBoardVO vo); // => 업로드 
  //3. 상세보기 (다운로드)
  //4. 수정 => ? 
  //5. 삭제 (파일 제거)
}
