package kh.spring.dao;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MessagesDTO;

@Repository
public class MessagesDAO {
	
	@Autowired
	private SqlSessionTemplate jdbc;
	
	public int insert(MessagesDTO dto) {
		Map<String,String> param = new HashMap<>();
		param.put("name", dto.getName());
		param.put("msg",dto.getMsg());
		
		return jdbc.insert("Messages.insert", param);
	}
	
	public List<MessagesDTO> selectAll() {
		return jdbc.selectList("Messages.selectAll");
	}
	
//	public int delete(int seq) {
//		return jdbc.delete("Messages.delete", seq);
//	}
	
	public int deleteBy(String col, String val) {
		Map<String,String> param = new HashMap<>();
		param.put("col", col);
		param.put("val", val);
		
		return jdbc.delete("Messages,delete", param);
	}
	
	public List<MessagesDTO> selectDyn1(String name) {
		return jdbc.selectList("Messages.selectDyn1", name);
	}
	
}
