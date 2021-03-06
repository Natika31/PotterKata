import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BasketTest {

	private Basket basket;

	@Before
	public void setUp() throws Exception {
		this.basket = new Basket();
	}

	@After
	public void tearDown() throws Exception {
		this.basket = null;
	}
	
	@Test
	public void testEmptyBasketcosts0e() {
		assertEquals(0.0F,this.basket.calculateBasketPrice(),0);
	}

	@Test
	public void testBuyOneBookcosts8e() {
		Book book = new Book("TOME1");
		this.basket.addBook(book);
		assertEquals(8.0F,this.basket.calculateBasketPrice(),0);
	}
	
	@Test
	public void testBuyTwoIdenticalBookscosts16e() {
		Book book = new Book("TOME1");
		this.basket.addBook(book);
		this.basket.addBook(book);
		assertEquals(16.0F,this.basket.calculateBasketPrice(),0);
	}
	
	@Test
	public void testBuyTwoDifferentBookscosts15e20() {
		this.basket.addBook(new Book("TOME1"));
		this.basket.addBook(new Book("TOME2"));
		assertEquals(15.20F,this.basket.calculateBasketPrice(),0);
	}
	
	@Test
	public void testBuyThreeBooksIncludingTwoDifferentBookscosts23e2() {
		this.basket.addBook(new Book("TOME1"));
		this.basket.addBook(new Book("TOME2"));
		this.basket.addBook(new Book("TOME1"));
		assertEquals(23.20F,this.basket.calculateBasketPrice(),0);
	}
	
	@Test
	public void testBuyThreeDifferentBookscosts21e6() {
		this.basket.addBook(new Book("TOME2"));
		this.basket.addBook(new Book("TOME1"));
		this.basket.addBook(new Book("TOME3"));
		assertEquals(21.60F,this.basket.calculateBasketPrice(),0);
	}
	
	
	
	

}
