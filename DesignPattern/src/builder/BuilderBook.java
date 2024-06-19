package builder;

import java.util.Objects;

// builder pattern - slim 버전 !!
public class BuilderBook {
	private String isbn;
	private String title;
	private String author;
	private String description;
	private int price;
	
	private BuilderBook() {} // 생성자 private
	
	// builder() 호출할 때마다 새로운 객체 반환한다는 점에서 singleton pattern 과 다르다.
	public static BuilderBook builder() { 
		return new BuilderBook();
	}

	public String getIsbn() {
		return isbn;
	}
	public BuilderBook isbn(String isbn) { // method chain pattern
		this.isbn = isbn;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public BuilderBook title(String title) {
		this.title = title;
		return this;
	}
	public String getAuthor() {
		return author;
	}
	public BuilderBook author(String author) {
		this.author = author;
		return this;
	}
	public String getDescription() {
		return description;
	}
	public BuilderBook description(String description) {
		this.description = description;
		return this;
	}
	public int getPrice() {
		return price;
	}
	public BuilderBook price(int price) {
		this.price = price;
		return this;
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
		BuilderBook other = (BuilderBook) obj;
		return Objects.equals(author, other.author) && Objects.equals(description, other.description)
				&& Objects.equals(isbn, other.isbn) && price == other.price && Objects.equals(title, other.title);
	}
	
	@Override
	public String toString() {
		return "NormalBook [isbn=" + isbn + ", title=" + title + ", author=" + author + ", description=" + description
				+ ", price=" + price + "]";
	}
	
}
