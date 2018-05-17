package com.xupt.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.xupt.mybatis.pojo.User;


public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{


	@Override
	public User findUserById(Integer id) {
		
		SqlSession sqlSession = super.getSqlSession();
		return sqlSession.selectOne("test.findUserById",id);
	}
	
}
