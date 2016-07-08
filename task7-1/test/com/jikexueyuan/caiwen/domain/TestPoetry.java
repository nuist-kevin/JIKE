package com.jikexueyuan.caiwen.domain;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Description: <br>
 * 任务 7: SSH框架之Hibernate入门 <br>
 * 1、［使用HQL实现］输出数据中名字为三个字的诗人列表及其诗词的数量统计。格式如：姓名 － 诗词数量 <br>
 * 2、分页输出诗人李白所有诗词的标题，要求每10个标题分为1页，输出的数据格式如下： <br>
 * 诗人李白相关的数据总共 XXX页。 <br>
 * 第一页内容： <br>
 * 《。。。》 <br>
 * 《。。。》 <br>
 * 最后一页内容： <br>
 * 《。。。》 <br>
 * 《。。。》 <br>
 * <br>
 * 3、［使用关联映射实现］输出某一个诗人所有的诗词前15个字（包括标点符号），这个诗人的名字要求用户输入，敲回车后进行查询操作。 <br>
 *
 * @author caiwen
 * @version 1.0
 */

public class TestPoetry {

	private static SessionFactory sessionFactory;

	/**
	 * 第三个小题，由于test中无法接收控制台输入，写在main方法中运行
	 */
	public static void main(String[] args) {
		sessionFactory = getSessionFactory();
		Session session = sessionFactory.openSession();
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入诗人名称，按回车确认，退出请输入exit：");
		while (scanner.hasNext()) {
			String writer = scanner.next();
			if (writer.equals("exit")) {
				System.out.println("谢谢使用，再见");
				scanner.close();
				break;
			}
			Query query = session.createQuery(
					"select substring(pp.content, 1, 15) from Poet p join p.poetries pp where p.name = :name");
			query.setParameter("name", writer);
			List<String> result = query.list();
			if (result.size() == 0) {
				System.out.println("未收录此人的诗词");
			} else {
				for (String title : result) {
					System.out.println(title);
				}
			}
		}
		session.close();
	}

	/**
	 * 获取sessionFactory的静态方法
	 */
	private static SessionFactory getSessionFactory() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		return new MetadataSources(registry).buildMetadata().buildSessionFactory();
	}

	@BeforeClass
	public static void setup() {
		sessionFactory = getSessionFactory();
	}

	/**
	 * 第一个小题
	 */
	@Test
	public void test1() {
		Session session = sessionFactory.openSession();
		List<Object[]> resultList = session.createQuery(
				"select p.poet.name, count(p) from Poetry p " + "group by p.poet.name having length(p.poet.name) = 9 ")
				.list();

		/*
		 * SQL query 方法实现 List<Object[]> resultList = session.createNativeQuery(
		 * "select t2.name, count(t2.name)" + "   FROM" +
		 * "   tang_poetry.poetries t1" + "   JOIN" +
		 * "   tang_poetry.poets t2 ON t1.poet_id = t2.id" +
		 * "   group by t2.name" + "   having length(t2.name) = 9"
		 * ).getResultList();
		 */

		for (Object[] record : resultList) {
			System.out.println(record[0] + " - " + record[1]);
		}
	}

	/**
	 * 第二个小题
	 */
	@Test
	public void test2() {
		Session session = sessionFactory.openSession();
		Long recordNum = (Long) session.createQuery("select count(p.title) from Poetry p where p.poet.name = '李白'")
				.uniqueResult();
		System.out.println(recordNum);
		int pageNum = (int) (recordNum % 10 == 0 ? recordNum / 10 : (recordNum / 10 + 1));
		for (int i = 1; i <= pageNum; i++) {
			List<String> titles = session
					.createNativeQuery("select t1.title" + "   FROM" + "   tang_poetry.poetries t1" + "   JOIN"
							+ "   tang_poetry.poets t2 ON t1.poet_id = t2.id" + "   where t2.name='李白'")
					.setFirstResult((i - 1) * 10).setMaxResults(10).getResultList();
			System.out.println("第" + i + "页：");
			for (String title : titles) {
				System.out.println("《" + title + "》");
			}
		}
		session.close();
	}

	@AfterClass
	public static void teardown() {
		sessionFactory.close();
	}

}
