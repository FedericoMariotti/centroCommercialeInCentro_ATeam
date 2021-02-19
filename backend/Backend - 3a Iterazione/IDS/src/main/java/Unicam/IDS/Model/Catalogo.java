package Unicam.IDS.Model;
import Unicam.IDS.Model.Market;
import Unicam.IDS.Model.Product;

import javax.persistence.*;
import java.util.List;


public class Catalogo {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int ID;

	//I PRODOTTI PRESENTI NEL CATALOGO
	@Column(name = "products")
	@ElementCollection(targetClass=Product.class)
	private List<Product>  products;
	
	//I NEGOZI PRESENTI NEL CATALOGO
	@Column(name = "markets")
	@ElementCollection(targetClass=Market.class)
	private List<Market>  markets;
	
	//DBManagerRead dbManagerRead = DBManagerRead.getInstance();
	
	
	//DBManagerEdit dbManagerEdit = DBManagerEdit.getInstance();
	
	//TODO FIX
	public Catalogo () {
	}


		


//TODO ADD PRODUCT E NEGOZIO
	 


	/** Rimuove un prodotto alla lista di prodotti del negozio
	 * @return the Markets
	 */
	public void removeProduct(Product product){
		if (product == null) throw new NullPointerException ("");
		products.remove(product);
	}
	
}
