import java.util.*;

class Book {
    private String title;
    private String author;
    private String category;
    private double price;

    public Book(String title, String author, String category, double price) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
    
}
