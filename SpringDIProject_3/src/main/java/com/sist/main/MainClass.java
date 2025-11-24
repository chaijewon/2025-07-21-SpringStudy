package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 *   application-context.xml
 *   application-datasource.xml
 *   application-security.xml
 *   application-websocket.xml
 *   
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String[] xml={"student-app.xml",
				      "member-app.xml",
				      "sawon-app.xml"};
	    ApplicationContext app=
	    		new ClassPathXmlApplicationContext(xml);*/
		ApplicationContext app=
				new ClassPathXmlApplicationContext("*-app.xml");
	    
	    Member m=(Member)app.getBean("mem");
	    System.out.println("번호:"+m.getNo());
	    System.out.println("이름:"+m.getName());
	    System.out.println("성별:"+m.getSex());
	    
	    

	}

}
