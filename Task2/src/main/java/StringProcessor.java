public class StringProcessor {

    // Строка, состоящая из N копий строки s, записанных подряд
    public static String lineCopy(String s, int n) {
        if (n < 0) throw new IllegalArgumentException("n < 0");
        if (n == 0) return "";
        String copy = "";
        for (int i = 0; i < n; i++) copy += s;
        return copy;
    }

    // Количество вхождений второй строки в первую
    public static int lineOccurrence(String first, String second) {
        if (second == null || second.isEmpty()) throw new NullPointerException("Вторая строка пустая или null!");
        int occurrences = 0;
        int i = first.indexOf(second);
        while (i >= 0)
        {
            occurrences += 1;
            i = first.indexOf(second, i+1);
        }
        return occurrences;
    }

    // Замена 1, 2, 3
    public static String replace123(String original) {
        String first = original.replaceAll("1", "один");
        String second = first.replaceAll("2", "два");
        String third = second.replaceAll("3", "три");
        return third;
    }

    // Удаление каждого второго по счету символа
    public static StringBuilder delSecondSymbol(StringBuilder original) {
        int i = 0;
        while (i < original.length() - 1) original = original.deleteCharAt(++i);
        return original;
    }

    // Строка, в которой все слова идут в обратном порядке, а пробелы остаются на местах
    public static String lineReverse(String s) {
        char[] arr = s.toCharArray();
        String res = "";
        String[] words = s.split("(\\s)+");
        int j = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') res = res + arr[i];
            else {
                res = res + words[words.length - j];
                while (arr[i] != ' ') {
                    i++;
                }
                res = res + arr[i];
                j++;
            }
        }
        return res;
    }
}
