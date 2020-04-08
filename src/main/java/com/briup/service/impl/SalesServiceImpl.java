package com.briup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.briup.bean.Chance;
import com.briup.bean.User;
import com.briup.dao.SalesDao;
import com.briup.dao.UserDao;
import com.briup.service.ISalesService;

/**
 * @author 作者 zwj:
 * @version 创建时间：2020年4月1日 下午9:00:27 类说明
 */
@Service
public class SalesServiceImpl implements ISalesService {

	@Autowired
	private SalesDao salesDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	public void insertChance(Chance chance, Integer creatorId, Integer handlerId) {
		User creatorUser = userDao.findById(creatorId).get();
		chance.setCreator(creatorUser);
		User handlerUser = userDao.findById(handlerId).orElse(null);
		chance.setHandler(handlerUser);
		salesDao.save(chance);
	}
	
	@Override
	public Page<Chance> getChances(String customer, String address) {
		
		return getChances(customer, address, 0);
	}

	@Override
	public Page<Chance> getChances(String customer, String address, Integer pageIndex) {
		Page<Chance> chances = null;
		PageRequest pageable = PageRequest.of(pageIndex, 2);
		if ((customer !=null && customer.trim()!="") && (address!=null && address.trim()!="")) {
			//根据客户名字以及区域进行查询
			chances = salesDao.findByCustomerAndAddress(customer, address, pageable);
		}else if (customer!=null && customer.trim()!="") {
			//根据客户名字查询
			chances = salesDao.findByCustomerLike(customer, pageable);
		}else if (address !=null && address.trim()!="") {
			//根据区域查询
			chances = salesDao.findByAddress(address, pageable);
		} else {
			//无条件查询
			chances = salesDao.findAll(pageable);
		}
		return chances;
	}

	@Override
	public void deleteChance(Integer id) {
		salesDao.deleteById(id);
	}

	@Override
	public Chance findChanceById(Integer id) {
		/*
		 * .get():获取当前类对象
		 * .orElse(xxx):获取类对象，同时如果对象不存在可以指定默认值
		 */
		return salesDao.findById(id).orElse(null);
	}


}
