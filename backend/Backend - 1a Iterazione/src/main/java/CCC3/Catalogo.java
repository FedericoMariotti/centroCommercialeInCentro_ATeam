package CCC3;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Catalogo {
	
	
	//I PRODOTTI PRESENTI NEL CATALOGO
	private List<Product>  products;
	
	//I NEGOZI PRESENTI NEL CATALOGO
	private List<Market>  markets;
	
	DBManager dbManager = DBManager.getInstance();
	public Catalogo () {
		this.setProductsDB();
		this.setMarketsDB();
		
	}

	/**
	 * imposta la lista dei negozi prendendoli dal database
	 */
	private void setMarketsDB() {
		this.markets = dbManager.getMarkets();
		
	}

	/**
	 * imposta la lista dei negozi prendendoli dal database
	 */
	private void setProductsDB() {
		this.products = dbManager.getProducts();
		
	}
	
	List<Product> getProducts () {
		return products; 
	}
	
	/**
	 * @param qwery 
	 * 				la parola che si deve cercare all'interno dei prodotti
	 */
	 List<Product> searchProducts (String qwery){
		
		 return dbManager.getProducts(qwery) ;
		 
	 }
	 
	 List<Product> searchMarkets (String qwery){
			
		 return dbManager.getMarkets(qwery) ;
		 
	 }
	 
	 List<Product> searchProductsbyMarket (String market, String product){
		 return dbManager.getMarkets(market).getProducts(product);
	 }
	 
	
}
