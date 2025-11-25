package com.sist.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.service.EmpService;
import com.sist.vo.DeptVO;
import com.sist.vo.EmpVO;

@Component("mc") // map.put("mc",new MainClass()) => Object getBean("mc")
public class MainClass {
	@Autowired
    private EmpService service;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 사용자정의 클래스,라이브러리 클래스를 관리하는 클래스 => 컨테이너
		// 등록된 모든 클래스를 Map에 저장한다 
		// 패키지 단위 / 한개 클래스
		              // => <bean>
		// => 사용자의 정의 클래스
        ApplicationContext app=
        	  new ClassPathXmlApplicationContext("application-*.xml");
        MainClass mc=app.getBean("mc",MainClass.class);
        List<EmpVO> eList=mc.service.empListData();
        List<DeptVO> dList=mc.service.deptListData();
        EmpVO vo=mc.service.empDetailData(7788);
        
        System.out.println("======= 부서 정보 =======");
        for(DeptVO dvo:dList)
        {
        	System.out.println(dvo.getDeptno()+" "
        			+dvo.getDname()+" "
        			+dvo.getLoc());
        }
	}

}
