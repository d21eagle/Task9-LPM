import static org.junit.Assert.*;

public class WeightProductTest {

    @org.junit.Test
    public void WeightProductNullNameTest() {
        try {
            WeightProduct test1 = new WeightProduct(null, "Specification", 4);
        } catch (IllegalArgumentException err) {
            System.err.println("Наименование товара = null!");
        }
    }

    @org.junit.Test
    public void WeightProductNullSpecificationTest() {
        try {
            WeightProduct test2 = new WeightProduct("Name", null, 4);
        } catch (IllegalArgumentException err) {
            System.err.println("Описание товара = null!");
        }
    }

    @org.junit.Test
    public void WeightProductNegativeWeightTest() {
        try {
            WeightProduct test3 = new WeightProduct("Name", "Specification", -8);
        } catch (IllegalArgumentException err) {
            System.err.println("Отрицательный вес!");
        }
    }
}
