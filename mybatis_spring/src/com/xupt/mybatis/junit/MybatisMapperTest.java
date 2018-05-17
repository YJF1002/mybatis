package com.xupt.mybatis.junit;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xupt.mybatis.mapper.UserMapper;
import com.xupt.mybatis.pojo.Orders;
import com.xupt.mybatis.pojo.User;

public class MybatisMapperTest {
	
	@Test
	public void testMapper() throws Exception{
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		UserMapper Mapper =  ac.getBean(UserMapper.class);
		
		List<User> list = Mapper.findOrderByUserId();
		
		for (User user : list) {
			System.out.println(user);
		}
	}
}