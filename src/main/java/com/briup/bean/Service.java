package com.briup.bean;

import java.io.Serializable;

public class Service implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String type;
	private Customer customer;
	private String status;
	private String request;
	private User creator;
	private String handler;
	private String process;
	private String result;
	private String satisfy;
	public Service() {
		super();
	}
	
	public Service(String type, Customer customer, String status, String request, User creator, String handler,
			String process, String result, String satisfy) {
		super();
		this.type = type;
		this.customer = customer;
		this.status = status;
		this.request = request;
		this.creator = creator;
		this.handler = handler;
		this.process = process;
		this.result = result;
		this.satisfy = satisfy;
	}

	public Service(Integer id, String type, Customer customer, String status, String request,
			User creator, String handler, String process, String result, String satisfy) {
		super();
		this.id = id;
		this.type = type;
		this.customer = customer;
		this.status = status;
		this.request = request;
		this.creator = creator;
		this.handler = handler;
		this.process = process;
		this.result = result;
		this.satisfy = satisfy;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	/*public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}*/
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	public String getHandler() {
		return handler;
	}
	public void setHandler(String handler) {
		this.handler = handler;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getSatisfy() {
		return satisfy;
	}
	public void setSatisfy(String satisfy) {
		this.satisfy = satisfy;
	}
	@Override
	public String toString() {
		return "Service [id=" + id + ", type=" + type + ", customer=" + customer + ", status="
				+ status + ", request=" + request + ", creator=" + creator + ", handler=" + handler + ", process="
				+ process + ", result=" + result + ", satisfy=" + satisfy + "]";
	}

	
}
