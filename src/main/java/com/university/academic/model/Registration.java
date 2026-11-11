package com.university.academic.model;

import jakarta.persistence.*;

import java.time.LocalDate;

// Join entity for the Student <-> Course many-to-many relationship.
// It exists as its own entity because the link carries extra data.
@Entity
@Table(
        name = "registrations",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"student_id", "course_id", "academic_year", "semester"}
        )
)
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;

    @Column(name = "academic_year", nullable = false, length = 9)
    private String academicYear;

    @Column(nullable = false, length = 20)
    private String semester;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private RegistrationStatus status = RegistrationStatus.PENDING;

    // Nullable: no grade exists until the course is graded
    @Column
    private Double grade;

    // Many registrations belong to one student. FK: registrations.student_id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    // Many registrations belong to one course. FK: registrations.course_id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public Registration() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(LocalDate registrationDate) { this.registrationDate = registrationDate; }
    public String getAcademicYear() { return academicYear; }
    public void setAcademicYear(String academicYear) { this.academicYear = academicYear; }
    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }
    public RegistrationStatus getStatus() { return status; }
    public void setStatus(RegistrationStatus status) { this.status = status; }
    public Double getGrade() { return grade; }
    public void setGrade(Double grade) { this.grade = grade; }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
}
