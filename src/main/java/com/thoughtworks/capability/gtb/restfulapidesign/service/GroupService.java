package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.GroupRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    private final StudentRepository studentRepository;

    public GroupService(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    public List<Group> getGroups() {
        List<Student> studentList = studentRepository.findAll();
        List<Student> students = getShuffleStudentList(studentList);
        List<Group> groups = groupRepository.findAll();
        return resetGroup(students, groups);
    }

    private List<Student> getShuffleStudentList(List<Student> studentList) {
        List<Student> sortedStudent = new ArrayList<>(studentList);
        Collections.shuffle(sortedStudent);
        return sortedStudent;
    }

    private List<Group> resetGroup(List<Student> students, List<Group> groups) {
        int startIndex = 0;
        int amountInEveryTeam = students.size() / groups.size();
        int remain = students.size() % groups.size();
        for (Group group : groups) {
            if (remain > 0) {
                group.setStudentList(students.subList(startIndex, startIndex + amountInEveryTeam + 1));
                remain--;
                startIndex = startIndex + amountInEveryTeam + 1;
            } else {
                group.setStudentList(students.subList(startIndex, startIndex + amountInEveryTeam));
                startIndex = startIndex + amountInEveryTeam;
            }
        }
        return groups;
    }


}
