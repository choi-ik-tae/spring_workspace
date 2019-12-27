package kh.spring.dao;

import java.sql.Connection;
import javax.sql.DataSource;

public class DAO {
	private DataSource ds;
	
	public DAO(DataSource ds) {
		this.ds = ds;
	}
	
	private Connection getConnection() throws Exception {
		return ds.getConnection();
	}
	
	public void insert() throws Exception{
		Connection con = this.getConnection();
		con.prepareStatement("");
		con.close();
	}
	public void select() throws Exception{
		Connection con = this.getConnection();
		con.prepareStatement("");
		con.close();
	}
	
}
