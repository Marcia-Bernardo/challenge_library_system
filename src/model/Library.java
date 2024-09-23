package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {
    private List<Book> booksList = new ArrayList<>();
    private List<Customer> customersList = new ArrayList<>();
    private List<Employee> employeesList = new ArrayList<>();
    private List<Loan> loansList = new ArrayList<>();
    private List<Booking> bookingsList = new ArrayList<>();
    private String name;
    private String address;

    public Library(String name, String address) {
        this.name = name;
        this.address = address;
    }

    //    Customer
    public Customer getCustomer(int idCustomer) {
        Customer customer = null;

        for (int i = 0; i < customersList.size(); i++) {
            if (Objects.equals(customersList.get(i).getId(), idCustomer)) {
                customer = customersList.get(i);
            }
        }
        return customer;
    }

    public void addCustomer(Customer customer) {
        customersList.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customersList.remove(customer);
    }


//    Employee

    public Employee getEmployee(String nameEmployee) {
        Employee employee = null;

        for (int i = 0; i < employeesList.size(); i++) {
            if (Objects.equals(customersList.get(i).getName(), nameEmployee)) {
                employee = employeesList.get(i);
            }
        }
        return employee;
    }

    public void addEmployee(Employee employee) {
        employeesList.add(employee);
    }

//    Book

    public Book getBook(int idBook) {
        Book book = null;

        for (int i = 0; i < booksList.size(); i++) {
            if (Objects.equals(idBook, booksList.get(i).getId())) {
                book = booksList.get(i);
            }
        }
        return book;
    }

    public void addBook(Book book) {
        booksList.add(book);
    }

    public void removeBook(Book book) {
        booksList.remove(book);
    }


//    Loan

    public void addLoan(Loan loan) {
        loansList.add(loan);
    }

    public void payLoan(Loan loan) {
        loan.setPaid(true);
    }

    public void setReturnDate(Loan loan) {
        loan.setCloseDate(LocalDateTime.now());
    }

    public List<Loan> getListLoans() {
        return loansList;
    }

    public List<Loan> getCustomerLoans(Customer customer) {
        List<Loan> customerLoans = new ArrayList<>();


        for (int i = 0; i < loansList.size(); i++) {
            if (Objects.equals(customer, loansList.get(i).getClient())) {
                customerLoans.add(loansList.get(i));
            }
        }
        return customerLoans;
    }

    public List<Loan> getLoansCreatedBeforeDate(LocalDateTime date) {
        List<Loan> loansByDate = new ArrayList<>();

        for (int i = 0; i < loansList.size(); i++) {
            if (loansList.get(i).getCreateAt().isBefore(date)) {
                loansByDate.add(loansList.get(i));
            }
        }
        return loansByDate;
    }

    public List<Loan> getLoansCreatedAfterDate(LocalDateTime date) {
        List<Loan> loansByDate = new ArrayList<>();

        for (int i = 0; i < loansList.size(); i++) {
            if (loansList.get(i).getCreateAt().isAfter(date)) {
                loansByDate.add(loansList.get(i));
            }
        }
        return loansByDate;
    }

    public List<Loan> getLoansCreatedBetweenDate(LocalDateTime date, LocalDateTime date1) {
        List<Loan> loansByDate = new ArrayList<>();

        for (int i = 0; i < loansList.size(); i++) {
            if (loansList.get(i).getCreateAt().isAfter(date) & (loansList.get(i).getCreateAt().isBefore(date1))) {
                loansByDate.add(loansList.get(i));
            }
        }
        return loansByDate;
    }

    public List<Loan> getLoansByClosingDateBefore(LocalDateTime date) {
        List<Loan> loansByDate = new ArrayList<>();

        for (int i = 0; i < loansList.size(); i++) {
            if (loansList.get(i).getCloseDate() != null) {

                if ((loansList.get(i).getCloseDate()).isBefore(date)) {
                    loansByDate.add(loansList.get(i));
                }
            }
        }
        return loansByDate;
    }

    public List<Loan> getLoansByClosingDateAfter(LocalDateTime date) {
        List<Loan> loansByDate = new ArrayList<>();

        for (int i = 0; i < loansList.size(); i++) {
            if (loansList.get(i).getCloseDate() != null) {

                if ((loansList.get(i).getCloseDate()).isAfter(date)) {
                    loansByDate.add(loansList.get(i));
                }
            }
        }
        return loansByDate;
    }

    public List<Loan> getLoansClosingBetweenDate(LocalDateTime date, LocalDateTime date1) {
        List<Loan> loansByDate = new ArrayList<>();

        for (int i = 0; i < loansList.size(); i++) {
            if (loansList.get(i).getCloseDate() != null){
                if (loansList.get(i).getCloseDate().isAfter(date) & (loansList.get(i).getCloseDate().isBefore(date1))) {
                    loansByDate.add(loansList.get(i));
                }
            }
        }
        return loansByDate;
    }


//    Booking

    public void addBooking(Booking booking) {
        bookingsList.add(booking);
    }

    //    List

    public List<Customer> getClientList() {
        return customersList;
    }

    public List<Book> getBooksList() {
        return booksList;
    }


    public List<Employee> getEmployeesList() {
        return employeesList;
    }


    public List<Booking> getBookingsList() {
        return bookingsList;
    }

public List<Booking> getCustomerBooking(Customer customer){
    List <Booking> customerBooking = new ArrayList<>();

    for (int i = 0; i < bookingsList.size(); i++) {
        if(Objects.equals(customer, bookingsList.get(i).getCostumer())){
            customerBooking.add(bookingsList.get(i));
        }
    }
    return customerBooking;
}

    //    Library

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
