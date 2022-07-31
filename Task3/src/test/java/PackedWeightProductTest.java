import static org.junit.Assert.*;

public class PackedWeightProductTest {
    PackedWeightProduct product = new PackedWeightProduct(new ProductPackage(1.0, "Пакет"),
            20.0, new WeightProduct("Угли", "Древесные угли", 20.0));

    @org.junit.Test
    public void PackedWeightProductNegativeWeightTest() {
        try {
            PackedWeightProduct product = new PackedWeightProduct(new ProductPackage(0.5, "Пакет"),
                    -20.0, new WeightProduct("Угли", "Древесные угли", -20.0));
        } catch (IllegalArgumentException err) {
            System.err.println("Отрицательный вес!");
        }
    }

    @org.junit.Test
    public void testGetNetWeight() {
        assertEquals(product.getNetWeight(), 20.0, 0);
    }

    @org.junit.Test
    public void testGetGrossWeight() {
        assertEquals(product.getGrossWeight(), 21.0,0);
    }
}
