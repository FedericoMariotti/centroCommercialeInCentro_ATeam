package CCC3;
/**
 * @author Fabio Lori 2
 *
 */
public class Customer {

		//IL CODICE UNIVOCO GENERATO DAI DATI DEL CLIENTE PER IDENTIFICARLO
		private int ID;
		
		//IL Name DEL CLIENTE
		private String name;
		
		//IL COGName DEL CLIENTE
		private String surname;
		
		// L'INDIRIZZO DEL CLIENTE
		private String address; 
		
		//IL NUMERO DI TELEFONO DEL CLIENTE
		private int cellNumber;

		public Customer(String name, String surname, String address, int cellNumber)
		{
			this.setID(name,surname);
			this.setName(name);
			this.setSurname(surname);
			this.setAddress (address);
			this.setCellNumber (cellNumber);
				
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
		 * @return the cogName
		 */
		public String getSurname() {
			return surname;
		}

		/**
		 * @param cogName the cogName to set
		 */
		public void setSurname(String surname) {
			this.surname = surname;
		}

		/**
		 * @return the Address
		 */
		public String getAddress() {
			return address;
		}
//TODO
		
		

		



}
