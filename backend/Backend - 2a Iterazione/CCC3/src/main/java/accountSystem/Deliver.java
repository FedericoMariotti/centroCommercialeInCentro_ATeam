package accountSystem;

import CCC3.Order;
import CCC3.OrderStatus;

public class Deliver  extends Account{
	
	//IL CODICE UNIVOCO GENERATO DAI DATI DEL CORRIERE PER IDENTIFICARLO
	private int ID;
	

	
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
	
	public Deliver(int cellNumber,String email, String password,String name, String surname) {
		super(cellNumber,email,password, name,surname);
		this.setID(name,surname,cellNumber);

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
