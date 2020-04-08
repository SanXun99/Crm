package com.briup.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.CustomerConstitute;
import com.briup.dao.CustomerDao;
import com.briup.service.ICustomerConstituteService;

/** 
* @author 作者 zwj: 
* @version 创建时间：2020年4月3日 上午10:45:01 
* 类说明 
* 	
*/

@Service
public class CustomerConstituteServiceImpl implements ICustomerConstituteService {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<CustomerConstitute> regionAnalyze() {
		List<CustomerConstitute> list = new ArrayList<CustomerConstitute>();
		//从数据库中将所有客户信息查找出来。(需要获取总数)
		float nums = customerDao.findAll().size();
		
		String[] regions = {"华中","华南","华东","华北"};
		for (String region : regions) {
			//根据地区，查询数据库中对应的条目数
			int num = customerDao.findByRegion(region).size();
			
			//获取百分比
			float y = num/nums*100;
			CustomerConstitute cc = new CustomerConstitute(region, y, region);
			list.add(cc);
		}
		//然后根据地区进行筛选，然后封装成List自定义对象
		return list;
	}

	@Override
	public List<CustomerConstitute> levelAnalyze() {
		List<CustomerConstitute> list = new ArrayList<CustomerConstitute>();
		float nums = customerDao.findAll().size();
		String[] levels = {"普通客户","重点开发客户","大客户","合作伙伴","战略合作伙伴"};
		for (String level : levels) {
			//根据客户等级，查询数据库中对应的条目数
			int num = customerDao.findByLevel(level).size();
			
			float y = num/nums*100;
			CustomerConstitute cc = new CustomerConstitute(level,y,null);
			list.add(cc);
		}
		return list;
	}

}
