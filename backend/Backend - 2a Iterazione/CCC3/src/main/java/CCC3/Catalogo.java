package CCC3;
import java.util.List;


public class Catalogo {
	
	
	//I PRODOTTI PRESENTI NEL CATALOGO
	private List<Product>  products;
	
	//I NEGOZI PRESENTI NEL CATALOGO
	private List<Market>  markets;
	
	//DBManagerRead dbManagerRead = DBManagerRead.getInstance();
	
	
	//DBManagerEdit dbManagerEdit = DBManagerEdit.getInstance();
	
	
	public Catalogo () {
		this.setProductsDB();
		this.setMarketsDB();
		
	}

	/**
	 * imposta la lista dei negozi prendendoli dal database
	 */
	private void setMarketsDB() {
		this.markets = DBManagerRead.getMarkets();
		
	}

	/**
	 * imposta la lista dei negozi prendendoli dal database
	 */
	private void setProductsDB() {
		this.products = DBManagerRead.getProducts();
		
	}
	
	List<Product> getProducts () {
		return products; 
	}
	
	/**
	 * @param qwery 
	 * 				la parola che si deve cercare all'interno dei prodotti
	 */
	 List<Product> searchProducts(String qwery){
		
		 return DBManagerRead.getProducts(qwery) ;
		 
	 }
	 
	 List<Market> searchMarkets(String qwery){
			
		 return DBManagerRead.getMarkets(qwery) ;
		 
	 }

	 
	 List<Product> searchProductsbyMarket(String market, String product){

		 return DBManagerRead.searchProductsbyMarket (market, product);
	 }


	/** Aggiunge un prodotto alla lista di prodotti del negozio
	 * @return the Markets
	 */
	public void addProduct(Product newproduct){
		if (newproduct == null) throw new NullPointerException ("");
		DBManagerEdit.addProduct(newproduct);
		products.add(newproduct);
	}

	/** Rimuove un prodotto alla lista di prodotti del negozio
	 * @return the Markets
	 */
	public void removeProduct(Product product){
		if (product == null) throw new NullPointerException ("");
		DBManagerEdit.removeProduct(product);
		products.remove(product);
	}
	
}
