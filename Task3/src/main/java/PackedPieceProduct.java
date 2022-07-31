import java.util.Objects;

public class PackedPieceProduct extends PackedProduct {

    private final int count;
    private final PieceProduct product;

    public PackedPieceProduct(ProductPackage productPackaging, int count, PieceProduct product) {
        super(product.getNameOfProduct(), product.getSpecification(), productPackaging);
        if (count < 0) throw new IllegalArgumentException("Отрицательное количество штук!");
        this.count = count;
        this.product = product;
    }

    // Получение количества штук товара
    public int getCount() {
        return count;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PackedPieceProduct)) return false;
        PackedPieceProduct that = (PackedPieceProduct) o;
        return getCount() == that.getCount() && Objects.equals(getProductPackage(),
                that.getProductPackage()) && Objects.equals(getProduct(), that.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductPackage(), getCount(), getProduct());
    }

    @Override
    public String toString() {
        return "Упакованный штучный товар [" +
                "Наименование = '" + product.getNameOfProduct() + '\'' +
                ", Тип упаковки = '" + productPackage.getNameOfPackage() + '\'' +
                ", Штук = " + count +
                ']' + '\n';
    }

    // Масса нетто
    public double getNetWeight() {
        return count * product.getWeight();
    }

    // Масса брутто
    public double getGrossWeight() {
        return count * product.getWeight() + productPackage.getWeightOfPackage();
    }
}
