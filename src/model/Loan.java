package model;

import java.time.LocalDateTime;

public class Loan {
    private Customer customer;
    private Employee employee;
    private Book book;
    private LocalDateTime createAt;
    private LocalDateTime estimated;
    private LocalDateTime closeDate;
    private float fine;
    private boolean paid;

    public Loan(Customer customer, LocalDateTime createAt, Book book, Employee employee) {
        this.customer = customer;
        this.fine = 0;
        this.closeDate = null;
        this.createAt = createAt;
        this.estimated= createAt.plusDays(7);
        this.book = book;
        this.employee = employee;
        this.paid=true;
    }
    public Loan(Customer customer, LocalDateTime createAt, Book book, Employee employee, LocalDateTime closeDate) {
        this.customer = customer;
        this.fine = 0;
        this.closeDate = null;
        this.createAt = createAt;
        this.estimated= createAt.plusDays(7);
        this.book = book;
        this.employee = employee;
        this.closeDate = closeDate;

        this.paid=true;
    }
    public Loan(Customer customer,  Book book, Employee employee) {
        this.customer = customer;
        this.fine = 0;
        this.closeDate = null;
        this.createAt = LocalDateTime.now();
        this.estimated= createAt.plusDays(7);
        this.book = book;
        this.employee = employee;
        this.paid=true;

    }

    @Override
    public String toString() {
        return "{" +
                "customer=" + customer.getName() +
                ", employee=" + employee.getName() +
                ", book=" + book.toStringLoan() +
                ", createAt=" + createAt +
                ", estimated=" + estimated +
                ", closeDate=" + closeDate +
                ", fine=" + fine +
                ", paid=" + paid +
                '}';
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public LocalDateTime getEstimated() {
        return estimated;
    }

    public void setEstimated(LocalDateTime estimated) {
        this.estimated = estimated;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getClient() {
        return customer;
    }

    public void setClient(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public float getFine() {
        return fine;
    }

    public void setFine(float fine) {
        this.fine = fine;
    }

    public LocalDateTime getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDateTime closeDate) {
        this.closeDate = closeDate;
    }
}
