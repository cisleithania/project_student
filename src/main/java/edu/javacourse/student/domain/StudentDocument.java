package edu.javacourse.student.domain;

// Документ, с местами учебы студента

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "sr_student_document")
@Entity
public class StudentDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id")
    private Long documentId;
    @Column(name = "document_number")
    private String documentNumber;
    @Column(name = "document_date")
    private LocalDate documentDate; // дата начала обучения
    @Column(name = "expired_date")
    private LocalDate expiredDate; // дата окончания обучения
    // студент может учится в нескольких университетах
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;
    // использование Enum
    @Column(name = "student_form")
    @Enumerated
    private StudentForm studentForm;

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public LocalDate getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(LocalDate documentDate) {
        this.documentDate = documentDate;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public StudentForm getStudentForm() {
        return studentForm;
    }

    public void setStudentForm(StudentForm studentForm) {
        this.studentForm = studentForm;
    }
}
