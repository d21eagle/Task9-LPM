public class EndOfStringFilter implements Filter {

    private final String pattern;

    public EndOfStringFilter(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    // Проверка на то, что строка заканчивается подстрокой pattern
    @Override
    public Boolean apply(String n) {
        return n.endsWith(pattern);
    }
}
