import java.util.Arrays;

public class GrossSum {

    public static double getProductWeight(PackedProduct... products) {
        return Arrays.stream(products).mapToDouble(PackedProduct::getGrossWeight).sum();
    }
}
