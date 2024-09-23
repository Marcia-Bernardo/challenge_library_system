package services;

import model.Book;
import model.Booking;
import model.Library;
import model.Loan;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class BookService {
    Scanner scan = new Scanner(System.in);

    private Library library;

    public BookService(Library library) {
        this.library = library;
    }

    public Book getBook() {
        System.out.println("Write the id of the book");
        int idBook = scan.nextInt();

        return library.getBook(idBook);
    }

    public Book addBook() {


        System.out.println("Write the name of the book");
        String bookName = scan.nextLine();

        System.out.println("Write the name of the author of the book");
        String authorName = scan.nextLine();

        System.out.println("Write the year of the book");
        int year = scan.nextInt();
        scan.nextLine();

        System.out.println("Write the  book edition");
        String edition = scan.nextLine();

        System.out.println("Write the quantity");
        int qtd = scan.nextInt();

        Book book = new Book(bookName, qtd, edition, year, authorName);
        library.addBook(book);
        return book;
    }

    public boolean updateBook(Book book) {

        System.out.println("Write the name of the book");
        String bookName = scan.nextLine();

        if (!Objects.equals(bookName, "")) {
            book.setName(bookName);
        }

        System.out.println("Write the name of the author of the book");
        String authorName = scan.nextLine();
        if (!Objects.equals(authorName, "")) {
            book.setAuthor(authorName);
        }

        System.out.println("Write the year of the book");
        int year = scan.nextInt();
        scan.nextLine();
        if (!Objects.equals(year, "")) {
            book.setYear(year);
        }

        System.out.println("Write the  book edition");
        String edition = scan.nextLine();
        if (!Objects.equals(edition, "")) {
            book.setEdition(edition);
        }

        System.out.println("Write the quantity");
        int qtd = scan.nextInt();
        if (!Objects.equals(qtd, "")) {
            book.setQuantity(qtd);
        }

        LocalDateTime updateDate = LocalDateTime.now();
        return true;
    }

    public boolean remove(Book book) {
        library.removeBook(book);
        return true;
    }

    public List<Book> getListBooks() {
        return library.getBooksList();
    }

    public boolean isBookAvailable(Book book) {
        boolean available = true;
        int qtd = 0;
        List<Loan> loanList = library.getListLoans();
        List<Booking> bookingList = library.getBookingsList();

        for (int i = 0; i < loanList.size(); i++) {
            if (Objects.equals(loanList.get(i).getBook().getName(), book.getName())) {
                if (loanList.get(i).getCloseDate() == null) {
                    qtd++;
                } else if (LocalDateTime.now().isBefore(loanList.get(i).getCloseDate())) {
                    qtd++;
                }
            }
        }

        for (int i = 0; i < bookingList.size(); i++) {
            if (LocalDateTime.now().isBefore(bookingList.get(i).getBookingDate())) {
                qtd++;
            }
        }

        if (qtd >= book.getQuantity()) {
            available = false;
        }

        return available;
    }
}