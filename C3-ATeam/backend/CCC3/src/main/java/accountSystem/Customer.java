package accountSystem;
/**
 * @author Fabio Lori 2
 *
 */
public class Customer extends Account{

		//IL CODICE UNIVOCO GENERATO DAI DATI DEL CLIENTE PER IDENTIFICARLO
		private int ID;
		
		// L'INDIRIZZO DEL CLIENTE
		private String address; 


		public Customer(int cellNumber,String email, String password,String name, String surname, String address)
		{	super(cellNumber, email, password,name,surname);

			this.setAddress (address);
						
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
		public void setID(String name, String surname) {
			
		}

		/**
		 * @return the Address
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
			
		
//TODO
		
		

		



}
