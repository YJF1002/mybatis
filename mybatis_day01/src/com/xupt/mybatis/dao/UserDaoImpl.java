package com.xupt.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.xupt.mybatis.pojo.User;


public class UserDaoImpl implements UserDao{
	private SqlSessionFactory sqlSessionFactory;
	
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(Integer id) {
		
		SqlSession sqlsession = sqlSessionFactory.openSession();
		return sqlsession.selectOne("test.findUserById",id);
	}
	
}
