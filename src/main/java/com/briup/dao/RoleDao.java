package com.briup.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Role;

/** 
* @author 作者 zwj: 
* @version 创建时间：2020年3月27日 下午2:46:48 
* 类说明 :
* 	从数据库中查找role相关数据。使用默认提供的方法
*/
public interface RoleDao extends JpaRepository<Role, Integer> {
	Role findByName(String name);
}
