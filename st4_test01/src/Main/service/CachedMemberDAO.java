package Main.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import Main.DTO.MemberDTO;

public class CachedMemberDAO {
	private static long nextId = 0;
	private static Map<String, MemberDTO> map = new HashMap<String, MemberDTO>();
	public void insert(MemberDTO dto) {
		dto.setId(++nextId);
		map.put(dto.getEmail(), dto);	
	}
	public MemberDTO selectByEmail(String email) {
		return map.get(email);
	}
	public Collection<MemberDTO> selectAll(){
		return map.values();
	}
	public void update(MemberDTO dto) {
		map.put(dto.getEmail(), dto);
	}
}
