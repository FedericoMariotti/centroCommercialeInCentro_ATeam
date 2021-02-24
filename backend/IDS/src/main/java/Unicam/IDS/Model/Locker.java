package Unicam.IDS.Model;

import javax.persistence.*;

@Entity
@Table(name = "lockers")
public class Locker{
	//IL CODICE UNIVOCO GENERATO DAI DATI DEL PUNTO DI RITIRO PER IDENTIFICARLO
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long ID;
	
	//IL NUMERO DI TELEFONO DEL PUNTO DI RITIRO
	@Column(name = "cellNumber")
	private int cellNumber;
	
	//IL NOME DEL PUNTO DI RITIRO
	@Column(name = "name")
	private String name;
	
	//L'INDIRIZZO DEL PUNTO DI RITIRO
	@Column(name = "address")
	private String address;
	
	//L'ORARIO DI APERTURA DEL PUNTO DI RITIRO
	@Column(name = "openingTime")
	private int openingTime;
	
	//L'ORARIO DI CHIUSURA DEL PUNTO DI RITIRO
	@Column(name = "closingTime")
	private int closingTime;
	
	
	/* Costruisce un oggetto di tipo PUNTO DI RITIRO
	 * 
	 * @param name 	
	 * 				il nome del corriere
	 * 
	 * @param surname 	
	 * 				il cognome del corriere
	 * 
	 * @param cellNumber 	
	 * 				il cellulare del corriere
	 * 
	 * @throws NullPointerException
     *              il PUNTO DI RITIRO deve avere almeno un nome o un cognome per essere creato 
     *              @note questa evenienza potrebbe essere gestita dal controller.
	 * 
	 */


	public Locker(){
		super();
	}

	public Locker(String name, String address, int cellNumber, int openingTime, int closingTime) {

		if (name==null && address == null) 	throw new NullPointerException ("");
		else {
			this.setName(name);
			this.setAddress(address);
			this.setCellNumber(cellNumber);
			this.setOpeningTime (openingTime);
			this.setClosingTime(closingTime);
			
			}
	}
	
	


	/**
	 * @return the iD
	 */
	public long getID() {
		return ID;
	}


	/**
	 * @param id
	 */
	public void setID(long id) {
		this.ID=id;
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

	public int getCellNumber() {
		
		return cellNumber;
	}
	
	/**
	 * @return the iD
	 */
	public void setCellNumber(int cellNumber) {
		this.getCellNumber();
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
	
	/** @note Cambia lo stato del pacco, in consegna e company
	 * @param newStatus 
	 * 				Status è un enumerazione, il Locker può impostare lo stato solo in determinati tipi.
	 * @throws Exception 
	 */
	
	public void changeOrderStatus (OrderStatus newStatus, Order order) throws Exception {
		if (newStatus != OrderStatus.stokingInLocker && newStatus != OrderStatus.pickedInLocker && newStatus != OrderStatus.cancelled)
			throw new Exception ("Stato non modificabile dal locker");
		else {
			order.setStatus(newStatus);
		}
	
	
	}
	
}
