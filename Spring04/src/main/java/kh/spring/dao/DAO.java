package kh.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.DTO;

@Repository // bean을 만든거나 마찬가지
public class DAO {
	@Autowired // Annotation 방식 DI
	private DataSource ds;
	
	public Connection getConnection() throws Exception{
		return ds.getConnection();
	}
	
	public int insert(DTO dto) throws Exception{
		String sql = "insert into messages values(messages_seq.nextval,?,?,sysdate)";
		try(Connection con = this.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getMsg());
			
			int result = pstat.executeUpdate();
			con.commit();
			return result;
		}
	}
}
