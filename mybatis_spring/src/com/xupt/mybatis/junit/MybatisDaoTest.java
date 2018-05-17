package com.xupt.mybatis.junit;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xupt.mybatis.dao.UserDao;
import com.xupt.mybatis.dao.UserDaoImpl;
import com.xupt.mybatis.pojo.User;

public class MybatisDaoTest {
	private ApplicationContext context;

	@Before
	public void setUp() throws Exception {
		this.context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}
	

	@Test
	public void testUserDao() throws Exception{
		//加载核心配置文件
		UserDao userDao = this.context.getBean(UserDao.class);
		User user = userDao.findUserById(10);
		
		System.out.println(user);
	}
}
