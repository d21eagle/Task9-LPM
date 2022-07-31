import static org.junit.Assert.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOStreamsTest {

    IOStreams iostreams = new IOStreams();

    @org.junit.Test
    public void firstTest() {

        try (OutputStream out = new FileOutputStream("data.txt");
            InputStream in = new FileInputStream("data.txt")) {
            int[] arr = {1, 2, 3, 4};
            iostreams.writeByteStream(out, arr);
            assertArrayEquals(arr, iostreams.readByteStream(in));
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @org.junit.Test
    public void secondTest() {

        try (Writer writer = new FileWriter("data.txt");
            Reader reader = new FileReader("data.txt")) {
            int [] arr = {1, 2, 3, 4, 5};
            iostreams.writeCharsStream(writer, arr);
            assertArrayEquals(arr, iostreams.readCharsStream(reader));
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @org.junit.Test
    public void thirdTest() throws IOException {

        File f1 = new File("data.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(f1));
        writer.write("check arr: 8 22 44 552");
        writer.close();
        int position = 11;
        String res = "8 22 44 552";

        assertEquals(res, iostreams.readRandomAccessFile(f1, position));
    }

    @org.junit.Test
    public void fourthTest() throws IOException {

        File dir = new File("C:\\Users\\Vlad Ilyashenko\\IdeaProjects\\Block7");
        List<File> fileRes;
        fileRes = iostreams.filesCatalog("txt", dir);

        List<String> res = new ArrayList<>();
        for (File temp: fileRes) {
            res.add(temp.getName());
        }

        List<String> actRes = new ArrayList<>();
        actRes.add("data.txt");
        actRes.add("test1.txt");

        assertEquals(actRes, res);
    }

    @org.junit.Test
    public void sixthTest() throws Exception {

        List<Flat> flats = new ArrayList<>();
        List<Person> personFlat2 = new ArrayList<>();
        List<Person> personFlat3 = new ArrayList<>();

        personFlat2.add(new Person("Власов", "Сергей", "Юрьевич", 13, 2, 2002));
        personFlat2.add(new Person("Власов", "Юрий", "Денисович", 17, 8, 1980));

        personFlat3.add(new Person("Жданов", "Евгений", "Павлович", 25, 3, 1990));
        personFlat3.add(new Person("Жданова", "София", "Евгеньевна", 19, 1, 2003));
        personFlat3.add(new Person("Жданова", "Елизавета", "Игоревна", 7, 9, 1981));

        flats.add(new Flat(5, 23, personFlat2));
        flats.add(new Flat(11, 80, personFlat3));

        House house = new House("31", "ул. Мира 32", new Person
                ("Власов", "Юрий", "Денисович", 17, 8, 1980), flats);

        HouseSerializeAndDeserialize.houseSerialize(house, new File("data.txt"));
        assertEquals(house, HouseSerializeAndDeserialize.houseDeserialize(new File("data.txt")));
    }

    @org.junit.Test
    public void eightTaskTest() throws Exception {

        List<Flat> flats = new ArrayList<>();
        List<Person> personFlat2 = new ArrayList<>();
        List<Person> personFlat3 = new ArrayList<>();

        personFlat2.add(new Person("Власов", "Сергей", "Юрьевич", 13, 2, 2002));
        personFlat2.add(new Person("Власов", "Юрий", "Денисович", 17, 8, 1977));

        personFlat3.add(new Person("Жданов", "Евгений", "Павлович", 25, 3, 1980));
        personFlat3.add(new Person("Жданова", "София", "Евгеньевна", 19, 1, 2003));
        personFlat3.add(new Person("Жданова", "Елизавета", "Игоревна", 7, 9, 1981));

        flats.add(new Flat(5, 23, personFlat2));
        flats.add(new Flat(11, 80, personFlat3));

        House house = new House("31", "ул. Мира 32", new Person
                ("Власов", "Юрий", "Денисович", 17, 8, 1980), flats);

        assertEquals(house, HouseWithJackson.ObjectReturnFromJson(HouseWithJackson.ObjectJson(house)));
    }
}