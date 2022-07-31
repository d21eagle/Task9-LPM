import java.util.Objects;
public class PieceProduct extends Product {

    private final double weight;

    public PieceProduct(String nameOfProduct, String specification, double weight) {
        super(nameOfProduct, specification);
        if (Double.compare(weight, 0.0) == -1) throw new IllegalArgumentException();
        this.weight = weight;
    }

    public PieceProduct(PieceProduct product) {
        super(product);
        weight = product.getWeight();
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PieceProduct)) return false;
        if (!super.equals(o)) return false;
        PieceProduct that = (PieceProduct) o;
        return Double.compare(that.getWeight(), getWeight()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWeight());
    }

    @Override
    public String toString() {
        return "Штучный товар [" +
                "Наименование = '" + nameOfProduct + '\'' +
                ", Описание = '" + specification + '\'' +
                ", Вес одной штуки = " + weight + "(кг)" +
                ']';
    }
}
