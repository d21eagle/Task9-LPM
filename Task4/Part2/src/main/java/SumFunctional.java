public class SumFunctional<T extends IOneRealArgumentFunction> implements IOneArgumentFunctional<T> {
    private final double rightEnd, leftEnd;

    public SumFunctional(double leftEnd, double rightEnd) {
        this.leftEnd = leftEnd;
        this.rightEnd = rightEnd;
    }

    public double calculate(T function) {
        if (leftEnd < function.getLeftEnd() || rightEnd > function.getRightEnd()) throw new IllegalArgumentException();
        return  function.getFunctionValue(function.getRightEnd()) +
                function.getFunctionValue(function.getLeftEnd()) +
                function.getFunctionValue((function.getRightEnd() + function.getRightEnd()) / 2);
    }
}