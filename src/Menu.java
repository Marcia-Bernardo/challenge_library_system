import java.util.Scanner;

public final class Menu {
    private static final Scanner scan = new Scanner(System.in);

    public static int drawMenu() {

        System.out.println("_____________________");
        System.out.println("MENU");
        System.out.println("1. Customer Management");
        System.out.println("2. Book Management");
        System.out.println("3. Loan");
        System.out.println("4. Booking");
        System.out.println("0. Exit");
        System.out.println("_____________________");

        System.out.println("Choose a option: ");
        int option =scan.nextInt();
        scan.nextLine();
        return option;
    }

    public static int drawCustomerMenu() {

        System.out.println("_____________________");
        System.out.println("MENU");
        System.out.println("1. Consult customer");
        System.out.println("2. Insert customer");
        System.out.println("3. Update customer");
        System.out.println("4. Delete customer");
        System.out.println("5. List customer");
        System.out.println("0. Exit");
        System.out.println("_____________________");

        System.out.println("Choose a option: ");
        int option =scan.nextInt();
        scan.nextLine();
        return option;
    }

    public static int drawBookMenu() {

        System.out.println("_____________________");
        System.out.println("MENU");
        System.out.println("1. Consult book");
        System.out.println("2. Insert book");
        System.out.println("3. Update book");
        System.out.println("4. Delete book");
        System.out.println("5. List all books available");
        System.out.println("6. List all books");
        System.out.println("0. Exit");
        System.out.println("_____________________");

        System.out.println("Choose a option: ");
        int option =scan.nextInt();
        scan.nextLine();
        return option;
    }

    public static int drawLoanMenu() {

        System.out.println("_____________________");
        System.out.println("MENU");

        System.out.println("1. Consult customer loans");
        System.out.println("2. Register loan");
        System.out.println("3. Return book");
        System.out.println("4. Pay off debt");
        System.out.println("5. List all loans by creation date after the specified date.");
        System.out.println("6. List all by creation date before the specified date.");
        System.out.println("7. List, between the specified dates, all loans by creation date.");
        System.out.println("8. List all loans by delivery date, before the specified date");
        System.out.println("9. List all loans by delivery date, after the specified date");
        System.out.println("10. List all loans by delivery date, between specified dates");
        System.out.println("11. List all books loans from the library");
        System.out.println("0. Exit");
        System.out.println("_____________________");

        System.out.println("Choose a option: ");
        int option =scan.nextInt();
        scan.nextLine();
        return option;
    }

    public static int drawBookingMenu() {

        System.out.println("_____________________");
        System.out.println("MENU");
        System.out.println("1. Consult book bookings");
        System.out.println("2. Consult client bookings");
        System.out.println("3. Register booking");
        System.out.println("0. Exit");
        System.out.println("_____________________");

        System.out.println("Choose a option: ");
        int option =scan.nextInt();
        scan.nextLine();
        return option;
    }

}