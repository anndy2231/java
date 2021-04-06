
public class Student1_Exec {

	public static void main(String[] args) {
//		Student s1 = new Student("홍길동","경기도 부천시","010-1234-5678",30);
//		s1.name = "홍길동";
//		s1.address = "경기도 부천시";
//		s1.phone = "010-1234-5678";
//		s1.age = 30;
//		
//		Student s2 = new Student();
//		s2.name = "둘리";
//		s2.address = "서울시 강서구";
//		s2.phone = "010-9876-5432";
//		s2.age = 300;
		
		Student1 s3 = new Student1("김남덕", "경기도 부천","010-3034-5678", 30);
		s3.printInfo();
//		s3.age(); private 불가능
		
		
		s3.setName("고길동");
		System.out.println(s3.getName());
		
		System.out.println(s3);
	}

}
