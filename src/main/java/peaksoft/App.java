package peaksoft;

import peaksoft.config.DataBaseConnection;
import peaksoft.models.Student;
import peaksoft.services.StudentServices;
import peaksoft.services.StudentServicesImpl;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        StudentServicesImpl services = new StudentServicesImpl();
        //System.out.println(services.deleteStudent(scanner.nextLong()));
        //services.getAllStudents().forEach(System.out::println);
        services.getAllStudents().forEach(System.out::println);



    }
}
