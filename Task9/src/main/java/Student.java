public class Student extends Human {

    private String university;
    private String faculty;
    private String special;

    public Student(String surname, String name, String middleName, int age, Gender gender, String university, String faculty, String special) {
        super(surname, name, middleName, age, gender);
        this.university = university;
        this.faculty = faculty;
        this.special = special;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getSpecial() {
        return special;
    }

    public String getUniversity() {
        return university;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}