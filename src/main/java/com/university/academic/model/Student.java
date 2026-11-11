package com.university.academic.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registration_number", nullable = false, unique = true, length = 30)
    private String registrationNumber;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    // Many students belong to one department. FK: students.department_id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    // One student has exactly one profile (FK lives in student_profiles.student_id)
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private StudentProfile profile;

    // One student has many registrations
    @OneToMany(mappedBy = "student")
    private List<Registration> registrations = new ArrayList<>();

    public Student() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
    public StudentProfile getProfile() { return profile; }

    // Keeps both sides of the one-to-one in sync
    public void setProfile(StudentProfile profile) {
        this.profile = profile;
        if (profile != null) {
            profile.setStudent(this);
        }
    }

    public List<Registration> getRegistrations() { return registrations; }
    public void setRegistrations(List<Registration> registrations) { this.registrations = registrations; }
}
