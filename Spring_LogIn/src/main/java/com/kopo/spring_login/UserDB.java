package com.kopo.spring_login;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.sqlite.SQLiteConfig;

public class UserDB {

	public boolean createTable() {
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/userInfoList.db",
					config.toProperties());

			// use
			String query = "CREATE TABLE userInfo(idx INTEGER PRIMARY KEY AUTOINCREMENT, id TEXT, pwd TEXT, name TEXT, birthday TEXT, address TEXT, created TEXT, updated TEXT)";
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(query);
			statement.close();

			// close
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean insertData(UserInfo userinfo) {
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/userInfoList.db", config.toProperties());

			// 아이디 중복 여부 검사
			String query1 = "SELECT * from userInfo WHERE id=?";
			PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
			preparedStatement1.setString(1, userinfo.id);
			ResultSet resultSet = preparedStatement1.executeQuery(); // 커서가 가리키는 곳 가져오기 위함
			if(resultSet.next()) {
				preparedStatement1.close();
				connection.close();
				return false;
			}
			preparedStatement1.close();
			
			// password hash
			userinfo.pwd = sha256(userinfo.pwd);
			
			// use
			String query = "INSERT INTO userInfo (id, pwd, name, birthday, address, created, updated) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userinfo.id);
			preparedStatement.setString(2, userinfo.pwd);
			preparedStatement.setString(3, userinfo.name);
			preparedStatement.setString(4, userinfo.birthday);
			preparedStatement.setString(5, userinfo.address);
			preparedStatement.setString(6, userinfo.created);
			preparedStatement.setString(7, userinfo.updated);
			int result = preparedStatement.executeUpdate();
			
			if (result < 1) {
				preparedStatement.close();
				connection.close();
				return false;
			}
			preparedStatement.close();

			// close
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public String sha256(String msg) {
		try {
		    MessageDigest md = MessageDigest.getInstance("SHA-256");
		    md.update(msg.getBytes());
		    
		    StringBuilder builder = new StringBuilder();
		    for (byte b: md.digest()) {
		      builder.append(String.format("%02x", b));
		    }
		    return builder.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public String selectData() {
		String resultString = "";
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/userInfoList.db",
					config.toProperties());

			// use
			String query = "SELECT * from userInfo";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery(); // 커서가 가리키는 곳 가져오기 위함
			while (resultSet.next()) {
				int idx = resultSet.getInt("idx");
				String id = resultSet.getString("id");
				String pwd = resultSet.getString("pwd");
				String name = resultSet.getString("name");
				String birthday = resultSet.getString("birthday");
				String address = resultSet.getString("address");
				String created = resultSet.getString("created");
				String updated = resultSet.getString("updated");
				resultString = resultString + "<tr>"
						+ "<td>" + idx + "</td>"
						+ "<td>" + id + "</td>"
						+ "<td>" + pwd + "</td>"
						+ "<td>" + name	+ "</td>"
						+ "<td>" + birthday + "</td>"
						+ "<td>" + address + "</td>"
						+ "<td>" + created + "</td>"
						+ "<td>" + updated + "</td>"
						+ "<td><a href = 'update?idx=" + idx + "'>수정</a></td>"
						+ "<td><a href = 'delete?idx=" + idx + "'>삭제</a></td>";
			resultString = resultString + "</tr>";
			}
			
			// close
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
		}
		return resultString;
	}
	
	
	public String selectData2() {
		String resultString = "";
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/userInfoList.db",
					config.toProperties());

			// use
			String query = "SELECT * from userInfo";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery(); // 커서가 가리키는 곳 가져오기 위함
			while (resultSet.next()) {
				int idx = resultSet.getInt("idx");
				String id = resultSet.getString("id");
				String pwd = resultSet.getString("pwd");
				String name = resultSet.getString("name");
				String birthday = resultSet.getString("birthday");
				String address = resultSet.getString("address");
				String created = resultSet.getString("created");
				String updated = resultSet.getString("updated");
				resultString = resultString + "<tr>"
						+ "<td>" + idx + "</td>"
						+ "<td>" + id + "</td>"
						+ "<td>" + pwd + "</td>"
						+ "<td>" + name	+ "</td>"
						+ "<td>" + birthday + "</td>"
						+ "<td>" + address + "</td>"
						+ "<td>" + created + "</td>"
						+ "<td>" + updated + "</td>";
			resultString = resultString + "</tr>";
			}
			
			// close
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
		}
		return resultString;
	}
	

	public String searchData(String searchText) {
		String resultString = "";
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/userInfoList.db",
					config.toProperties());

			// use
			String query = "SELECT * FROM userInfo WHERE name LIKE ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "%" + searchText + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) { // 이름에 동일한 글자가 있을 수 있기 때문에 반복문 사용
				int idx = resultSet.getInt("idx");
				String id = resultSet.getString("id");
				String pwd = resultSet.getString("pwd");
				String name = resultSet.getString("name");
				String birthday = resultSet.getString("birthday");
				String address = resultSet.getString("address");
				String created = resultSet.getString("created");
				String updated = resultSet.getString("updated");
				resultString = resultString + "<tr>"
							+ "<td>" + idx + "</td>"
							+ "<td>" + id + "</td>"
							+ "<td>" + pwd + "</td>"
							+ "<td>" + name	+ "</td>"
							+ "<td>" + birthday + "</td>"
							+ "<td>" + address + "</td>"
							+ "<td>" + created + "</td>"
							+ "<td>" + updated + "</td>";
				resultString = resultString + "</tr>";
			}

			// close
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
		}
		return resultString;
	}

	public UserInfo detailsData(int idx) {
		UserInfo resultData = new UserInfo();
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/userInfoList.db",
					config.toProperties());

			// use
			String query = "SELECT * FROM userInfo WHERE idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, idx);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				resultData.idx = resultSet.getInt("idx");
				resultData.id = resultSet.getString("id");
				resultData.pwd = resultSet.getString("pwd");
				resultData.name = resultSet.getString("name");
				resultData.birthday = resultSet.getString("birthday");
				resultData.address = resultSet.getString("address");
				resultData.created = resultSet.getString("created");
				resultData.updated = resultSet.getString("updated");
			}

			// close
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
		}
		return resultData;
	}
	
	public boolean updateData(UserInfo userinfo) {
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/userInfoList.db",
					config.toProperties());
						
			// password hash
			userinfo.pwd = sha256(userinfo.pwd);
			
			// use
			String query = "UPDATE userInfo SET id=?, pwd=?, name=?, birthday=?, address=?, updated=? WHERE idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userinfo.id);
			preparedStatement.setString(2, userinfo.pwd);
			preparedStatement.setString(3, userinfo.name);
			preparedStatement.setString(4, userinfo.birthday);
			preparedStatement.setString(5, userinfo.address);
			preparedStatement.setString(6, userinfo.updated);
			preparedStatement.setInt(7, userinfo.idx);
			int result = preparedStatement.executeUpdate();
			
			if (result < 1) {
				return false;
			}

			// close
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public boolean updateData2 (UserInfo userinfo) {
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/userInfoList.db",
					config.toProperties());
						
			// password hash
			userinfo.pwd = sha256(userinfo.pwd);
			
			// use
			String query = "UPDATE userInfo SET pwd=?, name=?, birthday=?, address=?, updated=? WHERE idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userinfo.pwd);
			preparedStatement.setString(2, userinfo.name);
			preparedStatement.setString(3, userinfo.birthday);
			preparedStatement.setString(4, userinfo.address);
			preparedStatement.setString(5, userinfo.updated);
			preparedStatement.setInt(6, userinfo.idx);
			int result = preparedStatement.executeUpdate();
			
			if (result < 1) {
				return false;
			}

			// close
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean updateData3 (UserInfo userinfo) {
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/userInfoList.db",
					config.toProperties());
						
			// use
			String query = "UPDATE userInfo SET name=?, birthday=?, address=?, updated=? WHERE idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userinfo.name);
			preparedStatement.setString(2, userinfo.birthday);
			preparedStatement.setString(3, userinfo.address);
			preparedStatement.setString(4, userinfo.updated);
			preparedStatement.setInt(5, userinfo.idx);
			int result = preparedStatement.executeUpdate();
			
			if (result < 1) {
				return false;
			}

			// close
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void deleteData(int idx) {
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/userInfoList.db",
					config.toProperties());

			// use
			String query = "DELETE FROM userInfo WHERE idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, idx);
			preparedStatement.executeUpdate();

			// close
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Boolean logInData(String id, String pwd) {
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/userInfoList.db", config.toProperties());
			
			pwd = sha256(pwd);
			
			// use
			String query = "SELECT id, pwd FROM userInfo WHERE id = ? AND pwd = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, pwd);			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) { 
				preparedStatement.close();
				connection.close();
				return true;
			} else {
				preparedStatement.close();
				connection.close();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public int logInData2(String id, String pwd) {
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/userInfoList.db", config.toProperties());
			
			pwd = sha256(pwd);
			
			// use
			String query = "SELECT * FROM userInfo WHERE id = ? AND pwd = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, pwd);			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) { 
				int idx = resultSet.getInt("idx");
				preparedStatement.close();
				connection.close();
				return idx;
			} else {
				preparedStatement.close();
				connection.close();
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	
}
