import java.util.Objects;
import java.io.Serializable;

public class Payment implements Serializable {

    private String fullName;
    private int date;
    private int month;
    private int year;
    private int paySum;

    // Конструкторы
    public Payment() {
        this.fullName = "UnknownPayment";
        this.date = 0;
        this.month = 0;
        this.year = 0;
        this.paySum = 0;
    }

    public Payment(String fullName, int d, int m, int y, int sum) {
        this.fullName = fullName;
        boolean flag;
        if (((year % 4 == 0) && (year % 100) != 0) || (year % 400 == 0)) {
            year = y;
            flag = false;
        }
        else if (year > 0) {
            this.year = y;
            flag = true;
        } else {
            throw new IllegalArgumentException("Неккоректно введен год");
        }
        if (1 <= m && m <= 12) month = m;
        else throw new IllegalArgumentException("Некорректно введен месяц!");
        if (month == 2 && flag == true) {
            if (1 <= d && d <= 29) date = d;
            else throw new IllegalArgumentException("Некорректно введен день!");
        }
        else {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                if (1 <= d && d <= 31) date = d;
                else throw new IllegalArgumentException("Некорректно введен день!");
            }
            else {
                if (month == 4 || month == 6 || month == 9 || month == 11) {
                    if (1 <= d && d <= 30) date = d;
                    else throw new IllegalArgumentException("Некорректно введен день!");
                }
            }
        }
        this.paySum = sum;
    }

    public Payment(Payment p) {
        this.fullName = p.getFullName();
        this.paySum = p.getPaySum();
        this.date = p.getDate();
        this.month = p.getMonth();
        this.year = p.getYear();
    }

    // Сеттеры и геттеры
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) { this.month = month; }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPaySum() {
        return paySum;
    }

    public void setPaySum(int paySum) {
        this.paySum = paySum;
    }

    @Override
    public boolean equals(Object h) {
        if (this == h) return true;
        if (h == null || getClass() != h.getClass()) return false;
        Payment payment = (Payment) h;
        return date == payment.date
                && month == payment.month && year == payment.year
                && Double.compare(payment.paySum, paySum) == 0
                && Objects.equals(fullName, payment.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, date, month, year, paySum);
    }

    @Override
    public String toString() {
        return "Плательщик: " + fullName +
                ", дата: " + date + '.' + month + '.' + year +
                " сумма: " + paySum / 100 + " руб. " + paySum % 100 + " коп.";
    }
}
