package Main.service;

import Main.DTO.MemberDAO;
import Main.DTO.MemberDTO;

public class ChangePasswordService {
	private MemberDAO memberDao = new MemberDAO();
	public void changePassword(String email, String oldPw, String newPw) {
		MemberDTO dto = memberDao.selectByEmail(email);
		if(dto == null) {
			System.out.println("이메일이 존재하지 않습니다.");
			return;
		}
		dto.changePassword(oldPw, newPw);
		memberDao.update(dto);
		
	}
}
