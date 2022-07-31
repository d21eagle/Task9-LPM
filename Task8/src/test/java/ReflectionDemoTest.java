import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class ReflectionDemoTest {

    @org.junit.Test
    public void getCountOfHumansTest() {

        Human human1 = new Human("Сергей","Иванов");
        Human human2 = new Human("Павел","Сидоров");
        Human human3 = new Human("Коля","Васечкин");
        List<Object> listOfSomething = new ArrayList<>();
        listOfSomething.add(human1);
        listOfSomething.add(human2);
        listOfSomething.add(human3);
        listOfSomething.add(1);
        listOfSomething.add("Hello");
        listOfSomething.add("");
        listOfSomething.add(null);
        Human human4 = new Human("Алексей","Мирный");
        listOfSomething.add(human4);
        Teacher teacher = new Teacher("Иван","Мартынов","Завуч");
        listOfSomething.add(teacher);
        assertEquals(ReflectionDemo.getCountOfHumans(listOfSomething), 5);
    }

    @org.junit.Test
    public void getNamesOfPublicMethodsTest() {

        Human human1 = new Human("Сергей","Иванов");
        List<String> str = List.of("getName", "toString", "getSurname", "wait", "wait", "wait", "equals", "hashCode", "getClass", "notify", "notifyAll");

        assertEquals(ReflectionDemo.getNamesOfPublicMethods(human1), str);
    }

    @org.junit.Test
    public void getNamesOfSuperClassesTest() {

        Teacher teacher = new Teacher("Иван","Мартынов","Завуч");
        List<String> str = List.of("Human", "java.lang.Object");

        assertEquals(ReflectionDemo.getNamesOfSuperClasses(teacher), str);
    }

    @org.junit.Test
    public void getNamesOfSuperClassesObjectTest() {

        Object obj = new Object();
        List<String> str = new ArrayList<>();

        assertEquals(ReflectionDemo.getNamesOfSuperClasses(obj), str);
    }
}