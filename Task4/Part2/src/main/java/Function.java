public class Function implements IOneRealArgumentFunction {

    double A, B, x;
    double rightEnd, leftEnd;

    public Function(double a, double b, double leftEnd, double rightEnd) {
        A = a;
        B = b;
        this.leftEnd = leftEnd;
        this.rightEnd = rightEnd;
    }

    @Override
    public double getFunctionValue(double x) throws IllegalArgumentException {
        if (x > rightEnd || x < leftEnd) throw new IllegalArgumentException();
        return A * x + B;
    }

    @Override
    public double getRightEnd() {
        return rightEnd;
    }

    @Override
    public double getLeftEnd() {
        return leftEnd;
    }
}
