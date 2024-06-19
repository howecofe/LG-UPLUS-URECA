package builder;

import java.util.Objects;

public class NormalBook {
	private String isbn;
	private String title;
	private String author;
	private String description;
	private int price;
	
	public NormalBook() {}
	public NormalBook(String isbn, String title, String author, String description, int price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.description = description;
		this.price = price;
	}
	
	public NormalBook(String isbn, String title, String author) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, description, isbn, price, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NormalBook other = (NormalBook) obj;
		return Objects.equals(author, other.author) && Objects.equals(description, other.description)
				&& Objects.equals(isbn, other.isbn) && price == other.price && Objects.equals(title, other.title);
	}
	
	@Override
	public String toString() {
		return "NormalBook [isbn=" + isbn + ", title=" + title + ", author=" + author + ", description=" + description
				+ ", price=" + price + "]";
	}
	
}
