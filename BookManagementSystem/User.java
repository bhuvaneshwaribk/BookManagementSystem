class User {
    private String id;
    private String name;
    private List<Book> wishlist;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.wishlist = new ArrayList<>();
    }

    public void buyBook(String title, Admin admin) throws BookNotFoundException {
        boolean bookFound = false;
        for (Book book : admin.displayAllBooks()) {
            if (book.getTitle().equals(title)) {
                admin.removeBook(title);
                wishlist.add(book);
                bookFound = true;
                break;
            }
        }
        if (!bookFound) {
            throw new BookNotFoundException("Book not found: " + title);
        }
    }

    public List<Book> searchBook(String keyword, Admin admin) {
        List<Book> searchResults = new ArrayList<>();
        for (Book book : admin.displayAllBooks()) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(book);
            }
        }
        return searchResults;
    }

    public Book viewBookDetails(String title, Admin admin) throws BookNotFoundException {
        for (Book book : admin.displayAllBooks()) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        throw new BookNotFoundException("Book not found: " + title);
    }

    public void addBookToWishlist(String title, Admin admin) throws BookNotFoundException {
        boolean bookFound = false;
        for (Book book : admin.displayAllBooks()) {
            if (book.getTitle().equals(title)) {
                wishlist.add(book);
                bookFound = true;
                break;
            }
        }
        if (!bookFound) {
            throw new BookNotFoundException("Book not found: " + title);
        }
    }

    public List<Book> getWishlist() {
        return wishlist;
    }
}
