package com.briup.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.Role;
import com.briup.service.IRoleService;

/**
 * @author 作者 zwj:
 * @version 创建时间：2020年3月27日 上午11:51:01 类说明 : 角色管理模块
 */
@Controller
public class RoleController {
	// Service层
	@Autowired
	private IRoleService roleService;
	
	// 显示进来第一页的数据
	@RequestMapping("toRole")
	public String toRole(HttpSession session) {
		// 将数据库中所有角色信息查询出来。保存到session之中。
		Page<Role> roles = roleService.findAllRoles();
		session.setAttribute("roles", roles);
		// System.out.println(roles.getTotalPages());
		return "pages/role";
	}

	// 新增角色功能
	@RequestMapping("saveRole")
	@ResponseBody
	public String saveRole(Role role) {
		if (role.getId() != null) {
			roleService.saveRole(role);
			return "修改成功";
		} else {
			roleService.saveRole(role);
			return "添加成功";
		}
	}

	// 根据指定页码，查询数据
	@RequestMapping("pageRole")
	public String updatePageRole(Integer pageIndex, HttpSession session) {
		Page<Role> roles = roleService.findAllRoles(pageIndex);
		session.setAttribute("roles", roles);
		// 判断上一页是否有数据
		// System.out.println(roles.hasPrevious());
		// 获取当前页码
		//System.out.println(roles.getNumber());
		return "pages/role";
	}


	// 根据ID，查询指定的角色
	@RequestMapping("findRoleById")
	@ResponseBody
	public Role findRoleById(Integer id) {
		return roleService.findRoleById(id);
	}
	
	@RequestMapping("deleteRoleById")
	@ResponseBody
	public String deleteRoleById(Integer id) {
		roleService.deleteRole(id);
		return "删除成功";
	}
}
