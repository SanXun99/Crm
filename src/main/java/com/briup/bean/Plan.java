package com.briup.bean;

import java.io.Serializable;

public class Plan implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Chance chance;
	
	private String todo;
	
	private String result;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Chance getChance() {
		return chance;
	}

	public void setChance(Chance chance) {
		this.chance = chance;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Plan() {
	}

	public Plan(Chance chance, String todo) {
		super();
		this.chance = chance;
		this.todo = todo;
	}

	public Plan(Integer id, Chance chance, String todo, String result) {
		super();
		this.id = id;
		this.chance = chance;
		this.todo = todo;
		this.result = result;
	}

	public Plan(Chance chance, String todo, String result) {
		super();
		this.chance = chance;
		this.todo = todo;
		this.result = result;
	}

	@Override
	public String toString() {
		return "Plan [id=" + id + ", chance=" + chance + ", todo=" + todo + ", result=" + result + "]";
	}
	
	
}
