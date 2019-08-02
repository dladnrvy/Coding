package member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainForAssembler {

	
	 private static Assembler assembler = new Assembler();
	  
	  private static MemberRegisetService regisetService =
	  assembler.getRegisetService();
	 
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("명령어를 입력해주세요");
			
			String command = reader.readLine();
			
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			
			// new uk@naver.com ukpyo 1111 1111 -> 띄어쓰기 split
			if(command.startsWith("new ")) {
				processNewCommand(command.split(" "));
			}
			
			if(command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
			}
		}
	}
	
	private static void processNewCommand(String[] args) {
		if(args.length != 5) {
			printHelp();
			return;
		}
		
		MemberRegisetService service = assembler.getRegisetService();
		RegisterRequest request = new RegisterRequest();
		request.setEmail(args[1]);
		request.setName(args[2]);
		request.setPassword(args[3]);
		request.setConfirmPassword(args[4]);
		if(!request.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호 확인이 일치하지 않습니다.");
			return;
		}
		
		try {
			service.register(request);
			System.out.println("등록되었습니다.");			 
		} catch (AleadyExistingMemberException e) {
			e.printStackTrace();
			System.out.println("이미 존재하는 이메일인 것 같은데 제대로좀 입력 해라 아후 진짜 ");
		}
	}
	
	
	private static void processChangeCommand(String[] args) {
		if(args.length !=4) {
			printHelp();
			return;
		}
		
		ChangePasswordService service = assembler.getPwService();
		
		try {
			service.changePassword(args[1], args[2], args[3]);
			System.out.println("암호가 변경되었습니다.");
		} catch (MemberNotfoundException e) {
			e.printStackTrace();
			System.out.println("존재하지 않는 이메일 이라니까아아아아아 쫌 씨");
		} catch (IdPasswordNotMatchingException e) {
			e.printStackTrace();
			System.out.println("이메일과 암호가 일치하지 않는데 제대로좀 해 진짜 ㅡㅡ");
		}
	}

	private static void printHelp() {
		System.out.println("");
		System.out.println("잘못된 명령 입니다. 아래 명령 사용법을 확인하세요.");
		System.out.println("new 이메일 사용자이름 암호 암호확인");
		System.out.println("change 이메일 현재암호 새로운암호");
	}

	
}
