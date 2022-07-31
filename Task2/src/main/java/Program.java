public class Program {

    public static void main(String[] args) {

        System.out.println();
        System.out.println("--Задания 1-6--");
        System.out.println(">>Строка, состоящая из N копий строки s, записанных подряд");
        String string = "один"; int copies = 5;
        String lineCopy = StringProcessor.lineCopy(string, copies);
        System.out.println("Строка для копирования: '" + string + "'.");
        System.out.println("Количество копий: " + copies);
        System.out.println("Результат копирования: '" + lineCopy + "'.");
        System.out.println();

        System.out.println(">>Количество вхождений второй строки в первую");
        String origStr = "один триллион один миллион одиннадцать";
        String subStr = "один";
        int Occur2to1 = StringProcessor.lineOccurrence(origStr, subStr);
        System.out.println("Строка 1: '" + origStr + "'.");
        System.out.println("Строка 2: '" + subStr + "'.");
        System.out.println("Количество вхождений второй строки в первую: " + Occur2to1);
        System.out.println();

        System.out.println(">>Замена 1, 2, 3");
        String origString = "6475634574281";
        String changedString = StringProcessor.replace123(origString);
        System.out.println("Строка для замены: '" + origString + "'.");
        System.out.println("Изменённая строка: '" + changedString + "'.");
        System.out.println();

        System.out.println(">>Удаление каждого второго по счету символа");
        StringBuilder binaryString = new StringBuilder("10101010101010101");
        System.out.println("Исходная строка: '" + binaryString + "'.");
        StringProcessor.delSecondSymbol(binaryString);
        System.out.println("Изменённая строка: '" + binaryString + "'.");
        System.out.println();

        System.out.println(">>Строка, в которой все слова идут в обратном порядке, а пробелы остаются на местах");
        String origString1 = "abc ";
        String reverseString = StringProcessor.lineReverse(origString1);
        System.out.println("Строка для реверса: '" + origString1 + "'.");
        System.out.println("Реверсивная строка: '" + reverseString + "'.");
        System.out.println("\n");

        System.out.println("--Задания 7-11--");
        FinanceReport report1 = new FinanceReport(5);
        int reportsCount = report1.getPayments();
        System.out.println("Количество платежей: " + reportsCount);

        // Данные о составителе
        report1.setFormerName("ФИО составителя");
        report1.setFormDay(28);
        report1.setFormMonth(11);
        report1.setFormYear(2021);

        // Ввод данных плательщиков
        Payment human1 = new Payment("Федоров Мирон Янович", 1, 11, 2021, 50000000);
        Payment human2 = new Payment("Хинтер Дмитрий Фёдорович", 5, 11, 2021, 30000000);
        Payment human3 = new Payment("Пушкин Александр Сергеевич", 22, 5, 1830, 80000000);
        Payment human4 = new Payment("Толстой Лев Николаевич", 11, 7, 1890, 45000000);
        Payment human5 = new Payment("Кинг Мартин Лютер", 17, 1, 1960, 35000000);

        // Заполнение таблицы платежей
        report1.setReports(human1, 0);
        report1.setReports(human2, 1);
        report1.setReports(human3, 2);
        report1.setReports(human4, 3);
        report1.setReports(human5, 4);

        // Вывод массива платежей
        String repOut = report1.toString();
        System.out.println(repOut);
        System.out.println();

        // Получение сводки о конкретном платеже
        Payment payInfo = report1.getReports(2);
        System.out.println("Информация о платеже 3:\n" + payInfo + "\n");

        // Хэшкоды плательщиков
        int hCode1 = human1.hashCode();
        System.out.printf("Код плательщика %s: %d\n", human1.getFullName(), hCode1);
        int hCode2 = human2.hashCode();
        System.out.printf("Код плательщика %s: %d\n",  human2.getFullName(), hCode2);

        if (human1.equals(human2)) {
            System.out.println("Платежи совпадают!");
        }
        else {
            System.out.println("Платежи не совпадают!");
        }
        System.out.println();

        // Копирование исходного массива платежей
        FinanceReport report2 = new FinanceReport(report1);
        String repOut3 = report2.toString();
        System.out.println(repOut3);

        FinanceReport reportInfo = FinanceReportProcessor.specCharReport(report1, 'ф');
        System.out.println("\nПлатежи всех людей, чья фамилия начинается на указанный символ:");
        String repOut1 = reportInfo.toString();
        System.out.println(repOut1);

        FinanceReport reportInfo1 = FinanceReportProcessor.getPayBySize(report1, 45000000);
        System.out.println("\nПлатежи, размер которых меньше заданной величины:");
        String repOut2 = reportInfo1.toString();
        System.out.println(repOut2);
    }
}
