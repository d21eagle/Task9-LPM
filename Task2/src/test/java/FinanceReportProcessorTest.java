import static org.junit.Assert.*;

public class FinanceReportProcessorTest {

    @org.junit.Test // (Тест) Получение платежей всех людей, чья фамилия начинается на указанный символ
    public void specCharReportTest1() {
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
                "\t Плательщик: ФИО плательщика, дата: 1.1.1970 сумма: 0 руб. 0 коп.\n" +
                "]]";
        assertEquals(expected, FinanceReportProcessor.specCharReport(test1, 'ф').toString());
    }

    @org.junit.Test // (Тест) Получение платежей всех людей, чья фамилия начинается на указанный символ
    public void specCharReportTest2() {
        Payment human1 = new Payment("Федоров Мирон Янович", 13, 11, 2015, 30);
        Payment human2 = new Payment("Хинтер Дмитрий Фёдорович", 5, 6, 2021, 15);
        Payment human3 = new Payment("Филатов Иван Иванович", 10, 7, 2011, 30);
        Payment human4 = new Payment("Петров Юрий Васильевич", 6, 8, 2011, 18);
        Payment human5 = new Payment("Филонов Виктор Игоревич", 2, 9, 2011, 10);
        FinanceReport test1 = new FinanceReport(5);
        test1.setFormerName("ФИО составителя");
        test1.setFormDay(10);
        test1.setFormMonth(12);
        test1.setFormYear(2021);
        test1.setReports(human1, 0);
        test1.setReports(human2, 1);
        test1.setReports(human3, 2);
        test1.setReports(human4, 3);
        test1.setReports(human5, 4);
        String expected = "[Автор: ФИО составителя, дата: 10.12.2021, Платежи: [\n" +
                "\t Плательщик: Федоров Мирон Янович, дата: 13.11.2015 сумма: 0 руб. 30 коп.\n" +
                "\t Плательщик: ФИО плательщика, дата: 1.1.1970 сумма: 0 руб. 0 коп.\n" +
                "\t Плательщик: Филатов Иван Иванович, дата: 10.7.2011 сумма: 0 руб. 30 коп.\n" +
                "\t Плательщик: ФИО плательщика, дата: 1.1.1970 сумма: 0 руб. 0 коп.\n" +
                "\t Плательщик: Филонов Виктор Игоревич, дата: 2.9.2011 сумма: 0 руб. 10 коп.\n" +
                "]]";
        assertEquals(expected, FinanceReportProcessor.specCharReport(test1, 'ф').toString());
    }

    @org.junit.Test // (Тест) Получение платежей всех людей, чья фамилия начинается на указанный символ
    public void specCharReportTest3() {
        try {
            Payment human1 = new Payment("Федоров Мирон Янович", 13, 11, 2015, 30);
            Payment human2 = new Payment("", 5, 6, 2021, 15);
            Payment human3 = new Payment("Филатов Иван Иванович", 10, 7, 2011, 30);
            Payment human4 = new Payment("", 6, 8, 2011, 18);
            Payment human5 = new Payment("Филонов Виктор Игоревич", 2, 9, 2011, 10);
            FinanceReport test1 = new FinanceReport(5);
            test1.setFormerName("ФИО составителя");
            test1.setFormDay(10);
            test1.setFormMonth(12);
            test1.setFormYear(2021);
            test1.setReports(human1, 0);
            test1.setReports(human2, 1);
            test1.setReports(human3, 2);
            test1.setReports(human4, 3);
            test1.setReports(human5, 4);
        } catch (IllegalArgumentException err) {
            System.err.println("Empty Payer's name!");
        }
    }

    @org.junit.Test // (Тест) Получение всех платежей, размер которых меньше заданной величины
    public void getPayBySizeTest1() {
        Payment human1 = new Payment("Федоров Мирон Янович", 13, 11, 2015, 30);
        Payment human2 = new Payment("Хинтер Дмитрий Фёдорович", 5, 6, 2021, 15);
        Payment human3 = new Payment("Иванов Иван Иванович", 10, 7, 2011, 30);
        Payment human4 = new Payment("Петров Юрий Васильевич", 6, 8, 2011, 18);
        Payment human5 = new Payment("Усачев Виктор Игоревич", 2, 9, 2011, 10);
        FinanceReport test2 = new FinanceReport(5);
        test2.setFormerName("ФИО составителя");
        test2.setFormDay(10);
        test2.setFormMonth(12);
        test2.setFormYear(2021);
        test2.setReports(human1, 0);
        test2.setReports(human2, 1);
        test2.setReports(human3, 2);
        test2.setReports(human4, 3);
        test2.setReports(human5, 4);
        int sum = 20;
        String expected = "[Автор: ФИО составителя, дата: 10.12.2021, Платежи: [\n" +
                "\t Плательщик: ФИО плательщика, дата: 1.1.1970 сумма: 0 руб. 0 коп.\n" +
                "\t Плательщик: Хинтер Дмитрий Фёдорович, дата: 5.6.2021 сумма: 0 руб. 15 коп.\n" +
                "\t Плательщик: ФИО плательщика, дата: 1.1.1970 сумма: 0 руб. 0 коп.\n" +
                "\t Плательщик: Петров Юрий Васильевич, дата: 6.8.2011 сумма: 0 руб. 18 коп.\n" +
                "\t Плательщик: Усачев Виктор Игоревич, дата: 2.9.2011 сумма: 0 руб. 10 коп.\n" +
                "]]";
        assertEquals(expected,FinanceReportProcessor.getPayBySize(test2, sum).toString());
    }
}
