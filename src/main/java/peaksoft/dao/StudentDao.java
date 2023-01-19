package peaksoft.dao;

import peaksoft.enums.Gender;
import peaksoft.models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * name : kutman
 **/
public interface StudentDao {
    //create table;
    void createTable();
    //save students;
    void saveStudents(Student student);
    //find by student id;
    Student findByStudentId(Long id);
    //update student;
    void  updateStudent(Long id,Student newStudent);
    //delete
    void deleteStudent(Long id);

    //findAll
    List<Student>getallStudents();
    //delete
    void deleteByStudentId(Long studentID);

    List<Student> getAllStudentsSortByAge();

    boolean checkByAge();

    void addColumnGender(Gender gender);

    Map<Gender, List<Student>> gruopByGender();

    void deleteAllStudents(); //ddl

}
