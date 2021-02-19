package CCC3;

import java.util.List;

import accountSystem.Account;
import accountSystem.Deliver;

public class AccountManager {
	//Si occupa della creazione degli account in base al tipo e comapny
	
	private List<Account>  accounts; 

	
	public void updateAccounts() {
		this.accounts = DBManagerRead.getAccounts();
		
	}
	
	public static void createDeliverAccount (int cellNumber,String email, String password, String name, String surname) {
		DBManagerEdit.addDeliverAccount(cellNumber, email, password, name, surname);
		
	}
		
	
	public static void createCustomerAccount (int cellNumber, String email, String password, String name, String surname, String address) {
		DBManagerEdit.addCustomerAccount(cellNumber, email, password, name, surname, address);
		
	}
	
	public static void createSellerAccount (int cellNumber, String email, String password, String name, String surname) {
		DBManagerEdit.addSellerAccount(cellNumber, email, password, name, surname);
		
	}
	
	public static void editDeliverAccount (int ID, int cellNumber, String email, String password, String name, String surname) {
		DBManagerEdit.editDeliverAccount(ID, cellNumber, email, password, name, surname);
		
	}

	
	public static void editCustomerAccount (int ID, int cellNumber, String email, String password, String name, String surname, String address) {
		DBManagerEdit.editCustomerAccount(ID, cellNumber, email, password, name, surname, address);
		
	}
	
	public static void editSellerAccount (int ID, int cellNumber, String email, String password, String name, String surname) {
		DBManagerEdit.editSellerAccount(ID, cellNumber, email, password, name, surname);
		
	}
	
}
