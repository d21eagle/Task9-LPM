import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class CollectionsTest {

    @Test
    public void countCoincidenceTest() {
        // 1.Метод возвращает количество строк входного списка, у которых первый символ совпадает с заданным.

        char b = 'x';
        List<String> str = List.of("", "zhk", "xyz", "x");
        assertEquals(CollectionsDemo.countCoincidence(str, b), 2);
    }

    @Test
    public void namesakesListTest() {
        // 2.Метод возвращает список однофамильцев заданного человека среди людей из входного списка.

        List<Human> humanList1 = new ArrayList<>();

        Human human1 = new Human("Петров", "Антон", "Сергеевич", 19);
        Human human2 = new Human("Петров", "Федор", "Сергеевич", 19);
        Human human3 = new Human("Иванов", "Александр", "Викторович", 20);

        humanList1.add(human1);
        humanList1.add(human2);

        List<Human> humanList2 = CollectionsDemo.namesakesList(humanList1, human3);
        assertTrue(humanList2.isEmpty());
    }

    @Test
    public void namesakesListGoodTest() {
        // 2.Метод возвращает список однофамильцев заданного человека среди людей из входного списка.

        List<Human> humanList1 = new ArrayList<>();

        Human human1 = new Human("Петров", "Антон", "Сергеевич", 19);
        Human human2 = new Human("Петров", "Федор", "Сергеевич", 19);
        Human human3 = new Human("Иванов", "Александр", "Викторович", 20);

        humanList1.add(human1);
        humanList1.add(human2);
        humanList1.add(human3);

        List<Human> humanList2 = CollectionsDemo.namesakesList(humanList1, human2);
        assertEquals(humanList2.size(), 2);
    }

    @Test
    public void copyArrayListTest() {
        // 3.Метод возвращает копию входного списка, не содержащую выделенного человека.

        ArrayList<Human> humanList1 = new ArrayList<>();

        Human human1 = new Human("Петров", "Антон", "Сергеевич", 19);
        Human human2 = new Human("Петров", "Федор", "Сергеевич", 19);
        Human human3 = new Human("Иванов", "Александр", "Викторович", 20);

        humanList1.add(human1);
        humanList1.add(human2);
        humanList1.add(human3);

        List<Human> humanList2 = CollectionsDemo.copyArrayList(humanList1, human1);
        assertEquals(humanList2.size(), 2);
        assertEquals(humanList2.get(0).getName(), "Федор");
    }

    @Test
    public void hashSetsListTest() {
        // 4.Метод возвращает список всех множеств входного списка, которые не пересекаются с заданным множеством.

        List<HashSet<Integer>> l = new ArrayList<>();

        HashSet<Integer> a = new HashSet<>(List.of(1, 3, 5));
        HashSet<Integer> b = new HashSet<>(List.of(2, 4, 6));
        HashSet<Integer> c = new HashSet<>(List.of(7, 8, 9));

        ArrayList<Set<Integer>> k = new ArrayList<>();
        k.add(a);
        k.add(b);
        l.add(a);
        l.add(b);

        assertEquals(CollectionsDemo.hashSetsList(l, c), k);
    }

    @Test
    public void maxAgeListTest() {
        // 5.Метод возвращает множество людей из входного списка с максимальным возрастом.

        List<Human> humanList = new ArrayList<>();

        Student human1 = new Student("Петров", "Антон", "Сергеевич", 20, "ФМИТ");
        Student human2 = new Student("Петров", "Федор", "Сергеевич", 20, "ФМИТ");
        Student human3 = new Student("Иванов", "Александр", "Викторович", 20, "ФМИТ");

        humanList.add(human1);
        humanList.add(human2);
        humanList.add(human3);

        humanList = CollectionsDemo.maxAgeList(humanList);
        assertEquals(humanList.get(0).getAge(), 20);
        assertEquals(humanList.size(), 3);
    }

    @Test
    public void idContainedSetTest() {
        // 7.Метод возвращает множество людей, идентификаторы которых содержатся во входном множестве.

        int a = 19, b = 20, c = 18;

        Human human1 = new Human("Петров", "Антон", "Сергеевич", 19);
        Human human2 = new Human("Петров", "Федор", "Сергеевич", 19);
        Human human3 = new Human("Иванов", "Александр", "Викторович", 20);

        HashMap<Integer, Human> humanHashMap = new HashMap<>();
        humanHashMap.put(22, human1);
        humanHashMap.put(20, human2);
        humanHashMap.put(21, human3);

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(a);
        hashSet.add(b);
        hashSet.add(c);

        Set<Human> humanSet = CollectionsDemo.idContainedSet(humanHashMap, hashSet);

        assertEquals(humanSet.size(), 1);
    }

    @Test
    public void ageEighteenListTest() {
        // 8.Метод возвращает список идентификаторов людей, чей возраст не менее 18 лет.

        HashMap<Integer, Human> humanHashMap = new HashMap<>();

        Human human1 = new Human("Петров", "Антон", "Сергеевич", 17);
        Human human2 = new Human("Петров", "Федор", "Сергеевич", 19);
        Human human3 = new Human("Иванов", "Александр", "Викторович", 20);

        humanHashMap.put(22, human1);
        humanHashMap.put(20, human2);
        humanHashMap.put(21, human3);

        List<Integer> humanList = CollectionsDemo.ageEighteenList(humanHashMap);
        assertEquals(humanList.size(), 2);
    }

    @Test
    public void idAndAgeMapTest() {
        // 9.Метод строит отображение, которое идентификатору сопоставляет возраст человека.

        Map<Integer, Human> humanHashMap1 = new HashMap<>();

        Human human1 = new Human("Петров", "Антон", "Сергеевич", 17);
        Human human2 = new Human("Петров", "Федор", "Сергеевич", 19);
        Human human3 = new Human("Иванов", "Александр", "Викторович", 20);

        humanHashMap1.put(20, human1);
        humanHashMap1.put(22, human2);
        humanHashMap1.put(21, human3);

        Map<Integer, Integer> humanHashMap2 = CollectionsDemo.idAndAgeMap(humanHashMap1);

        assertEquals(humanHashMap2.toString(), "{20=17, 21=20, 22=19}");
    }

    @Test
    public void ageAndPersonMapTest() {
        /*
            10.Метод строит отображение, которое целому числу (возраст человека) сопоставляет список
            всех людей данного возраста из входного множества.
        */

        Set<Human> people = new HashSet<>();

        Human human1 = new Human("Шамадрин", "Сергей", "Валерьевич", 20);
        Human human2 = new Human("Романовский", "Иван", "Владимирович", 19);
        Human human3 = new Human("Петренко", "Сергей", "Юрьевич", 22);
        Human human4 = new Human("Иванов", "Федор", "Андреевич", 19);

        people.add(human1);
        people.add(human2);
        people.add(human3);
        people.add(human4);

        Map<Integer, List<Human>> humanHashMap1 = CollectionsDemo.ageAndPersonMap(people);

        assertEquals(humanHashMap1.get(19).size(), 2);
    }
}