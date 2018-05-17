package com.xupt.mybatis.junit;


import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xupt.mybatis.mapper.UserMapper;
import com.xupt.mybatis.pojo.User;
import com.xupt.mybatis.pojo.UserExample;

public class MybatisMapperTest {
	
	@Test
	public void testMapper() throws Exception{
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		UserMapper Mapper =  ac.getBean(UserMapper.class);
		UserExample exam = new UserExample();
		
		exam.createCriteria().andSexEqualTo("1");
		exam.setOrderByClause("id desc");
		User user = new User();
		user.setUsername("许仙");
		user.setSex("1");
		Mapper.insert(user);
		
		
		
		
		
		
	}
}