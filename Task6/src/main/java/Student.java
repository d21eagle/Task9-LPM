import java.util.Objects;

public class Student extends Human {

    private String faculty;

    public Student(String surname, String name, String middleName, int age, String faculty) {
        super(surname, name, middleName, age);
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
