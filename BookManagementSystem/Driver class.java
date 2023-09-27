void BookManage(){
        List<Book> books = new ArrayList<>();
        Admin admin = new Admin("admin123");
        User user = new User("user1", "John");

        

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter 'admin' or 'user' to log in: ");
        String role = scanner.nextLine();

        if (role.equalsIgnoreCase("admin")) {
          
            while (true) {
                System.out.println("\nAdmin Menu:");
                System.out.println("1. Add a book");
                System.out.println("2. Update book price");
                System.out.println("3. Remove a book");
                System.out.println("4. Display all books");
                System.out.println("5. Display books by category");
                System.out.println("6. Display books by title");
                System.out.println("7. Display books by author");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");
                int adminChoice = scanner.nextInt();
                scanner.nextLine(); 

                switch (adminChoice) {
                    case 1:
                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter category: ");
                        String category = scanner.nextLine();
                        System.out.print("Enter price: ");
                        double price = scanner.nextDouble();
                        admin.addBook(new Book(title, author, category, price));
                        System.out.println("Book added successfully!");
                        break;
                    case 2:
                        System.out.print("Enter book title to update price: ");
                        String bookToUpdate = scanner.nextLine();
                        System.out.print("Enter new price: ");
                        double newPrice = scanner.nextDouble();
                        try {
                            admin.updatePrice(bookToUpdate, newPrice);
                            System.out.println("Price updated successfully!");
                        } catch (BookNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.print("Enter book title to remove: ");
                        String bookToRemove = scanner.nextLine();
                        try {
                            admin.removeBook(bookToRemove);
                            System.out.println("Book removed successfully!");
                        } catch (BookNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        List<Book> allBooks = admin.displayAllBooks();
                        displayBooks(allBooks);
                        break;
                    case 5:
                        System.out.print("Enter category to filter books: ");
                        String filterCategory = scanner.nextLine();
                        List<Book> booksByCategory = admin.displayBooksByCategory(filterCategory);
                        displayBooks(booksByCategory);
                        break;
                    case 6:
                        System.out.print("Enter title keyword to filter books: ");
                        String titleKeyword = scanner.nextLine();
                        List<Book> booksByTitle = admin.displayBooksByTitle(titleKeyword);
                        displayBooks(booksByTitle);
                        break;
                    case 7:
                        System.out.print("Enter author keyword to filter books: ");
                        String authorKeyword = scanner.nextLine();
                        List<Book> booksByAuthor = admin.displayBooksByAuthor(authorKeyword);
                        displayBooks(booksByAuthor);
                        break;
                    case 8:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        } else if (role.equalsIgnoreCase("user")) {
          
            while (true) {
                System.out.println("\nUser Menu:");
                System.out.println("1. Buy a book");
                System.out.println("2. Search for books");
                System.out.println("3. View book details");
                System.out.println("4. Add book to wishlist");
                System.out.println("5. View wishlist");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int userChoice = scanner.nextInt();
                scanner.nextLine(); 

                switch (userChoice) {
                    case 1:
                        System.out.print("Enter the title of the book to buy: ");
                        String bookToBuy = scanner.nextLine();
                        try {
                            user.buyBook(bookToBuy, admin);
                            System.out.println("Book purchased successfully!");
                        } catch (BookNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        System.out.print("Enter keyword to search for books: ");
                        String keyword = scanner.nextLine();
                        List<Book> searchResults = user.searchBook(keyword, admin);
                        displayBooks(searchResults);
                        break;
                    case 3:
                        System.out.print("Enter the title of the book to view details: ");
                        String bookToView = scanner.nextLine();
                        try {
                            Book bookDetails = user.viewBookDetails(bookToView, admin);
                            displayBookDetails(bookDetails);
                        } catch (BookNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        System.out.print("Enter the title of the book to add to your wishlist: ");
                        String bookToAddToWishlist = scanner.nextLine();
                        try {
                            user.addBookToWishlist(bookToAddToWishlist, admin);
                            System.out.println("Book added to wishlist successfully!");
                        } catch (BookNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        List<Book> wishlist = user.getWishlist();
                        displayBooks(wishlist);
                        break;
                    case 6:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        } else {
            System.out.println("Invalid login role. Please choose 'admin' or 'user'.");
        }
    }


private static void displayBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            for (Book book : books) {
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Category: " + book.getCategory());
                System.out.println("Price: $" + book.getPrice());
                System.out.println("--------------------");
            }
        }
    }

    private static void displayBookDetails(Book book) {
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Category: " + book.getCategory());
        System.out.println("Price: $" + book.getPrice());
    }
 }