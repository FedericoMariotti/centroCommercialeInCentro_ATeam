package CCC3;

public class Main {

	public static void main(String[] args) {
	 	DBManager dbManager = DBManager.getInstance();
    	dbManager.setDBManager("jdbc:mysql://localhost:3306/test", "root","");
    	dbManager.DBtest();
    	Catalogo c = new Catalogo();
    	// INTERFACCIA GRAFICA
    	// CARICO IL CATALOGO?
	}

}
