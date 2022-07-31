import java.util.Objects;

public class ProductPackage {

    protected double weightOfPackage;
    protected String nameOfPackage;

    public ProductPackage(double weightOfPackage, String nameOfPackage) {
        if (Double.compare(weightOfPackage, 0.0) == -1) throw new IllegalArgumentException("Отрицательный вес!");
        if (nameOfPackage == null) throw new IllegalArgumentException();
        this.nameOfPackage = nameOfPackage;
        this.weightOfPackage = weightOfPackage;
    }

    public String getNameOfPackage() {
        return nameOfPackage;
    }

    public double getWeightOfPackage() {
        return weightOfPackage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductPackage)) return false;
        ProductPackage that = (ProductPackage) o;
        return Double.compare(that.getWeightOfPackage(), getWeightOfPackage()) == 0
                && getNameOfPackage().equals(that.getNameOfPackage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameOfPackage(), getWeightOfPackage());
    }

    @Override
    public String toString() {
        return "Упаковка [" +
                "Тип упаковки = '" + nameOfPackage + '\'' +
                ", Вес = " + weightOfPackage + "(кг)" +
                ']';
    }
}
