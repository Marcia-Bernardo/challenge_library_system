package services;

import model.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LoanService {

    private Library library;

    public LoanService(Library library) {
        this.library = library;
    }

    public Loan addLoan(Customer customer, Book book, Employee employee) {

        Loan loan = new Loan(customer, book, employee);
        library.addLoan(loan);
        return loan;
    }

    public List<Loan> getCustomerLoans(Customer customer) {
        return library.getCustomerLoans(customer);
    }

    public List<Loan> getLoansBeforeDateByCreatedAt(LocalDateTime date){
        return library.getLoansCreatedBeforeDate(date);
    }

    public List<Loan> getLoansAfterDateByCreatedAt(LocalDateTime date){
        return library.getLoansCreatedAfterDate(date);
    }

    public List<Loan> getLoansBetweenDateByCreatedAt(LocalDateTime date, LocalDateTime date1){
        return library.getLoansCreatedBetweenDate(date, date1);
    }


    public List<Loan> getLoansClosingDateBefore(LocalDateTime date){
        return library.getLoansByClosingDateBefore(date);
    }

    public List<Loan> getLoansClosingDateAfter(LocalDateTime date){
        return library.getLoansByClosingDateAfter(date);
    }

    public List<Loan> getLoansBetweenDateByClose(LocalDateTime date, LocalDateTime date1){
        return library.getLoansClosingBetweenDate(date, date1);
    }

    public boolean hasFines(Customer customer) {
        List<Loan> customerLoans = getCustomerLoans(customer);
        boolean hasFines = false;

        for (int i = 0; i < customerLoans.size(); i++) {
            if (!customerLoans.get(i).isPaid()) {
                hasFines = true;
                break;
            }
        }
        return hasFines;
    }

    public void calculateFine(Customer customer) {
        List<Loan> customerLoans = getCustomerLoans(customer);

        for (int i = 0; i < customerLoans.size(); i++) {
            if (LocalDateTime.now().isAfter(customerLoans.get(i).getEstimated())) {
                customerLoans.get(i).setFine(2 * ChronoUnit.DAYS.between(customerLoans.get(i).getEstimated(), LocalDateTime.now()));
                customerLoans.get(i).setPaid(false);
            }
        }
    }

    public float getTotalFineAmount(Customer customer) {
        List<Loan> customerLoans = getCustomerLoans(customer);
        float value = 0;

        for (int i = 0; i < customerLoans.size(); i++) {
            if (!customerLoans.get(i).isPaid()) {
                value += customerLoans.get(i).getFine();
            }
        }

        return value;
    }

    public void payFines(Customer customer) {
        List<Loan> customerLoans = getCustomerLoans(customer);
        for (int i = 0; i < customerLoans.size(); i++) {
            if (!customerLoans.get(i).isPaid()) {
                library.payLoan(customerLoans.get(i));
            }
        }
    }

    public String returnBook(Customer customer, int id) {
        List<Loan> customerLoans = getCustomerLoans(customer);
        String msnReturn = "";

        for (int i = 0; i < customerLoans.size(); i++) {
            if (Objects.equals(id, customerLoans.get(i).getBook().getId())) {
                if (LocalDateTime.now().isBefore(customerLoans.get(i).getEstimated())) {
                    library.setReturnDate(customerLoans.get(i));
                    msnReturn="success";
                }else{
                    customerLoans.get(i).setFine(2 * ChronoUnit.DAYS.between(customerLoans.get(i).getEstimated(), LocalDateTime.now()));
                    customerLoans.get(i).setPaid(false);
                    msnReturn="success with fine";
                }
            }
        }
        return msnReturn;
    }

    public List<Loan> allLoanAtAnyTime(){
        List<Loan> loansBooks = library.getListLoans();
        List<Loan> loanAtAnyTime= new ArrayList<>();
        for (int i = 0; i < loansBooks.size(); i++) {
            if(loansBooks.get(i).getCloseDate()==null){
        loanAtAnyTime.add(loansBooks.get(i));
            }
        }
        return loanAtAnyTime;
    }
}
