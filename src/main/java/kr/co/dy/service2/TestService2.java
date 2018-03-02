package kr.co.dy.service2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dy.dao.TestDAO;

@Service
public class TestService2 {

	@Autowired
	TestDAO testDao;

	// 실제 사용자가 호출하려고 했던 메소드. joinPoint가 됨.
	// AOP를 사용하기 때문에 프록시에 의해 대신 호출된다. (proceed() 사용시)
	public void doCqwer() {
		System.out.println("doCService - joinPoint");
	}
	
	public void doDasdf() {
		System.out.println("doDService - joinPoint");
	}
}
