package kh.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kh.spring.dto.DTO;

public class DAO {
	
	public DAO() {
		super();
	}
	public DAO(DataSource ds) {
		super();
		this.ds = ds;
	}

	private DataSource ds;
	
	private Connection getConnection() throws Exception {
		return ds.getConnection();
	}
	
	public int insert(String name, String msg) throws Exception {
		String sql = "insert into messages values (messages_seq.nextval, ?, ?, sysdate)";
		try(
				Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				){
			pstat.setString(1, name);
			pstat.setString(2, msg);
			int result = pstat.executeUpdate();

			con.commit();
			return result;
		}
	}
	
	public List<DTO> selectAll() throws Exception {
		String sql = "select * from messages order by seq";
		try(
				Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();
				){
			List<DTO> list = new ArrayList<>();
			while(rs.next()) {
				int seq = rs.getInt(1);
				String name = rs.getString(2);
				String msg = rs.getString(3);
				Timestamp write_date = rs.getTimestamp(4);
				
				DTO dto = new DTO(seq, name, msg, write_date);
				list.add(dto);
			}
			con.commit();
			return list;
		}
	}
	
	public int delete(int seq) throws Exception {
		String sql = "delete from messages where seq = ?";
		try(
				Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				){
			pstat.setInt(1, seq);
			int result = pstat.executeUpdate();
			
			con.commit();
			return result;
		}
	}
}
