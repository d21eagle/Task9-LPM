
public class Main {

    public static void main(String[] args) {
        // Упаковка
        System.out.println();
        System.out.println("<Часть 1>");
        ProductPackage productPackage = new ProductPackage(0.1, "Полиэтилен");
        System.out.println(productPackage.toString());

        // Товар
        Product product = new Product("Конфеты", "Шоколадные");
        System.out.println(product.toString());

        // Весовой товар
        WeightProduct weightProduct = new WeightProduct("Апельсины", "Вкусные и спелые", 3);
        System.out.println(weightProduct.toString());

        // Штучный товар
        PieceProduct pieceProduct = new PieceProduct("Миска", "Для кормления животных", 0.5);
        System.out.println(pieceProduct.toString());

        // Упакованный весовой товар
        System.out.println();
        ProductPackage productPackage2 = new ProductPackage(0.3, "Картон");
        WeightProduct weightProduct2 = new WeightProduct("Апельсины", "Пальчики оближешь", 3);
        PackedWeightProduct packedWeightProduct = new PackedWeightProduct(productPackage2, 3, weightProduct2);
        System.out.println(packedWeightProduct.toString());
        System.out.println("Масса нетто: " + packedWeightProduct.getNetWeight());
        System.out.println("Масса брутто: " + packedWeightProduct.getGrossWeight());

        // Упакованный штучный товар
        System.out.println();
        ProductPackage productPackage3 = new ProductPackage(0.3, "Картон");
        PieceProduct pieceProduct2 = new PieceProduct("Миска", "Пластмассовая", 1);
        PackedPieceProduct packedPieceProduct = new PackedPieceProduct(productPackage3, 2, pieceProduct2);
        System.out.println(packedPieceProduct.toString());
        System.out.println("Масса нетто: " + packedPieceProduct.getNetWeight());
        System.out.println("Масса брутто: " + packedPieceProduct.getGrossWeight());

        // Партия весовых товаров
        System.out.println();
        ProductPackage productPackage4 = new ProductPackage(5.0, "Коробка");
        PackedWeightProduct[] weightProducts = {
                new PackedWeightProduct(productPackage4, 8.0,
                        new WeightProduct("Яблоки", "Апорт", 8.0)),
                new PackedWeightProduct(productPackage4, 10.0,
                        new WeightProduct("Бананы", "Эквадор", 10.0)),
                new PackedWeightProduct(productPackage4, 9.0,
                        new WeightProduct("Хурма", "Таджикистан", 9.0))
        };

        // Партия штучных товаров
        PackedPieceProduct[] pieceProducts = {
                new PackedPieceProduct(productPackage4, 1,
                        new PieceProduct("БП", "AeroCool", 11.0)),
                new PackedPieceProduct(productPackage4, 1,
                        new PieceProduct("ОЗУ", "Samsung", 11.0)),
                new PackedPieceProduct(productPackage4, 1,
                        new PieceProduct("ГПУ", "Nvidia GeForce", 11.0))
        };

        ProductBatch productBatch1 = new ProductBatch("Партия №1", weightProducts);
        ProductBatch productBatch2 = new ProductBatch("Партия №2", pieceProducts);
        System.out.println(productBatch1.toString());
        System.out.println();
        System.out.println(productBatch2.toString());

        // Суммарная масса брутто всех товаров в партии
        System.out.println();
        double grossWeight1 = productBatch1.getWeight();
        System.out.println("Масса брутто " + productBatch1.getSpecification() + ": " + grossWeight1);
        double grossWeight2 = productBatch2.getWeight();
        System.out.println("Масса брутто " + productBatch2.getSpecification() + ": " + grossWeight2);

        // Работа с интерфейсом "Фильтр"
        // Проверка на то, что строка str начинается с подстроки pattern
        System.out.println();
        System.out.println("<Часть 2>");
        String str1 = "Лучше поздно, чем никогда";
        BeginStringFilter filter1 = new BeginStringFilter("Лучше");
        String pattern1 = filter1.getPattern();
        System.out.println("Подстрока для фильтрации: " + pattern1);
        boolean res1 = filter1.apply(str1);
        System.out.println("Строка 'Лучше поздно, чем никогда' начинается с" +
                " подстроки '" + pattern1 + "': " + res1);

        // Проверка на то, что строка str содержит подстроку pattern
        System.out.println();
        String str2 = "Лучше поздно, чем никогда";
        ContainsOfStringFilter filter2 = new ContainsOfStringFilter("поздно");
        String pattern2 = filter2.getPattern();
        System.out.println("Подстрока для фильтрации: " + pattern2);
        boolean res2 = filter2.apply(str2);
        System.out.println("Строка 'Лучше поздно, чем никогда' содержит" +
                " подстроку '" + pattern2 + "': " + res2);

        // Проверка на то, что строка str заканчивается подстрокой pattern
        System.out.println();
        String str3 = "Лучше поздно, чем никогда";
        EndOfStringFilter filter3 = new EndOfStringFilter("никогда");
        String pattern3 = filter3.getPattern();
        System.out.println("Подстрока для фильтрации: " + pattern3);
        boolean res3 = filter3.apply(str3);
        System.out.println("Строка 'Лучше поздно, чем никогда' заканчивается" +
                " подстрокой '" + pattern3 + "': " + res3);

        // Фильтрация товаров
        System.out.println();
        System.out.println("<Часть 3>");
        ProductPackage productPackage5 = new ProductPackage(0.1, "Пакет");
        PieceProduct banana = new PieceProduct("Бананы", "Эквадор", 0.3);
        PackedPieceProduct bananaPack = new PackedPieceProduct(productPackage5, 10, banana);
        ProductBatch batch1 = new ProductBatch("Партия Фруктов", bananaPack);

        int filter10 = ProductService.countByFilter(batch1, new BeginStringFilter("Бананы"));
        int filter20 = ProductService.countByFilter(batch1, new ContainsOfStringFilter("Эквадор"));
        System.out.println("Кол-во элементов партии с наименованием 'Бананы': " + filter10);
        System.out.println("Кол-во элементов партии с наименованием, содержащим подстроку 'Эквадор': " + filter20);
    }
}
