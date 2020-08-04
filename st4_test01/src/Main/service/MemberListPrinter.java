package Main.service;

import java.util.Collection;

import Main.DTO.MemberDAO;
import Main.DTO.MemberDTO;

public class MemberListPrinter {
	private MemberDAO memberDao = new MemberDAO();
	private MemberPrinter printer = new MemberPrinter();
	public void printAll() {
		Collection<MemberDTO> lists = memberDao.selectAll();
		System.out.println("총 회원 수는: " + lists.size());
		for(MemberDTO dto : lists) {
			printer.print(dto);
			
		}
	}
	
	
	
}
