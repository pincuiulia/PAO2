package model;

public class Student extends Person {
    private String studentNumber;
    private double averageMark;
    private String className;

    public Student(String name, String phoneNumber, String email, String studentNumber, double averageMark, String className) {
        super(name, phoneNumber, email);
        this.studentNumber = studentNumber;
        this.averageMark = averageMark;
        this.className = className;
    }

    // Getteri și Setteri pentru noile câmpuri
    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
