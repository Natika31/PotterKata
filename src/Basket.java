import java.util.ArrayList;

public class Basket {
	
	public enum Tome {TOME1,TOME2,TOME3,TOME4,TOME5};
	public ArrayList<Book> books;
	private float price;

	public Basket() {
		this.books = new ArrayList<>();
		this.price = 0;
	}

	public void addBook(Book book) {		
		this.books.add(book);
	}

	public float calculateBasketPrice() {
		for(Book abook:books) {
			price += abook.getPrice();
		}
		price -= discount(this.getNbOfDifferentBooks());
		return price;
	}

	private float discount(int nbOfDifferentBooks){
		float discount = 0.0F;
		if(getNbOfDifferentBooks()==2)
			discount  = 0.05F*nbOfDifferentBooks*8;
		if(getNbOfDifferentBooks()==3)
			discount  = 0.10F*nbOfDifferentBooks*8;
		return discount;
	}

	private Integer getNbOfCopies(String bookTitle) {
		int nbOfCopies=0;
		for(Book abook:books) {
			if(abook.getTitle().equals(bookTitle))
				nbOfCopies++;
		}
		return nbOfCopies;
	}

	private int getNbOfDifferentBooks() {
		int nbOfDifferentBooks =0;
		for(Tome tome:Tome.values()) {
			if(getNbOfCopies(tome.name()) !=0) {
				nbOfDifferentBooks ++;
			}
		}
		return nbOfDifferentBooks;
	}
}
