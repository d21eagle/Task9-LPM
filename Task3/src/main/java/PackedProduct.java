abstract public class PackedProduct extends Product {

    protected final ProductPackage productPackage;

    public PackedProduct(String name, String specification, ProductPackage productPackage) {
        super(name, specification);
        this.productPackage = productPackage;
    }

    public ProductPackage getProductPackage() {
        return productPackage;
    }

    abstract public double getNetWeight();

    abstract public double getGrossWeight();
}
