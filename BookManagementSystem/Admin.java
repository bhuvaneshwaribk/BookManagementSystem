class Admin {
    private String id;
    private List<Book> books;

    public Admin(String id) {
        this.id = id;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void updatePrice(String title, double newPrice) throws BookNotFoundException {
        boolean bookFound = false;
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                book.setPrice(newPrice);
                bookFound = true;
                break;
            }
        }
        if (!bookFound) {
            throw new BookNotFoundException("Book not found: " + title);
        }
    }

    public void removeBook(String title) throws BookNotFoundException {
        boolean bookRemoved = books.removeIf(book -> book.getTitle().equals(title));
        if (!bookRemoved) {
            throw new BookNotFoundException("Book not found: " + title);
        }
    }

    public List<Book> displayAllBooks() {
        return books;
    }

    public List<Book> displayBooksByCategory(String category) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> displayBooksByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> displayBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }
}
