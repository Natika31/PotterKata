import java.util.ArrayList;

public class Basket {

	private ArrayList<Book> books;
	private int price;

	public Basket() {
		this.books = new ArrayList<>();
		this.price = 0;
	}

	public float compute() {
			for(Book book:books) {
				price += book.getPrice();
			}	
		return price;
	}

	public void addBook(Book book) {
		this.books.add(book);
	}

}
