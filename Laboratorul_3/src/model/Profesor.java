package model;

public class Profesor extends Person {
    private String course;
    private int year;

    public Profesor(String name, String phoneNumber, String email, String course, int year) {
        super(name, phoneNumber, email);
        this.course = course;
        this.year = year;
    }

    // Getteri și Setteri pentru noile câmpuri
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
