package Main.DTO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDAO {
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
	
	
}
