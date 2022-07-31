public class ExpFunction implements IOneRealArgumentFunction {

    double A, B;
    double rightEnd, leftEnd;

    public ExpFunction(double leftEnd, double rightEnd, double a, double b) {
        this.A = a;
        this.B = b;
        this.rightEnd = rightEnd;
        this.leftEnd = leftEnd;
    }

    @Override
    public double getFunctionValue(double x) throws IllegalArgumentException {
        if (x > rightEnd || x < leftEnd) throw new IllegalArgumentException();
        return A * Math.exp(x) + B;
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
