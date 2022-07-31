
public class Program {

    public static void main(String[] args) {

        //1.1 Решение квадратного уравнения
        SquareEquation eq1 = new SquareEquation(1, 10, -24);
        double[] res = eq1.solveSquareEquation();
        System.out.println("Корни уравнения: ");
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

        //1.2 Поиск большего корня либо выброс исключения, если корней нет
        System.out.println();
        SquareEquationPro solver = new SquareEquationPro(eq1);
        double maxAns = solver.getMaxAnswer();
        System.out.println("Больший корень:\n" + maxAns);

        //2.1-2.2 Работа с интерфейсом «Функция одного вещественного аргумента, определенная на отрезке [a; b]»
        System.out.println();
        Function function = new Function(3, 6, 1, 10);
        double value1 = function.getFunctionValue(3);
        System.out.println("Значение функции 'Ax + B': " + value1);
        System.out.println("Левый конец отрезка: " + function.getLeftEnd());
        System.out.println("Правый конец отрезка: " + function.getRightEnd());

        System.out.println();
        DivisionFunction divisionFunction = new DivisionFunction(9, 3, 2,2, 0, 10);
        double value2 = divisionFunction.getFunctionValue(1);
        System.out.println("Значение функции '(Ax + B) / (Cx + D)': " + value2);
        System.out.println("Левый конец отрезка: " + divisionFunction.getLeftEnd());
        System.out.println("Правый конец отрезка: " + divisionFunction.getRightEnd());

        System.out.println();
        ExpFunction expFunction = new ExpFunction(1, 4, 2, 1);
        double value3 = expFunction.getFunctionValue(2);
        System.out.println("Значение функции 'A * exp(x) + B': " + value3);
        System.out.println("Левый конец отрезка: " + expFunction.getLeftEnd());
        System.out.println("Правый конец отрезка: " + expFunction.getRightEnd());

        System.out.println();
        SinFunction sinFunction = new SinFunction(0, 3, 1, 1);
        double value4 = sinFunction.getFunctionValue(0.2);
        System.out.println("Значение функции 'A * sin(Bx)': " + value4);
        System.out.println("Левый конец отрезка: " + sinFunction.getLeftEnd());
        System.out.println("Правый конец отрезка: " + sinFunction.getRightEnd());

        //2.3-2.4 Работа с интерфейсом «Функционал от одного аргумента»
        System.out.println();
        SinFunction sinFunction2 = new SinFunction(0, 3, 1, 1);
        SumFunctional<SinFunction> sumFunctional = new SumFunctional<>(0, 0.5);
        double result1 = sumFunctional.calculate(sinFunction2);
        System.out.println("Сумма значений функции на концах отрезка и в его середине: " + result1);

        System.out.println();
        SinFunction sinFunction3 = new SinFunction(0, 3.1415, 1, 1);
        IntegralFunctional<SinFunction> integralFunctional = new IntegralFunctional<>(0, 3.1415);
        double result2 = integralFunctional.calculate(sinFunction3, 0.0001, 0.0001);
        System.out.println("Определенный интеграл на отрезке [a; b]: " + result2);
    }
}
