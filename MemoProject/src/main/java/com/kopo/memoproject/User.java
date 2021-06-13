package com.kopo.memoproject;

public class User {
	int idx;
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
	
<<<<<<< HEAD
=======
	User(int idx, String name, String birthday, String address) {
		this.idx = idx;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
	}
	
	User(int idx, String pwd, String name, String birthday, String address) {
		this.idx = idx;
		this.pwd = pwd;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
	}
	
>>>>>>> 1f8bc39d9efe120c11a2d348441da9dbd828c7c8
	User(String id, String pwd, String name, String birthday, String address, String created) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.created = created;
	}
	
}

