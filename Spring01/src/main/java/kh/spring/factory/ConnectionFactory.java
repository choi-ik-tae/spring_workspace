package kh.spring.factory;

import kh.spring.interfaces.Connection;
import kh.spring.jdbc.MSConnection;
import kh.spring.jdbc.OracleConnection;

public class ConnectionFactory {
	public static Connection getConnection(String type) {
		// ��� ���ڰ��� ���Ͽ� ������� �����ϴ� ����� ���丮 ������ ����
		
		if(type.contentEquals("oracle")) {
			return new OracleConnection();
		} else if(type.contentEquals("ms")) {
			return new MSConnection();
		} else {
			return null;
		}
	}
}
