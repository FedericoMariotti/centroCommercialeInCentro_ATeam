package CCC3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import accountSystem.Account;
import accountSystem.Customer;
import accountSystem.Deliver;
import accountSystem.Seller;

public class DBManagerRead implements DBManager {
	
	private static DBManagerRead instance;
	
	public static DBManagerRead getInstance() {

		if (instance == null) {
			instance = new DBManagerRead();
		}
		return instance;
	}
	private static List <Market> createMarketsObj(ResultSet rs) {
		List<Market> m = new ArrayList<Market>();
		try {
			while ( rs.next() ) { //TODO
			//TOFIX
			
				int IDparking = rs.getInt("idParking");
				ResultSet rs2 = connector.getStatement().executeQuery("SELECT name, address, openingTime, closingTime FROM Parking WHERE idParking LIKE"+ IDparking);
				Parking temporaryParking = new Parking (rs2.getString("name"),rs2.getString("address"),rs2.getInt("openingTime"),rs2.getInt("closingTime"));
				Market temporaryMarket = new Market(rs.getString("name"),rs.getString("address"),rs.getString("type"),rs2.getInt("openingTime"),rs2.getInt("closingTime"),temporaryParking);
				m.add(temporaryMarket);
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		return m;
	}
	// mi connetto al database
	//raccolgo in rs i risultati della query, poi avvio il metodo createMarketsOBJ: si occupa di creare oggetti di tipo market in java per rendere funzionante il programma
	public static  List<Market> getMarkets() {
		List<Market> markets = new ArrayList<Market>();
		try {
			connector.connect();
			ResultSet rs = connector.getStatement().executeQuery("SELECT idMarket, name, address, openingTime, closingTime, idSeller, idParking FROM Market");
			markets.addAll(createMarketsObj(rs));
			}
		catch (SQLException ex) {
				ex.printStackTrace();
		}
		
		return markets;
	}
	
	public static  List<Market> getMarkets(String query) {
		List<Market> markets = new ArrayList<Market>();
		try {
			connector.connect();
			ResultSet rs = connector.getStatement().executeQuery("SELECT * FROM Market WHERE nome like " + query +"or brand like"+ query + "");
			markets.addAll(createMarketsObj(rs));
		}
		catch (SQLException ex) {
				ex.printStackTrace();
		}
		
		return markets;
	}
	
	
//	public MarketType getMarketTypeFromString(String stringa) {
//		switch (stringa) {
//
//		case "abbigliamento":
//			return MarketType.abbigliamento;
//		case "arredamento":
//			return MarketType.arredamento;
//		case "bottegacalzature":
//			return MarketType.bottegacalzature;
//		case "edilizia":
//			return MarketType.edilizia;
//		case "elettronica":
//			return MarketType.elettronica;
//		case "farmacia":
//			return MarketType.farmacia;
//		case "ipermercato":
//			return MarketType.ipermercato;
//		case "profumeria":
//			return MarketType.profumeria;
//
//		default:
//			throw new RuntimeException("Not implemened yet");
//		}
//		
//		
//	}

	public static List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();
		try {
			connector.connect();
			ResultSet rs = connector.getStatement().executeQuery("SELECT * FROM Product");
			while ( rs.next() ) { 

				Product product=new Product(rs.getString("name"), rs.getInt("price"),rs.getString("brand"),rs.getString("description"),rs.getString("tags"),rs.getInt("quantity"));
				products.add(product);
			}
		}
		catch (SQLException ex) {
				ex.printStackTrace();
		}
		
		return products;
		
	}
	
	public static List<Product> getProducts (String query){
		 
			List<Product> products = new ArrayList<Product>();
			try {
				connector.connect();
				ResultSet rs = connector.getStatement().executeQuery("SELECT * FROM Product WHERE name like " + query + "or brand like " + query +"or tag like" + query + "");
				while ( rs.next() ) { 

					Product product=new Product(rs.getString("name"), rs.getInt("price"),rs.getString("brand"),rs.getString("description"),rs.getString("tags"),rs.getInt("quantity"));
					products.add(product);
				}
			}
			catch (SQLException ex) {
					ex.printStackTrace();
			}
			
			return products;				 
	 }

	public static List<Product> searchProductsbyMarket(String querymarket, String queryproduct) {

		List<Product> products = new ArrayList<Product>();
		try {
			connector.connect();
			ResultSet rs = connector.getStatement().executeQuery("SELECT * FROM Product WHERE Market like (SELECT ID from Market where name like " + querymarket + ") and ( name like " + queryproduct + "or brand like " + queryproduct +")" );
			while ( rs.next() ) { 

				Product product=new Product(rs.getString("name"), rs.getInt("price"),rs.getString("brand"),rs.getString("description"),rs.getString("tags"),rs.getInt("quantity"));
				products.add(product);
			}
		}
		catch (SQLException ex) {
				ex.printStackTrace();
		}
		
		return products;				 
 }

	public static List<Order> getOrders() {
		List<Order> orders = new ArrayList<Order>();
		try {
			connector.connect();
			ResultSet rs = connector.getStatement().executeQuery("SELECT * FROM Order");
			while ( rs.next() ) { 
				OrderStatus temporaryStatus = getOrderStatusFromString(rs.getString("status"));
				//FIX NON SUPPORTA PIU PRODOTTI IN UN SOLO ORDINE; FIX L'ORDINE DEI PARAMETRI NEL DB è ERRATO
			//	Order order= new Order(rs.getString("name"), rs.getInt("price"),rs.getString("brand"),rs.getString("description"),rs.getString("tags"),rs.getInt("quantity"));
			//	orders.add(order);
			}
		}
		catch (SQLException ex) {
				ex.printStackTrace();
		}
		
		return orders;
	}
	
	public static OrderStatus getOrderStatusFromString(String status) {
		switch (status) {

		case "recieved":
			return OrderStatus.recieved;
		case "preparing":
			return OrderStatus.preparing;
		case "shipped":
			return OrderStatus.shipped;
		case "inDelivery":
			return OrderStatus.inDelivery;
		case "delivered":
			return OrderStatus.delivered;
		case "deliveredInLocker":
			return OrderStatus.deliveredInLocker;
		case "stokingInLocker":
			return OrderStatus.stokingInLocker;
		case "pickedInLocker":
			return OrderStatus.pickedInLocker;
		case "cancelled":
			return OrderStatus.cancelled;

		default:
			throw new RuntimeException("Invalid Status while importing from DB");
		}
	}

	

	public static String getPassword(String email) {
		String password = null;
		try {
			connector.connect();
			ResultSet rs = connector.getStatement().executeQuery("SELECT password FROM Seller WHERE email LIKE " + email + ";");
			ResultSet rs2 = connector.getStatement().executeQuery("SELECT password FROM Customer WHERE email LIKE " + email + ";");
			ResultSet rs3 = connector.getStatement().executeQuery("SELECT password FROM Deliver WHERE email LIKE " + email + ";");
			if (rs != null) { 
				password = rs.getString("password");
			}
			else if (rs2 !=null) {
				password = rs2.getString("password");
			}
			else if (rs3 !=null) {
				password = rs3.getString("password");
			}
			
		}
		catch (SQLException ex) {
				ex.printStackTrace();
		}
		
		 return password; 
	}


	public static List<Account> getAccounts() {
		List<Account> accounts = null;
		try {
			connector.connect();
			ResultSet rs = connector.getStatement().executeQuery("SELECT * FROM Seller;");
			ResultSet rs2 = connector.getStatement().executeQuery("SELECT * FROM Customer ");
			ResultSet rs3 = connector.getStatement().executeQuery("SELECT * FROM Deliver ;");
			while ( rs.next() ) { 

				Account a = new Seller(rs.getInt("cellNumber"), rs.getString("email"),rs.getString("password"),rs.getString("name"),rs.getString("surname"));
				accounts.add(a);
			}
		
			while ( rs2.next() ) { 

				Account a = new Customer (rs2.getInt("cellNumber"), rs2.getString("email"),rs2.getString("password"),rs2.getString("name"),rs2.getString("surname"), rs2.getString("address"));
				accounts.add(a);
			}
			
			while ( rs3.next() ) { 

				Account a = new Deliver (rs3.getInt("cellNumber"), rs3.getString("email"),rs3.getString("password"),rs3.getString("name"),rs3.getString("surname"));
				accounts.add(a);
			}
		}
		catch (SQLException ex) {
				ex.printStackTrace();
		}
		
		 return accounts; 
	}
}



