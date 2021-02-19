package CCC3;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DeliverTest {

		@Test
		final void testsetID() {
			//Deliver d1 = new Deliver();
		

        }
	
		@Test
		final void testgetID() {
			//Deliver d1 = new Deliver();
			

	        }
		
		@Test
		final void testgetter() {
			Deliver d1 = new Deliver ("LUCA", "DEL MEDICO", 333610787);
			Deliver d2 = new Deliver ("LUCA", "DEL MEDICO", 333610787);
			Deliver d3 = new Deliver ("ROBERTO", "ROSI", 345888201);
			assertTrue (d1.getName() == d2.getName());
			assertTrue (d1.getSurname() == d2.getSurname());
			assertTrue (d1.getCellNumber() == d2.getCellNumber());
			assertFalse (d2.getName() == d3.getName());
			assertFalse(d2.getSurname() == d3.getSurname());
			assertFalse (d2.getCellNumber() == d3.getCellNumber());

	        }
		
		@Test
		final void testsetter() {
			Deliver d1 = new Deliver ("LUCA", "DEL MEDICO", 333610787);
			Deliver d2 = new Deliver ("AZIZ", "HU", 0);

			assertTrue (d1.getName() != d2.getName());
			d2.setName("LUCA");
			assertTrue (d1.getName() == d2.getName());
			
			assertTrue (d1.getSurname() != d2.getSurname());
			d2.setSurname("DEL MEDICO");
			assertTrue (d1.getSurname() == d2.getSurname());

			assertTrue (d1.getCellNumber() != d2.getCellNumber());
			d2.setCellNumber(333610787);
			assertTrue (d1.getCellNumber() == d2.getCellNumber());


	        }
		
		@Test
		final void testchangeOrderStatus() throws Exception {
			Deliver d1 = new Deliver ("LUCA", "DEL MEDICO", 333610787);
			List<String> tags1 = new ArrayList<String>();
			tags1.add("Adidas");
			tags1.add("Running");
			Product p1 = new Product("Runner 8", 80, "Adidas", "Scarpe da corsa suola morbida per media distanza", tags1, 3);
			List<Product> products1 = new ArrayList<Product>();
			products1.add(p1);
			Customer c1 = new Customer ();
			Order o1 = new Order(products1, c1, d1);
			o1.setStatus(OrderStatus.shipped);
			d1.changeOrderStatus(OrderStatus.inDelivery, o1);		
			assertTrue (o1.getStatus() == OrderStatus.inDelivery);
			d1.changeOrderStatus(OrderStatus.delivered, o1);
			assertTrue (o1.getStatus() == OrderStatus.delivered);
//			assertThrows(NullPointerException.class, //non riconosce l'asserzione, creare una eccezione dedicata?
//	                () -> 	d1.changeOrderStatus(OrderStatus.preparing, o1));
		

	        }
		
}