package kh.spring.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import kh.spring.dao.DAO;

public class Main {
	public static void main(String[] args) throws Exception{
		//DAO dao = new DAO(ConnectionFactory.getConnection(args[0]));
		
																			// classpath : resources를 가르킴
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:context.xml");
		DAO dao = (DAO)ctx.getBean("dao"); // return 방식이 Object라 다운캐스팅
		dao.select();
		
	}
}
