package com.kopo.finalexam;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.sqlite.SQLiteConfig;


public class PeopleDB {

	public String sha256(String msg) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(msg.getBytes());

			StringBuilder builder = new StringBuilder();
			for (byte b : md.digest()) {
				builder.append(String.format("%02x", b));
			}
			return builder.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public boolean createTable() {
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/peopleDB.db",
					config.toProperties());

			// use
			String query = "CREATE TABLE apartment (idx INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, content TEXT, created TEXT, updated TEXT, userIdx INTEGER)";
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(query);

			String query2 = "CREATE TABLE people (idx INTEGER PRIMARY KEY AUTOINCREMENT, id TEXT, pwd TEXT, name TEXT, age TEXT, gender TEXT, created TEXT)";
			Statement statement2 = connection.createStatement();
			int result2 = statement2.executeUpdate(query2);

			// close
			statement.close();
			statement2.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean insertApartment(Apartment apt) {
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/peopleDB.db",
					config.toProperties());

			// use
			String query = "INSERT INTO apartment (title, content, created, updated, userIdx) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, apt.title);
			preparedStatement.setString(2, apt.content);
			preparedStatement.setString(3, apt.created);
			preparedStatement.setString(4, apt.updated);
			preparedStatement.setInt(5, apt.userIdx);
			int result = preparedStatement.executeUpdate();

			if (result < 1) {
				preparedStatement.close();
				connection.close();
				return false;
			}

			// close
			connection.close();
			preparedStatement.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Apartment detailsData(int idx) {
		Apartment resultData = new Apartment();
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/peopleDB.db",
					config.toProperties());

