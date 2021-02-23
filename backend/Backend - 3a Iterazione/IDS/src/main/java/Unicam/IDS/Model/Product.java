package Unicam.IDS.Model;


import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

//quando un prodotto viene venduto decremento quantity, se quantiti +è 0 deve essere segnalato, caso d uso? refill prodotto?
@Entity
@Table(name = "products")
public class Product {
    //IL CODICE UNIVOCO GENERATO DAI DATI DEL PRODOTTO PER IDENTIFICARLO
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long ID;
	
	//IL NOME DEL Prodotto
	@Column(name = "name")
	private String name;
	
	//IL PREZZO DEL PRODOTTO
	@Column(name = "price")
	private int price;
	
	//LA MARCA DEL PRODOTTO
	@Column(name = "brand")
	private String brand;
	
	//LA DESCRIZIONE DEL PRODOTTO
	@Column(name = "description")
	private String description;
	
	//I TAG DEL PRODOTTO, se piu di uno sono separati dalla virgola
	@Column(name = "tags")
	private String tags;
	
	//IL NUMERO DI PRODOTTI DISPONIBILI
	@Column(name = "quantity")
	private int quantity;

	@ManyToOne
	private Market market;

	public Product(){
		super();
	}

	public Product(String name, int price, String brand, String description, String tags, int quantity,Market market){
			this.setName(name);
			this.setPrice(price);
			this.setBrand(brand);
			this.setDescription(description);
			this.setTags(tags);
			this.setQuantity(quantity);
			this.setMarket(market);

	}

	/**
	 * @return the iD
	 */
	public long getID() {
		return ID;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}



	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}



	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}



	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}



	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}



	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}



	/**
	 * @return the tags
	 */
	public String getTags() {
		return tags;
	}



	/**
	 * @param tags the tags to set
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}



	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}



	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	/**
	 * @param market the market to set
	 */
	public void setMarket(Market market) {
		this.market = market;
	}


	/**
	 * @return the market
	 */
	public Market getMarket (){
		return  this.market;
	}

}
