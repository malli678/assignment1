package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "employee_profiles")
@SequenceGenerator(
        name = "profile_seq",
        sequenceName = "profile_seq",
        allocationSize = 1
)
public class EmployeeProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_seq")
    private Long id;

    @Column(nullable = false, length = 15)
    private String phone;

    @Column(length = 200)
    private String address;

    @OneToOne
    @JoinColumn(name = "employee_id", nullable = false, unique = true)
    @JsonBackReference
    private Employee employee;

    public EmployeeProfile() {}

    public EmployeeProfile(String phone, String address) {
        this.phone = phone;
        this.address = address;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Long getId() { return id; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public Employee getEmployee() { return employee; }
}
