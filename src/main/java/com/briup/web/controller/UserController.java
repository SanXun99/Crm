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

import com.briup.bean.Role;
import com.briup.bean.User;
import com.briup.service.IRoleService;
import com.briup.service.IUserService;

/**
 * @author 作者 zwj:
 * @version 创建时间：2020年3月26日 下午4:34:45 类说明
 */
@Controller
public class UserController {
	// service层
	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;

	// 获取前台输入的用户名密码,进行校验
	@RequestMapping("user/login")
	@ResponseBody
	public String login(String name, String password, HttpSession session) {
		// 需要判断用户名和密码是否为空，但是前台已经完成。

		// 调用service层，来判断用户名和密码是否正确。
		User user = userService.findByName(name);
		// 如果user为空，则表示用户名不存在
		if (user == null) {
			return "当前用户名不存在!";
		}
		// 判断密码是否正确
		if (!user.getPassword().equals(password)) {
			return "密码错误!";
		}

		// 判断用户状态: 1为正常，2为注销
		if (user.getFlag() != 1) {
			return "该用户已被注销!";
		}
		// 将数据保存在session范围中，供前台使用。
		session.setAttribute("user", user);

		return "success";
	}

	// 退出功能
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "login";
	}

	// 显示用户管理的界面
	@RequestMapping("toUser")
	public String toUser(HttpSession session, Integer roleId) {
		session.setAttribute("roleId", roleId);
		// 查询User信息,有roleId则根据条件查询，没有则把所有用户查询出来
		Page<User> users = userService.findUsersByRole(roleId);
		session.setAttribute("users", users);
		// 查询角色信息-角色的名字
		List<Role> allRoles = roleService.allRoles();
		session.setAttribute("allRoles", allRoles);
		// System.out.println(roles.getTotalPages());
		return "pages/user";
	}

	// 分页查询
	@RequestMapping("updateUserPage")
	public String userPage(Integer pageIndex, HttpSession session) {
		Integer roleId = (Integer) session.getAttribute("roleId");
		Page<User> users = userService.findUsersByRole(roleId, pageIndex);
		session.setAttribute("users", users);
		return "pages/user";
	}

	@RequestMapping("resetUser")
	@ResponseBody
	public String resetUser(HttpSession session) {
		session.removeAttribute("roleId");
		return "重置成功";
	}

	@RequestMapping(value = "saveUser", method = RequestMethod.POST)
	@ResponseBody
	public String saveUser(User user) {
		if (user.getId() != null) {
			userService.saveUser(user);
			return "修改成功";
		} else {
			userService.saveUser(user);
			return "添加成功";
		}
	}

	@RequestMapping(value = "user/{id}",method = RequestMethod.GET)
	@ResponseBody
	public User selectUserById(@PathVariable Integer id) {
		return userService.findUserById(id);
	}

	@RequestMapping(value = "user/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteUserById(@PathVariable Integer id) {
		userService.deleteUserById(id);
		return "删除成功";
		
	}
}
