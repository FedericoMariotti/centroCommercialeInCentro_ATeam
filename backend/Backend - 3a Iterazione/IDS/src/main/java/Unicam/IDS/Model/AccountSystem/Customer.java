package Unicam.IDS.Model.AccountSystem;

import javax.persistence.*;

/**
 * @author Fabio Lori 2
 *
 */
@Entity
@Table(name = "customers")

public class Customer extends Account{

		//IL CODICE UNIVOCO GENERATO DAI DATI DEL CLIENTE PER IDENTIFICARLO
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		long ID;

		// L'INDIRIZZO DEL CLIENTE
		@Column(name = "address")
		private String address;

	//@JsonCreator

		public Customer(){
			super();
		}


		public Customer(long cellNumber,String email, String password,String name, String surname, String address)
		{
			//super(cellNumber, email, password,name,surname);

			this.setCellNumber(cellNumber);
			this.setEmail(email);
			this.setPassword(password);
			this.setName(name);
			this.setSurname(surname);
			this.setAddress (address);
						
		}


		/**
		 * @return the iD
		 */
		public long getID() {
			return ID;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(long id){
			this.ID = id;
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
