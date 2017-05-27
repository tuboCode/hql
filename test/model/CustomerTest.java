package model;

import static org.junit.Assert.*;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Customer;
import util.HibernateSessionFactory;

public class CustomerTest {

	//创建一个hibrtnate session 实例变量
	private Session session = null;
	
	@Before
	public void setUp() throws Exception {
		session = HibernateSessionFactory.getCurrentSession();
	}

	@After
	public void tearDown() throws Exception {
		session.close();
	}

	@Test
	public void testSeller() {
		//query实例对象的创建
		String hql = " from Customer ";
		Query query = session.createQuery(hql);
		//调用query的list方法查询，完成面向对象的查询
		List<Customer> customers =  query.list();
		
		for(Customer customer:customers){
			System.out.println("name"+customer.getName());
		}
	}

}
