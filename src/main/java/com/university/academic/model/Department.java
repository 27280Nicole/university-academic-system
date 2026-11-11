package com.university.academic.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true, length = 20)
    private String code;

    // One department has exactly one head (a lecturer). FK: departments.head_id
    @OneToOne
    @JoinColumn(name = "head_id", unique = true)
    private Lecturer head;

    // One department employs many lecturers (FK lives in lecturers.department_id)
    @OneToMany(mappedBy = "department")
    private List<Lecturer> lecturers = new ArrayList<>();

    // One department offers many courses (FK lives in courses.department_id)
    @OneToMany(mappedBy = "department")
    private List<Course> courses = new ArrayList<>();

    // One department admits many students (FK lives in students.department_id)
    @OneToMany(mappedBy = "department")
    private List<Student> students = new ArrayList<>();

    public Department() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public Lecturer getHead() { return head; }
    public void setHead(Lecturer head) { this.head = head; }
    public List<Lecturer> getLecturers() { return lecturers; }
    public void setLecturers(List<Lecturer> lecturers) { this.lecturers = lecturers; }
    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }
    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> students) { this.students = students; }
}
