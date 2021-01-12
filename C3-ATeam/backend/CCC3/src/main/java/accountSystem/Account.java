package accountSystem;

import java.util.Base64;

public abstract class Account {
	// IL NUMERO DI TELEFONO
	private int cellNumber;
	// L'EMAIL
	private String email;
	// LA PASSWORD PER FARE L'ACCESSO
	private String password;
	//IL NOME DELL'ACCOUNT
	private String name;
	
	//IL COGNOME DELL ACCOUNT
	private String surname;


	public Account (int cellNumber,String email, String password, String name, String surname) {
		this.setCellNumber(cellNumber);
		this.setEmail(email);
		this.setPassword(password);
		this.setName(name);
		this.setSurname(surname);
		}



	/**
	 * @return the cellNumber
	 */
	public int getCellNumber() {
		return cellNumber;
	}



	/**
	 * @param cellNumber the cellNumber to set
	 */
	public void setCellNumber(int cellNumber) {
		this.cellNumber = cellNumber;
	}



	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}



	/**
	 * @param email the email to set
 	* @throws InvalidAttributesException 
 	*/
	public void setEmail(String email) {
		//TODO controllare l'eccezione
		if ((email.contains("@") || email.contains(".")) == false) throw new NullPointerException();
		this.email = email;
	}



	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @param password the password da settare, viene criptata utilizzando la libreria base64
	 */
	public void setPassword(String password) {
		this.password = Base64.getEncoder().encodeToString(password.getBytes());
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
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

}
