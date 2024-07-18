package Models;


	public class Main {
	    public static void main(String[] args) {
	        Library library = new Library();
	        LibraryMenu menu = new LibraryMenu(library);
	        
	       
	        menu.start();
	    }
	}
