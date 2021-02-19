package CCC3;

import java.util.List;

import accountSystem.Customer;
import accountSystem.Deliver;

public class OrdersManager {
	//LA LISTA DI TUTTI GLI ORDINI PRESENTI NEL DATABASE
	private List<Order>  orders; 
	


		
// UN ISTANZA DELLA CLASSE DBMANAGER 
	
	//DBManagerRead dbManagerRead = DBManagerRead.getInstance();
	
	
	//DBManagerEdit dbManagerEdit = DBManagerEdit.getInstance();
	
	public OrdersManager () {
		this.setOrdersDB();
	
	}


	private void setOrdersDB() {
		this.orders = null; // Svuota la lista degli ordini per evitare duplicati
		this.orders = DBManagerRead.getOrders();
		
	}

	
	public void addOrder (Order o) {
		if (o==null) {
			throw new NullPointerException ("Can't add a null order");
		}
		else {
			DBManagerEdit.addOrder(o);
			setOrdersDB(); //Aggiorna la lista degli ordini in locale
			
		}
	}
	
	
	public void cleanCart (Cart c) {
		c.getProducts().clear();
		
	}


	public void createOrder (Cart c, Deliver d, Customer cm) {
		Order o = new Order(c.getProducts(), cm, d, OrderStatus.recieved);
		this.addOrder(o);
		cleanCart(c);
		
	} 
	
}
