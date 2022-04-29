import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
interface EqualsHumansAndMaxAge {
    boolean checkHumansAndMaxAge(Human h1, Human h2, Human h3, int maxAge);
}

public class LambdaDemo {

    // 1. Для строки символов получить ее длину
    public static final Function<String, Integer> getLengthOfString = String::length;

    // 2. Для строки символов получить ее первый символ, если он существует, или null иначе
    public static final Function<String, Character> getFirstElem = (s) ->
            Optional.ofNullable(s).filter(x -> !x.isEmpty()).map(y -> y.charAt(0)).orElse(null);

    // 3. Для строки проверить, что она не содержит пробелов
    public static final Function<String, Boolean> notHaveSpace = (s) -> (!s.contains(" "));

    // 4. Слова в строке разделены запятыми, по строке получить количество слов в ней
    public static final Function<String, Integer> countWordsInString = (s) -> {
        if (s == null || s.isEmpty()) {
            return null;
        }

        List<String> arr = new ArrayList<>();
        String[] arr1 = s.split(",");

        for (String ss: arr1) {
            if((!ss.equals("") && !ss.equals(" "))) {
                arr.add(ss);
            }
        }
        return arr.size();
    };

    // 5. По человеку получить его возраст
    public static final Function<? super Human, Integer> getAgeOfHuman = Human::getAge;

    // 6. По двум людям проверить, что у них одинаковая фамилия
    public static final BiFunction<? super Human, ? super Human, Boolean> equalsSurname = (h1, h2) -> h1.getSurname().equals(h2.getSurname());

    // 7. Получить фамилию, имя и отчество человека в виде одной строки (разделитель — пробел)
    public static final Function<? super Human, String> makeStringHuman = (h) ->
            String.format("%s %s %s", h.getSurname(), h.getName(), h.getMiddleName());

    // 8. Сделать человека старше на один год (по объекту Human создать новый объект)
    public static final Function<Human, Human> getOlder = (h) ->
            new Human(h.getSurname(),h.getName(), h.getMiddleName(), h.getAge() + 1, h.getGender());

    // 9. По трем людям и заданному возрасту maxAge проверить, что все три человека моложе maxAge.
    public static final EqualsHumansAndMaxAge equalsAge = (h1, h2, h3, maxAge) ->
            (h1.getAge() < maxAge && h2.getAge() < maxAge && h3.getAge() < maxAge);
}