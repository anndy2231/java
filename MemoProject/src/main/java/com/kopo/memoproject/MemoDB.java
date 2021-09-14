package com.kopo.memoproject;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.sqlite.SQLiteConfig;

public class MemoDB {

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
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/memoDB.db",
					config.toProperties());

			// use
			String query = "CREATE TABLE memo (idx INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, content TEXT, created TEXT, updated TEXT, userIdx INTEGER)";
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(query);

			String query2 = "CREATE TABLE user (idx INTEGER PRIMARY KEY AUTOINCREMENT, id TEXT, pwd TEXT, name TEXT, birthday TEXT, address TEXT, created TEXT)";
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

	public boolean insertMemo(Memo memo) {
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/memoDB.db",
					config.toProperties());

			// use
			String query = "INSERT INTO memo (title, content, created, updated, userIdx) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, memo.title);
			preparedStatement.setString(2, memo.content);
			preparedStatement.setString(3, memo.created);
			preparedStatement.setString(4, memo.updated);
			preparedStatement.setInt(5, memo.userIdx);
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

	public Memo detailsData(int idx) {
		Memo resultData = new Memo();
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/memoDB.db",
					config.toProperties());

			// use
			String query = "SELECT * FROM memo WHERE idx=?";
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
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/memoDB.db",
					config.toProperties());

			pwd = sha256(pwd);

			// use
			String query = "SELECT idx FROM user WHERE id=? and pwd=?";
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

	public User detailsData3(int idx) {
		User resultData = new User();
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/memoDB.db",
					config.toProperties());

			// use
			String query = "SELECT * FROM user WHERE idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, idx);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				resultData.idx = resultSet.getInt("idx");
				resultData.id = resultSet.getString("id");
				resultData.pwd = resultSet.getString("pwd");
				resultData.name = resultSet.getString("name");
				resultData.address = resultSet.getString("address");
				resultData.birthday = resultSet.getString("birthday");
			}

			// close
			connection.close();
			preparedStatement.close();
		} catch (Exception e) {
		}
		return resultData;
	}

	public String selectMemo(int userIdx) {
		String resultString = "";
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/memoDB.db",
					config.toProperties());

			// use
			String query = "SELECT * from memo where userIdx = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userIdx);
			ResultSet resultSet = preparedStatement.executeQuery(); // 커서가 가리키는 곳 가져오기 위함

			while (resultSet.next()) {
				int idx = resultSet.getInt("idx");
				String title = resultSet.getString("title");
				String content = resultSet.getString("content");
				String created = resultSet.getString("created");
				String updated = resultSet.getString("updated");
				resultString = resultString + "<tr>" + "<td>" + idx + "</td>" + "<td>" + title + "</td>" + "<td>"
						+ content + "</td>" + "<td>" + created + "</td>" + "<td>" + updated + "</td>"
						+ "<td><a href = 'update?idx=" + idx + "'>수정</a></td>" + "<td><a href = 'delete?idx=" + idx
						+ "'>삭제</a></td>";
				resultString = resultString + "</tr>";
			}

			// close
			connection.close();
			preparedStatement.close();
		} catch (Exception e) {
		}
		return resultString;
	}

	public void deleteMemo(int idx) {
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/memoDB.db",
					config.toProperties());

			// use
			String query = "DELETE FROM memo WHERE idx=?";
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

	public boolean updateMemo(Memo memo) {
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/memoDB.db",
					config.toProperties());

			// use
			String query = "UPDATE memo SET title=?, content=?, updated=? WHERE idx=?";
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

	public boolean updateUser(User user) {
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/memoDB.db",
					config.toProperties());

			// password hash
			user.pwd = sha256(user.pwd);

			// use
			String query = "UPDATE user SET pwd=?, name=?, birthday=?, address=? WHERE idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.pwd);
			preparedStatement.setString(2, user.name);
			preparedStatement.setString(3, user.birthday);
			preparedStatement.setString(4, user.address);
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

	public boolean updateUser2(User user) {
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/memoDB.db",
					config.toProperties());

			// use
			String query = "UPDATE user SET name=?, birthday=?, address=? WHERE idx=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.name);
			preparedStatement.setString(2, user.birthday);
			preparedStatement.setString(3, user.address);
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

	public boolean signUp(User user) {
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/memoDB.db",
					config.toProperties());

			// 아이디 중복 여부 검사
			String query1 = "SELECT * from user WHERE id=?";
			PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
			preparedStatement1.setString(1, user.id);
			ResultSet resultSet = preparedStatement1.executeQuery();
			if (resultSet.next()) {
				preparedStatement1.close();
				connection.close();
				return false;
			}
			preparedStatement1.close();

			// password hash
			user.pwd = sha256(user.pwd);

			// use
			String query2 = "INSERT INTO user (id, pwd, name, birthday, address, created) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query2);
			preparedStatement.setString(1, user.id);
			preparedStatement.setString(2, user.pwd);
			preparedStatement.setString(3, user.name);
			preparedStatement.setString(4, user.birthday);
			preparedStatement.setString(5, user.address);
			preparedStatement.setString(6, user.created);
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
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/memoDB.db",
					config.toProperties());

			pwd = sha256(pwd);

			// use
			String query = "SELECT id, pwd FROM user WHERE id = ? AND pwd = ?";
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

	public String searchUser(String searchName) {
		String resultString = "";
		try {
			// open
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/" + "c:/tomcat/memoDB.db",
					config.toProperties());

			// use
			String query = "SELECT * FROM user WHERE name LIKE ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "%" + searchName + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) { // 이름에 동일한 글자가 있을 수 있기 때문에 반복문 사용
				int idx = resultSet.getInt("idx");
				String name = resultSet.getString("name");
				String birthday = resultSet.getString("birthday");
				String address = resultSet.getString("address");
				resultString = resultString + "<tr>" + "<td>" + idx + "</td>" + "<td>" + name + "</td>" + "<td>"
						+ birthday + "</td>" + "<td>" + address + "</td>";
				resultString = resultString + "</tr>";
			}

			// close
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
		}
		return resultString;
	}

}
