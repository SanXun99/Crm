package com.briup.bean;

import java.io.Serializable;

public class Linkman implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Customer customer;
	private String name;
	private String sex;
	private String position;
	private String telephone;
	private String mobileTelephone;
	private String memo;
	public Linkman() {
		super();
	}
	public Linkman(Integer id, Customer customer, String name, String sex, String position, String telephone,
			String mobileTelephone, String memo) {
		super();
		this.id = id;
		this.customer = customer;
		this.name = name;
		this.sex = sex;
		this.position = position;
		this.telephone = telephone;
		this.mobileTelephone = mobileTelephone;
		this.memo = memo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMobileTelephone() {
		return mobileTelephone;
	}
	public void setMobileTelephone(String mobileTelephone) {
		this.mobileTelephone = mobileTelephone;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	@Override
	public String toString() {
		return "Linkman [id=" + id + ", customer=" + customer + ", name=" + name + ", sex=" + sex + ", position="
				+ position + ", telephone=" + telephone + ", mobileTelephone=" + mobileTelephone + ", memo=" + memo
				+ "]";
	}
	
	

}
