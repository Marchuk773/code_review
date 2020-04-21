package ua.lviv.iot.springfirst.rest.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.springfirst.rest.dataaccess.StudentRepository;
import ua.lviv.iot.springfirst.rest.model.Student;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Integer studentId) {
        return studentRepository.findById(studentId).get();
    }

    public void deleteStudentById(Integer studentId) {
        studentRepository.deleteById(studentId);
    }

    public Student updateStudentById(Student newStudent, Integer studentId) {
        if (studentRepository.existsById(studentId)) {
            studentRepository.findById(studentId).get().setFirstName(newStudent.getFirstName());
            studentRepository.findById(studentId).get().setLastName(newStudent.getLastName());
            return newStudent;
        } else {
            return null;
        }

    }

    public List<Student> getAllByFirstName(String firstName) {
        return studentRepository.findAllByFirstName(firstName);
    }

}