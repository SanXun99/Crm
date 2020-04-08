package com.briup.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//客户表
@Entity
public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String region;
	
	//经理
	@JoinColumn(name = "manager_id")
	@ManyToOne
	private User manager;
	private String level;
	private String address;
	private String zip;
	private String telephone;
	private String fax;
	private String website;
	private String licence;
	private String chieftain;
	private Float bankroll;
	private Float turnover;
	private String bank;
	private String bankAccount;
	private String status;
	
	
	public Customer(Integer id) {
		super();
		this.id = id;
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
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public User getManager() {
		return manager;
	}
	public void setManager(User manager) {
		this.manager = manager;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLicence() {
		return licence;
	}
	public void setLicence(String licence) {
		this.licence = licence;
	}
	public String getChieftain() {
		return chieftain;
	}
	public void setChieftain(String chieftain) {
		this.chieftain = chieftain;
	}
	public Float getBankroll() {
		return bankroll;
	}
	public void setBankroll(Float bankroll) {
		this.bankroll = bankroll;
	}
	public Float getTurnover() {
		return turnover;
	}
	public void setTurnover(Float turnover) {
		this.turnover = turnover;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Customer() {
		super();
	}
	
	public Customer(String name, String region, User manager) {
		super();
		this.name = name;
		this.region = region;
		this.manager = manager;
	}
	public Customer(Integer id, String name, String region, User manager, String level, String address, String zip,
			String telephone, String fax, String website, String licence, String chieftain, Float bankroll,
			Float turnover, String bank, String bankAccount, String status) {
		super();
		this.id = id;
		this.name = name;
		this.region = region;
		this.manager = manager;
		this.level = level;
		this.address = address;
		this.zip = zip;
		this.telephone = telephone;
		this.fax = fax;
		this.website = website;
		this.licence = licence;
		this.chieftain = chieftain;
		this.bankroll = bankroll;
		this.turnover = turnover;
		this.bank = bank;
		this.bankAccount = bankAccount;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", region=" + region + ", manager=" + manager + ", level="
				+ level + ", address=" + address + ", zip=" + zip + ", telephone=" + telephone + ", fax=" + fax
				+ ", website=" + website + ", licence=" + licence + ", chieftain=" + chieftain + ", bankroll="
				+ bankroll + ", turnover=" + turnover + ", bank=" + bank + ", bankAccount=" + bankAccount + ", status="
				+ status + "]";
	}

	
}
