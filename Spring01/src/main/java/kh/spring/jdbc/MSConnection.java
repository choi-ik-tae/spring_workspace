package kh.spring.jdbc;

import kh.spring.interfaces.Connection;

public class MSConnection implements Connection {
	public static MSConnection getConnection() {
		return new MSConnection();
	}
	
	public void prepareStatement() {}
	public void close() {}
}
