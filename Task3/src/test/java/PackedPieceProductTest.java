import static org.junit.Assert.*;

public class PackedPieceProductTest {

    PieceProduct product = new PieceProduct("Апельсин", "Сочный, спелый", 0.2);
    PackedPieceProduct packagedProduct = new PackedPieceProduct(new ProductPackage(0.1, "Пакет"),
            10, product);


    @org.junit.Test
    public void testGetCount() {
        assertEquals(packagedProduct.getCount(), 10);
    }

    @org.junit.Test
    public void testGetProduct() {
        assertEquals(packagedProduct.getProduct(), product);
    }

    @org.junit.Test
    public void testGetNetWeight() {
        assertEquals(packagedProduct.getNetWeight(), 2.0, 0);
    }

    @org.junit.Test
    public void testGetGrossWeight() {
        assertEquals(packagedProduct.getGrossWeight(), 2.1, 0);
    }
}
