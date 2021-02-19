package CCC3;

public class Parking {
	
	private int ID;
	//IL NOME DEL PARCHEGGIO
	private String name;
	
	//L'INDIRIZZO DEL PARCHEGGIO
	private String address;
	
	//L'ORARIO DI APERTURA DEL PARCHEGGIO
	private int openingTime;
	
	//L'ORARIO DI CHIUSURA DEL PARCHEGGIO
	private int closingTime;
	
	public Parking(String name, String address, int openingTime, int closingTime) {
		if (name==null && address == null) 	throw new NullPointerException ("");
		else {
			this.setID(name,address);
			this.setName(name);
			this.setAddress(address);
			this.setOpeningTime (openingTime);
			this.setClosingTime(closingTime);
			
			}
	}
	
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}


	/**
	 * @param address 
	 * @param name 
	 * @param cellNumber 
	 */
	private void setID(String name, String address) {
		return;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the address
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

	/**
	 * @return the openingTime
	 */
	public int getOpeningTime() {
		return openingTime;
	}


	/**
	 * @param openingTime the openingTime to set
	 */
	public void setOpeningTime(int openingTime) {
		this.openingTime = openingTime;
	}


	/**
	 * @return the closingTime
	 */
	public int getClosingTime() {
		return closingTime;
	}

	/**
	 * @param openingTime the openingTime to set
	 */
	public void setClosingTime(int closingTime) {
		this.closingTime = closingTime;
	}



}
