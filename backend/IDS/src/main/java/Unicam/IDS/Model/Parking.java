package Unicam.IDS.Model;

import javax.persistence.*;

@Entity
@Table(name = "parking")
public class Parking {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long ID;
	//IL NOME DEL PARCHEGGIO
	@Column(name = "name")
	private String name;
	
	//L'INDIRIZZO DEL PARCHEGGIO
	@Column(name = "address")
	private String address;
	
	//L'ORARIO DI APERTURA DEL PARCHEGGIO
	@Column(name = "openingTime")
	private int openingTime;
	
	//L'ORARIO DI CHIUSURA DEL PARCHEGGIO
	@Column(name = "closingTime")
	private int closingTime;


	//I PARCHEGGI OCCUPATI
	@Column(name = "occupiedparks")
	private int occupied;

	public Parking(){
		super();
	}
	public Parking(String name, String address, int openingTime, int closingTime) {
		if (name==null && address == null) 	throw new NullPointerException ("");
		else {
			this.setName(name);
			this.setAddress(address);
			this.setOpeningTime (openingTime);
			this.setClosingTime(closingTime);
			this.occupied = 0;
			}
	}
	
	/**
	 * @return the iD
	 */
	public long getID() {
		return ID;
	}


	/**
	 * @param ID
	 */
	public void setID(long ID) {
		this.ID = ID;
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
	 * @param closingTime the openingTime to set
	 */
	public void setClosingTime(int closingTime) {
		this.closingTime = closingTime;
	}

	/**
	 * @return the occcupiedparks
	 */
	public int getOccupied() {
		return occupied;
	}

	/**
	 * @param occupied the occupiedparks to set
	 */
	public void setOccupied(int occupied) {
		this.occupied = occupied;
	}



}
