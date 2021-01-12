package accountSystem;
import java.util.Base64;

import CCC3.DBManager;
import CCC3.DBManagerRead;
public class LogIn {

	
	
	public static boolean autentication(String email, String password){		
		if ((Base64.getEncoder().encodeToString(password.getBytes()).matches(DBManagerRead.getPassword(email)))){
			return true;
		}
		else return false;
		
	}

		
}
