package com.sist.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// => 데이터베이스: MySQL :(MyBatis , JPA) 
// 언어: (Java, Kotlin) , Python  Front(Vue / React) 
// Docker / AWS / Git(Action)
@RestController
public class RecipeRestController {
  @GetMapping(value="recipe/detail.do",
		   produces = "text/plain;charset=UTF-8")
  public List<String> recipe_detail()
  {
	  List<String> list=new ArrayList<String>();
	  list.add("홍길동1");
	  list.add("홍길동2");
	  list.add("홍길동3");
	  return list;
  }
}
