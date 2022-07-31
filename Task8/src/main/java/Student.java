public class Student extends Human {

    private String name;
    private String surname;
    private final String faculty;

    Student(String name, String surname, String faculty) {
        super(name, surname);
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", faculty='" + faculty + '\'' +
                '}';
    }
}
