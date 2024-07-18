package Models;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class LibraryMenu {
  private Library Library;
  
  public LibraryMenu(Library library) {
	  this.Library=library;
	  
  }
  public void start() {
	  Scanner scanner = new Scanner(System.in);
	  while(true) {
		  System.out.println("\nLibrary Management System");
		  System.out.println("1. Add Book");
		  System.out.println("2. Remove Book");
		  System.out.println("3. Find Book by Title");
		  System.out.println("4. Find Book by Author");
		  System.out.println("5. List All Books");
		  System.out.println("6. List Available Books");
		  System.out.println("7. Exit");
		  
		  System.out.print("Enter your choice: ");
          int choice = scanner.nextInt();
          scanner.nextLine(); // Consume newline character
          
          switch (choice) {
          case 1:
              addBook(scanner);
              break;
          case 2:
              removeBook(scanner);
              break;
          case 3:
              findBookByTitle(scanner);
              break;
          case 4:
              findBookByAuthor(scanner);
              break;
          case 5:
              listAllBooks();
              break;
          case 6:
              listAvailableBooks();
              break;
          case 7:
              System.out.println("Exiting...");
              return;
          default:
              System.out.println("Invalid choice. Please try again.");
	  }

		  
	  
  }
}
  
  private void addBook(Scanner scanner) {
      System.out.print("Enter book title: ");
      String title = scanner.nextLine();
      System.out.print("Enter book author: ");
      String author = scanner.nextLine();
      System.out.print("Enter book ISBN: ");
      String ISBN = scanner.nextLine();
      System.out.print("Enter book genre: ");
      String genre = scanner.nextLine();
      System.out.print("Enter book publication year: ");
      int publicationYear = scanner.nextInt();
      scanner.nextLine(); 
   
      boolean available = true;
      System.out.print("Enter book departments (comma-separated): ");
      String departmentsString = scanner.nextLine();
      List<String> departments = new ArrayList<>();
      for (String department : departmentsString.split(",")) {
          departments.add(department.trim());
      }
      
      Book book = new Book(title, author, ISBN, genre, publicationYear, departments,available);
      for (String department : departments) {
          Library.addBook(book, department);
       
      }
      System.out.println("Book added successfully!");
  }

  private void removeBook(Scanner scanner) {
      System.out.print("Enter ISBN of the book to remove: ");
      String ISBN = scanner.nextLine();
      Library.removeBook(ISBN);
      System.out.println("Book removed successfully!");
  }

  private void findBookByTitle(Scanner scanner) {
      System.out.print("Enter book title to search: ");
      String title = scanner.nextLine();
      List<Book> books = Library.findBookByTitle(title);
      if (books.isEmpty()) {
          System.out.println("No books found with that title.");
      } else {
          System.out.println("Found books:");
          for (Book book : books) {
              System.out.println(book);
          }
      }
  }

  private void findBookByAuthor(Scanner scanner) {
      System.out.print("Enter book author to search: ");
      String author = scanner.nextLine();
      List<Book> books = Library.findBookByAuthor(author);
      if (books.isEmpty()) {
          System.out.println("No books found by that author.");
      } else {
          System.out.println("Found books:");
          for (Book book : books) {
              System.out.println(book);
          }
      }
  }

  private void listAllBooks() {
      List<Book> books = Library.listAllBooks();
      if (books.isEmpty()) {
          System.out.println("The library is empty.");
      } else {
          System.out.println("All books:");
          for (Book book : books) {
              System.out.println(book);
          }
      }
  }

  private void listAvailableBooks() {
      List<Book> books = Library.listAvailableBooks();
      if (books.isEmpty()) {
          System.out.println("No books are available.");
      } else {
          System.out.println("Available books:");
          for (Book book : books) {
              System.out.println(book);
          }
      }
  }
}

