package member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForAssembler2 {

	
	/* private static Assembler assembler = new Assembler(); */
	  
	//스프링 컨테이너 생성 : 조립기 설정파일 appCtx1.xml
	 private  static ApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx5.xml");
	 
	public static void main(String[] args) throws IOException {
		
		System.out.println("스프링 컨테이너에서 받은 객체");
		System.out.println("");
		MemberRegisetService regisetService1 = ctx.getBean("regisetService", MemberRegisetService.class);
		MemberRegisetService regisetService2 = ctx.getBean("regisetService", MemberRegisetService.class);
		
		boolean chk = regisetService1 == regisetService2;
		
		System.out.println("regisetService1 == regisetService2 : " + chk);
		
		System.out.println("");
	}
}
