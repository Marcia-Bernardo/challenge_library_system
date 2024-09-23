package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Person {
    private static int autoID;
    private int id;
    private String name;
    private LocalDate birthDate;
    private String address;
    private String email;
    private String phoneNumber;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public Person(String name, LocalDate birthDate, String address, String email, String phoneNumber, LocalDateTime createAt) {
        autoID++;
        this.id =autoID;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createAt = createAt;
        this.updateAt = createAt;
    }

    public Person(String name, LocalDate birthDate, String email) {
        autoID++;
        this.id =autoID;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.createAt =  LocalDateTime.now();
        this.updateAt =  LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='"+ id + "'" +
                ", name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
