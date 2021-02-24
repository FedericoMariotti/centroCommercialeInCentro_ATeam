package Unicam.IDS.Model.AccountSystem;

import javax.persistence.*;

@Entity
@Table(name = "sellers")
public class Seller extends Account{

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long ID;

	public Seller(){
		super();
	}

	@Override
	public void setId(long id) {
		this.ID = id;
	}

	public Seller(int cellNumber,String email, String password, String name, String surname){
		super(cellNumber, email, password, name, surname);

	}

	/**
	 * @return the iD
	 */
	public long getID() {
		return ID;
	}





}
