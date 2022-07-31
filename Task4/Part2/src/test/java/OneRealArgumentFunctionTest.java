import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OneRealArgumentFunctionTest {

    @org.junit.Test
    public void FunctionTest() {
        Function function = new Function(1, 2, 1, 10);
        assertEquals(function.getFunctionValue(2), 4, 0);
    }

    @org.junit.Test
    public void ExpFunctionTest() {
        ExpFunction expFunction = new ExpFunction(1, 3, 1, 0);
        assertTrue(expFunction.getFunctionValue(3) - 20.08 < 0.1);
    }

    @org.junit.Test
    public void SinFunctionTest() {
        SinFunction sinFunction = new SinFunction(0, 3.1415, 1, 1);
        assertTrue(sinFunction.getFunctionValue(0.5) - 0.099 < 0.5);
    }

    @org.junit.Test
    public void DivisionFunctionTest() {
        DivisionFunction divisionFunction = new DivisionFunction(10, 2, 1,1, 0, 10);
        assertEquals(divisionFunction.getFunctionValue(1), 12, 1e+5);
    }

    @org.junit.Test
    public void errorTest() {
        try {
            ExpFunction expFunction = new ExpFunction(1, 2, 1, 0);
            expFunction.getFunctionValue(100);
        } catch (IllegalArgumentException err) {
            System.err.println();
        }
    }
}
