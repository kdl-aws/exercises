package exercisethree;

public class FictionBook extends Book {
    /**
     * Calls the parent constructor Book to create a FictionBook object.
     * @param title : title of the book
     * @param author : the book's author
     * @param yearPublished : when the book got published
     */
    public FictionBook(final String title, final String author,
            final int yearPublished) {
        super(title, author, yearPublished);
    }
}
