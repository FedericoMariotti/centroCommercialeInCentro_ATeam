package Unicam.IDS.Model.AccountSystem;

import Unicam.IDS.Model.Order;
import Unicam.IDS.Model.OrderStatus;

import javax.persistence.*;

@Entity
@Table(name = "delivers")
public class Deliver  extends Account{
	
	//IL CODICE UNIVOCO GENERATO DAI DATI DEL CORRIERE PER IDENTIFICARLO
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long ID;

	public Deliver(){
		super();
	}
	
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
	
	private void setID(long id) {
	this.ID = id;
	return ;
	}

	/**
	 * @return the iD
	 */
	
	public long getID() {
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
