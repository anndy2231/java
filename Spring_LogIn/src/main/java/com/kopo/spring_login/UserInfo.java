package com.kopo.spring_login;

public class UserInfo {

	int idx;
	String id;
	String pwd;
	String name;
	String birthday;
	String address;
	String created;
	String updated;

	UserInfo() {

	}
	
	UserInfo(String id, String pwd, String name, String birthday, String address) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
	}
	
	UserInfo(int idx, String name, String birthday, String address, String updated) {
		this.idx = idx;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.updated = updated;
	}
	
	UserInfo(int idx, String pwd, String name, String birthday, String address, String updated) {
		this.idx = idx;
		this.pwd = pwd;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.updated = updated;
	}

	UserInfo(int idx, String id, String pwd, String name, String birthday, String address, String updated) {
		this.idx = idx;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.updated = updated;
	}
	
	UserInfo(String id, String pwd, String name, String birthday, String address, String created, String updated) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.created = created;
		this.updated = updated;
	}

}
