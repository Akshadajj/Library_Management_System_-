package Models;

public class LibraryTest {

    @Test
    public void testAddBook() {
        Library library = new Library();
        Book book = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084", "Fiction", 1960, Arrays.asList("Default Department"), true);
        library.addBook(book, "Default Department");
        assertEquals(1, library.getBooks("Default Department").size());
    }

    @Test
    public void testFindBookByTitle() {
        Library library = new Library();
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084", "Fiction", 1960, Arrays.asList("Default Department"), true);
        Book book2 = new Book("1984", "George Orwell", "9780451524935", "Fiction", 1949, Arrays.asList("Default Department"), true);
        library.addBook(book1, "Default Department");
        library.addBook(book2, "Default Department");
        List<Book> result = library.findBookByTitle("Mockingbird");
        assertEquals(1, result.size());
        assertEquals("To Kill a Mockingbird", result.get(0).getTitle());
    }

    @Test
    public void testFindBookByAuthor() {
        Library library = new Library();
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084", "Fiction", 1960, Arrays.asList("Default Department"), true);
        Book book2 = new Book("1984", "George Orwell", "9780451524935", "Fiction", 1949, Arrays.asList("Default Department"), true);
        library.addBook(book1, "Default Department");
        library.addBook(book2, "Default Department");
        List<Book> result = library.findBookByAuthor("Harper Lee");
        assertEquals(1, result.size());
        assertEquals("To Kill a Mockingbird", result.get(0).getTitle());
    }

    @Test
    public void testFindBookByDepartment() {
        Library library = new Library();
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084", "Fiction", 1960, Arrays.asList("Default Department", "Fiction Department"), true);
        Book book2 = new Book("1984", "George Orwell", "9780451524935", "Fiction", 1949, Arrays.asList("Default Department"), true);
        library.addBook(book1, "Default Department");
        library.addBook(book1, "Fiction Department");
        library.addBook(book2, "Default Department");
        List<Book> result = library.getBooks("Fiction Department");
        assertEquals(1, result.size());
        assertEquals("To Kill a Mockingbird", result.get(0).getTitle());
    }
}