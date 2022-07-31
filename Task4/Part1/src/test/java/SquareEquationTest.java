import static org.junit.Assert.*;
import java.util.Arrays;

public class SquareEquationTest {

    @org.junit.Test
    public void solveSquareEquationTest() {
        SquareEquation equation = new SquareEquation(2, -1, -1);
        double[] rootAct = new double[2];
        rootAct[0] = -0.5;
        rootAct[1] = 1.0;
        double[] rootExp = equation.solveSquareEquation();
        assertArrayEquals(rootExp, rootAct, 0);
    }

    @org.junit.Test
    public void solveSquareEquationNullDescTest() {
        SquareEquation equation = new SquareEquation(3, -18, 27);
        double[] rootAct = new double[2];
        rootAct[0] = 3.0;
        double[] rootExp = equation.solveSquareEquation();
        assertArrayEquals(rootExp, rootAct, 0);
    }

    @org.junit.Test
    public void solveSquareEquationNegativeDescTest() {
        try {
            SquareEquation equation = new SquareEquation(-1, 3, -12);
        } catch (IllegalArgumentException err) {
            System.err.println("Нет корней!");
        }
    }
}
