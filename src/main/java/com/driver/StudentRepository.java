package com.driver;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class StudentRepository {

    private HashMap<String, Student> studentMap;
    private HashMap<String, Teacher> teacherMap;
    private HashMap<String, List<String>> teacherStudentMapping;

    public StudentRepository(){
        this.studentMap = new HashMap<>();
        this.teacherMap = new HashMap<>();
        this.teacherStudentMapping = new HashMap<>();
    }

    public void saveStudent(Student student){
        studentMap.put(student.getName(), student);
    }

    public void saveTeacher(Teacher teacher){
        teacherMap.put(teacher.getName(), teacher);
    }

    public void saveStudentTeacherPair(String studentName, String teacherName){
        if(studentMap.containsKey(studentName) && teacherMap.containsKey(teacherName)){
            List<String> students = teacherStudentMapping.getOrDefault(teacherName, new ArrayList<>());
            students.add(studentName);
            teacherStudentMapping.put(teacherName, students);
        }
    }

    public Student findStudent(String studentName){
        return studentMap.get(studentName);
    }

    public Teacher findTeacher(String teacherName){
        return teacherMap.get(teacherName);
    }

    public List<String> findStudentsFromTeacher(String teacherName){
        return teacherStudentMapping.getOrDefault(teacherName, new ArrayList<>());
    }

    public List<String> findAllStudents(){
        return new ArrayList<>(studentMap.keySet());
    }

    public void deleteTeacher(String teacherName){
        teacherMap.remove(teacherName);
        teacherStudentMapping.remove(teacherName);
    }

    public void deleteAllTeachers(){
        teacherMap.clear();
        teacherStudentMapping.clear();
    }
}
