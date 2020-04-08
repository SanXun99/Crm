package com.briup.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Chance;
import com.briup.bean.User;

/**
 * @author 作者 zwj:
 * @version 创建时间：2020年4月1日 下午3:29:29 类说明
 */
public interface SalesDao extends JpaRepository<Chance, Integer> {
	// 根据潜在客户名，查询对应的销售商机并分页
	Page<Chance> findByCustomerLike(String customer, Pageable pageable);

	// 根据区域名，查询对应的销售商机并分页
	Page<Chance> findByAddress(String address, Pageable pageable);
	
	//根据潜在客户名及区域名，查询对应的销售商机并分页
	Page<Chance> findByCustomerAndAddress(String customer,String address,Pageable pageable);
	// 根据客户经理，查询对应的销售商机并分页
	Page<Chance> findByHandler(User handler, Pageable pageable);

	// 根据客户经理和区域，一起查询对应的销售商机并分页
	Page<Chance> findByHandlerAndAddress(User handler, String address, Pageable pageable);
}
