package CCC3;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	private static DBConnection instance;
	private String url;
	private String user;
	private String pwd;
	private Connection conn = null;
	private Statement stmt;
	

	public void setDBConnection(String url, String user, String pwd) {
		this.url = url;
		this.user = user;
		this.pwd = pwd;
	}

	public static DBConnection getInstance() {
		if (instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}

	
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your Mysql JDBC Driver? " + "Include in your library path!");
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			stmt = conn.createStatement();
			System.out.println("Database connected, ready to go!");
			
		} catch (SQLException e) {
			System.out.println("Problems in opening a connection to the DB");
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("Problems in closing the connection to the DB");
			e.printStackTrace();
		}
	}

	public boolean DBtest() {
		Boolean result = true;
		try {
			if (conn == null || !conn.isClosed()) {
				connect();
				result = false;
			}
			DatabaseMetaData data = conn.getMetaData();
			//System.out.println("Details on DBMS - " + data.getDatabaseProductName() + "\n" + "  version:  "
				//	+ data.getDriverMajorVersion() + "\n" + "  catalogs: " + data.getCatalogs().getCursorName() + "\n"
				//	+ "  schemas:  " + data.getSchemas().getRow() + "\n");
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public Statement getStatement() {
		return stmt;
		
	}
}
