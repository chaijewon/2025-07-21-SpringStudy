package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
// component : page 
// => detail => prop:[변수]  => v-bind
// => RestFul : @GetMapping @PostMapping @PutMapping @DeleteMapping
//              => SELECT    => INSERT    => UPDATE   => DELETE
// <> &lt  &gt
public interface BoardMapper {
  @Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
		 +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
		 +"FROM (SELECT no,subject,name,regdate,hit "
		 +"FROM springBoard ORDER BY no DESC)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<BoardVO> boardListData(@Param("start") int start,
		  @Param("end") int end);
  @Select("SELECT COUNT(*) FROM springBoard")
  public int boardRowCount();
}
