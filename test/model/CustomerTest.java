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

	//����һ��hibrtnate session ʵ������
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
		//queryʵ������Ĵ���
		String hql = " from Customer ";
		Query query = session.createQuery(hql);
		//����query��list������ѯ������������Ĳ�ѯ
		List<Customer> customers =  query.list();
		
		for(Customer customer:customers){
			System.out.println("name"+customer.getName());
		}
	}

}
