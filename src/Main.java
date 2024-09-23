import model.*;
import services.BookService;
import services.BookingService;
import services.CustomerService;
import services.LoanService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Library library = new Library("Maurício Barroso", "Rua da Feitosa");

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CustomerService customerService = new CustomerService(library);
        BookService bookService = new BookService(library);
        LoanService loanService = new LoanService(library);
        BookingService bookingService = new BookingService(library);
        Customer customer = null;
        Book book = null;
        LocalDate birthDate = LocalDate.of(2000, 7, 30);
        Customer customer1 = new Customer("Márcia Bernardo", birthDate, "marcia@gmail.com");
        Customer customer2 = new Customer("Emma Bernardo", birthDate, "emma@gmail.com");
        Book book1 = new Book("Mulheres que correm com os lobos", 2, "1", 2014, "Antonieta Silva");
        Book book2 = new Book("Análise Matemática", 4, "5", 2020, "Andreia Barros");
        LocalDateTime createAt = LocalDateTime.of(2024, 6, 8, 00, 00);
        LocalDateTime closeDate = LocalDateTime.of(2024, 7, 8, 00, 00);

        Employee employee = new Employee("Hugo Miguel", birthDate, "hugo@gmail.com", Type.COUNT);
        Loan loan = new Loan(customer1, createAt, book1, employee);
        Loan loan2 = new Loan(customer1, createAt, book2, employee, closeDate);
        Loan loan3= new  Loan(customer2, createAt, book1, employee);

        LocalDateTime bookingDate = LocalDateTime.of(2024, 8, 24, 00, 00);

        Booking booking = new Booking(customer1, book2, bookingDate, true);
        library.addEmployee(employee);
        library.addCustomer(customer1);
        library.addCustomer(customer2);
        library.addBook(book1);
        library.addBook(book2);
        library.addLoan(loan);
        library.addLoan(loan2);
        library.addLoan(loan3);


        library.addBooking(booking);
        int optionMenu, optionInnerMenu;
        int idCustomer;


        do {
            optionMenu = Menu.drawMenu();

            switch (optionMenu) {

                case 1:
                    do {
                        optionInnerMenu = Menu.drawCustomerMenu();

                        switch (optionInnerMenu) {

                            case 1:
                                customer = customerService.getCustomer();
                                if (customer == null) {
                                    System.out.println("The client doesn't exist. Insert! ");
                                    break;
                                }

                                loanService.calculateFine(customer);
                                System.out.println(customer);

                                break;
                            case 2:
                                customer = customerService.addCustomer();
                                break;

                            case 3:
                                if (customer == null) {
                                    System.out.println("Consult customer");
                                    break;
                                }
                                boolean sucess = customerService.updateCustomer(customer);
                                if (sucess) {
                                    System.out.println("Updated successfully!");
                                } else {
                                    System.out.println("Modification failed");
                                }
                                break;

                            case 4:
                                if (customer == null) {
                                    System.out.println("Consult customer");
                                    break;
                                }
                                boolean remove = customerService.removeCustomer(customer);
                                if (remove) {
                                    System.out.println("Removed successfully!");
                                } else {
                                    System.out.println("Removal failed");
                                }
                                break;

                            case 5:
                                List<Customer> customersList = customerService.getListCustomers();
                                for (int i = 0; i < customersList.size(); i++) {
                                    System.out.println(customersList.get(i));
                                }
                                break;

                            case 0:
                                break;

                            default:
                                System.out.println("Neither option is valid");
                                break;
                        }
                    } while (optionInnerMenu != 0);

                    break;


                case 2:
                    do {
                        optionInnerMenu = Menu.drawBookMenu();
                        switch (optionInnerMenu) {
                            case 1:
                                book = bookService.getBook();
                                if (book == null) {
                                    System.out.println("We don't have this book in the library collection");
                                }

                                System.out.println(book);
                                break;

                            case 2:
                                book = bookService.addBook();
                                break;

                            case 3:
                                if (book == null) {
                                    book = bookService.getBook();
                                }
                                boolean sucess = bookService.updateBook(book);
                                if (sucess) {
                                    System.out.println("Updated successfully!");
                                } else {
                                    System.out.println("Modification failed");
                                }
                                break;

                            case 4:
                                if (book == null) {
                                    book = bookService.getBook();
                                }
                                boolean deleted = bookService.remove(book);
                                if (deleted) {
                                    System.out.println("Removed successfully!");
                                } else {
                                    System.out.println("Removal failed");
                                }
                                break;

                            case 5:
                                List<Book> listBooks = bookService.getListBooks();
                                for (int i = 0; i < listBooks.size(); i++) {
                                    boolean isAvailable = bookService.isBookAvailable(listBooks.get(i));
                                    if (isAvailable) {
                                        System.out.println(listBooks.get(i));
                                    }
                                }
                                break;

                            case 6:
                                List<Book> listAllBooks = bookService.getListBooks();
                                for (int i = 0; i < listAllBooks.size(); i++) {
                                        System.out.println(listAllBooks.get(i));
                                }
                                break;


                            case 0:
                                break;

                            default:
                                System.out.println("Neither option is valid");
                                break;
                        }



                    } while (optionInnerMenu != 0);
                    break;

                case 3:
                    do {
                        optionInnerMenu = Menu.drawLoanMenu();
                        switch (optionInnerMenu) {

                            case 1:

                                if (customer == null) {
                                    System.out.println("Consult customer ");
                                    break;
                                }

                                List<Loan> loanList = loanService.getCustomerLoans(customer);
                                for (int i = 0; i < loanList.size(); i++) {
                                    System.out.println(loanList.get(i));
                                }
                                if (loanList.isEmpty()) {
                                    System.out.println("There is no loan");
                                }

                                break;

                            case 2:

                                book = bookService.getBook();
                                if (book == null) {
                                    System.out.println("We don't have this book in the library collection");
                                    break;
                                }
                                if (!bookService.isBookAvailable(book)) {
                                    System.out.println("Book isn't available for loan");
                                    break;
                                }

                                customer = customerService.getCustomer();
                                if (customer == null) {
                                    System.out.println("The client doesn't exist. Insert! ");
                                    break;
                                }

                                if (loanService.hasFines(customer)) {
                                    System.out.println("Customer has fine");
                                    break;
                                }

                                loanService.addLoan(customer, book, employee);
                                System.out.println("The book was loan successfully!");
                                break;

                            case 3:
                                if (customer == null) {
                                    System.out.println("Consult customer ");
                                    break;
                                }
                                System.out.println("Write the book ID: ");
                                int idBook = scan.nextInt();
                                if (Objects.equals(loanService.returnBook(customer, idBook), "success")) {
                                    System.out.println("Book return success!");
                                } else {
                                    System.out.println("Book returned with fine, you exceeded the delivery deadline!");
                                }
                                break;

                            case 4:
                                if (customer == null) {
                                    System.out.println("Consult customer ");
                                    break;
                                }
                                float value = loanService.getTotalFineAmount(customer);
                                System.out.println(value);
                                loanService.payFines(customer);
                                System.out.println("Paid!");
                                break;

                            case 5:
                                System.out.println("Write creation date: ");
                                String dateBefore = scan.nextLine();
                                String[] arrOfStr_B = dateBefore.split("/");

                                LocalDateTime newDate = LocalDateTime.of(Integer.parseInt(arrOfStr_B[2]),
                                        Integer.parseInt(arrOfStr_B[1]),
                                        Integer.parseInt(arrOfStr_B[0]),
                                        23,
                                        59);
                                List<Loan> listDateOpenBefore = loanService.getLoansAfterDateByCreatedAt(newDate);
                                for (int i = 0; i < listDateOpenBefore.size(); i++) {
                                    System.out.println(listDateOpenBefore.get(i));
                                }
                                if (listDateOpenBefore.isEmpty()) {
                                    System.out.println("There is no loan on this date");
                                }
                                break;

                            case 6:
                                System.out.println("Write creation date: ");
                                String dateAfter = scan.nextLine();
                                String[] arrOfStr_A = dateAfter.split("/");

                                LocalDateTime newDate1 = LocalDateTime.of(Integer.parseInt(arrOfStr_A[2]),
                                        Integer.parseInt(arrOfStr_A[1]),
                                        Integer.parseInt(arrOfStr_A[0]),
                                        23,
                                        59);
                                List<Loan> listDateOpenAfter = loanService.getLoansBeforeDateByCreatedAt(newDate1);
                                for (int i = 0; i < listDateOpenAfter.size(); i++) {
                                    System.out.println(listDateOpenAfter.get(i));
                                }
                                if (listDateOpenAfter.isEmpty()) {
                                    System.out.println("There is no loan on this date");
                                }
                                break;

                            case 7:
                                System.out.println("Write creation date: ");
                                String dateBetween = scan.nextLine();
                                String[] arrOfStr1 = dateBetween.split("/");

                                LocalDateTime newDate2 = LocalDateTime.of(Integer.parseInt(arrOfStr1[2]),
                                        Integer.parseInt(arrOfStr1[1]),
                                        Integer.parseInt(arrOfStr1[0]),
                                        23,
                                        59);

                                System.out.println("Write the start date: ");
                                String date1 = scan.nextLine();
                                String[] arrOfStr2 = date1.split("/");

                                LocalDateTime newDate3 = LocalDateTime.of(Integer.parseInt(arrOfStr2[2]),
                                        Integer.parseInt(arrOfStr2[1]),
                                        Integer.parseInt(arrOfStr2[0]),
                                        23,
                                        59);

                                List<Loan> listDateBetween = loanService.getLoansBetweenDateByCreatedAt(newDate2, newDate3);
                                for (int i = 0; i < listDateBetween.size(); i++) {
                                    System.out.println(listDateBetween.get(i));
                                }
                                if (listDateBetween.isEmpty()) {
                                    System.out.println("There is no loan on this date");
                                }
                                break;

                            case 8:


                                System.out.println("Write the start date: ");
                                String date2 = scan.nextLine();
                                String[] arrOfStrB = date2.split("/");

                                LocalDateTime closeDateTimeBefore = LocalDateTime.of(Integer.parseInt(arrOfStrB[2]),
                                        Integer.parseInt(arrOfStrB[1]),
                                        Integer.parseInt(arrOfStrB[0]),
                                        23,
                                        59);

                                List<Loan> ListDateCloseBefore = loanService.getLoansClosingDateBefore(closeDateTimeBefore);
                                for (int i = 0; i < ListDateCloseBefore.size(); i++) {
                                    System.out.println(ListDateCloseBefore.get(i));
                                }
                                if (ListDateCloseBefore.isEmpty()) {
                                    System.out.println("There is no loan on this date");
                                }
                                break;

                            case 9:


                                System.out.println("Write the start date: ");
                                String date3 = scan.nextLine();
                                String[] arrOfStrA = date3.split("/");

                                LocalDateTime closeDateTimeAfter = LocalDateTime.of(Integer.parseInt(arrOfStrA[2]),
                                        Integer.parseInt(arrOfStrA[1]),
                                        Integer.parseInt(arrOfStrA[0]),
                                        23,
                                        59);

                                List<Loan> ListDateCloseAfter = loanService.getLoansClosingDateAfter(closeDateTimeAfter);
                                for (int i = 0; i < ListDateCloseAfter.size(); i++) {
                                    System.out.println(ListDateCloseAfter.get(i));
                                }
                                if (ListDateCloseAfter.isEmpty()) {
                                    System.out.println("There is no loan on this date");
                                }
                                break;

                            case 10:
                                System.out.println("Write the start date: ");
                                String dateCloseBetween = scan.nextLine();
                                String[] arrOfStrBetween = dateCloseBetween.split("/");

                                LocalDateTime newDateBetween = LocalDateTime.of(Integer.parseInt(arrOfStrBetween[2]),
                                        Integer.parseInt(arrOfStrBetween[1]),
                                        Integer.parseInt(arrOfStrBetween[0]),
                                        23,
                                        59);

                                System.out.println("Write the end date: ");
                                String dateCloseBetween1 = scan.nextLine();
                                String[] arrOfStrBetween1 = dateCloseBetween1.split("/");

                                LocalDateTime newDateBetween1 = LocalDateTime.of(Integer.parseInt(arrOfStrBetween1[2]),
                                        Integer.parseInt(arrOfStrBetween1[1]),
                                        Integer.parseInt(arrOfStrBetween1[0]),
                                        23,
                                        59);

                                List<Loan> listDateCloseBetween = loanService.getLoansBetweenDateByClose(newDateBetween, newDateBetween1);
                                for (int i = 0; i < listDateCloseBetween.size(); i++) {
                                    System.out.println(listDateCloseBetween.get(i));
                                }
                                if (listDateCloseBetween.isEmpty()) {
                                    System.out.println("There is no loan on this date");
                                }
                                break;

                            case 11:
                                List<Loan> loanAtAnyTime= loanService.allLoanAtAnyTime();
                                for (int i = 0; i < loanAtAnyTime.size(); i++) {
                                    System.out.println(loanAtAnyTime.get(i));
                                }
                                break;

                            default:
                                System.out.println("Neither option is valid");
                                break;
                        }

                    } while (optionInnerMenu != 0);
                    break;

                case 4:
                    do {
                        optionInnerMenu = Menu.drawBookingMenu();
                        switch (optionInnerMenu) {

                            case 1:
                                if (book == null) {
                                    System.out.println("Consult book");
                                    break;
                                }

                                if (!bookService.isBookAvailable(book)) {
                                    System.out.println("This book isn't available");
                                    break;
                                } else {
                                    System.out.println("This book is available");
                                }
                                break;

                            case 2:
                                if (customer == null) {
                                    System.out.println("Consult client");
                                    break;
                                }
                                List<Booking> bookingList = bookingService.getBookingByCustomer(customer);
                                for (int i = 0; i < bookingList.size(); i++) {
                                    Booking customerBooking = bookingList.get(i);
                                    System.out.println("Costumer " + customerBooking.getCostumer().getName() +
                                            " booked " + customerBooking.getBook().getName() +
                                            " for " + customerBooking.getBookingDate());
                                    if (bookingList.get(i).getBookingDate().isAfter(LocalDateTime.now())) {
                                        if (!bookService.isBookAvailable(book)) {
                                            System.out.println("This book isn't available, passed the booking date ");
                                            break;
                                        } else {
                                            System.out.println("This book is available");
                                        }
                                        break;
                                    }
                                }

                                if (bookingList.isEmpty()) {
                                    System.out.println("There is no booking");
                                }
                                break;

                            case 3:
                                if (customer == null) {
                                    System.out.println("Consult client");
                                    break;
                                }
                                if (book == null) {
                                    System.out.println("Consult book");
                                    break;
                                }
                                if (bookService.isBookAvailable(book)) {

                                    System.out.println("Date to book?");
                                    String date = scan.nextLine();
                                    String[] arrOfStr = date.split("/");

                                    LocalDateTime newDate = LocalDateTime.of(Integer.parseInt(arrOfStr[2]),
                                            Integer.parseInt(arrOfStr[1]),
                                            Integer.parseInt(arrOfStr[0]),
                                            23,
                                            59);
                                    bookingService.addBooking(customer, book, newDate);
                                }
                                break;
                            case 0:

                                break;

                            default:
                                System.out.println("Neither option is valid");
                                break;
                        }

                    } while (optionInnerMenu != 0);
                    break;

                case 0:
                    System.out.println("End of application");
                    break;

                default:
                    System.out.println("Neither option is valid");
                    break;
            }

        } while (optionMenu != 0);
    }

}