			// use
			String query = "SELECT * FROM apartment WHERE idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, idx);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				resultData.idx = resultSet.getInt("idx");
				resultData.title = resultSet.getString("title");
				resultData.content = resultSet.getString("content");
				resultData.created = resultSet.getString("created");
				resultData.updated = resultSet.getString("updated");
			}

			// close
			connection.close();
			preparedStatement.close();
		} catch (Exception e) {
		}
		return resultData;
	}
	
	public int detailsData2(String id, String pwd) {
		int resultData = 0;
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/peopleDB.db",
					config.toProperties());
			
			pwd = sha256(pwd);
			
			// use
			String query = "SELECT idx FROM people WHERE id=? and pwd=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, pwd);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				resultData = resultSet.getInt("idx");
			}

			// close
			connection.close();
			preparedStatement.close();
		} catch (Exception e) {
		}
		return resultData;
	}
	
	public People detailsData3(int idx) {
		People resultData = new People();
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/peopleDB.db",
					config.toProperties());

			// use
			String query = "SELECT * FROM people WHERE idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, idx);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				resultData.idx = resultSet.getInt("idx");
				resultData.id = resultSet.getString("id");
				resultData.pwd = resultSet.getString("pwd");
				resultData.name = resultSet.getString("name");
				resultData.age = resultSet.getString("age");
				resultData.gender = resultSet.getString("gender");
			}

			// close
			connection.close();
			preparedStatement.close();
		} catch (Exception e) {
		}
		return resultData;
	}
	
	public String selectApartment(int userIdx) {
		String resultString = "";
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/peopleDB.db", config.toProperties());

			// use
			String query = "SELECT * from apartment where userIdx = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userIdx);
			ResultSet resultSet = preparedStatement.executeQuery(); // 커서가 가리키는 곳 가져오기 위함
			
			while (resultSet.next()) {
				int idx = resultSet.getInt("idx");
				String title = resultSet.getString("title");
				String content = resultSet.getString("content");
				String created = resultSet.getString("created");
				String updated = resultSet.getString("updated");
				resultString = resultString + "<tr>" 
						+ "<td>" + idx + "</td>"
						+ "<td>" + title + "</td>"
						+ "<td>" + content + "</td>"
						+ "<td>" + created	+ "</td>"
						+ "<td>" + updated + "</td>"
						+ "<td><a href = 'update?idx=" + idx + "'>수정</a></td>"
						+ "<td><a href = 'delete?idx=" + idx + "'>삭제</a></td>";
				resultString = resultString + "</tr>";
			}

			// close
			connection.close();
			preparedStatement.close();
		} catch (Exception e) {
		}
		return resultString;
	}
	
	
	public String selectPeople() {
		String resultString = "";
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/peopleDB.db", config.toProperties());

			// use
			String query = "SELECT * from people";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery(); // 커서가 가리키는 곳 가져오기 위함
			while (resultSet.next()) {
				int idx = resultSet.getInt("idx");
				String id = resultSet.getString("id");
				String pwd = resultSet.getString("pwd");
				String name = resultSet.getString("name");
				String birthday = resultSet.getString("age");
				String address = resultSet.getString("gender");
				String created = resultSet.getString("created");
				resultString = resultString + "<tr>"
						+ "<td>" + idx + "</td>"
						+ "<td>" + id + "</td>"
						+ "<td>" + pwd + "</td>"
						+ "<td>" + name	+ "</td>"
						+ "<td>" + birthday + "</td>"
						+ "<td>" + address + "</td>"
						+ "<td>" + created + "</td>"
						+ "<td><a href = 'update2?idx=" + idx + "'>수정</a></td>"
						+ "<td><a href = 'delete2?idx=" + idx + "'>삭제</a></td>";
				resultString = resultString + "</tr>";
			}
			
			// close
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
		}
		return resultString;
	}
	
	
	public void deleteApartment(int idx) {
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/peopleDB.db", config.toProperties());

			// use
			String query = "DELETE FROM apartment WHERE idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, idx);
			preparedStatement.executeUpdate();

			// close
			connection.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void deletePeople(int idx) {
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/peopleDB.db", config.toProperties());

			// use
			String query = "DELETE FROM people WHERE idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, idx);
			preparedStatement.executeUpdate();

			// close
			connection.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean updateApartment(Apartment memo) {
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/peopleDB.db", config.toProperties());
						
			// use
			String query = "UPDATE apartment SET title=?, content=?, updated=? WHERE idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, memo.title);
			preparedStatement.setString(2, memo.content);
			preparedStatement.setString(3, memo.updated);
			preparedStatement.setInt(4, memo.idx);
			int result = preparedStatement.executeUpdate();
			
			if (result < 1) {
				return false;
			}

			// close
			connection.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean updatePeople(People user) {
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/peopleDB.db", config.toProperties());
						
			// password hash
			user.pwd = sha256(user.pwd);
			
			// use
			String query = "UPDATE people SET pwd=?, name=?, age=?, gender=? WHERE idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.pwd);
			preparedStatement.setString(2, user.name);
			preparedStatement.setString(3, user.age);
			preparedStatement.setString(4, user.gender);
			preparedStatement.setInt(5, user.idx);
			int result = preparedStatement.executeUpdate();
			
			if (result < 1) {
				return false;
			}

			// close
			connection.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean updatePeople2(People user) {
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/peopleDB.db", config.toProperties());
						
			// use
			String query = "UPDATE people SET name=?, age=?, gender=? WHERE idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.name);
			preparedStatement.setString(2, user.age);
			preparedStatement.setString(3, user.gender);
			preparedStatement.setInt(4, user.idx);
			int result = preparedStatement.executeUpdate();
			
			if (result < 1) {
				return false;
			}

			// close
			connection.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean signUp(People people) {
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/peopleDB.db",
					config.toProperties());

			// 아이디 중복 여부 검사
			String query1 = "SELECT * from people WHERE id=?";
			PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
			preparedStatement1.setString(1, people.id);
			ResultSet resultSet = preparedStatement1.executeQuery();
			if(resultSet.next()) {
				preparedStatement1.close();
				connection.close();
				return false;
			}
			preparedStatement1.close();
			
			// password hash
			people.pwd = sha256(people.pwd);
			
			// use
			String query2 = "INSERT INTO people (id, pwd, name, age, gender, created) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query2);
			preparedStatement.setString(1, people.id);
			preparedStatement.setString(2, people.pwd);
			preparedStatement.setString(3, people.name);
			preparedStatement.setString(4, people.age);
			preparedStatement.setString(5, people.gender);
			preparedStatement.setString(6, people.created);
			int result = preparedStatement.executeUpdate();

			if (result < 1) {
				preparedStatement.close();
				connection.close();
				return false;
			}

			// close
			connection.close();
			preparedStatement.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Boolean logIn(String id, String pwd) {
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/peopleDB.db", config.toProperties());
			
			pwd = sha256(pwd);
			
			// use
			String query = "SELECT id, pwd FROM people WHERE id = ? AND pwd = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, pwd);			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) { 
				connection.close();
				preparedStatement.close();
				return true;
			} else {
				connection.close();
				preparedStatement.close();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public String searchPeople(String searchName) {
		String resultString = "";
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/peopleDB.db",
					config.toProperties());

			// use
			String query = "SELECT * FROM people WHERE name LIKE ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "%" + searchName + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) { // 이름에 동일한 글자가 있을 수 있기 때문에 반복문 사용
				int idx = resultSet.getInt("idx");
				String name = resultSet.getString("name");
				String age = resultSet.getString("age");
				String gender = resultSet.getString("gender");
				resultString = resultString + "<tr>"
							+ "<td>" + idx + "</td>"
							+ "<td>" + name	+ "</td>"
							+ "<td>" + age + "</td>"
							+ "<td>" + gender + "</td>";
				resultString = resultString + "</tr>";
			}

			// close
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
		}
		return resultString;
	}
	
	
	public int peopleStatistics1() {
		int count = 0;
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/peopleDB.db",
					config.toProperties());

			// use
			String query = "SELECT count(*) FROM people";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				count = resultSet.getInt(1);
			}
			// close
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
		}
		return count;
	}
	
	public int peopleStatistics2() {
		int count = 0;
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/peopleDB.db",
					config.toProperties());

			// use
			String query = "SELECT sum(age)/count(*) FROM people";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				count = resultSet.getInt(1);
			}
			// close
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
		}
		return count;
	}
	
	public int peopleStatistics3_man() {
		int count = 0;
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/peopleDB.db",
					config.toProperties());

			// use
			String query = "SELECT count(gender) from people  where gender = '남성'";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				count = resultSet.getInt(1);
			}
			// close
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
		}
		return count;
	}
	
	public int peopleStatistics3_woman() {
		int count = 0;
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/peopleDB.db",
					config.toProperties());

			// use
			String query = "SELECT count(gender) from people  where gender = '여성'";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				count = resultSet.getInt(1);
			}
			// close
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
		}
		return count;
	}
	
}
