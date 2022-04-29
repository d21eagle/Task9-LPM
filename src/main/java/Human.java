import java.util.Objects;

public class Human {

    private String surname;
    private String name;
    private String middleName;
    private int age;
    private Gender gender;

    public Human(String surname, String name, String middleName, int age, Gender gender) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.age = age;
        this.gender = gender;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age
                && Objects.equals(surname, human.surname)
                && Objects.equals(name, human.name)
                && Objects.equals(middleName, human.middleName)
                && gender == human.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, middleName, age, gender);
    }

    @Override
    public String toString() {
        return "Human {" +
                "name='" + surname + '\'' +
                ", surname='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}