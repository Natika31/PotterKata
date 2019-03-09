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
	public void testEmptyBasketcosts0() {
		assertEquals(0,this.basket.compute());
	}

	@Test
	public void testBuyOneBookcosts8() {
		Book book = new Book("title1");
		this.basket.addBook(book);
		assertEquals(8,this.basket.compute());
	}

}
