package CCC3;
/*Il caso d&#39;uso viene attivato dal commerciante nel momento in cui decide di inserire il suo negozio
nella piattaforma. Il sistema chiede al commerciante informazioni sul negozio (Nome, Indirizzo, Tipo
Negozio, Orari Apertura, Zona Consegna Domicilio, Punti Di Ritiro Disponibili, Parcheggi
Convenzionati), il commerciante le compila, terminata questa fase il sistema mostra un riepilogo
delle informazioni al commerciante, se il commerciante conferma la correttezza di quest&#39;ultime
allora il negozio viene correttamente inserito dal sistema, altrimenti il sistema permette di
modificare le informazioni.*/

import java.util.List;

public class Market {
	//IL CODICE UNIVOCO GENERATO DAI DATI DEL NEGOZIO PER IDENTIFICARLO
	private int ID;
	
	//IL NOME DEL NEGOZIO
	private String name;
	
	//L'INDIRIZZO DEL NEGOZIO
	private String address;
	
	//IL TIPO DI NEGOZIO
	private MarketType type;
	
	//I PRODOTTI DEL NEGOZIO
	private List<Product> products;

	public Market(String name, String address, MarketType type)
	{
		this.setID(name,address,type);
		this.setName(name);
		this.setAddress(address);
		this.setType(type);
			
	
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
	public void setID(String name, String address, MarketType type) {
		
	}

	/**
	 * @return the Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param Name the Name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the type
	 */
	public MarketType getType() {
		return type;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(MarketType type) {
		this.type = type;
	}
	
	/**
	 * @return the Products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/** Aggiunge un prodotto alla lista di prodotti del negozio
	 * @return the Markets
	 */
	public void addProduct(Product newproduct){
		if (newproduct == null) throw new NullPointerException ("");
		products.add(newproduct);
	}

	/** Rimuove un prodotto alla lista di prodotti del negozio
	 * @return the Markets
	 */
	public void removeProduct(Product product){
		if (product == null) throw new NullPointerException ("");
		products.remove(product);
	}

	
	
	

}
