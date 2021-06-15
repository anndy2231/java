package com.kopo.finalexam;

public class Apartment {

	int idx;
	String title;
	String content;
	String created;
	String updated;
	int userIdx;

	Apartment() {

	}

	Apartment(int idx, String title, String content, String updated) {
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.updated = updated;
	}

	Apartment(String title, String content, String created, String updated, int userIdx) {
		this.title = title;
		this.content = content;
		this.created = created;
		this.updated = updated;
		this.userIdx = userIdx;
	}
}
