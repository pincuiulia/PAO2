package service;

import model.Student;
import model.Profesor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class StorageService {
    private List<Student> students = new ArrayList<>();
    private List<Profesor> professors = new ArrayList<>();

    public void addStudent(Student student) {
        if (findPersonByName(student.getName()).isEmpty()) {
            students.add(student);
        } else {
            System.out.println("Already existing");
        }
    }

    public void addProfesor(Profesor profesor) {
        if (findPersonByName(profesor.getName()).isEmpty()) {
            professors.add(profesor);
        } else {
            System.out.println("Already existing");
        }
    }

    public Optional<Object> findPersonByName(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return Optional.of(student);
            }
        }
        for (Profesor profesor : professors) {
            if (profesor.getName().equals(name)) {
                return Optional.of(profesor);
            }
        }
        return Optional.empty();
    }

    // Continuarea StorageService.java

    public void readPersonByName(String name) {
        Optional<Object> person = findPersonByName(name);
        person.ifPresentOrElse(
                p -> {
                    if (p instanceof Student) {
                        Student student = (Student) p;
                        System.out.println("name: " + student.getName() +
                                "\nphone number: " + student.getPhoneNumber() +
                                "\nemail: " + student.getEmail() +
                                "\nstudent number: " + student.getStudentNumber() +
                                "\naverage mark: " + student.getAverageMark() +
                                "\nclass: " + student.getClassName());
                    } else if (p instanceof Profesor) {
                        Profesor profesor = (Profesor) p;
                        System.out.println("name: " + profesor.getName() +
                                "\nphone number: " + profesor.getPhoneNumber() +
                                "\nemail: " + profesor.getEmail() +
                                "\ncourse: " + profesor.getCourse() +
                                "\nyear: " + profesor.getYear());
                    }
                },
                () -> System.out.println("Not existing")
        );
    }

}
