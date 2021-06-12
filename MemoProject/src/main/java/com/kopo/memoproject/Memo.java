package com.kopo.memoproject;

public class Memo {

	int idx;
	String title;
	String content;
	String created;
	String updated;
	int userIdx;

	Memo() {

	}

	Memo(int idx, String title, String content, String updated) {
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.updated = updated;
	}

	Memo(String title, String content, String created, String updated, int userIdx) {
		this.title = title;
		this.content = content;
		this.created = created;
		this.updated = updated;
		this.userIdx = userIdx;
	}
}
