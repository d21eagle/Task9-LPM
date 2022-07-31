import static org.junit.Assert.*;

public class ProductServiceTest {

    private ProductBatch batch1;
    private ProductBatch batch2;

    @org.junit.Before
    public void testVocation() {
        ProductPackage productPackage1 = new ProductPackage(0.1, "Пакет");

        WeightProduct candies = new WeightProduct("Конфеты", "Шоколадные", 0.5);
        PackedWeightProduct candiesPack = new PackedWeightProduct(productPackage1, 2, candies);
        batch1 = new ProductBatch("Партия Конфет", candiesPack);

        ProductPackage productPackage2 = new ProductPackage(1, "Коробка");

        PackedPieceProduct[] pieceProducts = {
                new PackedPieceProduct(productPackage2, 1,
                        new PieceProduct("БП", "AeroCool", 11.0)),
                new PackedPieceProduct(productPackage2, 1,
                        new PieceProduct("БП", "Samsung", 11.0)),
                new PackedPieceProduct(productPackage2, 1,
                        new PieceProduct("ГПУ", "Nvidia GeForce", 11.0))
        };
        batch2 = new ProductBatch("Партия комплектующих", pieceProducts);
    }

    @org.junit.Test
    public void countByFilterTest1() {
        assertEquals(ProductService.countByFilter(batch1, new BeginStringFilter("Конфеты")), 1);
        assertEquals(ProductService.countByFilter(batch1, new ContainsOfStringFilter("Шоколадные")), 0);
        assertEquals(ProductService.countByFilter(batch1, new EndOfStringFilter(" ")), 0);
    }

    @org.junit.Test
    public void countByFilterTest2() {
        assertEquals(ProductService.countByFilter(batch2, new BeginStringFilter("БП")), 2);
        assertEquals(ProductService.countByFilter(batch2, new ContainsOfStringFilter("Samsung")), 0);
        assertEquals(ProductService.countByFilter(batch2, new EndOfStringFilter(" ")), 0);
    }
}
