package peaksoft.services;

import peaksoft.dao.StudentDao;
import peaksoft.dao.StudentDaoImpl;
import peaksoft.models.Student;

import java.util.List;

/**
 * name : kutman
 **/
public class StudentServicesImpl implements StudentServices {
    StudentDao studentDao = new StudentDaoImpl();

    @Override
    public String createTable() {
        studentDao.createTable();
        return "успешно!";
    }

    @Override
    public String saveStudents(Student student) {
        studentDao.saveStudents(student);
        return "успешно!";

    }

    @Override
    public Student findByStudentId(Long id) {
        return studentDao.findByStudentId(id);
    }

    @Override
    public String updateStudent(Long id, Student newStudent) {
        studentDao.updateStudent(id,newStudent);
        return "yes";
    }

    @Override
    public String deleteStudent(Long id) {
        studentDao.deleteStudent(id);
        return "yes1";
    }

    public List<Student> getAllStudents() {
        return studentDao.getAllStudentsSortByAge();

    }
}
