package com.university.academic.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "student_profiles")
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false, length = 20)
    private String gender;

    @Column(name = "phone_number", length = 30)
    private String phoneNumber;

    @Column(name = "residential_address")
    private String address;

    // Each profile belongs to exactly one student. FK: student_profiles.student_id (unique)
    @OneToOne(optional = false)
    @JoinColumn(name = "student_id", nullable = false, unique = true)
    private Student student;

    public StudentProfile() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
}
