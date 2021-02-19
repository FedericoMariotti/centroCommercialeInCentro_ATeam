package CCC3;

import java.util.List;

public class Seller {
	
	//IL CODICE UNIVOCO GENERATO DAI DATI DEL COMMERCIANTE PER IDENTIFICARLO
	private int ID;
	
	//IL Name DEL COMMERCIANTE
	private String name;
	
	//IL COGName DEL COMMERCIANTE
	private String surname;
	//private String indirizzo; prendiamolo dal Market no?
	
	//I NEGOZI DEL COMMERCIANTE
	private List<Market> markets;

	public Seller(String name, String surname)
	{
		this.setID(name,surname);
		this.setName(name);
		this.setSurname(surname);
			
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
