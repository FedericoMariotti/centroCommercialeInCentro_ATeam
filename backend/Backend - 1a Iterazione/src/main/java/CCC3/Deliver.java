package CCC3;




public class Deliver  {
	
	//IL CODICE UNIVOCO GENERATO DAI DATI DEL CORRIERE PER IDENTIFICARLO
	private int ID;
	
	//IL NOME DEL CORRIERE
	private String name;
	
	//IL COGNOME DEL CORRIERE
	private String surname;
	
	//IL NUMERO DI CELLULARE DEL CORRIERE
	private long cellNumber;
	

	
	/* Costruisce un oggetto di tipo corriere
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
     *              il corriere deve avere almeno un nome o un cognome per essere creato 
     *              @note questa evenienza potrebbe essere gestita dal controller.
	 * 
	 */
	
	public Deliver  (String name, String surname, long cellNumber) {
		if (name==null && surname == null) 	throw new NullPointerException ("");
		else {
			this.setID(name,surname,cellNumber);
			this.setName(name);
			this.setSurname(surname);
			this.setCellNumber(cellNumber);
			}
	}

	/* Crea un codice univoco per il corriere
	 * @note puo usare l hashcode
	 * 
	 * @param name 	
	 * 				il nome del corriere
	 * 
	 * @param surname 	
	 * 				il cognome del corriere
	 * 
	 * @param cellNumber 	
	 * 				il cellulare del corriere
	 */
	
	private void setID(String name, String surname, long cellNumber) {
	// TODO Auto-generated method stub
	return ;
	}

	/**
	 * @return the iD
	 */
	
	public int getID() {
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
	 * @return the surname
	 */
	
	public String getSurname() {
		return surname;
	}


	/**
	 * @param surname the surname to set
	 */
	
	public void setSurname(String surname) {
		this.surname = surname;
	}


	/**
	 * @return the cellNumber
	 */
	
	public long getCellNumber() {
		return cellNumber;
	}


	/**
	 * @param cellNumber the cellNumber to set
	 */
	
	public void setCellNumber(long cellNumber) {
		this.cellNumber = cellNumber;
	}
	
	/** @note Cambia lo stato del pacco, in consegna e company
	 * @param newStatus 
	 * 				Status è un enumerazione, il corriere può impostare lo stato solo in determinati tipi.
	 * @throws Exception 
	 */
	
	public void changeOrderStatus (OrderStatus newStatus, Order order) throws Exception {
		if (newStatus != OrderStatus.inDelivery && newStatus != OrderStatus.delivered && newStatus != OrderStatus.deliveredInLocker && newStatus != OrderStatus.cancelled)
			throw new Exception ("Stato non modificabile dal corriere");
		else {
			order.setStatus(newStatus);
		}
	
	
	}
	
	

}
