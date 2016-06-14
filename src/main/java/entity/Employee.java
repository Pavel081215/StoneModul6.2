package entity;


import java.sql.Date;

//import java.util.Date;

public class Employee {

    private Integer id;
    private Date birthDay;
    private String name;
    private String surname;
    private long phone;
    private String position;
    private long salary;

    public Integer getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public long getPhone() {
        return phone;
    }

    public String getPosition() {
        return position;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setPosition(String position) {
        this.position = position;
    }


}
