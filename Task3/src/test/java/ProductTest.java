import static org.junit.Assert.*;

public class ProductTest {

    @org.junit.Test
    public void ProductNullNameTest() {
        try {
            Product test1 = new Product(null, "Specification");
        } catch (IllegalArgumentException err) {
            System.err.println("Наименование товара = null!");
        }
    }

    @org.junit.Test
    public void ProductNullSpecificationTest() {
        try {
            Product test2 = new Product("Name", null);
        } catch (IllegalArgumentException err) {
            System.err.println("Описание товара = null!");
        }
    }
}
