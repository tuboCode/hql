package model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import util.HibernateSessionFactory;

public class CommodityTest {
	private Session session = null;

	@Test
	public void commondityTest1() {
		String hql = " from Commodity c order by seller.id asc, price desc ,name asc ";
		Query query = session.createQuery(hql);
		List<Commodity> commoditys = query.list();
		for (Commodity commodity : commoditys) {
			System.out.println(commodity.getId());
			System.out.println(commodity.getName());
			System.out.println(commodity.getPrice());
		}
	}

	@Test
	public void commondityTest2() {
		String hql = " from Commodity c where c.price*5>3000 order by c.price asc ";
		Query query = session.createQuery(hql);
		List<Commodity> commoditys = query.list();
		for (Commodity commodity : commoditys) {
			System.out.println(commodity.getPrice()*5);
		}
	}
	
	@Test
	public void commondityTest3() {
		String hql = " from Commodity c where c.price<200 or c.price>300 ";
		Query query = session.createQuery(hql);
		List<Commodity> commoditys = query.list();
		for (Commodity commodity : commoditys) {
			System.out.println(commodity.getPrice()*5);
		}
	}
	
	@Test
	public void commondityTest4() {
		/*
		String hql = " from Commodity c where c.price between 1000 and 5000 "
				+ "and c.category like '%电脑%' and c.name like '%电脑_' ";
				*/
		String hql  = " from Commodity c where c.price between"
				+ " 1000 and 5000 or  c.category like '%电脑%' or name like '%电脑%' ";
		Query query = session.createQuery(hql);
		List<Commodity> commoditys = query.list();
		for (Commodity c : commoditys) {
			System.out.println(c.getName());
			System.out.println(c.getCategory());
			System.out.println(c.getPrice());
		}
	}
	
	@Test
	public void commondityTest3() {
		String hql = " from Commodity c where c.price<200 or c.price>300 ";
		Query query = session.createQuery(hql);
		List<Commodity> commoditys = query.list();
		for (Commodity commodity : commoditys) {
			System.out.println(commodity.getPrice()*5);
		}
	}
	
	@Before
	public void setUp() throws Exception {
		session = HibernateSessionFactory.getCurrentSession();
	}

	@After
	public void tearDown() throws Exception {
		session.close();
	}

}
