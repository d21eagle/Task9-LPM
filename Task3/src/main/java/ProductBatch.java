import java.util.Arrays;
import java.util.Objects;

public class ProductBatch {

    private final String specification;
    private final PackedProduct[] products;

    // Конструктор по произвольному набору упаковок товаров
    public ProductBatch(String specification, PackedProduct... products) {
        if (specification == null) throw new IllegalArgumentException();
        this.specification = specification;
        this.products = products;
    }

    public String getSpecification() {
        return specification;
    }

    public PackedProduct[] getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductBatch)) return false;
        ProductBatch that = (ProductBatch) o;
        return Objects.equals(getSpecification(), that.getSpecification()) && Arrays.equals(getProducts(), that.getProducts());
    }

    @Override
    public int hashCode() {
        int res = Objects.hash(getSpecification());
        res = 31 * res + Arrays.hashCode(getProducts());
        return res;
    }

    @Override
    public String toString() {
        return "Партия товаров: " + specification +
                " Товары: \n" + Arrays.toString(products);
    }

    // Суммарная масса брутто всех товаров в партии
    public double getWeight() {
        return GrossSum.getProductWeight(products);
    }
}
