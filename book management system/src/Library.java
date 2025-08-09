import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void showBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void showUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void issueBook(int bookId, int userId) {
        Book book = findBook(bookId);
        User user = findUser(userId);

        if (book == null) {
            System.out.println("Book not found!");
        } else if (user == null) {
            System.out.println("User not found!");
        } else if (book.isIssued()) {
            System.out.println("Book already issued!");
        } else {
            book.setIssued(true);
            System.out.println("Book \"" + book.getTitle() + "\" issued to " + user.getName());
        }
    }

    public void returnBook(int bookId) {
        Book book = findBook(bookId);
        if (book == null) {
            System.out.println("Book not found!");
        } else if (!book.isIssued()) {
            System.out.println("Book is not issued!");
        } else {
            book.setIssued(false);
            System.out.println("Book \"" + book.getTitle() + "\" returned.");
        }
    }

    private Book findBook(int bookId) {
        for (Book b : books) {
            if (b.getBookId() == bookId) return b;
        }
        return null;
    }

    private User findUser(int userId) {
        for (User u : users) {
            if (u.getUserId() == userId) return u;
        }
        return null;
    }
}
