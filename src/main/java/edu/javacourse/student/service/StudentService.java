package edu.javacourse.student.service;

// бизнес-логика для работы Spring

import edu.javacourse.student.dao.StudentRepository;
import edu.javacourse.student.domain.Student;
import edu.javacourse.student.domain.StudentDocument;
import edu.javacourse.student.view.StudentRequest;
import edu.javacourse.student.view.StudentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// (специализация @Component) обычно используется если класс предостовляет какой-то бизнес-функционал
@Service
public class StudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public List<StudentResponse> getStudentInfo(StudentRequest request) {
        // получение списка студентов
        List<Student> student = studentRepository.findStudent(request.getLastName(),
                request.getFirstName(),
                request.getMiddleName(),
                request.getDateOfBirth(),
                request.getPassportSeria(),
                request.getPassportNumber(),
                request.getPassportDate());
        // если студент не найден
        if(student.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        // получение списка документов
        List<StudentDocument> docs = student.get(0).getDocuments();
        List<StudentResponse> result = docs.stream().map(d -> getResponse(d)).collect(Collectors.toList());
        return result;
    }

    // метод, возвращающий StudentResponse из StudentDocument
    private StudentResponse getResponse(StudentDocument doc) {
        StudentResponse sr = new StudentResponse();
        sr.setDocumentNumber(doc.getDocumentNumber());
        sr.setDocumentDate(doc.getDocumentDate());
        sr.setExpiredDate(doc.getExpiredDate());
        sr.setFacultyName(doc.getFaculty().getFacultyName());
        sr.setUniversityName(doc.getFaculty().getUniversity().getUniversityName());
        sr.setStudentForm(doc.getStudentForm().toString());

        return sr;
    }

}
