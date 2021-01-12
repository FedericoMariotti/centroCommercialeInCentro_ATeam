package CCC3;

import java.sql.SQLException;
// si occupa di aggiungere e modificare le informazioni nel DB
public class DBManagerEdit implements DBManager {

	private static DBManagerEdit instance;
	
	public static DBManagerEdit getInstance() {

		if (instance == null) {
			instance = new DBManagerEdit();
		}
		return instance;
	}

	
	
	public static void addOrder(Order o) {
		try {
			connector.connect();
			// TODO controlla, i metodi to string potrebbero ritornare valori a caso, creare oggetti di tipo customer e deliver?
			//in pratica dovrebbe prendere un cliente che gia esiste nel db
			connector.getStatement().executeQuery("INSERT INTO Order VALUES ( " + o.getCustomer().getID()+ "," + o.getDeliver().getID()+ "," + o.getPrice() + "," + o.getStatus().toString() +  ");");
			for (int i=0; i<o.getProducts().size(); i++) {
				//Se non funziona: SELECT * FROM OrderHistory ORDER BY ID DESC LIMIT 1
				connector.getStatement().executeQuery("INSERT INTO OrderHistory VALUES ( (SELECT MAX(ID) FROM Order )" +  "," + o.getCustomer().getID()+ "," + o.getProducts().get(i).getID() +"," +o.getPrice() +");"+ "");
				}
			}	
		catch (SQLException ex) {
				ex.printStackTrace();
		}
		
		return;
		
	}
	//vedere se passare direttamente da questo e poi aggiornare la lista dal database
	public static void removeProduct(Product product) {
		try {
			connector.connect();
			connector.getStatement().executeQuery("DELETE FROM products ( SELECT * FROM products WHERE ID LIKE " + product.getID() + ");");
		}	
		catch (SQLException ex) {
				ex.printStackTrace();
		}
		
		return;
		
	}

	public static void addProduct(Product newproduct) {
		try {
			connector.connect();
			connector.getStatement().executeQuery("INSERT INTO Product VALUES ( " + newproduct.getName() + "," + newproduct.getPrice() + "," +  newproduct.getBrand() + "," + newproduct.getDescription() +"," + newproduct.getTags() + "," + newproduct.getQuantity() + ");");
		}	
		catch (SQLException ex) {
				ex.printStackTrace();
		}
		
		return;
		
		
	}
	
	public static void addDeliverAccount(int cellNumber, String email, String password, String name, String surname) {
		try {
			connector.connect();
			connector.getStatement().executeQuery("INSERT INTO Deliver VALUES ( " + cellNumber + "," + email + "," +  password + "," + name +"," + surname + ");");
		}	
		catch (SQLException ex) {
				ex.printStackTrace();
		}
		
		return;
	}
	
	
	public static void addCustomerAccount(int cellNumber, String email, String password, String name, String surname,String address) {
		try {
			connector.connect();
			connector.getStatement().executeQuery("INSERT INTO Customer VALUES ( " + cellNumber + "," + email + "," +  password + "," + name +"," + surname + "," + address + ");" );
		}	
		catch (SQLException ex) {
				ex.printStackTrace();
		}
		
		return;		
	}
	
	
	public static void addSellerAccount(int cellNumber, String email, String password, String name, String surname) {
		try {
			connector.connect();
			connector.getStatement().executeQuery("INSERT INTO Deliver VALUES ( " + cellNumber + "," + email + "," +  password + "," + name +"," + surname + ");");
		}	
		catch (SQLException ex) {
				ex.printStackTrace();
		}
		
		return;	
	}
	
	
	public static void editDeliverAccount(int ID, int cellNumber, String email, String password, String name, String surname) {
		try {
			connector.connect();
			connector.getStatement().executeQuery("UPDATE Deliver VALUES ( " + cellNumber + "," + email + "," +  password + "," + name +"," + surname + ") WHERE ID LIKE " + ID + ");");
		}	
		catch (SQLException ex) {
				ex.printStackTrace();
		}
		
		return;
	}
	public static void editCustomerAccount(int ID, int cellNumber, String email, String password, String name,String surname, String address) {
		try {
			connector.connect();
			connector.getStatement().executeQuery("UPDATE Customer VALUES ( " + cellNumber + "," + email + "," +  password + "," + name +"," + surname + "," + address + ") WHERE ID LIKE " + ID + ");");
		}	
		catch (SQLException ex) {
				ex.printStackTrace();
		}
		
		return;
		
	}
	public static void editSellerAccount(int ID, int cellNumber, String email, String password, String name,String surname) {
		try {
			connector.connect();
			connector.getStatement().executeQuery("UPDATE Seller VALUES ( " + cellNumber + "," + email + "," +  password + "," + name +"," + surname + ") WHERE ID LIKE " + ID + ");");
		}	
		catch (SQLException ex) {
				ex.printStackTrace();
		}
		
		return;
		
	}
		
	
}
