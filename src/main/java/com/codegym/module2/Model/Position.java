package com.codegym.module2.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Position")
public class Position {
    @Id
    private int id;

    private String position;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Position() {
    }

    public Position(int id, String position) {
        this.id = id;
        this.position = position;
    }



    @OneToMany(targetEntity = Employee.class)
    private List<Employee> employee;

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }
}
