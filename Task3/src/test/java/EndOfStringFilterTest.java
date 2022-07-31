import static org.junit.Assert.*;

public class EndOfStringFilterTest {

    EndOfStringFilter filter = new EndOfStringFilter("никогда");

    @org.junit.Test
    public void testGetPattern() {
        assertEquals(filter.getPattern(), "никогда");
    }

    @org.junit.Test
    public void testApplyTrue() {
        assertTrue(filter.apply("Лучше поздно, чем никогда"));
    }

    @org.junit.Test
    public void testApplyFalse() {
        assertFalse(filter.apply("лучше поздно, чем Никогда"));
        assertFalse(filter.apply("лучше рано, чем завтра"));
        assertFalse(filter.apply(""));
    }
}
