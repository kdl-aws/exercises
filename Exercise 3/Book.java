package exercisethree;

public class Book {
    /** The title of the book. */
    private String title;
    /** The book's author. */
    private String author;
    /** When the book got published. */
    private int yearPublished;
    /** Current rental status. */
    private boolean isRented;

    /**
     * Gets the book title.
     * @return title : title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     * @param bookTitle : title of the book
     */
    public void setTitle(final String bookTitle) {
        this.title = bookTitle;
    }

    /**
     * Gets the book's author.
     * @return author : author of the book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book.
     * @param bookAuthor : author of the book
     */
    public void setAuthor(final String bookAuthor) {
        this.author = bookAuthor;
    }

    /**
     * Gets the year the book was published.
     * @return yearPublished : publication year of the book
     */
    public int getYearPublished() {
        return yearPublished;
    }

    /**
     * Sets the year the book was published.
     * @param bookYearPublished : publication year of the book
     */
    public void setYearPublished(final int bookYearPublished) {
        this.yearPublished = bookYearPublished;
    }

    /**
     * Checks if the book is currently rented.
     * @return isRented : true if the book is rented, false otherwise
     */
    public boolean isRented() {
        return isRented;
    }

    /**
     * Sets the rental status of the book.
     * @param bookRented : rental status (true if rented, false if available)
     */
    public void setRented(final boolean bookRented) {
        this.isRented = bookRented;
    }

    /**
     * Creates a book object.
     * @param bookTitle : title of the book
     * @param bookAuthor : the book's author
     * @param bookYearPublished : when the book got published
     */
    public Book(final String bookTitle, final String bookAuthor,
            final int bookYearPublished) {
        setTitle(bookTitle);
        setAuthor(bookAuthor);
        setYearPublished(bookYearPublished);
        setRented(false);
    }

    /** Rent function
     * Sets rented field to true.
     */
    public void rent() {
        setRented(true);
    }
    
    /**
     * Displays details of the current book.
     */
    public void displayBook() {
        System.out.printf("%-50s  %-30s  %4d%n", this.getTitle(),
                this.getAuthor(), this.getYearPublished());
    }
}
