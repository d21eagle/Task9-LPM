import static org.junit.Assert.*;

public class StringProcessorTest {

    @org.junit.Test
    public void testLineCopy() {
        String string = "Крот"; int copies = 3;
        String actual = StringProcessor.lineCopy(string, copies);
        String expected = "КротКротКрот";
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void testLineCopyZero() {
        String string = "Крот"; int copies = 0;
        String actual = StringProcessor.lineCopy(string, copies);
        String expected = "";
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void testLineCopyNegative() throws IllegalArgumentException {
        try {
            String string = "Крот"; int copies = -1;
            String actual = StringProcessor.lineCopy(string, copies);
            fail("Expected IllegalArgumentException");
        } catch(IllegalArgumentException thrown){
            assertNotEquals("", thrown.getMessage());
        }
    }

    @org.junit.Test
    public void testLineOccurrence() {
        String origStr = "моховитый мохнач мохнул мох";
        String subStr = "мох";
        int actual = StringProcessor.lineOccurrence(origStr, subStr);
        int expected = 4;
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void testLineOccurrenceNull() throws NullPointerException {
        try {
            String origStr = "моховитый мохнач мохнул мох";
            String subStr = null;
            int actual = StringProcessor.lineOccurrence(origStr, subStr);
            fail("Expected NullPointerException");
        } catch(NullPointerException thrown){
            assertNotEquals("", thrown.getMessage());
        }
    }

    @org.junit.Test
    public void testLineOccurrenceEmpty() throws NullPointerException {
        try {
            String origStr = "моховитый мохнач мохнул мох";
            String subStr = "";
            int actual = StringProcessor.lineOccurrence(origStr, subStr);
            fail("Expected NullPointerException");
        } catch(NullPointerException thrown){
            assertNotEquals("", thrown.getMessage());
        }
    }

    @org.junit.Test
    public void testReplace123() {
        String origString = "123404404404";
        String actual = StringProcessor.replace123(origString);
        String expected = "одиндватри404404404";
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void testReplace123Not123() {
        String origString = "AbcФлд&*&#576";
        String actual = StringProcessor.replace123(origString);
        String expected = "AbcФлд&*&#576";
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void testReplace123Random() {
        String origString = "825410730";
        String actual = StringProcessor.replace123(origString);
        String expected = "8два54один07три0";
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void testDelSecondSymbolEmpty() {
        StringBuilder binaryString = new StringBuilder("");
        StringProcessor.delSecondSymbol(binaryString);
        String actual = new String(binaryString);
        String expected = "";
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void testDelSecondSymbolDifferent() {
        StringBuilder binaryString = new StringBuilder("3343gfd890рмл%^*%&456");
        StringProcessor.delSecondSymbol(binaryString);
        String actual = new String(binaryString);
        String expected = "34gd9рл^%46";
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void testDelSecondSymbolSpaces() {
        StringBuilder binaryString = new StringBuilder("3 3 3 3 3 3 3 3 3");
        StringProcessor.delSecondSymbol(binaryString);
        String actual = new String(binaryString);
        String expected = "333333333";
        assertEquals(expected, actual);
    }

}