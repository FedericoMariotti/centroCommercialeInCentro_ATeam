package Unicam.IDS.Model;

import Unicam.IDS.Model.AccountSystem.Customer;
import Unicam.IDS.Model.AccountSystem.Deliver;
import Unicam.IDS.Model.AccountSystem.Seller;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "Orders")
public class Order {

    //IL CODICE UNIVOCO GENERATO DAI DATI PER IDENTIFICARLO
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long ID;
	
	//IL O I PRODOTTI CHE VENGONO ACQUISTATI DAL CLIENTE, SE SI VUOLE METTERE PIU VOLTE LO STESSO PRODOTTO BISOGNA AGGIUNGERLO DI NUOVO NELL?ORDINE,
	//LA QUANTITà NON VIENE PRESA IN CONSIDERAZIONE NELL'ORDER
	@Column(name = "products")
	@ElementCollection(targetClass=Product.class)
	private List<Product>  products;

	//IL CLIENTE CHE ACQUISTA
	@ManyToOne
	private Customer customer;
	
	//IL CORRIERE CHE SI OCCUPA DELLA CONSEGNA
	@ManyToOne
	private Deliver deliver;
	
	//L'IMPORTO CHE IL CLIENTE HA PAGATO, VIENE CREATO DALLA SOMMA DEI PREZZI DEI PRODOTTI NELL'ORDINE
	@Column(name = "price")
	private int price;
	
	//LO STATO DELL'ORDINE (APPENA VIENE CREATO L'OGGETTO VIENE SETTATO IN recieved)
	@Column(name = "status")
	private OrderStatus status;
	
	/* Costruisce un oggetto di tipo ordine
	 * 
	 * @param products 	
	 * 				i prodotti che vengono ordinati
	 * 
	 * @param customer 	
	 * 				il cliente che effettua l'ordine
	 * 
	 * @param deliver 	
	 * 				il corriere che si occupa della consegna
	 * 
	 * @param status 
	 * 				lo stato dell'ordine
	 * 
	 * @throws NullPointerException
     *             l'ordine deve avere almeno un cliente e dei prodotti
	 * 
	 */

	public Order(){
		super();
	}

	public Order (List<Product>  products, Customer customer, Deliver deliver, OrderStatus status) {
		if (products==null || customer == null) throw new NullPointerException ("");
		else {
			this.setProducts(products);
			this.setCustomer(customer);
			this.setDeliver(deliver);
			this.setStatus(status);
			this.setPrice();
			}
	}
	/**
	 * @param ID the ID to set
	 */
	public void setID(long ID) {
		this.ID = ID;
	}

	/**
	 * @return the ID
	 */
	public long getID() {
		return ID;
	}

	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the deliver
	 */
	public Deliver getDeliver() {
		return deliver;
	}

	/**
	 * @param deliver the deliver to set
	 */
	public void setDeliver(Deliver deliver) {
		this.deliver = deliver;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @set the price
	 */
	public void setPrice() {
		int sumprice= 0;
		for (int i =0; i<products.size();i++) {
			sumprice += products.get(i).getPrice();			
		}
			
		
		this.price = sumprice;
	}
	
	/**
	 * @return the status
	 */
	public OrderStatus getStatus() {
		return status;
	}

	/**
	 * @param newStatus the Status to set
	 */
	public void setStatus(OrderStatus newStatus) {
		//NotificaStatus.send(this.getCustomer(), newStatus);
		status = newStatus;
		
	}
}
