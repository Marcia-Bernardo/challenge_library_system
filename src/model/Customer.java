package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Customer extends Person {
    public Customer(String name, LocalDate birthDate, String address, String email, String phoneNumber, LocalDateTime createAt) {
        super(name, birthDate, address, email, phoneNumber, createAt);
    }

    public Customer(String name, LocalDate birthDate, String email) {
        super(name, birthDate, email);
    }

}
