package Main.service;

import java.util.Collection;

import Main.DTO.MemberDAO;
import Main.DTO.MemberDTO;

public class MemberListPrinter {
	private MemberDAO memberDao;
	private MemberPrinter printer;
	// 의존 객체 주입(DI) Dependency Injection
	public MemberListPrinter(MemberDAO memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	public void printAll() {
		Collection<MemberDTO> lists = memberDao.selectAll();
		System.out.println("총 회원 수는: " + lists.size());
		for(MemberDTO dto : lists) {
			printer.print(dto);
			
		}
	}
	
	
	
}
