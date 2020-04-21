package ua.lviv.iot.springfirst.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.springfirst.rest.business.StudentService;
import ua.lviv.iot.springfirst.rest.model.Student;
import java.util.List;

@RequestMapping("/students")
@RestController
public class StudentsController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getStudents(
            final @RequestParam(name = "firstName", required = false) String firstName) {
        if (firstName == null) {
            return studentService.getStudents();
        }
        return studentService.getAllByFirstName(firstName);
    }

    @GetMapping(path = "/{id}")
    public Student getStudent(final @PathVariable("id") Integer studentId) {
        return studentService.getStudentById(studentId);
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public Student createStudent(final @RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteStudent(@PathVariable("id") Integer studentId) {
        studentService.deleteStudentById(studentId);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> updateStudent(final @PathVariable("id") Integer studentId,
            final @RequestBody Student student) {
        Student studentBeforeUpdate = studentService.getStudentById(studentId);
        if (studentBeforeUpdate == null) {
            return ResponseEntity.notFound().build();
        }
        studentService.updateStudentById(student, studentId);
        return ResponseEntity.ok(studentBeforeUpdate);
    }

}