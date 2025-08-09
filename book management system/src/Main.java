import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);

        // Sample data
        lib.addBook(new Book(1, "The Alchemist", "Paulo Coelho"));
        lib.addBook(new Book(2, "1984", "George Orwell"));
        lib.addUser(new User(101, "Alice"));
        lib.addUser(new User(102, "Bob"));

        int choice;

        do {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Show all books");
            System.out.println("2. Show all users");
            System.out.println("3. Issue book");
            System.out.println("4. Return book");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> lib.showBooks();
                case 2 -> lib.showUsers();
                case 3 -> {
                    System.out.print("Enter Book ID to issue: ");
                    int bookId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    lib.issueBook(bookId, userId);
                }
                case 4 -> {
                    System.out.print("Enter Book ID to return: ");
                    int bookId = sc.nextInt();
                    lib.returnBook(bookId);
                }
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }
}
