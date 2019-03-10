import java.util.ArrayList;

public class Basket {

	private ArrayList<Book> books;
	private float price;
	private int nbOfTOME1;
	private int nbOfTOME2;
	private int nbOfTOME3;
	private int nbOfTOME4;
	private int nbOfTOME5;

	public Basket() {
		this.books = new ArrayList<>();
		this.price = 0;
		this.nbOfTOME1=0;
		this.nbOfTOME2=0;
		this.nbOfTOME3=0;
		this.nbOfTOME4=0;
		this.nbOfTOME5=0;
	}

	public void addBook(Book book) {
		this.books.add(book);
	}

	public float calculateBasketPrice() {
		for(Book book:books) {
			price += book.getPrice();
		}
		price -= discount();
		return price;
	}

	private boolean containsTwoDifferentBooks() {
		boolean contains = false;
		if(books.size()>1) {
			for(int index = 0; index < books.size()-1;index++) {
				contains |= !this.books.get(index).getTitle().equals(books.get(index + 1).getTitle());
			}
		}
		return contains;
	}

	private float discount(){
		float discount = 0.0F;
		getNbOfIdenticalBook();
		if(getNbOfDifferentBooks()==2)
			discount  = 0.05F*this.getNbOfDifferentBooks()*8;
		if(getNbOfDifferentBooks()==3)
			discount  = 0.10F*this.getNbOfDifferentBooks()*8;
		return discount;
	}

	private float getNbOfDifferentBooks() {
		int nbOfDifferentBooks =0;
		if(nbOfTOME1 != 0)
			nbOfDifferentBooks ++;
		if(nbOfTOME2 != 0)
			nbOfDifferentBooks++;
		if(nbOfTOME3 != 0)
			nbOfDifferentBooks++;
		if(nbOfTOME4 != 0)
			nbOfDifferentBooks++;
		if(nbOfTOME5 != 0)
			nbOfDifferentBooks++;
		return nbOfDifferentBooks;
	}

	private void getNbOfIdenticalBook() {
		for(Book book:books) {
			switch(book.getTitle()) {
			case "TOME1":
				nbOfTOME1++;
				break;
			case "TOME2":
				nbOfTOME2++;
				break;
			case "TOME3":
				nbOfTOME3++;
				break;
			case "TOME4":
				nbOfTOME4++;
				break;
			case "TOME5":
				nbOfTOME5++;
				break;
			default:
				System.out.println("Sorry, this book is unknown.");
			}
		}
	}






}
