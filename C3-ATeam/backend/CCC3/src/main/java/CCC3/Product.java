package CCC3;


//quando un prodotto viene venduto decremento quantity, se quantiti +è 0 deve essere segnalato, caso d uso? refill prodotto?

public class Product {
	
    //IL CODICE UNIVOCO GENERATO DAI DATI DEL PRODOTTO PER IDENTIFICARLO
	private int ID;
	
	//IL NOME DEL Prodotto
	private String name;
	
	//IL PREZZO DEL PRODOTTO
	private int price;
	
	//LA MARCA DEL PRODOTTO
	private String brand;
	
	//LA DESCRIZIONE DEL PRODOTTO
	private String description;
	
	//I TAG DEL PRODOTTO, se piu di uno sono separati dalla virgola
	private String tags;
	
	//IL NUMERO DI PRODOTTI DISPONIBILI
	private int quantity;


	
	public Product(String name, int price, String brand, String description, String tags, int quantity){
		
			this.setID(name,brand);
			this.setName(name);
			this.setPrice(price);
			this.setBrand(brand);
			this.setDescription(description);
			this.setTags(tags);
			this.setQuantity(quantity);

	}



	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}



	/**
	 * @param iD the iD to set
	 */
	public void setID(String name, String brand) {
		
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
}