import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import static org.junit.Assert.*;

public class LambdaTests {

    String s1 = "hello";
    String s2 = "hello world";
    String s3 = "Hi, I, am, from, Kazakhstan";

    Human human1 = new Human("Петров", "Пётр", "Петрович", 19 , Gender.MAN);
    Student human2 = new Student("Иванов", "Иван", "Иванович", 23, Gender.MAN, "ОмГУ", "ФМИТ", "МПБ");
    Human human3 = new Human("Семёнов", "Семён", "Семёнович", 19, Gender.MAN);
    Human human4 = new Human("Васечкин", "Николай", "Александрович", 19, Gender.MAN);

    // 1. Для строки символов получить ее длину
    @org.junit.Test
    public void Task1Test() {
        Function<String, Integer> lambda = LambdaDemo.getLengthOfString;
        assertEquals(Optional.of(5), Optional.ofNullable(LambdaRunner.run(lambda, s1)));
    }

    // 2. Для строки символов получить ее первый символ, если он существует, или null иначе
    @org.junit.Test
    public void Task2Test() {
        Function<String, Character> lambda = LambdaDemo.getFirstElem;
        assertEquals(Optional.of('h'),Optional.ofNullable(LambdaRunner.run(lambda, s1)));
    }

    // 3. Для строки проверить, что она не содержит пробелов
    @org.junit.Test
    public void Task3Test() {
        Function<String, Boolean> lambda = LambdaDemo.notHaveSpace;
        assertEquals(false, LambdaRunner.run(lambda, s2));
    }

    // 4. Слова в строке разделены запятыми, по строке получить количество слов в ней
    @org.junit.Test
    public void Task4Test() {
        Function<String, Integer> lambda = LambdaDemo.countWordsInString;
        assertEquals(Optional.of(5), Optional.ofNullable(LambdaRunner.run(lambda, s3)));
    }

    // 5. По человеку получить его возраст
    @org.junit.Test
    public void Task5Test() {
        Function<? super Human, Integer> lambda = LambdaDemo.getAgeOfHuman;
        assertEquals(Optional.of(19), Optional.ofNullable(LambdaRunner.run(lambda, human1)));
        assertEquals(Optional.of(23), Optional.ofNullable(LambdaRunner.run(lambda, human2)));
    }

    // 6. По двум людям проверить, что у них одинаковая фамилия
    @org.junit.Test
    public void Task6Test() {
        BiFunction<? super Human, ? super Human, Boolean> lambda = LambdaDemo.equalsSurname;
        assertEquals(false,LambdaRunner.biFunctionRun(lambda, human1, human2));
    }

    // 7. Получить фамилию, имя и отчество человека в виде одной строки (разделитель — пробел)
    @org.junit.Test
    public void Task7Test() {
        Function<? super Human, String> lambda = LambdaDemo.makeStringHuman;
        assertEquals("Петров Пётр Петрович", LambdaRunner.run(lambda, human1));
        assertEquals("Иванов Иван Иванович", LambdaRunner.run(lambda, human2));
    }

    // 8. Сделать человека старше на один год (по объекту Human создать новый объект)
    @org.junit.Test
    public void Task8Test() {
        Function<Human,Human> lambda = LambdaDemo.getOlder;
        assertEquals(20, LambdaRunner.run(lambda, human1).getAge());
        assertEquals(24, LambdaRunner.run(lambda, human2).getAge());
    }

    // 9. По трем людям и заданному возрасту maxAge проверить, что все три человека моложе maxAge.
    @org.junit.Test
    public void Task9Test() {
        int maxAge1 = 20;
        int maxAge2 = 18;

        assertTrue(LambdaDemo.equalsAge.checkHumansAndMaxAge(human1, human3, human4, maxAge1));
        assertFalse(LambdaDemo.equalsAge.checkHumansAndMaxAge(human1, human3, human4, maxAge2));
    }

    @org.junit.Test
    public void RunnerTest() {
        assertFalse(LambdaRunner.checkAgeRun(LambdaDemo.equalsAge, human1, human2, human3, 20));
    }
}