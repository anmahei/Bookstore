package fi.heiniola.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Book {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	private String isbn;
	private String title;
	private String author;
	private int year;
	private double price;
	
	@ManyToOne
	@JoinColumn(name="categoryid")
	private Category category;
	
	public Book() {
		super();
	}
	
	public Book(String isbn, String author, String title, int year, double price, Category category) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.year = year;
		this.price = price;
		this.category = category;

	}


	public long getId() {
		return id;
		
	}
	public void setId(long id) {
		this.id = id;
	}	
		public String getIsbn() {
			return isbn;
		}

		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;

	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price){
		this.price = price;
}
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", author=" + author + ", title=" + title + ", year=" + year + ", price=" + price + ", category=" + this.getCategory() + "]";
	}
}
