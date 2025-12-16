package exercisethree;

public class NonFictionBook extends Book {
    /**
     * Calls the parent constructor Book to create a NonFictionBook object.
     * @param title : title of the book
     * @param author : the book's author
     * @param yearPublished : when the book got published
     */
    public NonFictionBook(final String title, final String author,
            final int yearPublished) {
        super(title, author, yearPublished);
    }
}
