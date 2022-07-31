import java.util.*;

public class CollectionsDemo {

    public static int countCoincidence(List<String> humanList1, char a) {
        // 1.Метод возвращает количество строк входного списка, у которых первый символ совпадает с заданным.

        int count = 0;
        List<String> humanList2 = new ArrayList<>();

        for(String str: humanList1) {
            if (!(str.equals(""))) humanList2.add(str);
        }

        for(String str: humanList2) {
            if (str.charAt(0) == a) count++;
        }
        return count;
    }

    public static List<Human> namesakesList(List<Human> humanList, Human human) {
        // 2.Метод возвращает список однофамильцев заданного человека среди людей из входного списка.

        ArrayList<Human> namesakes = new ArrayList<>();

        for (Human person: humanList) {
            if(person.getSurname().equals(human.getSurname())) {
                namesakes.add(person);
            }
        }
        return namesakes;
    }

    public static List<Human> copyArrayList(List<Human> humanList1, Human human) {
        // 3.Метод возвращает копию входного списка, не содержащую выделенного человека.

        ArrayList<Human> humanList2 = new ArrayList<>();

        for (Human person: humanList1) {
            if (!person.equals(human)) {
                Human h = new Human(person);
                humanList2.add(h);
            }
        }
        return humanList2;
    }

    public static List<HashSet<Integer>> hashSetsList(List<HashSet<Integer>> hashSets, Set<Integer> hashSet) {
        // 4.Метод возвращает список всех множеств входного списка, которые не пересекаются с заданным множеством.

        List<HashSet<Integer>> setList1 = new ArrayList<>(hashSets);
        List<HashSet<Integer>> result = new ArrayList<>();

        for (HashSet<Integer> set: setList1) {
            HashSet<Integer> copySet = new HashSet<>(set);
            set.removeAll(hashSet);
            if (copySet.equals(set)) {
                result.add(set);
            }
        }
        return result;
    }

    public static List<Human> maxAgeList(List<Human> humanList1) {
        // 5.Метод возвращает множество людей из входного списка с максимальным возрастом.

        int maxAge = 0;
        ArrayList<Human> result = new ArrayList<>();

        for (Human person: humanList1) {
            if (person.getAge() > maxAge) {
                maxAge = person.getAge();
            }
        }

        for (Human person: humanList1) {
            if (person.getAge() == maxAge) {
                result.add(person);
            }
        }
        return result;
    }

    public static Set<Human> idContainedSet(Map<Integer, Human> maps, Set<Integer> ids) {
        // 7.Метод возвращает множество людей, идентификаторы которых содержатся во входном множестве.

        HashSet<Human> result = new HashSet<>();

        for (Map.Entry<Integer, Human> entry: maps.entrySet()) {
            Integer key = entry.getKey();
            Human human = entry.getValue();
            if (ids.contains(key)) {
                result.add(human);
            }
        }
        return result;
    }

    public static List<Integer> ageEighteenList(Map<Integer, Human> maps) {
        // 8.Метод возвращает список идентификаторов людей, чей возраст не менее 18 лет.

        List<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Human> entry: maps.entrySet()) {
            Integer key = entry.getKey();
            Human human = entry.getValue();

            if (human.getAge() >= 18) {
                result.add(key);
            }
        }
        return result;
    }

    public static Map<Integer, Integer> idAndAgeMap(Map<Integer, Human> maps) {
        // 9.Метод строит отображение, которое идентификатору сопоставляет возраст человека.

        Map<Integer, Integer> result = new HashMap<>();

        for (Map.Entry<Integer, Human> entry: maps.entrySet()) {
            Integer key = entry.getKey();
            Human human = entry.getValue();
            result.put(key, human.getAge());
        }
        return result;
    }

    public static Map<Integer, List<Human>> ageAndPersonMap(Set<Human> humans) {
        /*
            10.Метод строит отображение, которое целому числу (возраст человека) сопоставляет список
            всех людей данного возраста из входного множества.
        */

        Map<Integer, List<Human>> result = new HashMap<>();
        for (Human human: humans) {
            result.putIfAbsent(human.getAge(), new LinkedList<>());
            result.get(human.getAge()).add(human);
        }
        return result;
    }
}
