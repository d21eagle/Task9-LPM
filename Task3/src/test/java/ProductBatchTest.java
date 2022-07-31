import static org.junit.Assert.*;

public class ProductBatchTest {
    ProductPackage productPackage = new ProductPackage(1.0, "Коробка");
    PackedWeightProduct[] weightProducts = {
            new PackedWeightProduct(productPackage, 10.0,
                    new WeightProduct("Апельсин", "Спелый", 10.0))};

    PackedPieceProduct[] pieceProducts = {
            new PackedPieceProduct(productPackage, 10,
                    new PieceProduct("Игрушка", "6+", 10.0))};

    ProductBatch productBatch = new ProductBatch("Партия 1", weightProducts);

    @org.junit.Test
    public void testGetSpecification() {
        assertEquals(productBatch.getSpecification(), "Партия 1");
    }
/*
    @org.junit.Test
    public void testGetProducts() {
        assertEquals(productBatch.getProducts(), weightProducts);
    }
*/
    @org.junit.Test
    public void testGetGrossWeight() {
        assertEquals(productBatch.getWeight(), 11.0, 0);
    }
}