//					(extends Object 생략된 것)
public class Student1 {
	String name;
	String address;
	String phone;
	int age;

	Student1(String name, String address, String phone, int age) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.age = age;
//		this.printInfo();
	}

	protected void printInfo() {
		System.out.println(
				"이름 : " + this.name + ", 주소 : " + this.address + ", 연락처 : " + this.phone + ", 나이 : " + this.age);

	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
	@Override // 명시해주기
	public String toString() {
		return "이름 : " + this.name + ", 주소 : " + this.address + ", 연락처 : " + this.phone + ", 나이 : " + this.age;
	}
}
