package com.briup.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id		//标识当前主键列
	@GeneratedValue(strategy = GenerationType.IDENTITY) //开启自增长
    private Integer id;

    private String name;

    private String password;

    private Integer flag;
    
    @JoinColumn(name="role_id")
    @ManyToOne
    @JsonIgnore		//将来返回给前台时，忽略当前属性
    private Role role;

    public User() {
		super();
	}

	public User(Integer id) {
		super();
		this.id = id;
	}

	public User(Integer id, String name, String password, Integer flag, Role role) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.flag = flag;
		this.role = role;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

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
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", name=" + name +
        ", password=" + password +
        ", flag=" + flag +
        ", role=" + role +
        "}";
    }
}
