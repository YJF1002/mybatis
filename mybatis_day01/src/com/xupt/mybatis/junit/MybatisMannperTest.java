package com.xupt.mybatis.junit;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.xupt.mybatis.mapper.UserMapper;
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
		User user = um.findUserById(10);
		System.out.println(user);
		
		sqlSession.close();
	}
}
