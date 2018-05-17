package com.xupt.mybatis.junit;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.xupt.mybatis.pojo.User;

public class MybatisFirstTest {
	
	@Test
	public void testMybatis() throws Exception{
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//Resources
		//创建SqlSessionFactory
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建Sqlsession
		SqlSession sqlsession = sqlSessionFactory.openSession();
		//执行sql语句
		User user = sqlsession.selectOne("test.findUserById",10);
		
		System.out.println(user);
	}
	
	@Test
	public void testfindUserByUsername() throws Exception{
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//Resources
		//创建SqlSessionFactory
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建Sqlsession
		SqlSession sqlsession = sqlSessionFactory.openSession();
		//执行sql语句
		List<User> users = sqlsession.selectList("test.findUserByUsername","五");
		for(User user2 : users){
			System.out.println(user2);
		}
		
	}
	
	@Test
	public void testInsterUser() throws Exception{
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//Resources
		
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建Sqlsession
		
		SqlSession sqlsession = sqlSessionFactory.openSession();
		//执行sql语句
		
		User user = new User();
		user.setUsername("杜秦芝");
		user.setBirthday(new Date());
		user.setAddress("西安邮电大学");
		user.setSex("男");
		sqlsession.insert("test.insertUser",user);
		
		sqlsession.commit();
	}
}
