public class WeightProduct extends Product {

    private final double weight;

    public WeightProduct(String nameOfProduct, String specification, double weight) {
        super(nameOfProduct, specification);
        if (Double.compare(weight, 0.0) == -1) throw new IllegalArgumentException();
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Весовой товар [" +
                "Наименование = '" + nameOfProduct + '\'' +
                ", Описание = '" + specification + '\'' +
                ", Вес = " + weight + "(кг)" +
                ']';
    }
}
