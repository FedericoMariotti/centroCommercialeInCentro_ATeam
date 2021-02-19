package CCC3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LockerTest {


			@Test
			final void testsetID() {
				//Locker d1 = new Locker();
			

	        }
		
			@Test
			final void testgetID() {
				//Locker d1 = new Locker();
				

		        }
			
			@Test
			final void testgetter() {
				Locker l1 = new Locker ("ANGELI", "Via Angeli 8", 333610787,9,20);
				Locker l2 = new Locker ("ANGELI", "Via Angeli 8", 333610787,9,20);
				Locker l3 = new Locker ("ARCOBALENO", "piazza G.Carducci 234", 347585987,14,22);
				assertTrue (l1.getName() == l2.getName());
				assertTrue (l1.getAddress() == l2.getAddress());
				assertTrue (l1.getCellNumber() == l2.getCellNumber());
				assertTrue (l1.getOpeningTime() == l2.getOpeningTime());
				assertTrue (l1.getClosingTime() == l2.getClosingTime());
				
				assertFalse (l2.getName() == l3.getName());
				assertFalse(l2.getAddress() == l3.getAddress());
				assertFalse (l2.getCellNumber() == l3.getCellNumber());
				assertFalse (l2.getOpeningTime() == l3.getOpeningTime());
				assertFalse (l2.getClosingTime() == l3.getClosingTime());

		        }
			
			@Test
			final void testsetter() {
				Locker l1 = new Locker ("ANGELI", "Via Angeli 8", 333610787,9,20);
				Locker l2 = new Locker ("ARCOBALENO", "piazza G.Carducci 234", 347585987,14,22);

				assertTrue (l1.getName() != l2.getName());
				l2.setName("ANGELI");
				assertTrue (l1.getName() == l2.getName());
				
				assertTrue (l1.getAddress() != l2.getAddress());
				l2.setAddress("Via Angeli 8");
				assertTrue (l1.getAddress() == l2.getAddress());

				assertTrue (l1.getCellNumber() != l2.getCellNumber());
				l2.setCellNumber(333610787);
				assertTrue (l1.getCellNumber() == l2.getCellNumber());
				
				assertTrue (l1.getOpeningTime() != l2.getOpeningTime());
				l2.setOpeningTime(9);
				assertTrue (l1.getOpeningTime() == l2.getOpeningTime());
				
				assertTrue (l1.getClosingTime() != l2.getClosingTime());
				l2.setClosingTime(20);
				assertTrue (l1.getClosingTime() == l2.getClosingTime());
				


		        }
			
			@Test
			final void testchangeOrderStatus() throws Exception {
				Deliver d1 = new Deliver ("LUCA", "DEL MEDICO", 333610787);
				Locker l1 = new Locker ("ANGELI", "Via Angeli 8", 333610787,9,20);
				List<String> tags1 = new ArrayList<String>();
				tags1.add("Adidas");
				tags1.add("Running");
				Product p1 = new Product("Runner 8", 80, "Adidas", "Scarpe da corsa suola morbida per media distanza", tags1, 3);
				List<Product> products1 = new ArrayList<Product>();
				products1.add(p1);
				Customer c1 = new Customer ();
				Order o1 = new Order(products1, c1, d1);
				o1.setStatus(OrderStatus.shipped);
				l1.changeOrderStatus(OrderStatus.stokingInLocker, o1);		
				assertTrue (o1.getStatus() == OrderStatus.stokingInLocker);
				d1.changeOrderStatus(OrderStatus.pickedInLocker, o1);
				assertTrue (o1.getStatus() == OrderStatus.pickedInLocker);
//				assertThrows(NullPointerException.class, //non riconosce l'asserzione, creare una eccezione dedicata?
//		                () -> 	l1.changeOrderStatus(OrderStatus.preparing, o1));
			

		        }
			
	}


