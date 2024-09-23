package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Employee extends Person {

    Type type;


    public Employee(String name, LocalDate birthDate, String address, String email, String phoneNumber, LocalDateTime createAt, Type type) {
        super( name, birthDate,  address, email, phoneNumber, createAt);
        this.type = type;
    }

    public Employee(String name, LocalDate birthDate, String email, Type type) {
        super( name, birthDate, email);
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
