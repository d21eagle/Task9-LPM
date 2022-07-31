import static org.junit.Assert.*;

public class SquareEquationProTest {

    @org.junit.Test
    public void getMaxAnswerTest() {
        SquareEquation equation = new SquareEquation(3, -14, -5);
        SquareEquationPro solver = new SquareEquationPro(equation);
        assertEquals(solver.getMaxAnswer(), 5.0, 0);
    }

    @org.junit.Test
    public void getMaxAnswerExceptionTest() {
        try {
            SquareEquation equation = new SquareEquation(1, 6, 14);
            SquareEquationPro solver = new SquareEquationPro(equation);
        } catch (IllegalArgumentException err) {
            System.err.println();
        }
    }

}