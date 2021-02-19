package CCC3;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class DBManager {

	private static DBManager instance;
	private String url;
	private String user;
	private String pwd;
	private Connection conn = null;

	private DBManager() {
	}

	public void setDBManager(String url, String user, String pwd) {
		this.url = url;
		this.user = user;
		this.pwd = pwd;
	}

	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}

	private void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your Mysql JDBC Driver? " + "Include in your library path!");
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("Database connected, ready to go!");
		} catch (SQLException e) {
			System.out.println("Problems in opening a connection to the DB");
			e.printStackTrace();
		}
	}

	private void close() {
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
			System.out.println("Details on DBMS - " + data.getDatabaseProductName() + "\n" + "  version:  "
					+ data.getDriverMajorVersion() + "\n" + "  catalogs: " + data.getCatalogs().getCursorName() + "\n"
					+ "  schemas:  " + data.getSchemas().getRow() + "\n");
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int getTableCount(String table) {
		String SQL = "SELECT count(*) FROM " + table + ";";
		int count = 0;
		try (Connection conn = DriverManager.getConnection(url, user, pwd);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SQL);) {
			count = rs.getFetchSize();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return count;
	}
	

// TODO
	public  List<Market> getMarkets() {
		List<Market> markets = new ArrayList<Market>();
		try {
			this.connect();
		
			Connection conn = DriverManager.getConnection(url, user, pwd);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT idMarket, name, address, type, cellNumber, idSeller FROM Market");
			while ( rs.next() ) { 
				//MarketType temporaryMarketType = rs.getString(3); Switch case?
				MarketType temporaryMarketType = null;
				Market temporaryMarket = new Market(rs.getString(1),rs.getString(2),temporaryMarketType);
				markets.add(temporaryMarket);
			}
		}
		catch (SQLException ex) {
				ex.printStackTrace();
		}
		
		return markets;
	}

}


	

