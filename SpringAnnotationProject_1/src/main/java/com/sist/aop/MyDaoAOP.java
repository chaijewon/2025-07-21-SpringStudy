package com.sist.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDaoAOP {
  @Before("execution(* com.sist.dao.MyDAO.*(..))")
  //           return형                   모든 메소드    .. (매개변수 전체)  
  public void getConnection()
  {
	  System.out.println("🔔🔔🔔 오라클 연결 🔔🔔🔔");
  }
  @After("execution(* com.sist.dao.MyDAO.*(..))")
  public void disConnection()
  {
	  System.out.println("🔒🔒🔒 오라클 연결 해제 🔒🔒🔒");
  }
}
