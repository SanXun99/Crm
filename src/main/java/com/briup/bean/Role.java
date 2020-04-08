package com.briup.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//主键自动增长
	private Integer id;

	private String name;

	private String description;

	private Integer flag;

	/**
	 * mappedBy = "role" 中的role为User中和角色相关的属性(属性映射数据库中的字段)。
	 * cascade = CascadeType.ALL 表示绑定级联的所有操作
	 * fetch = FetchType.EAGER 表示需要立马加载，默认值为懒加载
	 */
	@OneToMany(mappedBy = "role",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<User> user;

	
	public Role() {
	}
	
	public Role(Integer id) {
		super();
		this.id = id;
	}


	/*public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Role{" + "id=" + id + ", name=" + name + ", description=" + description + ", flag=" + flag + "}";
	}

}
