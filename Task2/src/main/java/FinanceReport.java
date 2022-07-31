import java.io.Serializable;

public class FinanceReport implements Serializable {

    private final Payment[] reports;
    private final int arrOfLengths;
    private String formerName;
    private int formDay;
    private int formMonth;
    private int formYear;

    // Конструкторы
    public FinanceReport(int n)
    {
        reports = new Payment[n];
        arrOfLengths = n;
        for ( int i = 0; i < reports.length; i++)
            reports[i] = new Payment("ФИО плательщика", 1, 1, 1970, 0);
    }

    public FinanceReport() {
        this.arrOfLengths = 0;
        reports = new Payment[arrOfLengths];
        this.formerName = "UnknownFormer";
        this.formDay = 0;
        this.formMonth = 0;
        this.formYear = 0;
    }

    public FinanceReport(FinanceReport report) {
        this.reports = report.getReports();
        this.arrOfLengths = report.getPayments();
        this.formerName = report.getFormerName();
        this.formDay = report.getFormDay();
        this.formMonth = report.getFormMonth();
        this.formYear = report.getFormYear();
    }

    // Геттеры и сеттеры
    public String getFormerName() {
        return formerName;
    }

    public void setFormerName(String formerName) {
        this.formerName = formerName;
    }

    public int getFormDay() {
        return formDay;
    }

    public void setFormDay(int formDay) {
        this.formDay = formDay;
    }

    public int getFormMonth() {
        return formMonth;
    }

    public void setFormMonth(int formMonth) {
        this.formMonth = formMonth;
    }

    public int getFormYear() {
        return formYear;
    }

    public void setFormYear(int formYear) {
        this.formYear = formYear;
    }

    // Доступ к i-му платежу (чтение)
    public Payment getReports(int i) {
        return reports[i];
    }

    // Доступ к i-му платежу (запись)
    public void setReports(Payment reports, int i) {
        this.reports[i] = reports;
    }

    // Получение количества платежей
    public int getPayments() {
        return arrOfLengths;
    }

    public Payment[] getReports() {
        return reports;
    }

    @Override
    public boolean equals(Object rep) {
        if (this == rep) return true;
        if (!(rep instanceof FinanceReport)) return false;
        FinanceReport rep1 = (FinanceReport) rep;
        return getPayments() == rep1.getPayments()
                && getFormDay() == rep1.getFormDay()
                && getFormMonth() == rep1.getFormMonth()
                && getFormYear() == rep1.getFormYear()
                && getFormerName().equals(rep1.getFormerName());
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        StringBuilder n = new StringBuilder();
        String head = "[Автор: %s, дата: %d.%d.%d, Платежи: [\n";
        String t = "\t Плательщик: %s, дата: %d.%d.%d сумма: %d руб. %d коп.\n";
        String t_last = "\t Плательщик: %s, дата: %d.%d.%d сумма: %d руб. %d коп.\n";
        String brackets = "]]";
        n.append(String.format(head, getFormerName(), getFormDay(), getFormMonth(), getFormYear()));
        for (int i = 0; i < reports.length; i++)
        {
            if(i == reports.length - 1) {
                n.append(String.format(t_last, reports[i].getFullName(), reports[i].getDate(), reports[i].getMonth(), reports[i].getYear(), reports[i].getPaySum()/100, reports[i].getPaySum()%100));
            }
            else {
                n.append(String.format(t, reports[i].getFullName(), reports[i].getDate(), reports[i].getMonth(), reports[i].getYear(), reports[i].getPaySum()/100, reports[i].getPaySum()%100));
            }
        }
        n.append(String.format("%s", brackets));
        return n.toString();
    }
}
