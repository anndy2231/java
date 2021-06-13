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
<<<<<<< HEAD
	
	Memo(String title, String content, String created, String updated) {
		this.title = title;
		this.content = content;
		this.created = created;
		this.updated = updated;
	}

=======
>>>>>>> 1f8bc39d9efe120c11a2d348441da9dbd828c7c8

	Memo(String title, String content, String created, String updated, int userIdx) {
		this.title = title;
		this.content = content;
		this.created = created;
		this.updated = updated;
		this.userIdx = userIdx;
	}
}
