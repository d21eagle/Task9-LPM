import java.util.Arrays;

public class ProductService {

    public static int countByFilter(ProductBatch batch, Filter strFilter) {
        return (int) Arrays.stream(batch.getProducts()).
                filter(x -> strFilter.apply(x.getNameOfProduct())).count();
    }
}
