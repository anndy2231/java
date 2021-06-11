package com.kopo.memoproject;

public class User {
	String idx;
	String id;
	String pwd;
	String name;
	String birthday;
	String address;
	String created;
	
	User() {
		
	}
	
	User(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}
	
	User(String id, String pwd, String name, String birthday, String address, String created) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.created = created;
	}
	
}

