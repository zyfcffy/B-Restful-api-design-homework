package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudentList(String gender) {
        if (gender == null) {
            return studentRepository.findAll();
        } else {
            return studentRepository.findByGender(gender);
        }
    }

    public Student addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public void deleteById(int id) {
        studentRepository.deleteStudent(id);
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id);
    }
}
