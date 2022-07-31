import static org.junit.Assert.*;

public class PieceProductTest {

    @org.junit.Test
    public void PieceProductNullNameTest() {
        try {
            PieceProduct test1 = new PieceProduct(null, "Specification", 0.5);
        } catch (IllegalArgumentException err) {
            System.err.println("Наименование товара = null!");
        }
    }

    @org.junit.Test
    public void PieceProductNullSpecificationTest() {
        try {
            PieceProduct test2 = new PieceProduct("Name", null, 0.5);
        } catch (IllegalArgumentException err) {
            System.err.println("Описание товара = null!");
        }
    }

    @org.junit.Test
    public void PieceProductNegativeWeightTest() {
        try {
            PieceProduct test3 = new PieceProduct("Name", "Specification", -0.5);
        } catch (IllegalArgumentException err) {
            System.err.println("Отрицательный вес!");
        }
    }
}

