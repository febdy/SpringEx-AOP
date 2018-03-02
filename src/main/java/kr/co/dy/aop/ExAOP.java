package kr.co.dy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//aop 클래스 생성시 어노테이션 2개

@Component // Component-scan에 의한 Bean 설정을 위한 어노테이션
@Aspect // EXAOP클래스에 Advice가 들어있음을 알려줌.
public class ExAOP {
	
	// Advice : 실제 실행 할 수 있는 부가적인 작업들 (Method)
	
	@Around("execution(* kr.co.dy.service..test*(..))") // 메소드가 실행될 때
	//   앞의 * : 모든 패키지 || .. : 모든 하위 패키지(클래스) || test* : test로 시작하는 메소드 || (..) : 매개변수  수
	// Around 포인트컷을 활용할 때는 항상 Advice의 매개변수에 ProceedingJoinPoint가 있어야 함.
	public Object testAOP1(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("testAOP1 - Advice 실행. joinPoint 실행 전");
		Object obj = null; // proceed에 의한 리턴을 받아냄.
		
		try {
			obj = joinPoint.proceed();
		} finally {
			System.out.println("testAOP1 - Advice 실행. joinPoint 실행 후");
		}

		return obj;
	}

	@Around("execution(* kr.co.dy.service..*BService(..))")
	public Object testAOP2(ProceedingJoinPoint joinPoint) throws Throwable {
		Object obj = null;
		
		try {
			obj = joinPoint.proceed();
		} finally {
			System.out.println("testAOP2");
		}
		
		return obj;
	}
	
	@Around("within(kr.co.dy.service2..*)")
	public void withInAOP(ProceedingJoinPoint joinPoint) throws Throwable {
		Object obj = null;
		
		try {
			obj = joinPoint.proceed();
		} finally {
			System.out.println("withInAOP");
		}
	}
}
