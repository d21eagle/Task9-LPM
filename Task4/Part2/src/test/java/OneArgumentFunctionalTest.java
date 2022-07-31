import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OneArgumentFunctionalTest {

    @org.junit.Test
    public void errorTest() {
        try {
            ExpFunction expFunction = new ExpFunction(1, 2, 1, 0);
            IntegralFunctional<ExpFunction> integralFunctional = new IntegralFunctional<>(30, 50);
        } catch (IllegalArgumentException err) {
            System.err.println();
        }
    }

    @org.junit.Test
    public void sumFunctionalTest() {
        SinFunction sinFunction = new SinFunction(0, 3.1415, 1, 1);
        SumFunctional<SinFunction> sumFunctional = new SumFunctional<>(0, 3.1415);
        assertEquals(sumFunctional.calculate(sinFunction), 1, 1e+5);
    }

    // Тест интеграла от функции A*sin(B*x)
    @org.junit.Test
    public void sinIntegralTest() {
        SinFunction sinFunction = new SinFunction(0, 3.1415, 1, 1);
        IntegralFunctional<SinFunction> integralFunctional = new IntegralFunctional<>(0, 3.1415);
        assertEquals(integralFunctional.calculate(sinFunction, 0.0001, 0.0001), 2, 1e+5);
    }

    // Тест интеграла от функции Ax+B
    @org.junit.Test
    public void functionIntegralTest() {
        Function function = new Function(3, 6, 1, 5);
        IntegralFunctional<Function> integralFunctional = new IntegralFunctional<>(1, 5);
        assertEquals(integralFunctional.calculate(function, 0.0001, 0.0001), 60, 1e+5);
    }

    // Тест интеграла от функции (Ax+B)/(Cx+D)
    @org.junit.Test
    public void divisionFunctionIntegralTest() {
        DivisionFunction divisionFunction = new DivisionFunction(0, 0, 2,2, 1, 5);
        IntegralFunctional<DivisionFunction> integralFunctional = new IntegralFunctional<>(1, 5);
        assertEquals(integralFunctional.calculate(divisionFunction, 0.0001, 0.0001), 0, 1e+5);
    }

    // Тест интеграла от функции A*exp(x)+B
    @org.junit.Test
    public void expFunctionIntegralTest() {
        ExpFunction expFunction = new ExpFunction(1, 2, 2, 0);
        IntegralFunctional<ExpFunction> integralFunctional = new IntegralFunctional<>(1, 2);
        assertEquals(integralFunctional.calculate(expFunction, 0.0001, 0.0001), 9.3415, 1e+5);
    }


}
