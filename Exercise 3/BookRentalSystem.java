package exercisethree;

import java.util.ArrayList;

public class BookRentalSystem {
    /**
     * Contains the current library of books.
     */
    private static ArrayList<Book> library = new ArrayList<Book>();

    /**
     * Gets the current library.
     * @return library : the current library
     */
    public static ArrayList<Book> getLibrary() {
        return library;
    }
    
    

    /**
     * Removes all books in the library.
     */
    public static void clearLibrary() {
        library.clear();
    }

    /**
     * Returns the current size of the library.
     * @return size of the library
     */
    public static int getLibarySize() {
        return library.size();
    }

    /**
     * Adds a new book to the current library.
     * @param newBook : the book to be added to the library
     */
    public static void addBook(final Book newBook) {
        library.add(newBook);
    }

    /**
     * Displays currently rented books.
     */
    public static void displayAllBooks() {
        System.out.println("Current library:");

        for (Book currBook : library) {
            currBook.displayBook();
        }
    }

    /**
     * Displays currently rented books.
     */
    public static void displayRentedBooks() {
        System.out.println("Books rented:");

        for (Book currBook : library) {
            if (currBook.isRented()) {
                currBook.displayBook();
            }
        }
    }

    /**
     * The main function.
     * @param args
     */
    public static void main(final String[] args) {
        final int tlotrYear = 1954;
        final int tppYear = 2000;
        final int ggasYear = 1997;
        BookRentalSystem.addBook(new FictionBook("The Lord of the Rings",
                "J.R.R. Tolkien", tlotrYear));
        BookRentalSystem.addBook(new NonFictionBook("The Tipping Point",
                "M. Gladwell", tppYear));
        BookRentalSystem.addBook(new NonFictionBook("Guns, Germs, and Steel",
                "Jared Diamond ", ggasYear));
        System.out.println();
        BookRentalSystem.displayAllBooks();
        System.out.println();
        System.out.println();
        BookRentalSystem.displayRentedBooks();
    }

}
