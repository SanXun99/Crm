package com.briup.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.Chance;
import com.briup.bean.User;
import com.briup.service.ISalesService;
import com.briup.service.IUserService;

/**
 * @author 作者 zwj:
 * @version 创建时间：2020年4月1日 下午3:33:39 类说明
 */

@Controller
public class SalesController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ISalesService salesService;
	
	//根据条件显示第一页的商机信息
	@RequestMapping("toSales")
	public String findSales(HttpSession session,String customer,String address) {
		session.setAttribute("customer", customer);
		session.setAttribute("address", address);
		List<User> jinglis = userService.findByJingli(4);
		session.setAttribute("jinglis", jinglis);
		Page<Chance> chances = salesService.getChances(customer, address);
		session.setAttribute("chances", chances);
		return "pages/sales";
	}
	
	//添加用户
	@RequestMapping("addSales")
	@ResponseBody
	public String addSales(Chance chance,Integer creatorId,Integer handlerId) {
		if (handlerId == null) {
			return "处理人不能为空,请选择处理人!";
		}
		if (chance.getId()!=null) {
			salesService.insertChance(chance, creatorId, handlerId);
			return "修改成功";
		}else {
			salesService.insertChance(chance, creatorId, handlerId);
			return "添加成功";
		}
	}
	
	//根据条件分页查询
	@RequestMapping("updateSalesPage")
	public String updateSalesPage(HttpSession session,Integer pageIndex) {
		String customer = (String)session.getAttribute("customer");
		String address = (String)session.getAttribute("address");
		Page<Chance> chances = salesService.getChances(customer,address, pageIndex);
		session.setAttribute("chances", chances);
		return "pages/sales";
	}
	
	@RequestMapping("resetSales")
	@ResponseBody
	public String resetSales(HttpSession session) {
		session.removeAttribute("customer");
		session.removeAttribute("address");
		return "重置成功";
	}
	
	@RequestMapping(value = "sales/{id}",method = RequestMethod.GET)
	@ResponseBody
	public Chance selectSalesById(@PathVariable Integer id) {
		return salesService.findChanceById(id);
	}
	
	@RequestMapping(value = "sales/{id}",method = RequestMethod.POST)
	@ResponseBody
	public String deleteSalesById(@PathVariable Integer id) {
		salesService.deleteChance(id);
		return "删除成功";
	}
}
