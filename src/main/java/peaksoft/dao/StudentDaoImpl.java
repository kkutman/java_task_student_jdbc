package peaksoft.dao;

import peaksoft.config.DataBaseConnection;
import peaksoft.enums.Gender;
import peaksoft.models.Student;

import java.sql.*;
import java.util.*;


/**
 * name : kutman
 **/
public class StudentDaoImpl implements StudentDao {
    private Connection connection;

    public StudentDaoImpl() {
        this.connection = DataBaseConnection.getConnection();
    }

    @Override
    public void createTable() {
        String query = """
                create table if not exists students(
                id serial primary key,
                name varchar(50) not null,
                age int not null );
                """;
        try(Statement statement = connection.createStatement();) {
            statement.execute(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void saveStudents(Student student) {
        String SQLquery = """
                insert into students(name,age)
                values(?,?);
                """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQLquery)) {
            preparedStatement.setString(1,student.getName());
            preparedStatement.setByte(2, student.getAge());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Student findByStudentId(Long id) {
        String sqlqueri = """
              select * from students where id = ?; 
                """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlqueri)) {
            preparedStatement.setLong(1,id);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            Student student = new Student();
            if (!resultSet.next())
            {
                System.out.println("null");
            }
            student.setId(resultSet.getLong(1));
            student.setName(resultSet.getString(2));
            student.setAge(resultSet.getByte(3));
            resultSet.close();
            return student;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateStudent(Long id, Student newStudent) {
        String query1 = """
                update students set name = ?, age = ?
                where id = ?""";
        try(PreparedStatement statement = connection.prepareStatement(query1);) {
            statement.setString(1,newStudent.getName());
            statement.setByte(2,newStudent.getAge());
            statement.setLong(3,id);
            int i = statement.executeUpdate();
            if (i>0){
                System.out.println("trues");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void deleteStudent(Long id) {
        String query = """
               delete  from students where id = ?;
                """;
        try( PreparedStatement preparedStatement = connection.prepareStatement(query);) {
           preparedStatement.setLong(1,id);
           preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteByStudentId(Long studentID) {
        String query = """
                delete from students where id = ?;
                """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setLong(1,studentID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> getAllStudentsSortByAge() {
//        List<Student>students = new ArrayList<>();
//        String query3 = """
//                select * from students order by age desc;
//                """;
//        try(PreparedStatement preparedStatement = connection.prepareStatement(query3)) {
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                students.add(new Student(resultSet.getString(1), resultSet.getByte(2)));
//            }
//
//            resultSet.close();   preparedStatement.executeQuery();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return students;
        List<Student> studentList = new ArrayList<>();
        String query ="select * from students order by age";
        try( Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getByte("age"));
                studentList.add(student);
            }
            resultSet.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return studentList;
    }

    @Override
    public boolean checkByAge() {
        return false;
    }

    @Override
    public void addColumnGender(Gender gender) {
        String query = """
                alter type students add colum""";

    }

    @Override
    public Map<Gender, List<Student>> gruopByGender() {
        return null;
    }

    @Override
    public void deleteAllStudents() {

    }

    @Override
    public List<Student> getallStudents() {
        List<Student>students = new ArrayList<>();

        String query = """
                select * from students;
                """;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getLong(1));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getByte(3));
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
}
