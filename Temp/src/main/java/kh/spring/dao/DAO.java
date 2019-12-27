package kh.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DAO {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public int insert1() {
		String sql = "insert into tx values(tx_seq.nextval,'abc')";
		return jdbc.update(sql);
	}
	
	public int insert2() {
		String sql = "insert int tx values(tx_seq.nextval,'def')";
		return jdbc.update(sql);
	}
}
