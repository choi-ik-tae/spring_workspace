package kh.spring.jdbc;

import kh.spring.interfaces.Connection;

public class OracleConnection implements Connection {
	public static OracleConnection getConnection() {
		return new OracleConnection();
	}
	public void prepareStatement() {}
	public void close() {}
}
