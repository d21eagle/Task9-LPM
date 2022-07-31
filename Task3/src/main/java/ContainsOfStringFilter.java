public class ContainsOfStringFilter implements Filter {

    private final String pattern;

    public ContainsOfStringFilter(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    // Проверка на то, что строка содержит подстроку pattern
    @Override
    public Boolean apply(String n) {
        return n.contains(pattern);
    }
}
