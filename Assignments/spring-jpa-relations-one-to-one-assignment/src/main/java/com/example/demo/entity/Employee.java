package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "employees")
@SequenceGenerator(
        name = "emp_seq",
        sequenceName = "emp_seq",
        allocationSize = 1
)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
    private Long id;

    @Column(name = "emp_name", nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 130)
    private String email;

    @OneToOne(mappedBy = "employee",
              cascade = CascadeType.ALL,
              orphanRemoval = true)
    @JsonManagedReference
    private EmployeeProfile profile;

    public Employee() {}

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void setProfile(EmployeeProfile profile) {
        this.profile = profile;
        if (profile != null) {
            profile.setEmployee(this);
        }
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public EmployeeProfile getProfile() { return profile; }
}
