package Main.service;


import java.util.Date;

import Main.DTO.MemberDAO;
import Main.DTO.MemberDTO;
import Main.DTO.RegisterRequest;

public class MemberRegisterService {
	// 의존 객체
	private MemberDAO memberDao = new MemberDAO();
	public void regist(RegisterRequest req) {
		MemberDTO dto = memberDao.selectByEmail(req.getEmail());
		if (dto == null) {
			dto = new MemberDTO();
			dto.setEmail(req.getEmail());
			dto.setName(req.getName());
			dto.setPassword(req.getPassword());
			dto.setRegisterDate(new Date());
			memberDao.insert(dto);
			System.out.println("사용자 등록이 완료");
		}else {
			System.out.println("중복 사용자");
		}
	}
	
}
