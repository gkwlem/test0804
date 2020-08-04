package Main.service;

import Main.DTO.MemberDAO;
import Main.DTO.MemberDTO;

public class MemberInfoPrinter {
	private MemberDAO memberDao;
	private MemberPrinter printer;
	// 의존 객체 주입(DI) Dependency Injection
	public void setMemberDAO(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	public void printMemberInfo(String email) {
		MemberDTO dto = memberDao.selectByEmail(email);
		if(dto == null){
			System.out.println("데이터 없음\n");
			return;
		}
		printer.print(dto);
		
		
		
	}
}
