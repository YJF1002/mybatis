package com.xupt.mybatis.junit;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.xupt.mybatis.mapper.UserMapper;
import com.xupt.mybatis.pojo.Orders;
import com.xupt.mybatis.pojo.User;

public class MybatisMannperTest {
public SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void before() throws Exception{
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		//Resources
		InputStream in = Resources.getResourceAsStream(resource);
		
		//创建SqlSessionFactory
		 sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
	}
	@Test
	public void testMapper() throws Exception{
		//加载核心配置文件
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//从sqlSession获取Mapper对象
		
		UserMapper um = sqlSession.getMapper(UserMapper.class);
		List<Orders> os = um.findOrdersByOrdersId();
		for (Orders orders : os) {
			System.out.println(orders);
		}
	}
	@Test
	public void testfindOrderbyUserId() throws Exception{
	
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//从sqlSession获取Mapper对象
		
		UserMapper um = sqlSession.getMapper(UserMapper.class);
		List<User> list = um.findOrderByUserId();
		for (User user : list) {
			System.out.println(user);
		}
	}
}
