package Unicam.IDS.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*Il caso d&#39;uso viene attivato dal commerciante nel momento in cui decide di inserire il suo negozio
nella piattaforma. Il sistema chiede al commerciante informazioni sul negozio (Nome, Indirizzo, Tipo
Negozio, Orari Apertura, Zona Consegna Domicilio, Punti Di Ritiro Disponibili, Parcheggi
Convenzionati), il commerciante le compila, terminata questa fase il sistema mostra un riepilogo
delle informazioni al commerciante, se il commerciante conferma la correttezza di quest&#39;ultime
allora il negozio viene correttamente inserito dal sistema, altrimenti il sistema permette di
modificare le informazioni.*/

@Entity
@Table(name = "markets")
public class Market {
	//IL CODICE UNIVOCO GENERATO DAI DATI DEL NEGOZIO PER IDENTIFICARLO
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long ID;
	
	//IL NOME DEL NEGOZIO
	@Column(name = "name")
	private String name;
	
	//L'INDIRIZZO DEL NEGOZIO
	@Column(name = "address")
	private String address;
	
	//IL TIPO DI NEGOZIO
	@Column(name = "type")
	private String type;
	
	//ORARIO DI APERTURA DEL NEGOZIO
	@Column(name = "openingTime")
	private int openingTime;
	
	//ORARIO DI CHIUSURA DEL NEGOZIO
	@Column(name = "closingTime")
	private int closingTime;

	//I PARCHEGGI CONVENZIONATI
	//@Embedded
	//@Column(name = "")
	@ManyToMany(cascade = CascadeType.ALL)
	private List <Parking>  parking = new ArrayList<>();
	
//	//I PRODOTTI DEL NEGOZIO
//	private List<Product> products;

	public Market(){
		super();
	}
	public Market(String name, String address, String type, int openingtime, int closingTime,Parking parking)
	{

		this.setName(name);
		this.setAddress(address);
		this.setType(type);
		this.setOpeningTime(openingtime);
		this.setClosingTime(closingTime);
		this.setParking(parking);
	
	}

	/**
	 * @return the iD
	 */
	public long getID() {
		return ID;
	}

	/**
	 * @param ID the ID to set
	 */
	public void setID(long ID) {
		this.ID = ID;
	}

	/**
	 * @return the Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the Name to set
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
	public String getType() {
		return type;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * @return the openingTime
	 */
	public int getOpeningTime() {
		return openingTime;
	}


	/**
	 * @param openingTime the openingTime to set
	 */
	public void setOpeningTime(int openingTime) {
		this.openingTime = openingTime;
	}


	/**
	 * @return the closingTime
	 */
	public int getClosingTime() {
		return closingTime;
	}


	/**
	 * @param closingTime the closingTime to set
	 */
	public void setClosingTime(int closingTime) {
		this.closingTime = closingTime;
	}
	
	/**
	 * @return the list of the parking
	 */
	public List <Parking>  getParking() {
		return parking;
	}

	/**
	 * @param parking the lista dei parcheggi to set
	 */

	public void setParking(Parking parking) {
		this.parking.add(parking);
	}

//	/**
//	 * @return the Products
//	 */
//	public List<Product> getProducts() {
//		return products;
//	}
//
//	/** Aggiunge un prodotto alla lista di prodotti del negozio
//	 * @return the Markets
//	 */
//	public void addProduct(Product newproduct){
//		if (newproduct == null) throw new NullPointerException ("");
//		products.add(newproduct);
//	}
//
//	/** Rimuove un prodotto alla lista di prodotti del negozio
//	 * @return the Markets
//	 */
//	public void removeProduct(Product product){
//		if (product == null) throw new NullPointerException ("");
//		products.remove(product);
//	}

	
	
	

}
