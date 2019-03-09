import java.util.ArrayList;

public class Basket {

	private ArrayList<Book> books;
	private float price;

	public Basket() {
		this.books = new ArrayList<>();
		this.price = 0;
	}

	public void addBook(Book book) {
		this.books.add(book);
	}

	public float calculateShoppingBasket() {
		for(Book book:books) {
			price += book.getPrice();
		}
		price = price - discount();
		return price;
	}

	private boolean containsTwoDifferentBooks() {
		if(books.size()>1)
			return !books.get(0).getTitle().equals(books.get(1).getTitle());
		return false;
	}

	private float discount(){
		float discount = 0.0F;
		if(containsTwoDifferentBooks())
			discount  = 0.05F*price;
		return discount;
	}




}
