package Models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Department implements List<Book>  {
	    private String name;
	    private List<Book> books;

	    public Department(String name) {
	        this.name = name;
	        this.books = new ArrayList<>();
	    }

	    public void addBook(Book book) {
	        if (!books.contains(book)) {
	            books.add(book);
	        }
	    }

	    public boolean removeBook(String ISBN) {
	        for (int i = 0; i < books.size(); i++) {
	            if (books.get(i).getISBN().equals(ISBN)) {
	                books.remove(i);
	                return true;
	            }
	        }
	        return false;
	    }

	    public List<Book> findBookByTitle(String title) {
	        List<Book> foundBooks = new ArrayList<>();
	        for (Book book : books) {
	        	System.out.print("book------"+book);
	        	System.out.print("getTitle------"+title);
	            if (book.getTitle().equalsIgnoreCase(title)) {
	            	System.out.print("66666666------"+title);
	                foundBooks.add(book);
	            }
	        }
	        return foundBooks;
	    }

	    public List<Book> findBookByAuthor(String author) {
	        List<Book> foundBooks = new ArrayList<>();
	        for (Book book : books) {
	            if (book.getAuthor().equalsIgnoreCase(author)) {
	                foundBooks.add(book);
	            }
	        }
	        return foundBooks;
	    }

	    public List<Book> getBooks() {
	        return books;
	    }

	    public List<Book> getAvailableBooks() {
	        List<Book> availableBooks = new ArrayList<>();
	        for (Book book : books) {
	            if (book.isAvailable()) {
	                availableBooks.add(book);
	            }
	        }
	        return availableBooks;
	    }

	    public String getName() {
	        return name;
	    }
	}


