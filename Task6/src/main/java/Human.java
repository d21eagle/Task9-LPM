import java.util.Objects;

public class Human {

    private String surname;
    private String name;
    private String middleName;
    private int age;

    public Human(String surname, String name, String middleName, int age) {
        this.middleName = middleName;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Human(Human h) {
        this.surname = h.getSurname();
        this.name = h.getName();
        this.middleName = h.getMiddleName();
        this.age = h.getAge();
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age
                && Objects.equals(surname, human.surname)
                && Objects.equals(name, human.name)
                && Objects.equals(middleName, human.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, middleName, age);
    }

    @Override
    public String toString() {
        return "Human {" +
                "surname = '" + surname + '\'' +
                ", name = '" + name + '\'' +
                ", middleName = '" + middleName + '\'' +
                ", " + '}';
    }
}
