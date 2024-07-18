package Models;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Book {
	private String title;
	 private String author;
	 private String ISBN;
	 private String genre;
	 private int publicationYear;
	 private String Departments;
	 private boolean available;
	 
	 public Book(String title,String author,String ISBN,String genre,int publicationYear, String Departments,boolean available) {
		 this.title=title;
		 this.author=author;
		 this.ISBN=ISBN;
		 this.genre=genre;
		 this.publicationYear=publicationYear;
		 this.Departments=Departments;
		 this.available=available;
		 
	 }
	 

	 public Book(String title2, String author2, String iSBN2, String genre2, int publicationYear2,
		        List<String> departments2, boolean available2) {
		    this.title = title2;
		    this.author = author2;
		    this.ISBN = iSBN2;
		    this.genre = genre2;
		    this.publicationYear = publicationYear2;
		    this.Departments = departments2.stream().collect(Collectors.joining(", "));
		    this.available = available2;
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

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getDepartments() {
		return Departments;
	}

	public void setDepartments(String departments) {
		Departments = departments;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", ISBN=" + ISBN + ", genre=" + genre
				+ ", publicationYear=" + publicationYear + ", Departments=" + Departments + ", available=" + available
				+ "]";
	}
	 
	
}
