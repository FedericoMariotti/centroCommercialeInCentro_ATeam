package CCC3;

import accountSystem.Customer;

public class NotificaStatus {


	public static void send(Customer customer, OrderStatus newStatus) {
		try {
		SendNotifica.send("device","Gentile cliente, la informiamo che lo stato del suo ordine è stato aggiornato in" + newStatus.toString(),"Cambio stato ordine");
		}
		catch (NullPointerException("la notifica non è stata inviata al dispositivo"));
		
		//log.
	}

}
