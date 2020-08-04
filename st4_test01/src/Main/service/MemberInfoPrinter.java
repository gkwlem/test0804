package Main.service;

import Main.DTO.MemberDAO;
import Main.DTO.MemberDTO;

public class MemberInfoPrinter {
	private MemberDAO memberDao = new MemberDAO();
	private MemberPrinter printer = new MemberPrinter();
	public void printMemberInfo(String email) {
		MemberDTO dto = memberDao.selectByEmail(email);
		if(dto == null){
			System.out.println("데이터 없음\n");
			return;
		}
		printer.print(dto);
		
		
		
	}
}
