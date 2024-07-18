package Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.lang.Iterable;

public class Library {
	
	    private Map<String, List<Book>> departments;

	    public Library() {
	        this.departments = new HashMap<>();
	    }

	    public void addBook(Book book, String department) {
	        if (book != null) {
	            if (!departments.containsKey(department)) {
	                departments.put(department, new ArrayList<>());
	            }
	            departments.get(department).add(book);
	        }
	    }
	    //}

	    public void removeBook(String ISBN) {
	        for (List<Book> books : departments.values()) {
	            for (int i = 0; i < books.size(); i++) {
	                if (books.get(i).getISBN().equals(ISBN)) {
	                    books.remove(i);
	                    return;
	                }
	            }
	        }
	    }

	    
	    public List<Book> findBookByTitle(String title) {
	        List<Book> result = new ArrayList<>();
	        for (List<Book> books : departments.values()) {
	            for (Book book : books) {
	                if (book.getTitle() != null && book.getTitle().toLowerCase().contains(title.toLowerCase())) {
	                    if(!result.contains(book)) {
	                	result.add(book);
	                }
	               }
	            }
	        }
	        return result;
	    }

	    public List<Book> findBookByAuthor(String author) {
	        List<Book> result = new ArrayList<>();
	        for (List<Book> books : departments.values()) {
	            for (Book book : books) {
	                if (book.getAuthor() != null && book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
	                	if (!result.contains(book)) {
	                	result.add(book);
	                }
	             }
	           }
	        }
	        return result;
	    }

	    public List<Book> listAllBooks() {
	        Set<Book> result = new HashSet<>();
	        for (List<Book> books : departments.values()) {
	            result.addAll(books);
	        }
	        return new ArrayList<>(result);
	    }
	    public List<Book> listAvailableBooks() {
	        List<Book> result = new ArrayList<>();
	        for (List<Book> books : departments.values()) {
	            for (Book book : books) {
	                if (book.isAvailable()) {
	                    result.add(book);
	                }
	            }
	        }
	        return result;
	    }

	    public Map<String, List<Book>> getDepartments() {
	        return departments;
	    }
	}
