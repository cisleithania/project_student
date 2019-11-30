package edu.javacourse.student.domain;

import javax.persistence.*;

// Факультет

@Table(name = "sr_faculty")
@Entity
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faculty_id")
    private Long facultyId;
    // cascade - множество операции, которые будут повторяться в ассоциированном объекте (REFRESH - обновление данных в БД)
    // fetch - чтение связанных объектов из БД (LAZY - загрузка, только при обращении)
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY) // Несколько факультетов в Университете (ManyToOne)
    @JoinColumn(name = "university_id")  // колонка для связи с университетом
    private University university; // к какому университету относится факультет
    @Column(name = "faculty_name")
    private String facultyName; // название факультета

    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
}
