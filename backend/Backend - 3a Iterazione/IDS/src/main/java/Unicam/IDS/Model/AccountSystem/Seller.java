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

	public Seller(int cellNumber,String email, String password, String name, String surname){
		super(cellNumber, email, password, name, surname);

	}

	/**
	 * @return the iD
	 */
	public long getID() {
		return ID;
	}



	
	/**
	 * @return the Markets
	 */
	//public List<Market> getMarkets() {
	//TODO	return markets;
	//}

	/** Aggiunge un negozio alla lista di negozi del commerciante
	 * @return the Markets
	 */
//TODO	public void addMarket(Market newmarket){
	//	if (newmarket == null) throw new NullPointerException ("Can't add an invalid market");
	//	markets.add(newmarket);
//	}
	
	/** Rimuove un negozio alla lista di negozi del commerciante
	 * @return the Markets
	 */
//	public void removeMarket(Market newmarket){
//		if (newmarket == null) throw new NullPointerException ("Can't remove an invalid market");
	//	markets.remove(newmarket);
//	}
	

	

}
