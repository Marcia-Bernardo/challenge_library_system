package services;

import model.Customer;
import model.Library;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CustomerService {

    private Library library;

    public CustomerService(Library library) {
        this.library = library;

    }

    public Customer getCustomer() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Write the customer's id: ");
        int idCustomer = scan.nextInt();

        return library.getCustomer(idCustomer);

    }

    public Customer addCustomer() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Write the customer's name: ");
        String nameClient = scan.nextLine();

        System.out.println("Write the birthday date");
        String birthDate=scan.nextLine();
        String[] arrOfStr_B = birthDate.split("/");

        LocalDate birthDay = LocalDate.of(Integer.parseInt(arrOfStr_B[2]),
                Integer.parseInt(arrOfStr_B[1]),
                Integer.parseInt(arrOfStr_B[0]));


        System.out.println("Write the customer's mobile: ");
        String mobileNumber = scan.nextLine();

        Customer customer = new Customer(nameClient, birthDay, mobileNumber);
        library.addCustomer(customer);
        return customer;
    }

    public boolean updateCustomer(Customer customer){

        Scanner scan = new Scanner(System.in);

        System.out.println("Write the customer's name");
        String name=scan.nextLine();
        if(!Objects.equals(name, "")){
            customer.setName(name);
        }

        System.out.println("Write the birthday date");
        String birthDate=scan.nextLine();
        String[] arrOfStr_B = birthDate.split("/");

        LocalDate newDate = LocalDate.of(Integer.parseInt(arrOfStr_B[2]),
                Integer.parseInt(arrOfStr_B[1]),
                Integer.parseInt(arrOfStr_B[0]));

        if(!Objects.equals(birthDate,"")){
            customer.setBirthDate(newDate);
        }

        System.out.println("Write the customer's phoneNumber");
        String phoneNumber=scan.nextLine();
        if(!Objects.equals(phoneNumber, "")){
            customer.setPhoneNumber(phoneNumber);
        }

        LocalDateTime updateAt=LocalDateTime.now();
        customer.setUpdateAt(updateAt);

    return true;

    }

    public boolean removeCustomer(Customer customer){
        library.removeCustomer(customer);
        return true;
    }

    public List<Customer> getListCustomers(){
        return library.getClientList();
    }

}