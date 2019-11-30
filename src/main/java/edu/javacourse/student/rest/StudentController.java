package edu.javacourse.student.rest;

// Класс, которы принимает REST-запросы (REST - сервис)

import edu.javacourse.student.service.StudentService;
import edu.javacourse.student.view.StudentRequest;
import edu.javacourse.student.view.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Component // (специализация @Component) обычно используется если класс предостовляет какой-то бизнес-функционал
@Path("/student") // переход REST-сервиса MarriageController под управление jersey
public class StudentController {

    @Autowired
    private StudentService studentService;

    @POST
    // указываем, какой вариант преобразования объекта в строку (в данном случае используется json)
    @Consumes(MediaType.APPLICATION_JSON) // потребляет контент(json)
    @Produces(MediaType.APPLICATION_JSON) // производит контент(json)
    public List<StudentResponse> getStudentInfo(StudentRequest request) {
        return studentService.getStudentInfo(request);
    }
}
