package Unicam.IDS.Model;


/**
 * E' L'ENUMERAZIONE CHE GESTISCE GLI STATI DI UN PACCO
 * 
 * @author Fabio Lori 2
 *
 */
public enum OrderStatus {
	recieved, //Commerciante
	preparing,//Commerciante
	shipped,//Commerciante
	inDelivery,//Corriere
	delivered,//Corriere
	deliveredInLocker,//Corriere
	stokingInLocker,//PDR
	pickedInLocker,//PDR
	cancelled,//Commerciante - Corriere.
	
	

}
