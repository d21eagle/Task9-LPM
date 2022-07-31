import static org.junit.Assert.*;

public class ProductPackageTest {

    @org.junit.Test
    public void ProductPackageNullNameTest() {
        try {
            ProductPackage test1 = new ProductPackage(5, null);
        } catch (IllegalArgumentException err) {
            System.err.println("Название упаковки = null!");
        }
    }

    @org.junit.Test
    public void ProductPackageNegativeWeightTest() {
        try {
            ProductPackage test2 = new ProductPackage(-5, "Name");
        } catch (IllegalArgumentException err) {
            System.err.println("Отрицательный вес упаковки!");
        }
    }
}