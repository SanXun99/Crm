package com.briup.service;

import org.springframework.data.domain.Page;

import com.briup.bean.Chance;

/** 
* @author 作者 zwj: 
* @version 创建时间：2020年4月1日 下午8:34:35 
* 类说明 
*/
public interface ISalesService {
	
	/**
	 * 新增销售商机
	 */
	void insertChance(Chance chance,Integer creatorId,Integer handlerId);
	
	/**
	 * 如果商机开发成功
	 */
	//void insertChance(Chance chance);
	
	/**
	 * 根据客户和所在地查询显示
	 */
	Page<Chance> getChances(String customer,String address);
	
	/**
	 * 根据客户和所在地分页查询显示
	 * @param customer
	 * @param address
	 * @param pageIndex
	 * @return
	 */
	Page<Chance> getChances(String customer,String address,Integer pageIndex);
	
	/**
	 *删除 
	 */
	void deleteChance(Integer id);
	
	/**
	 * 根据id查询指定销售商机
	 */
	Chance findChanceById(Integer id);
	
}
