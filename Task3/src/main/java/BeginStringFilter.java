public class BeginStringFilter implements Filter {

    private final String pattern;

    public BeginStringFilter(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    // Проверка на то, что строка начинается с подстроки pattern
    @Override
    public Boolean apply(String n) {
        return n.startsWith(pattern);
    }
}
