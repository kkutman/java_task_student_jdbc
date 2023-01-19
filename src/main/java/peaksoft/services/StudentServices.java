package peaksoft.services;

import peaksoft.models.Student;

/**
 * name : kutman
 **/
public interface StudentServices {
    //create table;
    String createTable();
    //save students;
    String saveStudents(Student student);
    //find by student id;
    Student findByStudentId(Long id);
    //update student;
    String  updateStudent(Long id,Student newStudent);
    //delete
    String deleteStudent(Long id);

}
