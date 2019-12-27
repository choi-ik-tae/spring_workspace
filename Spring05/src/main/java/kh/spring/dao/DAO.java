package kh.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.DTO;

@Repository
public class DAO {
	@Autowired
	private DataSource ds;
	
	public Connection getConnection() throws Exception {
		return ds.getConnection();
	}
	// 메세지 입력
	public int insert(DTO dto) throws Exception {
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
	// 메세지 출력
	public List<DTO> selectAll() throws Exception {
		String sql = "select * from messages";
		try(Connection con = this.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();){
			List<DTO> list = new ArrayList<>();
			while(rs.next()) {
				int seq = rs.getInt(1);
				String name = rs.getString(2);
				String msg = rs.getString(3);
				Timestamp write_date = rs.getTimestamp(4);
				
				DTO dto = new DTO(seq,name,msg,write_date);
				list.add(dto);
			}
			return list;
		}
	}
	// 메세지 삭제
	public int delete(int seq) throws Exception {
		String sql = "delete from messages where seq = ?";
		try(Connection con = this.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setInt(1, seq);
			
			int result = pstat.executeUpdate();
			con.commit();
			return result;
		}
	}
}
