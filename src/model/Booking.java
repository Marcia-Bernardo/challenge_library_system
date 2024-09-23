package model;

import java.time.LocalDateTime;

public class Booking {
    private Customer customer;
    private Book book;
    private LocalDateTime bookingDate;
    private boolean closed;

    public Booking(Customer customer, Book book, LocalDateTime bookingDate, boolean closed) {
        this.customer = customer;
        this.book = book;
        this.bookingDate = bookingDate;
        this.closed = false;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "customer=" + customer +
                ", book=" + book +
                ", bookingDate=" + bookingDate +
                ", closed=" + closed +
                '}';
    }

    public Customer getCostumer() {
        return customer;
    }

    public Book getBook() {
        return book;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }


}
