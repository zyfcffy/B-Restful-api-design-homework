package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private final List<Student> studentList = new ArrayList<>();

    private final int INDEX_GAP = 1;

    public List<Student> findAll() {
        return studentList;
    }

    public Student addStudent(Student student) {
        AtomicInteger id = new AtomicInteger(studentList.size());
        int IdIncStep = 1;
        student.setId(id.addAndGet(IdIncStep));
        studentList.add(student);
        return studentList.get(student.getId() - INDEX_GAP);
    }

    public void deleteStudent(int id) {
        studentList.remove(id - INDEX_GAP);
    }
}