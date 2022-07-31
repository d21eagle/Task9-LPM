public class DivisionFunction implements IOneRealArgumentFunction {

    double A, B, D, C;
    double rightEnd, leftEnd;

    public DivisionFunction(double a, double b, double c, double d, double leftEnd, double rightEnd) {
        A = a;
        B = b;
        D = d;
        C = c;
        this.leftEnd = leftEnd;
        this.rightEnd = rightEnd;
    }

    @Override
    public double getFunctionValue(double x) throws IllegalArgumentException {
        if (x > rightEnd || x < leftEnd) throw new IllegalArgumentException();
        return (A * x + B) / (C * x + D);
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
