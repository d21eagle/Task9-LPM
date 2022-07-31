import static org.junit.Assert.*;

public class PaymentTest {

    @org.junit.Test // Тест конструктора по умолчанию
    public void PaymentDefaultTest() {
        Payment test1 = new Payment();
        assertEquals("Плательщик: UnknownPayment, дата: 0.0.0 сумма: 0 руб. 0 коп.", test1.toString());
    }

    @org.junit.Test // Тест конструктора с параметрами на некорректный ввод дня
    public void PaymentParamErrorTest1() {
        try {
            Payment test110 = new Payment("Федоров Мирон Янович", -13, 11, 2015, 20);
        } catch (IllegalArgumentException err) {
            System.err.println("Некорректно введен день!");
        }
    }

    @org.junit.Test // Тест конструктора с параметрами на некорректный ввод месяца
    public void PaymentParamErrorTest2() {
        try {
            Payment test112 = new Payment("Федоров Мирон Янович", 13, 13, 2015, 20);
        } catch (IllegalArgumentException err) {
            System.err.println("Некорректно введен месяц!");
        }
    }

    @org.junit.Test // Тест конструктора с параметрами на некорректный ввод года
    public void PaymentParamErrorTest3() {
        try {
            Payment test113 = new Payment("Федоров Мирон Янович", 13, 11, 0, 20);
        } catch (IllegalArgumentException err) {
            System.err.println("Некорректно введен год!");
        }
    }

    @org.junit.Test // Тест конструктора копирования
    public void PaymentCopyTest() {
        Payment test12 = new Payment("Федоров Мирон Янович", 13, 11, 2015, 20);
        Payment test13 = new Payment(test12);
        assertEquals(true, test12.equals(test13));
    }

    // Тесты геттеров
    @org.junit.Test
    public void getFullNameTest() {
        Payment test14 = new Payment("Федоров Мирон Янович", 13, 11, 2015, 20);
        assertEquals(test14.getFullName(), "Федоров Мирон Янович");
    }

    @org.junit.Test
    public void getDayTest() {
        Payment test15 = new Payment("Федоров Мирон Янович", 13, 11, 2015, 20);
        assertEquals(test15.getDate(), 13);
    }

    @org.junit.Test
    public void getMonthTest() {
        Payment test15 = new Payment("Федоров Мирон Янович", 13, 11, 2015, 20);
        assertEquals(test15.getMonth(), 11);
    }

    @org.junit.Test
    public void getYearTest() {
        Payment test15 = new Payment("Федоров Мирон Янович", 13, 11, 2015, 20);
        assertEquals(test15.getYear(), 2015);
    }

    @org.junit.Test // Тест метода equals()
    public void equalsTest() {
        Payment test21 = new Payment("Федоров Мирон Янович", 13, 11, 2015, 20);
        Payment test22 = new Payment("Федоров Мирон Янович", 13, 11, 2015, 20);
        assertEquals(true, test21.equals(test22));
    }

    @org.junit.Test // Тест метода hashCode()
    public void hashCodeTest() {
        Payment test4 = new Payment("Федоров Мирон Янович", 13, 11, 2015, 30);
        assertEquals(-1890450831, test4.hashCode());
    }

    @org.junit.Test // Тест метода toString()
    public void toStringTest() throws IllegalArgumentException {
        Payment test3 = new Payment("Федоров Мирон Янович", 13, 11, 2015, 30);
        assertEquals("Плательщик: Федоров Мирон Янович, дата: 13.11.2015 сумма: 0 руб. 30 коп.", test3.toString());
    }
}
