package com.driver;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class StudentService {

    private Map<String, Student> students = new HashMap<>();
    private Map<String, Teacher> teachers = new HashMap<>();
    private Map<String, List<String>> studentTeacherPairs = new HashMap<>();

    public void addStudent(Student student){
        students.put(student.getName(), student);
    }

    public void addTeacher(Teacher teacher){
        teachers.put(teacher.getName(), teacher);
    }

    public void createStudentTeacherPair(String studentName, String teacherName){
        List<String> studentList = studentTeacherPairs.getOrDefault(teacherName, new ArrayList<>());
        studentList.add(studentName);
        studentTeacherPairs.put(teacherName, studentList);
    }

    public Student findStudent(String studentName){
        return students.get(studentName);
    }

    public Teacher findTeacher(String teacherName){
        return teachers.get(teacherName);
    }

    public List<String> findStudentsFromTeacher(String teacherName){
        return studentTeacherPairs.getOrDefault(teacherName, new ArrayList<>());
    }

    public List<String> findAllStudents(){
        return new ArrayList<>(students.keySet());
    }

    public void deleteTeacher(String teacherName){
        teachers.remove(teacherName);
        studentTeacherPairs.remove(teacherName);
    }

    public void deleteAllTeachers(){
        teachers.clear();
        studentTeacherPairs.clear();
    }
}
