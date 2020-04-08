package com.briup.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.briup.bean.User;

/** 
* @author 作者 zwj: 
* @version 创建时间：2020年3月26日 下午4:47:57 
* 类说明 
*/
public interface IUserService {
	/**
	 * 根据用户名查询用户信息
	 * @param name
	 * @return
	 */
	User findByName(String name);
	
	/**
	 * 查询User信息,有roleId则根据条件查询，没有则把所有用户查询出来
	 */
	Page<User> findUsersByRole(Integer roleId);
	
	/**
	 * 根据分页查询User的相关信息,无roleId则查询所有用户。
	 * @param roleId
	 * @param pageIndex
	 * @return
	 */
	Page<User> findUsersByRole(Integer roleId,Integer pageIndex);
	
	/**
	 * 新增和修改用户信息
	 * @param user
	 */
	void saveUser(User user);
	
	/**
	 * 根据id查询对应的用户信息
	 */
	User findUserById(Integer id);
	
	/**
	 * 根据id删除用户
	 * @param id
	 */
	void deleteUserById(Integer id);
	
	/**
	 * 查询所有角色为经理的用户
	 */
	List<User> findByJingli(Integer id);
}
