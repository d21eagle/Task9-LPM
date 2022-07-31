import java.util.Objects;

public class PackedWeightProduct extends PackedProduct {

    private final double weight;
    private final WeightProduct product;

    // Конструтор по товару, массе товара и упаковке
    public PackedWeightProduct(ProductPackage productPackage, double weight, WeightProduct product) {
        super(product.getNameOfProduct(), product.getSpecification(), productPackage);
        if (Double.compare(weight, 0.0) == -1) throw new IllegalArgumentException("Отрицательный вес!");
        this.weight = weight;
        this.product = product;
    }

    public double getWeight() {
        return weight;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PackedWeightProduct)) return false;
        PackedWeightProduct that = (PackedWeightProduct) o;
        return Double.compare(that.getWeight(), getWeight()) == 0 && Objects.equals(getProductPackage(),
                that.getProductPackage()) && Objects.equals(getProduct(), that.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductPackage(), getWeight(), getProduct());
    }

    @Override
    public String toString() {
        return "Упакованный весовой товар [" +
                "Наименование = '" + product.getNameOfProduct() + '\'' +
                ", Тип упаковки = '" + productPackage.getNameOfPackage() + '\'' +
                ", Вес = " + weight + "(кг)" +
                ']' + '\n';
    }

    // Масса нетто
    public double getNetWeight() {
        return weight;
    }

    // Масса брутто
    public double getGrossWeight() {
        return weight + productPackage.getWeightOfPackage();
    }
}
