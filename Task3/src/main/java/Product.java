import java.util.Objects;

public class Product {

    protected String nameOfProduct;
    protected String specification;

    public Product(String nameOfProduct, String specification) {
        if (nameOfProduct == null || specification == null) throw new IllegalArgumentException();
        this.nameOfProduct = nameOfProduct;
        this.specification = specification;
    }

    public Product(Product product) {
        this.nameOfProduct = product.getNameOfProduct();
        this.specification = product.getSpecification();
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public String getSpecification() {
        return specification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getNameOfProduct(), product.getNameOfProduct())
                && Objects.equals(getSpecification(), product.getSpecification());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameOfProduct(), getSpecification());
    }

    @Override
    public String toString() {
        return "Товар [" +
                "Наименование = '" + nameOfProduct + '\'' +
                ", Описание = '" + specification + '\'' +
                ']';
    }
}
