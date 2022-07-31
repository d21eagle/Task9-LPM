public class SinFunction implements IOneRealArgumentFunction {

    double A, B;
    double rightEnd, leftEnd;

    public SinFunction(double leftEnd, double rightEnd, double a, double b) {
        A = a;
        B = b;
        this.leftEnd = leftEnd;
        this.rightEnd = rightEnd;
    }

    @Override
    public double getFunctionValue(double x) throws IllegalArgumentException {
        if (x > rightEnd || x < leftEnd) throw new IllegalArgumentException();
        return A * Math.sin(B * x);
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
