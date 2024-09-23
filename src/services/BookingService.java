package services;

import model.Book;
import model.Booking;
import model.Customer;
import model.Library;

import java.time.LocalDateTime;
import java.util.List;

public class BookingService {
    private Library library;
    public BookingService(Library library){this.library=library;}

    public void addBooking(Customer customer, Book book, LocalDateTime bookingDate){
        Booking booking= new Booking(customer, book, bookingDate, false);
        library.addBooking(booking);
    }

    public List<Booking> getBookingByCustomer (Customer customer){
        return library.getCustomerBooking(customer);
    }

    public void closeBookingOpenDate(){
        library.getBooksList();
    }
}