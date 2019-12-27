package kh.spring.factory;

import kh.spring.interfaces.Connection;
import kh.spring.jdbc.MSConnection;
import kh.spring.jdbc.OracleConnection;

public class ConnectionFactory {
	public static Connection getConnection(String type) {
		// 어떠한 인자값에 관하여 결과값을 배출하는 방식을 팩토리 디자인 패턴
		
		if(type.contentEquals("oracle")) {
			return new OracleConnection();
		} else if(type.contentEquals("ms")) {
			return new MSConnection();
		} else {
			return null;
		}
	}
}
