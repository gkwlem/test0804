package st4_test05.st4_test05;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import Main.DTO.RegisterRequest;
import Main.service.ChangePasswordService;
import Main.service.MemberInfoPrinter;
import Main.service.MemberListPrinter;
import Main.service.MemberRegisterService;

public class App1 {
	private static GenericXmlApplicationContext ctx;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] conf = {"classpath:appCtx1.xml", "classpath:appCtx2.xml"};
		ctx = new GenericXmlApplicationContext(conf);
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("명령어를 입력해주세요: ");
			String command = sc.nextLine();
			
			if (command.startsWith("new")) {
				String[] arg = command.split(" ");
				if (arg.length != 5) {
					printHelp();
					System.out.println();
					continue;
				}
				// 의존객체 (클래스 안에 객체) dependency object
				RegisterRequest req = new RegisterRequest();
				req.setEmail(arg[1]);
				req.setName(arg[2]);
				req.setPassword(arg[3]);
				req.setConfirmPassword(arg[4]);
				boolean bl = req.isPasswordEqualConfirmPassword();
				if(!bl) {
					System.out.println("비밀번호가 일치하지 않습니다.");
					continue;
				}
				// 의존 객체 주입(DI) Dependency Injection
				MemberRegisterService mrs = ctx.getBean("memberRegisterService",MemberRegisterService.class);
				mrs.regist(req);
				
			} else if (command.startsWith("Change")) {
				String [] arg = command.split(" ");
				if(arg.length != 4) {
					printHelp();
					continue;
				}
				ChangePasswordService changePawdSvc = ctx.getBean("changePasswordService", ChangePasswordService.class);
				changePawdSvc.changePassword(arg[1], arg[2], arg[3]);
				
			} else if (command.startsWith("list")) {
				// 의존객체 dependency object
				MemberListPrinter listPrint = ctx.getBean("memberListPrinter", MemberListPrinter.class);
				listPrint.printAll();
				
			} else if (command.startsWith("Info")) {
				String [] arg = command.split(" ");
				if(arg.length != 2) {
					printHelp();
					continue;
				}
				MemberInfoPrinter infoPrinter = ctx.getBean("memberInfoPrinter", MemberInfoPrinter.class);
				infoPrinter.printMemberInfo(arg[1]);
				
			} else if (command.startsWith("exit")) {
				System.out.println("종료");
				System.exit(0);
				
			} else {
				printHelp();
			}
		}
	}
	
	public static void printHelp() {
		System.out.println();
		System.out.println("명령어 사용법: ");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재비번 변경비번 ");
		System.out.println("list");
		System.out.println("info 이메일");
		System.out.println("프로그램 종료 exit");
		
		
	}
	

}
