import static org.junit.Assert.*;

public class FinanceReportTest {

    @org.junit.Test // Тест конструктора с параметрами
    public void FinanceReportParamTest() {
        Payment human1 = new Payment("Федоров Мирон Янович", 13, 11, 2015, 30);
        Payment human2 = new Payment();
        FinanceReport test1 = new FinanceReport(2);
        test1.setFormerName("ФИО составителя");
        test1.setFormDay(10);
        test1.setFormMonth(12);
        test1.setFormYear(2021);
        test1.setReports(human1, 0);
        test1.setReports(human2, 1);
        String expected = "[Автор: ФИО составителя, дата: 10.12.2021, Платежи: [\n" +
                "\t Плательщик: Федоров Мирон Янович, дата: 13.11.2015 сумма: 0 руб. 30 коп.\n" +
                "\t Плательщик: UnknownPayment, дата: 0.0.0 сумма: 0 руб. 0 коп.\n" +
                "]]";
        assertEquals(expected, test1.toString());
    }

    @org.junit.Test // Тест конструктора по умолчанию
    public void FinanceReportDefaultTest() {
        FinanceReport test2 = new FinanceReport();
        String expected = "[Автор: UnknownFormer, дата: 0.0.0, Платежи: [\n" + "]]";
        assertEquals(expected, test2.toString());
    }

    @org.junit.Test // Тест конструктора копирования
    public void FinanceReportCopyTest() {
        Payment human1 = new Payment("Федоров Мирон Янович", 13, 11, 2015, 30);
        Payment human2 = new Payment();
        FinanceReport test3 = new FinanceReport(2);
        test3.setFormerName("ФИО составителя");
        test3.setFormDay(10);
        test3.setFormMonth(12);
        test3.setFormYear(2021);
        test3.setReports(human1, 0);
        test3.setReports(human2, 1);
        FinanceReport test3Copy = new FinanceReport(test3);
        assertEquals(true, test3.equals(test3Copy));
    }

    @org.junit.Test // Тест записи в i-ый платеж
    public void setReportsTest() {
        Payment human1 = new Payment("Федоров Мирон Янович", 13, 11, 2015, 30);
        Payment human2 = new Payment();
        FinanceReport test4 = new FinanceReport(2);
        test4.setFormerName("ФИО составителя");
        test4.setFormDay(10);
        test4.setFormMonth(12);
        test4.setFormYear(2021);
        test4.setReports(human1, 0);
        test4.setReports(human2, 1);
        test4.setReports(human1, 1);
        String expected = "[Автор: ФИО составителя, дата: 10.12.2021, Платежи: [\n" +
                "\t Плательщик: Федоров Мирон Янович, дата: 13.11.2015 сумма: 0 руб. 30 коп.\n" +
                "\t Плательщик: Федоров Мирон Янович, дата: 13.11.2015 сумма: 0 руб. 30 коп.\n" +
                "]]";
        assertEquals(expected, test4.toString());
    }

    @org.junit.Test // Тест чтения i-ого платежа
    public void getReportsTest() {
        Payment human1 = new Payment("Федоров Мирон Янович", 13, 11, 2015, 30);
        FinanceReport test5 = new FinanceReport(2);
        test5.setFormerName("ФИО составителя");
        test5.setFormDay(10);
        test5.setFormMonth(12);
        test5.setFormYear(2021);
        test5.setReports(human1, 0);
        test5.setReports(human1, 1);
        assertEquals(true, human1.equals(test5.getReports(0)));
    }

    @org.junit.Test // Тест подсчета количества платежей
    public void getPaymentsTest() {
        FinanceReport test6 = new FinanceReport(2);
        assertEquals(2, test6.getPayments());
    }
}
