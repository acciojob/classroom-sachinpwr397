package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.saveStudent(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.saveTeacher(teacher);
    }

    public void addStudentTeacherPair(String studentName, String teacherName){
        studentRepository.saveStudentTeacherPair(studentName, teacherName);
    }

    public Student getStudentByName(String name){
        return studentRepository.findStudent(name);
    }

    public Teacher getTeacherByName(String name){
        return studentRepository.findTeacher(name);
    }

    public List<String> getStudentsByTeacherName(String teacher){
        return studentRepository.findStudentsFromTeacher(teacher);
    }

    public List<String> getAllStudents(){
        return studentRepository.findAllStudents();
    }

    public void deleteTeacherByName(String teacher){
        studentRepository.deleteTeacher(teacher);
    }

    public void deleteAllTeachers(){
        studentRepository.deleteAllTeachers();
    }
}
