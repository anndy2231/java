package com.kopo.finalexam;

public class People {
	int idx;
	String id;
	String pwd;
	String name;
	String age;
	String gender;
	String created;
	
	People() {
		
	}
	
	People(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}
	
	People(int idx, String name, String birthday, String address) {
		this.idx = idx;
		this.name = name;
		this.age = birthday;
		this.gender = address;
	}
	
	People(int idx, String pwd, String name, String birthday, String address) {
		this.idx = idx;
		this.pwd = pwd;
		this.name = name;
		this.age = birthday;
		this.gender = address;
	}
	
	People(String id, String pwd, String name, String birthday, String address, String created) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.age = birthday;
		this.gender = address;
		this.created = created;
	}
	
}

