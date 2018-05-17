package com.xupt.mybatis.mapper;

import com.xupt.mybatis.pojo.User;

public interface UserMapper {
	
	//遵循四个原则
	//接口方法名 == User.xml 中的id名
	//返回值类型 与 Mapper.xml文件中返回值类型一致
	//方法的入参类型与 Mapper.xml入参类型一致
	//命名空间指定此接口
	
	public User findUserById(Integer id);
	
	
	 
}
