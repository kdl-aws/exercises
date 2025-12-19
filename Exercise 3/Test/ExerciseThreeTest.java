package exercisethreetest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exercisethree.BookRentalSystem;
import exercisethree.FictionBook;
import exercisethree.NonFictionBook;
import exercisetwo.LeapYear;
import exercisethree.Book;

class ExerciseThreeTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();   
    
    @BeforeEach
    void setup() {
        // Clear the library before each test
        BookRentalSystem.clearLibrary();

        outContent.reset();
        System.setOut(new PrintStream(outContent));
    }
    
    @DisplayName("Get Book Title")
    @Test
    void testGetBook_RetrieveBookTitle_CorrectBookTitle() {
        Book book = new FictionBook("The Lord of the Rings",
                "J.R.R. Tolkien", 1954);
        
        assertEquals(book.getTitle(), "The Lord of the Rings", "Title is wrong or not stored");
    }
    
    @DisplayName("Set Book Title")
    @Test
    void testGetBook_SetBookTitle_CorrectBookTitle() {
        Book book = new FictionBook("TLoTR",
                "J.R.R. Tolkien", 1954);
        
        book.setTitle("The Lord of the Rings");
        assertEquals(book.getTitle(), "The Lord of the Rings", "Title is wrong or not stored");
    }
    
    @DisplayName("Get Book Author")
    @Test
    void testGetBook_RetrieveBookAuthor_CorrectBookAuthor() {
        Book book = new NonFictionBook("Guns, Germs, and Steel",
                        "Jared Diamond ", 1997);
        
        assertEquals(book.getTitle(), "Guns, Germs, and Steel", "Title is wrong or not stored");
    }
    
    @DisplayName("Set Book Author")
    @Test
    void testGetBook_SetBookAuthor_CorrectBookAuthor() {
        Book book = new NonFictionBook("GGaS",
                "Jared Diamond ", 1997);
        
        book.setTitle("Guns, Germs, and Steel");
        assertEquals(book.getTitle(), "Guns, Germs, and Steel", "Title is wrong or not stored");
    }

    
    @DisplayName("Create Book")
    @Test
    void testBookConstructor_AddBook_BookIsNullAndNotRented() {
        Book book = new FictionBook("The Lord of the Rings",
                "J.R.R. Tolkien", 1954);
        
        assertNotNull(book, "Object is not null");
        assertFalse(book.isRented(), "Should return false.");
    }
    
    @DisplayName("Rent Book")
    @Test
    void testRent_CheckIfRentalStatusBecomesTrue_RentedIsTrue() {
        BookRentalSystem.addBook(new NonFictionBook("The Tipping Point",
                "M. Gladwell", 2000));
        BookRentalSystem.addBook(new FictionBook("To Kill a Mockingbird", 
                "Harper Lee", 1960));
        
        BookRentalSystem.rentBooks(1);
        
        assertTrue(BookRentalSystem.getLibrary().get(1).isRented(), "Should return true.");
    }

    @DisplayName("Add Book")
    @Test
    void testAddBook_CheckIfListSizeIsEqual_SizeIsEqual() {
        BookRentalSystem.addBook(new FictionBook("The Lord of the Rings",
                "J.R.R. Tolkien", 1954));
        BookRentalSystem.addBook(new NonFictionBook("The Tipping Point",
                "M. Gladwell", 2000));
        
        assertEquals(BookRentalSystem.getLibarySize(), 2, "Should return 2.");
    }
    
    @DisplayName("Test Books with Invalid Index")
    @Test
    void testRent_RentOnlyOneBookWithInvalidIndex_ThrowsIndexOutOfBounds() {
        BookRentalSystem.addBook(new NonFictionBook("The Tipping Point",
                "M. Gladwell", 2000));
        BookRentalSystem.addBook(new FictionBook("All Your Perfects",
                "Colleen Hoover", 2018));
        String expectedExceptionMsg = "Index 3 out of bounds for length 2";
        
        
        IndexOutOfBoundsException actualExceptionMsg = assertThrows(IndexOutOfBoundsException.class, () -> {
            BookRentalSystem.getLibrary().get(3).rent();
        });
        assertEquals(expectedExceptionMsg, actualExceptionMsg.getMessage(), "Unexpected exception message");
    }
    @DisplayName("Display All Books")
    @Test
    void testDisplayAllBooks_PrintAllBooksInLibrary_CorrectPrintOutput() {
        BookRentalSystem.addBook(new NonFictionBook("The Tipping Point",
                "M. Gladwell", 2000));
        BookRentalSystem.addBook(new FictionBook("All Your Perfects",
                "Colleen Hoover", 2018));
        BookRentalSystem.addBook(new FictionBook("To Kill a Mockingbird", 
                "Harper Lee", 1960));
        BookRentalSystem.displayAllBooks();
        
        String output = outContent.toString(); 
        assertTrue(output.contains("The Tipping Point                                   M. Gladwell                     2000"));
        assertTrue(output.contains("All Your Perfects                                   Colleen Hoover                  2018"));
        assertTrue(output.contains("To Kill a Mockingbird                               Harper Lee                      1960"));
    }
    
    @DisplayName("Display Rented Books")
    @Test
    void testDisplayRentedBooks_PrintRentedBooksInLibrary_CorrectPrintOutput() {
        BookRentalSystem.addBook(new NonFictionBook("The Tipping Point",
                "M. Gladwell", 2000));
        BookRentalSystem.addBook(new FictionBook("All Your Perfects",
                "Colleen Hoover", 2018));
        BookRentalSystem.addBook(new FictionBook("The Lord of the Rings",
                "J.R.R. Tolkien", 1954));
        BookRentalSystem.getLibrary().get(1).rent();
        BookRentalSystem.displayRentedBooks();
        
        String output = outContent.toString(); 
        assertTrue(output.contains("All Your Perfects"));
        assertTrue(output.contains("Colleen Hoover"));
        assertTrue(output.contains("2018"));
    }
    
    @Test
    void testMainFunction_ReturnsVoid() {
        BookRentalSystem.main(null);
    }
}
