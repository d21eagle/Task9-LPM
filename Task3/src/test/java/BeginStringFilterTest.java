import static org.junit.Assert.*;

public class BeginStringFilterTest {

    BeginStringFilter filter = new BeginStringFilter("Лучше");

    @org.junit.Test
    public void testGetPattern() {
        assertEquals(filter.getPattern(), "Лучше");
    }

    @org.junit.Test
    public void testApplyTrue() {
        assertTrue(filter.apply("Лучше поздно, чем никогда"));
    }

    @org.junit.Test
    public void testApplyFalse() {
        assertFalse(filter.apply("лучше поздно, чем никогда"));
        assertFalse(filter.apply("лучше рано, чем завтра"));
        assertFalse(filter.apply(""));
    }
}
