import static org.junit.Assert.*;

public class ContainsOfStringFilterTest {

    ContainsOfStringFilter filter = new ContainsOfStringFilter("поздно");

    @org.junit.Test
    public void testGetPattern() {
        assertEquals(filter.getPattern(), "поздно");
    }

    @org.junit.Test
    public void testApplyTrue() {
        assertTrue(filter.apply("Лучше поздно, чем никогда"));
    }

    @org.junit.Test
    public void testApplyFalse() {
        assertFalse(filter.apply("лучше Поздно, чем никогда"));
        assertFalse(filter.apply("лучше рано, чем завтра"));
        assertFalse(filter.apply(""));
    }
}
