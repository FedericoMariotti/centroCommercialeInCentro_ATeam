package accountSystem;

import java.util.List;

import CCC3.Market;

public class Seller extends Account{
	

	
	private int ID = 0;
	//I NEGOZI DEL COMMERCIANTE
	private List<Market> markets;

	public Seller(int cellNumber,String email, String password, String name, String surname){	
		super(cellNumber, email, password, name, surname);
		this.setID(name,surname);
				
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
	 * @return the Markets
	 */
	public List<Market> getMarkets() {
		return markets;
	}

	/** Aggiunge un negozio alla lista di negozi del commerciante
	 * @return the Markets
	 */
	public void addMarket(Market newmarket){
		if (newmarket == null) throw new NullPointerException ("Can't add an invalid market");
		markets.add(newmarket);
	}
	
	/** Rimuove un negozio alla lista di negozi del commerciante
	 * @return the Markets
	 */
	public void removeMarket(Market newmarket){
		if (newmarket == null) throw new NullPointerException ("Can't remove an invalid market");
		markets.remove(newmarket);
	}
	

	

}
