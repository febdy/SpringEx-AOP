package kr.co.dy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dy.dao.TestDAO;

@Service
public class TestService {

	@Autowired
	TestDAO testDao;

	// 실제 사용자가 호출하려고 했던 메소드. joinPoint가 됨.
	// AOP를 사용하기 때문에 프록시에 의해 대신 호출된다. (proceed() 사용시)
	public String testService1() {
		System.out.println("Service 실행 - joinPoint");

		return "Hello world";
	}
	
	public String doBService() {
		System.out.println("Service - doBservice");
		
		return "THIS IS doBService()";
	}
}
