public class FinanceReportProcessor {

    public static FinanceReport specCharReport(FinanceReport reports, char a) {

        FinanceReport n = new FinanceReport(reports.getPayments());
        for (int i = 0; i < reports.getPayments(); i++) {
            if (reports.getReports(i).getFullName().equals(""))
                throw new IllegalArgumentException("empty name");
            if (Character.toLowerCase((char) reports.getReports(i).getFullName().charAt(0)) == Character.toLowerCase((char)a))
                n.setReports(reports.getReports(i), i);
        }
        n.setFormerName("ФИО составителя");
        n.setFormDay(10); n.setFormMonth(12); n.setFormYear(2021);
        return n;
    }
    public static FinanceReport getPayBySize(FinanceReport reports, double a) {
        FinanceReport n = new FinanceReport(reports.getPayments());
        for (int i = 0; i < reports.getPayments(); i++) {
            if (Double.compare(a,reports.getReports(i).getPaySum()) > 0)
                    n.setReports(reports.getReports(i), i);
        }
        n.setFormerName("ФИО составителя");
        n.setFormDay(10); n.setFormMonth(12); n.setFormYear(2021);
        return n;
    }
}